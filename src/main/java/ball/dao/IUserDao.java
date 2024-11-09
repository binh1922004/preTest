package ball.dao;

import ball.entity.Users;

import java.util.List;

public interface IUserDao {
        void insert(Users user);

        void update(Users user);

        void delete(int userid) throws Exception;

        boolean checkLogin(String email, String pass);

        Users findById(int userid);

        List<Users> findAll();

        List<Users> findAll(int page, int pagesize);

        int count();
}
