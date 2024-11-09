package ball.controller.Auth;

import ball.service.IUserService;
import ball.service.imp.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet("/login")
public class LoginController extends HttpServlet {

        IUserService userService = new UserServiceImpl();
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                req.getRequestDispatcher("/view/login.jsp").forward(req, resp);
        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                String email = req.getParameter("email");
                String pass = req.getParameter("pass");

                System.out.println("go here");

                if (userService.checkLogin(email, pass)){
                        req.getRequestDispatcher("/view/admin/test.jsp").forward(req, resp);
                }
                else{
                        System.out.println("Some error");
                }
        }
}
