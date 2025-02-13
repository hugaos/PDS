
import java.util.Date;

public class Employee implements EmployeeInterface{
    private String name;
    public Employee(String name){
        this.name = name;
    }
    public void start(Date date){
        System.out.println("Employee " + name + " started on " + date);
    }
    public void terminate(Date date){
        System.out.println("Employee " + name + " terminated on " + date);
    }
    public void work(){
        System.out.println("Employee " + name + " is working");
    }

}
