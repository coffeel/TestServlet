package main.java.com.mantiso;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by xue on 16-7-17.
 */
@WebServlet(name = "ControllerServlet")
public class ControllerServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        ApplicationSettings applicationSettings = new ApplicationSettings();
        applicationSettings.setformCssClass("blueUser");
        getServletContext().setAttribute("app", applicationSettings);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        user.setName("Kevin");
        user.setEmail("kevin@mantiso.com");

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/index.jsp");
        request.setAttribute("user", user);
        dispatcher.forward(request, response);
    }
}
