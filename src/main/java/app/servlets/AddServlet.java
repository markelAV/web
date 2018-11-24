package app.servlets;

import app.entities.Hero;
import app.model.Model;
import org.apache.commons.codec.binary.Base64;

import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

public class AddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nameHero = req.getParameter("name");
        if(nameHero!=null){
            Model model = Model.getInstance();
            req.setAttribute("hero",model.findHero(nameHero));
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("pages/add.jsp");
        requestDispatcher.forward(req, resp);
    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String name = req.getParameter("name");
            int id = Integer.parseInt(req.getParameter("id"));
            String universe = req.getParameter("universe");
            int power = Integer.parseInt(req.getParameter("power"));
            boolean alive = Boolean.parseBoolean(req.getParameter("alive"));
            String description = req.getParameter("description");
            String phone = req.getParameter("phone");
           // File file = (File)req.getAttribute("photo");
            //byte[] encodeBase64 = Base64.encodeBase64(extractBytes(file));
           // String base64Encoded = new String(encodeBase64, "UTF-8");
            Hero heroI = (Hero)req.getAttribute("hero");
            if(heroI!=null){
                heroI.setName(name);
                heroI.setId(id);
                heroI.setUniverse(universe);
                heroI.setPower(power);
                heroI.setAlive(alive);
                heroI.setDescription(description);
                heroI.setPhone(phone);
            }
            else {
                Hero hero = new Hero(name, id, universe, power, alive, description, phone);
                Model model = Model.getInstance();
                model.add(hero);
            }

            req.setAttribute("heroName", name);
            doGet(req, resp);
        }
        catch (IOException e){
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }
    }
    private byte[] extractBytes (File imgPath) throws IOException {

        BufferedImage bufferedImage = ImageIO.read(imgPath);

        // get DataBufferBytes from Raster
        WritableRaster raster = bufferedImage .getRaster();
        DataBufferByte data   = (DataBufferByte) raster.getDataBuffer();

        return ( data.getData() );
    }
}
