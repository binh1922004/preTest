package ball.controller;


import ball.entity.Book;
import ball.service.IBookService;
import ball.service.imp.BookServiceImpl;
import ball.ultils.Constant;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.awt.print.Pageable;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@WebServlet({"/books", "/book/detail", "/book/insert", "/book/edit"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50)
public class BookController extends HttpServlet {
        IBookService bookService = new BookServiceImpl();
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                String url = req.getRequestURI();

                if (url.contains("/detail")){
                        int id = Integer.parseInt(req.getParameter("bookid"));
                        Book book = bookService.findById(id);

                        req.setAttribute("book", book);
                        req.getRequestDispatcher("/view/book/book-detail.jsp").forward(req, resp);
                }
                else if (url.contains("books")){
                        int toltalBook = bookService.count();
                        int toltalPage = toltalBook/3;

                        if (toltalBook % 3 != 0)
                                toltalPage++;

                        int pagenumber = 1;
                        if (req.getParameter("pageNumber") != null){
                                pagenumber = Integer.parseInt(req.getParameter("pageNumber"));
                        }

                        List<Book> list = bookService.findAllPagin((pagenumber - 1)* 3, 3);

                        req.setAttribute("listbook", list);
                        List<Integer> pageNumbers = IntStream.rangeClosed(1, toltalPage)
                                .boxed()
                                .collect(Collectors.toList());

                        req.setAttribute("pageNumbers", pageNumbers);

                        req.getRequestDispatcher("/view/book/book-list.jsp").forward(req, resp);
                }
                else if (url.contains("insert")){
                        req.getRequestDispatcher("/view/book/book-create.jsp").forward(req, resp);
                }
                else if (url.contains("edit")){
                        int id = Integer.parseInt(req.getParameter("bookid"));
                        Book book = bookService.findById(id);
                        req.setAttribute("book", book);
                        req.getRequestDispatcher("/view/book/book-edit.jsp").forward(req, resp);
                }
        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                String url = req.getRequestURI();

                if (url.contains("insert")){
                        Book book = getBookFromView(req);
                        bookService.insert(book);
                        req.getRequestDispatcher("/view/admin/book-list.jsp");
                }
                else if (url.contains("edit")){
                        Book book = getBookFromView(req);
                        bookService.update(book);

                        resp.sendRedirect("/book/edit?bookid=" + book.getId());
                }
        }

        private Book getBookFromView(HttpServletRequest req) throws ServletException, IOException {
                Book book = new Book();

                int isbn = Integer.parseInt(req.getParameter("isbn"));
                String title = req.getParameter("title");
                String publisher = req.getParameter("publisher");
                double price = Double.parseDouble(req.getParameter("price"));
                String description = req.getParameter("description");
                Date publishdate = Date.valueOf(req.getParameter("publishDate"));
                int quantity = Integer.parseInt(req.getParameter("quantity"));

                Part part = req.getPart("cvimage");
                String fname = getFileName(part);
                String uploadPath = Constant.DEFAULT_FILENAME;
                File uploadDir = new File(uploadPath);

                if (!uploadDir.exists())
                        uploadDir.mkdirs();

                try{
                        if (part.getSize() > 0){
                                part.write(uploadPath + fname);
                                book.setCoverimage(fname);
                        }
                        else{
                                book.setCoverimage(Constant.DEFAULT_IMG);
                        }
                }
                catch (Exception ex){
                        System.out.println(ex.getMessage());
                }

                book.setIsbn(isbn);
                book.setTitle(title);
                book.setPublishdate(publishdate);
                book.setPublisher(publisher);
                book.setDescription(description);
                book.setPrice(price);
                book.setQuantity(quantity);

                if (req.getParameter("bookid") != null){
                        book.setId(Integer.parseInt(req.getParameter("bookid")));
                }

                return book;
        }

        private String getFileName(Part part) {
                for (String content : part.getHeader("content-disposition").split(";")) {
                        if (content.trim().startsWith("filename"))
                                return content.substring(content.indexOf("=") + 2,
                                        content.length() - 1);
                }
                return Constant.DEFAULT_FILENAME;
        }
}
