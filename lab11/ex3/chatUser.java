package ex3;

class chatUser extends User {

    public chatUser(chatRoomMediator mediator, String name) {
        super(mediator, name);
    }

    @Override
    public void send(String message, String roomName) {
        System.out.println(this.name + " is sending: " + message + " to " + roomName);
        mediator.sendMessage(message, roomName, this);
    }

    @Override
    public void receive(String message, String roomName) {
        System.out.println(this.name + " received: " + message + " in " + roomName);
    }
}
