package lab12.ex3;

public class Disponivel implements StateInterface{
    public void devolve(Livro livro) {
        System.out.println("Operação nao disponivel");
    }

    public void requesita(Livro livro) {
        livro.setState(new Emprestado());
    }

    public void reserva(Livro livro) {
        livro.setState(new Reservado());
    }

    public void cancelaReserva(Livro livro) {
        System.out.println("Operação nao disponivel");
    }

    public void regista(Livro livro) {
        System.out.println("Operação nao disponivel");
    }
}
