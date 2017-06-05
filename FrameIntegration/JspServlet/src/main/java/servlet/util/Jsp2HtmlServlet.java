package servlet.util;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

/**
 * Created by yuyufeng on 2017/5/25.
 */
@WebServlet(name = "Jsp2HtmlServlet",urlPatterns = "/jsp2HtmlServlet")
public class Jsp2HtmlServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("userName","yuyu爱抚");
        request.getRequestDispatcher("WEB-INF/jsp/util/jsp2Html.jsp").forward(request,response);
    }
}
