import java.util.ArrayList;
import java.util.List;

public class Registos{
    // Data elements
    private ArrayList<Empregado> empregados; // Stores the employees

    public Registos() {
        empregados = new ArrayList<>();
    }

    public void insere(Empregado emp) {
        empregados.add(emp);
    }

    public void remove(int codigo) {
        for (Empregado emp : empregados) {
            if (emp.codigo() == codigo) {
                empregados.remove(emp);
                break;
            }
        }
    }

    public boolean isEmpregado(int codigo) {
        // Code to find employee
        if (empregados.isEmpty()) {
            return false;
        }
        for (Empregado emp : empregados) {
            if (emp.codigo() == codigo) {
                return true;
            }
        }
        return false;
    }

    public List<Empregado> listaDeEmpregados() {
        if (empregados.isEmpty()) {
            return null;
        }
        return empregados;
    }
}
