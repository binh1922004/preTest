package ball.controller;


import ball.entity.Book;
import ball.service.IBookService;
import ball.service.imp.BookServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet({"/books", "/book/detail"})
public class BookController extends HttpServlet {
        IBookService bookService = new BookServiceImpl();
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                String url = req.getRequestURI();

                System.out.println(url);
                if (url.contains("/detail")){
                        int id = Integer.parseInt(req.getParameter("bookid"));
                        Book book = bookService.findById(id);

                        req.setAttribute("book", book);
                        System.out.println("view/book/book-detail.jsp");
                        System.out.println("Gohere");
                        req.getRequestDispatcher("/view/book/book-detail.jsp").forward(req, resp);
                }
                else if (url.contains("books")){
                        List<Book> list = bookService.findAll();

                        req.setAttribute("listbook", list);
                        req.getRequestDispatcher("/view/book/book-list.jsp").forward(req, resp);
                }
        }
}
