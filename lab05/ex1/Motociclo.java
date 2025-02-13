package lab05.ex1;

public class Motociclo extends Veiculo {
    private String tipo;

    public Motociclo(String matricula, String marca, String modelo, int cilindrada, String tipo) {
        super(matricula, marca, modelo, cilindrada);
        if (!tipo.equals("desportivo") && !tipo.equals("estrada"))
            throw new IllegalArgumentException("tipo inválido");
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "Motociclo" + "\n    Matricula: " + this.getMatricula() + "\n    Marca: " + this.getMarca()
                + "\n    Modelo: " + this.getModelo();
    }
}
