

public class TeamLeader extends BaseDecorater{
    public TeamLeader(EmployeeInterface employee){
        super(employee);
    }
    public void plan(){
        System.out.println("Team leader is planning");
    }
}
