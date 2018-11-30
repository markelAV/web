package app.entities;



import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.File;
import java.io.Serializable;

public class Hero implements Serializable {
    private int id;
    @NotNull(message="Имя должно быть задано")
    @Size(max = 25, message="Длина фамилии должна быть меньше 25")
    private String name;
    private String universe;
    private int power;
    private String description;
    private boolean alive;
   // private String logo;
    private String phone;
    static int nextId=0;
    public Hero (String name){
        this(name,0,null,0,false,null,null);
        //nextId++;
        //id=nextId;
    }
    public Hero (String name, int id){
        this(name,id,null,0,false,null,null);
    }
    public  Hero(String name, int id, String universe, int power, boolean alive, String description, String phone){
        setName(name);
        setId(id);
        setUniverse(universe);
        setPower(power);
        setAlive(alive);
        setDescription(description);
        setPhone(phone);
        // this.logo=logo;
        //nextId++;
        //id=nextId;
    }
    public void setFields(String name, String universe, int power, boolean alive, String description, String phone){
        setName(name);
        setUniverse(universe);
        setPower(power);
        setAlive(alive);
        setDescription(description);
        setPhone(phone);
       // this.logo=logo;
    }
    public int getId(){
        return id;
    }

    private void setId(int id){
        this.id=id;
    }
    //@NotNull
    public void setName(String name) {
        if(name!=null)
            this.name = name;
    }
    //@NotNull
    public String getName() {
        return name;
    }

    public String getUniverse() { return universe; }

    public void setUniverse(String universe) {
        if(universe != null && universe.length()<10)
        this.universe = universe;
    }

    public void setPower(int power) {
        if(power>0 && power<100) this.power = power;
    }

    public int getPower() {
        return power;
    }

    public void setDescription(String descreption) {
        if(descreption!= null && descreption.length()<255)
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
        if(phone!=null && phone.length()<12)
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



}
