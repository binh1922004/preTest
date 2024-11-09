package ball.dao.imp;

import ball.config.JPAConfig;
import ball.dao.IBookDao;
import ball.entity.Book;
import ball.entity.Users;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class BookDaoImpl implements IBookDao {
        @Override
        public void insert(Book book) {
                EntityManager enma = JPAConfig.getEntityManager();


                EntityTransaction trans = enma.getTransaction();
                try {
                        trans.begin();
                        //gọi phuong thức để insert, update, delete
                        enma.persist(book);
                        trans.commit();
                } catch (Exception e) {
                        e.printStackTrace();
                        trans.rollback();
                        throw e;
                } finally {
                        enma.close();
                }
        }

        @Override
        public void update(Book book) {
                EntityManager enma = JPAConfig.getEntityManager();


                EntityTransaction trans = enma.getTransaction();
                try {
                        trans.begin();
                        //gọi phuong thức để insert, update, delete
                        enma.merge(book);
                        trans.commit();
                } catch (Exception e) {
                        e.printStackTrace();
                        trans.rollback();
                        throw e;
                } finally {
                        enma.close();
                }
        }

        @Override
        public void delete(int bookid) throws Exception {
                EntityManager enma = JPAConfig.getEntityManager();
                EntityTransaction trans = enma.getTransaction();
                try {
                        trans.begin();
                        //gọi phuong thức để insert, update, delete
                        Book book = enma.find(Book.class, bookid);
                        if(book != null) {
                                enma.remove(book);
                        }else {
                                throw new Exception("Không tìm thấy");
                        }

                        trans.commit();
                } catch (Exception e) {
                        e.printStackTrace();
                        trans.rollback();
                        throw e;
                } finally {
                        enma.close();
                }
        }

        @Override
        public Book findById(int bookid) {
                EntityManager enma = JPAConfig.getEntityManager();
                return enma.find(Book.class, bookid);
        }

        @Override
        public List<Book> findAll(int page, int pagesize) {
                return null;
        }

        @Override
        public int count() {
                return 0;
        }

        @Override
        public List<Book> findAll() {
                EntityManager enma = JPAConfig.getEntityManager();
                TypedQuery<Book> query= enma.createNamedQuery("Book.findAll", Book.class);
                return query.getResultList();
        }
}
