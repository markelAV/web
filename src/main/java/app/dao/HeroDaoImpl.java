package app.dao;

import app.entities.Hero;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HeroDaoImpl implements HeroDao  {
    public int addHero(Hero hero) {
        Connection con = ConnectionDB.getConnection();
        try {
            PreparedStatement pr = con.prepareStatement("insert into "
                    + "heroes( name, universe, power, description, alive, phone) values(?,?,?,?,?,?)");
            pr.setString(1, hero.getName());
            pr.setString(2, hero.getUniverse());
            pr.setInt(3, hero.getPower());
            pr.setString(4, hero.getDescreption());
            pr.setBoolean(5,hero.isAlive());
            pr.setString(6,hero.getPhone());
            pr.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            try {
                con.close();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

            return 0;
        }
        try {
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return 1;//чтобы контролировать выполнение запроса можно выводить переменную в зависимости от успешность или неудачи выполнения запроса.
//можно также выводить айди объекта, который был добавлен в базу.
    }
    public int updateHero(Hero hero) {
        int result = 0;
        Connection con = ConnectionDB.getConnection();
        try {
            PreparedStatement pr = con.prepareStatement("update heroes set "
                    + "name=?, universe=?, power=?, description=?, alive=?, phone=? where id=?");
            pr.setString(1, hero.getName());
            pr.setString(2, hero.getUniverse());
            pr.setInt(3, hero.getPower());
            pr.setString(4, hero.getDescreption());
            pr.setBoolean(5,hero.isAlive());
            pr.setString(6,hero.getPhone());
            pr.setInt(7, hero.getId());
            result = pr.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;

    }
    public void removeHero(int id) {
        Connection con = ConnectionDB.getConnection();
        try {
            PreparedStatement pr = con.prepareStatement("delete from heroes where id=?");
            pr.setInt(1, id);
            pr.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    public Hero getHeroById(int id) {
        Hero hero = null;
        Connection connect = ConnectionDB.getConnection();
        try{
            PreparedStatement pr = connect.prepareStatement("select  id, name, universe, power, description, alive, phone, logo from heroes where id=?");
            pr.setInt(1,id);
            ResultSet rs = pr.executeQuery();
            if(rs.next()){
                hero = new Hero(rs.getString("name"),id);
                hero.setUniverse(rs.getString("universe"));
                hero.setPower(rs.getInt("power"));
                hero.setDescription(rs.getString("description"));
                hero.setAlive(rs.getBoolean("alive"));
                hero.setPhone(rs.getString("phone"));

            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        try {
            connect.close();
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return hero;
    }
    public List<Hero> getAllHeroes() {
        List<Hero> heroes = new ArrayList<Hero>();
        Hero hero = null;

        Connection con =ConnectionDB.getConnection();//getInstance().getConnection2();//
        try{
            PreparedStatement pr = con.prepareStatement("select  id, name, universe, power, description, alive, phone, logo from heroes ");
            ResultSet rs = pr.executeQuery();
            while (rs.next()){
                hero = new Hero(rs.getString("name"),rs.getInt("id"));
                hero.setUniverse(rs.getString("universe"));
                hero.setPower(rs.getInt("power"));
                hero.setDescription(rs.getString("description"));
                hero.setAlive(rs.getBoolean("alive"));
                hero.setPhone(rs.getString("phone"));
                heroes.add(hero);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        try {
            con.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return heroes;
    }
    public List<Hero> getChangeHeroes(boolean alive) {
        List<Hero> heroes = new ArrayList<Hero>();
        Hero hero = null;

        Connection con =ConnectionDB.getConnection();//getInstance().getConnection2();//
        try{
            PreparedStatement pr = con.prepareStatement("select  id, name, universe, power, description, alive, phone, logo from heroes where alive=? ");
            pr.setBoolean(1,alive);
            ResultSet rs = pr.executeQuery();
            while (rs.next()){
                hero = new Hero(rs.getString("name"),rs.getInt("id"));
                hero.setUniverse(rs.getString("universe"));
                hero.setPower(rs.getInt("power"));
                hero.setDescription(rs.getString("description"));
                hero.setAlive(rs.getBoolean("alive"));
                hero.setPhone(rs.getString("phone"));
                heroes.add(hero);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        try {
            con.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return heroes;
    }


}
