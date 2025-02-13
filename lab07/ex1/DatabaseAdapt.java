public class DatabaseAdapt implements AdaptInterface{
    private Database db;

    public DatabaseAdapt() {
        db = new Database();
    }

    public void addEmpregado(Empregado emp) {;
        Employee empregado = new Employee(emp.nome() + " " + emp.apelido(), (long) emp.codigo(),
                emp.salario());

        db.addEmployee(empregado);
    }

    public void deleteEmpregado(int empNum) {
        db.deleteEmployee(empNum);
    }

    public boolean isEmployee(int empNum) {
        Employee[] empList = db.getAllEmployees();
        if (empList == null) {
            return false;
        }
        for (Employee emp : empList) {
            if (emp.getEmpNum() == empNum) {
                return true;
            }
        }
        return false;
    }

    public void listEmpregados() {
        Employee[] empList = db.getAllEmployees();
        if (empList == null) {
            System.out.println("No employees found.");
            return;
        }
        for (Employee emp : empList) {
            System.out.println("Employee: " + emp.getName() + " (ID: " + emp.getEmpNum() + ")");
        }
    }
    
}
