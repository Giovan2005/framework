package main.framework.servelet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import main.framework.scanne.ScanneUtil;

public class FrontControllerServelet extends HttpServlet {
    private String nompacket;
    private List<Class<?>> listcontroller;

    @Override
    public void init() throws ServletException {
    

    nompacket = getInitParameter("ControllerPackage");

    listcontroller = ScanneUtil.getClassesAnnotatedWithController(nompacket);      

    }
    public void processrequest(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String url = req.getRequestURI();
        PrintWriter out = resp.getWriter();

        for (Class<?> controller : listcontroller) {
        out.println("Controller : " + controller.getName());
    }

        out.println(url);
        out.println(nompacket);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processrequest(req, resp);
    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processrequest(req, resp);
    }
    
}
