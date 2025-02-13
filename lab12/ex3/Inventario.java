package lab12.ex3;

public class Inventario implements StateInterface{
    public void devolve(Livro livro) {
        System.out.println("Operação nao disponivel");
    }
    public void requesita(Livro livro) {
        System.out.println("Operação nao disponivel");    
        }
    public void reserva(Livro livro) {
        System.out.println("Operação nao disponivel");
    }
    public void cancelaReserva(Livro livro) {
        System.out.println("Operação nao disponivel");
    }
    public void regista(Livro livro) {
        livro.setState(new Disponivel());
    }

}
