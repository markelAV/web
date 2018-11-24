package app.entities;

import java.io.File;

public class Hero {
    private int id;
    private String name;
    private String universe;
    private int power;
    private String description;
    private boolean alive;
   // private String logo;
    private String phone;

    public Hero(String name, int id, String universe, int power, boolean alive, String description, String phone){
        this.name=name;
        this.id =id;
        this.universe=universe;
        this.power = power;
        this.alive =alive;
        this.description=description;
        this.phone=phone;
       // this.logo=logo;
    }
    public int getId(){
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getUniverse() { return universe; }

    public void setUniverse(String universe) {
        this.universe = universe;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getPower() {
        return power;
    }

    public void setDescription(String descreption) {
        this.description = descreption;
    }

    public String getDescreption() {
        return description;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

  /*  public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }*/

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("Name: ")
                .append(name)
                .append(", id:")
                .append(id)
                .append(", universe: ")
                .append(universe)
                .append(", power")
                .append(power)
                .append(", description: ")
                .append(description)
                .append(", Alive is ")
                .append(alive)
                .append(", Telephone: ")
                .append(phone)
                .append('.');
        return str.toString();
    }

    @Override
    public int hashCode() {
        //todo Допилить метод
        //todo запилить проверку
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (universe != null ? universe.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (universe != null ? 1231 : 1237);
        result = 31 * result + (id != 0 ? 1231 : 0);

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        //todo Допилить реализацию
        boolean flag = false;
        if(obj==this) return true;
        if(obj==null) return false;

        return super.equals(obj);
    }
}
