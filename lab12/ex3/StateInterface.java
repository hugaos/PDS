package lab12.ex3;

public interface StateInterface {
    public void regista(Livro livro);
    public void requesita(Livro livro);
    public void devolve(Livro livro);
    public void reserva(Livro livro);
    public void cancelaReserva(Livro livro);

}