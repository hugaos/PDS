import java.util.*;

public class Produto {
    private int cod;
    private String desc;
    private double preco;
    private static int lastId=0;
    private Estado estado;
    private long tempo;

    public Produto(String desc, double preco) {
        this.desc = desc;
        this.preco = preco;
        this.cod=++lastId;
        this.estado = Estado.STOCK;
        this.tempo = 0;
    }
    
    public int getCodigo() {
        return cod;
    }

    public String getDescricao() {
        return desc;
    }

    public double getPreco() {
        return preco;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public long getTempo() {
        return tempo;
    }

    public void setTempo(long tempo) {
        this.tempo = tempo;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
}
