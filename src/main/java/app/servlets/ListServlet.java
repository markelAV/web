package app.servlets;

import app.entities.Hero;
import app.model.Model;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // System.out.println("Запущен метод догет");
        if(req.getParameter("name")!=null){doDelete(req,resp);}
        Model model = Model.getInstance();
        boolean flag = Boolean.parseBoolean(req.getParameter("alive"));

        List<Hero> heroes;
        if(flag){
            heroes = model.listAliveHero();
        }
        else{
            heroes = model.listNotAliveHero();
        }

        req.setAttribute("heroes", heroes);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("pages/list.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // System.out.println("Запущен метод delete");
        Model model = Model.getInstance();
        String name = req.getParameter("name");
        if(name!=null){
            //System.out.println("Передача имени и запуск метода");
             model.remove(name);
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("pages/list.jsp");
        requestDispatcher.forward(req, resp);

    }
}
