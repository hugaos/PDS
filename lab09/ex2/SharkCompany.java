package lab09.ex2;
import java.util.List;


public class SharkCompany {
	public static void main(String[] args) {
		Person[] persons = { new Person("Pedro"),
				new Person("Mafalda"),
				new Person("Profjam")};
		Company shark = new Company();
		Company.user = User.COMPANY;
		shark.admitEmployee(persons[0], 1000);
		shark.admitEmployee(persons[1], 900);
		shark.admitEmployee(persons[2], 1200);
		List<Employee> sharkEmps = shark.employees();
		for (Employee e : sharkEmps)
			System.out.println(e.getSalary());
		shark.paySalaries(1);

		for (Person p : persons) {
			assert shark.getSocialSecurity().getAderentes().contains(p);
			assert shark.getInsurance().getAderentes().contains(p);
		}

		System.out.println("\nSalário médio: " + shark.averageSalary());
		System.out.println("Permitido: " + shark.getParking().getPermitidos().contains(persons[0]) + "\tSalário: "
				+ sharkEmps.get(0).getSalary());
		System.out.println("Permitido: " + shark.getParking().getPermitidos().contains(persons[1]) + "\tSalário: "
				+ sharkEmps.get(1).getSalary());
		System.out.println("Permitido: " + shark.getParking().getPermitidos().contains(persons[2]) + "\t\tSalário: "
				+ sharkEmps.get(2).getSalary());
	}
}