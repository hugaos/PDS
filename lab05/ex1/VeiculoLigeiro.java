package lab05.ex1;

public class VeiculoLigeiro extends Veiculo {
    private String numQuadro;
    private int capBagageira;

    public VeiculoLigeiro(String matricula, String marca, String modelo, int cilindrada, String numQuadro,
            int capBagageira) {
        super(matricula, marca, modelo, cilindrada);
        this.numQuadro = numQuadro;
        this.capBagageira = capBagageira;
    }

    public String getNumQuadro() {
        return numQuadro;
    }

    public int getCapBagageira() {
        return capBagageira;
    }

    @Override
    public String toString() {
        return "Automóvel Ligeiro" + "\n    Matrícula: " + this.getMatricula() + "\n    Marca: " + this.getMarca()
                + "\n    Modelo: " + this.getModelo();
    }
}
