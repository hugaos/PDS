package lab05.ex1;

public class PPEletrico extends PesadoPassageiros implements VeiculoEletrico {
    private double autonomia;

    public PPEletrico(String matricula, String marca, String modelo, int potencia, int cilindrada, String numQuadro,
            double peso, int numPassageiros, double autonomia) {
        super(matricula, marca, modelo, potencia, cilindrada, numQuadro, peso, numPassageiros);
        this.autonomia = autonomia;
    }

    public double getAutonomia() {
        return autonomia;
    }

    public void carregar(int autonomia) {
        autonomia = 100;
    }

    public int autonomia() {
        return 0;
    }

    @Override
    public String toString() {
        return "Pesado de Passageiros Eletrico" + "\n    Matricula: " + this.getMatricula() + "\n    Marca: "
                + this.getMarca() + "\n    Modelo: " + this.getModelo();
    }
}
