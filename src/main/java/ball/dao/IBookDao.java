package ball.dao;

import ball.entity.Book;
import ball.entity.Users;

import java.util.List;

public interface IBookDao {
        void insert(Book book);

        void update(Book book);

        void delete(int bookid) throws Exception;

        Book findById(int bookid);


        List<Book> findAll(int page, int pagesize);

        int count();
        public List<Book> findAll();
}
