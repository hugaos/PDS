
import java.util.Date;
public class Empresa {
    public static void main(String[] args) {
        EmployeeInterface employee1 = new Employee("Diogo Oliveira");
        EmployeeInterface employee2 = new Employee("benji pirce");
        EmployeeInterface employee3 = new Employee("Profjam");
        EmployeeInterface employee4 = new Employee("Hugao");

        employee1.start(new Date());
        employee1.work();
        employee1.terminate(new Date());
        System.out.println();
        

        TeamMember teamMember = new TeamMember(employee2);
        teamMember.start(new Date());
        teamMember.work();
        teamMember.colaborate();
        teamMember.terminate(new Date());
        System.out.println();


        TeamLeader teamLeader = new TeamLeader(employee3);
        teamLeader.start(new Date());
        teamLeader.work();
        teamLeader.plan();
        teamLeader.terminate(new Date());
        System.out.println();


        Manager manager = new Manager(employee4);
        manager.start(new Date());
        manager.work();
        manager.manage();
        manager.terminate(new Date());
    }
}

