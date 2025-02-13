package ex3;

interface chatRoomMediator {
    void sendMessage(String message, String roomName, User user);

    void addUserToRoom(String roomName, User user);
}