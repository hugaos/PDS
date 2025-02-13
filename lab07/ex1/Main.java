public class Main {
    public static void main(String[] args) {
        // Database
        Database database = new Database();
        Employee emp1 = new Employee("John", 1, 50000);
        Employee emp2 = new Employee("Alice", 2, 60000);
        database.addEmployee(emp1);
        database.addEmployee(emp2);
        System.out.println("Todos os funcionários da Database:");
        for (Employee emp : database.getAllEmployees()) {
            System.out.println("Nome: " + emp.getName() + ", Número: " + emp.getEmpNum() + ", Salário: " + emp.getSalary());
        }
        database.deleteEmployee(1);
        System.out.println("Funcionários após remover John:");
        for (Employee emp : database.getAllEmployees()) {
            System.out.println("Nome: " + emp.getName() + ", Número: " + emp.getEmpNum() + ", Salário: " + emp.getSalary());
        }

        //Registos
        Registos registos = new Registos();
        Empregado empregado1 = new Empregado("Pedro", "Silva", 101, 45000);
        Empregado empregado2 = new Empregado("Maria", "Santos", 102, 55000);
        registos.insere(empregado1);
        registos.insere(empregado2);
        System.out.println("\nTodos os funcionários dos Registos:");
        for (Empregado emp : registos.listaDeEmpregados()) {
            System.out.println("Nome: " + emp.nome() + " " + emp.apelido() + ", Código: " + emp.codigo() + ", Salário: " + emp.salario());
        }
        registos.remove(101);
        System.out.println("Funcionários após remover Pedro:");
        for (Empregado emp : registos.listaDeEmpregados()) {
            System.out.println("Nome: " + emp.nome() + " " + emp.apelido() + ", Código: " + emp.codigo() + ", Salário: " + emp.salario());
        }
    }
}

