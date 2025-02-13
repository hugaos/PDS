

public class Manager extends BaseDecorater{
    public Manager(EmployeeInterface employee){
        super(employee);
    }
    public void manage(){
        System.out.println("Manager is managing");
    }
}
