package lab10.ex2;

public interface Handler {
    public Handler pickNextChef(Handler handler);

    public boolean handleRequest(String request);
}
