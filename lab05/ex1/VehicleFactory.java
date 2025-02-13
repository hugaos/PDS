package lab05.ex1;

public class VehicleFactory {

    public static Motociclo createMotociclo(String matricula, String marca, String modelo, int cilindrada,
            String tipo) {
        return new Motociclo(matricula, marca, modelo, cilindrada, tipo);
    }

    public static VeiculoLigeiro createAutomovelLigeiro(String matricula, String marca, String modelo, int cilindrada,
            String numQuadro, int capBagageira) {
        return new VeiculoLigeiro(matricula, marca, modelo, cilindrada, numQuadro, capBagageira);
    }

    public static Taxi createTaxi(String matricula, String marca, String modelo, int cilindrada,
            String numQuadro, int capBagageira, String numLicenca) {
        return new Taxi(matricula, marca, modelo, cilindrada, numQuadro, capBagageira, numLicenca);
    }

    public static PPEletrico createPPEletrico(String matricula, String marca, String modelo, int potencia,
            int cilindrada, String numQuadro,
            double peso, int numPassageiros, double autonomia) {
        return new PPEletrico(matricula, marca, modelo, potencia, cilindrada, numQuadro, peso, numPassageiros,
                autonomia);
    }

    public static ALEletrico createALEletrico(String matricula, String marca, String modelo, int cilindrada,
            String numQuadro,
            int capBagageira, int peso, int autonomia) {
        return new ALEletrico(matricula, marca, modelo, cilindrada, numQuadro, capBagageira, peso, autonomia);
    }

    public static PesadoMercadorias createPesadoMercadorias(String matricula, String marca, String modelo,
            int cilindrada, String numQuadro, double peso,
            double cargaMaxima) {
        return new PesadoMercadorias(matricula, marca, modelo, cilindrada, numQuadro, peso, cargaMaxima);
    }

    public static PesadoPassageiros createPesadoPassageiros(String matricula, String marca, String modelo, int potencia,
            int cilindrada,
            String numQuadro,
            double peso,
            int numPassageiros) {
        return new PesadoPassageiros(matricula, marca, modelo, potencia, cilindrada, numQuadro, peso, numPassageiros);
    }
}
