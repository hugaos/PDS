package ex3;

public abstract class User {
    protected chatRoomMediator mediator;
    protected String name;

    public User(chatRoomMediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    public abstract void send(String message, String roomName);

    public abstract void receive(String message, String roomName);
}