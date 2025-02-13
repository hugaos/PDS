package lab05.ex1;

public class PesadoPassageiros extends Veiculo {
    private String numQuadro;
    private double peso;
    private int numPassageiros;
    private int potencia;

    public PesadoPassageiros(String matricula, String marca, String modelo, int potencia, int cilindrada,
            String numQuadro,
            double peso,
            int numPassageiros) {
        super(matricula, marca, modelo, cilindrada);
        this.potencia = potencia;
        this.numQuadro = numQuadro;
        this.peso = peso;
        this.numPassageiros = numPassageiros;
    }

    public String getNumQuadro() {
        return numQuadro;
    }

    public double getPeso() {
        return peso;
    }

    public int getnumPassageiros() {
        return numPassageiros;
    }

    public int getPotencia() {
        return potencia;
    }

    @Override
    public String toString() {
        return "Pesado de Mercadorias" + "\n    Matricula: " + this.getMatricula() + "\n    Marca: " + this.getMarca()
                + "\n    Modelo: " + this.getModelo();
    }
}
