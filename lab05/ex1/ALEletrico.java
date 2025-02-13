package lab05.ex1;

public class ALEletrico extends VeiculoLigeiro implements VeiculoEletrico {
    private int autonomia;
    private double peso;

    // ("88-IJ-90", "Tesla", "Model 3", 500, "ALE123456789",500, 1000, 2000)

    public ALEletrico(String matricula, String marca, String modelo, int cilindrada, String numQuadro, int capBagageira,
            double peso, int autonomia) {
        super(matricula, marca, modelo, cilindrada, numQuadro, capBagageira);
        this.peso = peso;
        this.autonomia = autonomia;
    }

    public double getAutonomia() {
        return this.autonomia;
    }

    public double getPeso() {
        return this.peso;
    }

    public void carregar(int autonomia) {
        autonomia = 100;
    }

    public int autonomia() {
        return 0;
    }

    @Override
    public String toString() {
        return "Automovel Ligeiro Eletrico" + "\n    Matricula: " + this.getMatricula() + "\n    Marca: "
                + this.getMarca() + "\n    Modelo: " + this.getModelo();
    }
}
