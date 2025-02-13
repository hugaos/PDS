

public class TeamMember extends BaseDecorater{
    public TeamMember(EmployeeInterface employee){
        super(employee);
    }
    public void colaborate(){
        System.out.println("Team member is working with team");
    }
}
