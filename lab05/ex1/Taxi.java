package lab05.ex1;

public class Taxi extends VeiculoLigeiro {
    private String numLicenca;

    public Taxi(String matricula, String marca, String modelo, int cilindrada, String numQuadro, int capBagageira,
            String numLicenca) {
        super(matricula, marca, modelo, cilindrada, numQuadro, capBagageira);
        this.numLicenca = numLicenca;
    }

    public String getNumLicenca() {
        return numLicenca;
    }

    @Override
    public String toString() {
        return "Taxi" + "\n    Matricula: " + this.getMatricula() + "\n    Marca: " + this.getMarca() + "\n    Modelo: "
                + this.getModelo();
    }
}
