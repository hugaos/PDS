import java.util.List;

public class RegistosAdapter implements AdaptInterface {
    private Registos reg = new Registos();

    public void addEmpregado(Empregado emp) {
        reg.insere(emp);
    }

    public void deleteEmpregado(int empNum) {
        reg.remove(empNum);
    }

    public boolean isEmployee(int empNum) {
        return reg.isEmpregado(empNum);
    }

    public void listEmpregados() {
        List<Empregado> empList = reg.listaDeEmpregados();
        if (empList == null) {
            System.out.println("No employees found.");
            return;
        }
        for (Empregado emp : empList) {
            System.out.println("Employee: " + emp.nome() + " " + emp.apelido() + " (ID: " + emp.codigo() + ")");
        }
    }
}
