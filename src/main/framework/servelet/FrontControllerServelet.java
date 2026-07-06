package main.framework.servelet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FrontControllerServelet extends HttpServlet {
    public void processrequest(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String url = req.getRequestURI();
        PrintWriter out = resp.getWriter();


        out.println(url);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processrequest(req, resp);
    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processrequest(req, resp);
    }
    
}
