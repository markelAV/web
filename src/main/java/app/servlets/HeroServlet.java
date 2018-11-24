package app.servlets;

import app.entities.Hero;
import app.model.Model;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HeroServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        Model model = Model.getInstance();
        Hero hero = model.findHero(name);
        req.setAttribute("hero",hero);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("pages/hero.jsp");
        requestDispatcher.forward(req, resp);

    }
}
