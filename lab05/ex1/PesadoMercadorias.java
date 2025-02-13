package lab05.ex1;

public class PesadoMercadorias extends Veiculo {
    private String numQuadro;
    private double peso;
    private double cargaMaxima;

    public PesadoMercadorias(String matricula, String marca, String modelo, int cilindrada, String numQuadro,
            double peso,
            double cargaMaxima) {
        super(matricula, marca, modelo, cilindrada);
        this.numQuadro = numQuadro;
        this.peso = peso;
        this.cargaMaxima = cargaMaxima;
    }

    public String getNumQuadro() {
        return numQuadro;
    }

    public double getPeso() {
        return peso;
    }

    public double getCargaMaxima() {
        return cargaMaxima;
    }

    @Override
    public String toString() {
        return "Pesado de Mercadorias" + "\n    Matricula: " + this.getMatricula() + "\n    Marca: " + this.getMarca()
                + "\n    Modelo: " + this.getModelo();
    }
}
