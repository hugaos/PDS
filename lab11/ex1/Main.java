
public class Main {
    public static void main(String[] args) {
        Produto p1, p2, p3, p4, p5;
        Cliente c1, c2, c3;
        Gestor g1;
        Leilao l1;
        p1 = new Produto("Produto 1", 10);
        p2 = new Produto("Produto 2", 20);
        p3 = new Produto("Produto 3", 30);
        p4 = new Produto("Produto 4", 40);
        p5 = new Produto("Produto 5", 50);

        c1 = new Cliente("Cliente 1");
        c2 = new Cliente("Cliente 2");
        c3 = new Cliente("Cliente 3");

        g1 = new Gestor("Gestor 1");

        l1 = new Leilao();
        l1.addObserver(g1);

        l1.iniciarLeilao(p5, 10);
        l1.placeBid(c1 , 0, p2);
        l1.placeBid(c2 , 20, p2);
        l1.placeBid(c3 , 30, p2);

        l1.finalizarLeilao(p5);

    }



}
