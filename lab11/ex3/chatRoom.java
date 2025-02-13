package ex3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class chatRoom implements chatRoomMediator {
    private Map<String, List<User>> rooms = new HashMap<>();

    @Override
    public void sendMessage(String message, String roomName, User user) {
        List<User> users = rooms.get(roomName);
        if (users != null) {
            for (User u : users) {
                // Don't send the message to the user who sent it
                if (u != user) {
                    u.receive(message, roomName);
                }
            }
        }
    }

    @Override
    public void addUserToRoom(String roomName, User user) {
        List<User> users = rooms.get(roomName);
        if (users == null) {
            users = new ArrayList<>();
            rooms.put(roomName, users);
        }
        users.add(user);
    }
}