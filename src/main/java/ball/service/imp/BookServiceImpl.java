package ball.service.imp;

import ball.dao.IBookDao;
import ball.dao.imp.BookDaoImpl;
import ball.entity.Book;
import ball.service.IBookService;

import java.util.List;

public class BookServiceImpl implements IBookService {
        IBookDao bookDao = new BookDaoImpl();
        @Override
        public List<Book> findAll() {
                return bookDao.findAll();
        }

        @Override
        public Book findById(int id) {
                return bookDao.findById(id);
        }

}
