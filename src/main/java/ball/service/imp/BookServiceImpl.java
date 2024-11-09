package ball.service.imp;

import ball.dao.IBookDao;
import ball.dao.imp.BookDaoImpl;
import ball.entity.Book;
import ball.service.IBookService;

import java.util.List;

public class BookServiceImpl implements IBookService {
        IBookDao bookDao = new BookDaoImpl();

        @Override
        public void insert(Book book) {
                bookDao.insert(book);
        }

        @Override
        public void update(Book book){
                bookDao.update(book);
        }

        @Override
        public void delete(int bookid) throws Exception {
                bookDao.delete(bookid);
        }
        @Override
        public List<Book> findAll() {
                return bookDao.findAll();
        }

        @Override
        public List<Book> findAllPagin(int pageNumber, int pageSize) {
                return bookDao.findAllPaging(pageNumber, pageSize);
        }

        @Override
        public int count() {
                return bookDao.count();
        }


        @Override
        public Book findById(int id) {
                return bookDao.findById(id);
        }

}
