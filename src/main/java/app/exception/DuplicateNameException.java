package app.exception;

//хорошая задумка
public class DuplicateNameException extends Exception {
    public String Name;
    public DuplicateNameException(String name){
        super("\n Имя " + name +" дублируется");
        Name=name;
    }
}
