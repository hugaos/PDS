package lab12.ex3;

public class Livro {
    private StateInterface state;
    private String titulo, autor;
    private int isbn;
    private int ano;

    public Livro(String titulo, String autor, int isbn, int ano) {
        this.titulo = titulo;
        this.autor = autor;
        this.state = new Inventario();
        this.isbn = isbn;
        this.ano = ano;
    }
    public void setState(StateInterface state) {
        this.state = state;
    }

}
