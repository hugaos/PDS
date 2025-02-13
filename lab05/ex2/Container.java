package lab05.ex2;
import lab05.ex2.Portion.State;
import lab05.ex2.Portion.Temperature;
public abstract class Container{
    private Portion portion;

    public Container(Portion portion) {
        this.portion = portion;
    }

    public Portion getPortion() {
        return portion;
    }
    public static Container create(Portion portion) {
        if (portion.getState() == State.Liquid) {
            if (portion.getTemperature() == Temperature.COLD) {
                return new PlasticBottle(portion);
            }
            return new TermicBottle(portion);

        } else if (portion.getState() == State.Solid) {
            if (portion.getTemperature() == Temperature.COLD) {
                return new PlasticBag(portion);
            }
            return new Tupperware(portion) ;
        }
        return null;
    }

}
