
public interface Product {
	String code();
	String description();
	double points();
	boolean share(Client client);
	boolean giveBack(Client client);
	
}
