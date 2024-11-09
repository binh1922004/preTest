package ball.service;

import ball.entity.Book;

import java.util.List;

public interface IBookService {

        public void insert(Book book);
        public void update(Book book);
        public void delete(int bookid) throws Exception;
        public List<Book> findAll();
        public List<Book> findAllPagin(int pageNumber, int pageSize);
        public int count();
        public Book findById(int id);
}
