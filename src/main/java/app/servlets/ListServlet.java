package app.servlets;

import app.dao.HeroDao;
import app.dao.HeroDaoImpl;
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
       // Model model = Model.getInstance();
        HeroDao heroesDB = new HeroDaoImpl();
        String id = req.getParameter("id");
        if(id!=null){
           heroesDB.removeHero(Integer.parseInt(req.getParameter("id")));
        }

       boolean flag = Boolean.parseBoolean(req.getParameter("alive"));

      List<Hero> heroes;
       if(flag){
           heroes=((HeroDaoImpl) heroesDB).getChangeHeroes(true);
       }
       else{
           heroes=((HeroDaoImpl) heroesDB).getChangeHeroes(false);
       }



        req.setAttribute("heroes", heroes);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("pages/list.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // System.out.println("Запущен метод delete");
        Model model = Model.getInstance();
        String name = req.getParameter("id");
        if(name!=null){
            //System.out.println("Передача имени и запуск метода");
             model.remove(Integer.parseInt(name));
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("pages/list.jsp");
        requestDispatcher.forward(req, resp);

    }
}
