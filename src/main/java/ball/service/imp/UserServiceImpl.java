package ball.service.imp;

import ball.service.IUserService;
import ball.dao.IUserDao;
import ball.dao.imp.UserDaoImpl;

public class UserServiceImpl implements IUserService {
        IUserDao userDao = new UserDaoImpl();
        @Override
        public boolean checkLogin(String email, String pass) {
                return userDao.checkLogin(email, pass);
        }
}
