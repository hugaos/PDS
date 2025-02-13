package ex3;

public class Main {
    public static void main(String[] args) {
        chatRoomMediator mediator = new chatRoom();

        User user1 = new chatUser(mediator, "Alice");
        User user2 = new chatUser(mediator, "Bob");
        User user3 = new chatUser(mediator, "Charlie");

        mediator.addUserToRoom("Room1", user1);
        mediator.addUserToRoom("Room1", user2);
        mediator.addUserToRoom("Room2", user2);
        mediator.addUserToRoom("Room2", user3);

        user1.send("Hello everyone!", "Room1");
        user2.send("Hey Alice!", "Room1");
        user3.send("Hello Bob!", "Room2");
    }
}
