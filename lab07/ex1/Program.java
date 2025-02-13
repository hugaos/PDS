public class Program {
    public static void main(String[] args) {
        AdaptInterface databaseAdapter = new DatabaseAdapt();
        AdaptInterface registosAdapter = new RegistosAdapter();

        // Adicionando funcionários
        databaseAdapter.addEmpregado(new Empregado("Pedro", "Silva", 101, 45000));
        databaseAdapter.addEmpregado(new Empregado("Maria", "Santos", 102, 55000));
        registosAdapter.addEmpregado(new Empregado("John", "Doe", 201, 60000));
        registosAdapter.addEmpregado(new Empregado("Alice", "Smith", 202, 70000));

        // Listando funcionários
        System.out.println("Funcionários na base de dados:");
        databaseAdapter.listEmpregados();
        System.out.println("\nFuncionários nos registros:");
        registosAdapter.listEmpregados();

        // Removendo funcionários
        databaseAdapter.deleteEmpregado(101);
        registosAdapter.deleteEmpregado(202);

        // Listando funcionários após remoção
        System.out.println("\nFuncionários na base de dados após remoção:");
        databaseAdapter.listEmpregados();
        System.out.println("\nFuncionários nos registros após remoção:");
        registosAdapter.listEmpregados();
    }
}
