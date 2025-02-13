
import java.util.Vector;
class Database { // Data elements
    private Vector<Employee> employees; // Stores the employees

    public Database() {
        employees = new Vector<>();
    }

    public boolean addEmployee(Employee employee) {
        // Code to add employee
        employees.add(employee);
        return true;
    }

    public void deleteEmployee(long emp_num) {
        // Code to delete employee
        for (Employee employee : employees) {
            if (employee.getEmpNum() == emp_num) {
                employees.remove(employee);
                break;
            }
        }
    }

    public Employee[] getAllEmployees() {
        // Code to retrieve collection
        for (Employee employee : employees) {
            System.out.println(employee.getName());
        }
        return employees.toArray(new Employee[0]);
    }
}