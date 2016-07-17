package main.java.com.mantiso;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by xue on 16-7-17.
 */
@WebServlet(urlPatterns = {"/home"}, name = "SimpleServlet",
        initParams = {@WebInitParam(name = "ProductName", value = "Welcome Application")})
public class SimpleServlet extends HttpServlet {
    String appName = "My Application";
    String connstr = "connection string";

    @Override
    public void init() throws ServletException {
        appName = getInitParameter("ProductName");
        connstr = getServletContext().getInitParameter("connstr");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        //resp.getWriter().write("Hello World!");

        String name = req.getParameter("name");
        if (name != null)
            resp.getWriter().printf("<application>" +
                    "<name>Hello %s</name>" +
                    "<product>%s</product>" +
                    "<connectionString>%s</connectionString>" +
                    "</application>", name, appName, connstr);
        else {
            throw new ServletException("The name is not provided!");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        if (name != null && name != "")
            resp.getWriter().printf("Hello %s", name);
        else
            resp.sendRedirect("index.jsp");
    }
}
