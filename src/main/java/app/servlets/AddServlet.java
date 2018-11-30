package app.servlets;

import app.dao.HeroDao;
import app.dao.HeroDaoImpl;
import app.entities.Hero;
import app.model.Model;
//import org.apache.commons.codec.binary.Base64;
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
       String strId = req.getParameter("id");
       if(strId != null){
           HeroDao hd = new HeroDaoImpl();
           req.setAttribute("hero",hd.getHeroById(Integer.parseInt(strId)));
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("pages/add.jsp");
        requestDispatcher.forward(req, resp);
    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String active = "";
            if (req.getParameter("name").length()>0) {
                String name = req.getParameter("name");
                String strId = req.getParameter("id");
                String universe = req.getParameter("universe");
                String strpower = req.getParameter("power");
                boolean alive = Boolean.parseBoolean(req.getParameter("alive"));
                String description = req.getParameter("description");
                String phone = req.getParameter("phone");
                // File file = (File)req.getAttribute("photo");
                //byte[] encodeBase64 = Base64.encodeBase64(extractBytes(file));
                // String base64Encoded = new String(encodeBase64, "UTF-8");
                int power =0 ;
                if(strpower.length()>0){power = Integer.parseInt(strpower);}
                Hero upHero;
                HeroDao hd = new HeroDaoImpl();

                if (strId.length()>0) {
                    hd.updateHero(new Hero(name, Integer.parseInt(strId), universe, power, alive, description, phone));
                    active = "Hero changed!";

                }
                else {
                    hd.addHero(new Hero(name, 0, universe, power, alive, description, phone));
                    active = "Hero added!";
                }


                    req.setAttribute("active", active);
                req.setAttribute("heroName", name);
                 RequestDispatcher requestDispatcher = req.getRequestDispatcher("pages/add.jsp");
                requestDispatcher.forward(req, resp);
            }
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
