package ball.dao.imp;

import ball.config.JPAConfig;
import ball.dao.IUserDao;
import ball.entity.Users;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class UserDaoImpl implements IUserDao {

        @Override
        public void insert(Users user) {
                EntityManager enma = JPAConfig.getEntityManager();


                EntityTransaction trans = enma.getTransaction();
                try {
                        trans.begin();
                        //gọi phuong thức để insert, update, delete
                        enma.persist(user);
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
        public void update(Users user) {
                EntityManager enma = JPAConfig.getEntityManager();


                EntityTransaction trans = enma.getTransaction();
                try {
                        trans.begin();
                        //gọi phuong thức để insert, update, delete
                        enma.merge(user);
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
        public void delete(int userid) throws Exception {
                EntityManager enma = JPAConfig.getEntityManager();
                EntityTransaction trans = enma.getTransaction();
                try {
                        trans.begin();
                        //gọi phuong thức để insert, update, delete
                        Users user = enma.find(Users.class, userid);
                        if(user != null) {
                                enma.remove(user);
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
        public boolean checkLogin(String email, String pass) {
                EntityManager enma = JPAConfig.getEntityManager();
                String jpql = "SELECT u FROM Users u WHERE u.email like :email";
                TypedQuery<Users> query= enma.createQuery(jpql, Users.class);
                query.setParameter("email", "%" + email + "%");
                for (Users user: query.getResultList()){
                        if (user.getPasswd().equals(pass))
                                return true;
                }
                return false;
        }

        @Override
        public Users findById(int userid) {
                EntityManager enma = JPAConfig.getEntityManager();
                Users user = enma.find(Users.class, userid);
                return user;
        }

        @Override
        public List<Users> findAll() {
                EntityManager enma = JPAConfig.getEntityManager();
                TypedQuery<Users> query= enma.createNamedQuery("User.findAll", Users.class);
                return query.getResultList();
        }

        @Override
        public List<Users> findAll(int page, int pagesize) {
                EntityManager enma = JPAConfig.getEntityManager();
                TypedQuery<Users> query= enma.createNamedQuery("User.findAll", Users.class);
                query.setFirstResult(page*pagesize);
                query.setMaxResults(pagesize);
                return query.getResultList();
        }

        @Override
        public int count() {
                EntityManager enma = JPAConfig.getEntityManager();
                String jpql = "SELECT count(u) FROM Users u";
                Query query = enma.createQuery(jpql);
                return ((Long)query.getSingleResult()).intValue();
        }
}
