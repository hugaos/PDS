
import java.util.Date;

public class BaseDecorater implements EmployeeInterface{
    private EmployeeInterface employee;
    public BaseDecorater(EmployeeInterface employee){
        this.employee = employee;
    }
    public void start(Date date){
        employee.start(date);
    }
    public void terminate(Date date){
        employee.terminate(date);
    }
    public void work(){
        employee.work();
    }
    
}
