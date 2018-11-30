package app.model;

import app.entities.Hero;
import org.apache.commons.codec.binary.Base64;
//import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
//TODO добавить методов Create and Deleate
public class Model {
    private static Model instance = new Model();
    private Hero[] heroes;
    private void heroInstance(){

            heroes = new Hero[5];
            String[] names = new String[]{"Batman", "Superman", "Tor", "Spiderman", "Deadpool"};
            String[] namesFile = new String[]{"batman.jpg", "superman.jpg", "tor.jpg", "capitanAmerika.jpg", "men.jpg"};
            String[] universe = new String[]{"DC", "Marvel", "Marvel", "Marvel", "Marvel"};
            String[] description = new String[]{"Hero description 1", "Hero description 2", "Hero description 3", "Hero description 4", "Hero description 5"};
            String[] phone = new String[]{"81", "82", "83", "84", "85"};
            //int[] id = new int[]{111, 112, 113, 114, 115};
            int[] power = new int[]{74, 80, 72, 65, 81};
            boolean[] alive = new boolean[]{true, true, false, true, false};

            for (int i = 0; i < heroes.length; i++) {
                //byte[] encodeBase64 = Base64.encodeBase64(extractBytes(namesFile[i]));
               // String base64Encoded = new String(encodeBase64, "UTF-8");

               // heroes[i] = new Hero(names[i],universe[i], power[i], alive[i], description[i], phone[i]);

            }


    }
    private List<Hero> model;

    public static Model getInstance() {
        return instance;
    }

    private Model() {
        model = new ArrayList<Hero>();
        heroInstance();
        for (int i = 0; i <heroes.length ; i++) {
            model.add(heroes[i]);

        }
    }

    public void add(Hero hero) {
        model.add(hero);
    }

    public void remove (int idHero){
        Hero hero = findHero(idHero);
        if(hero!=null){
            model.remove(hero);
        }
        System.out.println("Герой с данным именем успешно удален");
    }
    public Hero findHero(int id){
        Hero hero = null;
        for (Hero herof: model) {
            if(herof.getId()==id){
                hero=herof;
                break;
            }

        }
        return hero;
    }

    public List<Hero> list() {
        return model;
    }
    public List<Hero> listAliveHero(){
        List<Hero> alivehero =new ArrayList<Hero>();
        for (Hero hero:model) {
            if(hero.isAlive()){
                alivehero.add(hero);
            }

        }
        return alivehero;
    }

    public List<Hero> listNotAliveHero(){
        List<Hero> notAliveHero =new ArrayList<Hero>();
        for (Hero hero:model) {
            if(!hero.isAlive()){
                notAliveHero.add(hero);
            }

        }
        return notAliveHero;
    }
    //multipart-form-data
    private byte[] extractBytes (String ImageName) throws IOException {
        // open image
        File imgPath = new File(ImageName);
        BufferedImage bufferedImage = ImageIO.read(imgPath);

        // get DataBufferBytes from Raster
        WritableRaster raster = bufferedImage .getRaster();
        DataBufferByte data   = (DataBufferByte) raster.getDataBuffer();

        return ( data.getData() );
    }
}
