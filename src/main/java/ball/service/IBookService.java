package ball.service;

import ball.entity.Book;

import java.util.List;

public interface IBookService {

        public List<Book> findAll();
        public Book findById(int id);
}
