package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by yuyufeng on 2017/4/24.
 */
@WebServlet(name = "TestServlet",urlPatterns = "/testServlet")
public class TestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("TestServlet.doPost");
        request.getRequestDispatcher("/WEB-INF/jsp/test/test.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("TestServlet.doGet");
        this.doPost(request,response);
    }
}
