package src;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;

public class Chat {

    private ArrayList<Message> messages;
    private ArrayList<User> users;

    public Chat(){
        this.messages = new ArrayList<Message>();
        this.users = new ArrayList<User>();
    }

    public ArrayList<Message> getMessages(){
        return this.messages;
    }

    public void addMessage(Message message){
        this.messages.add(message);
    }
    
    public int existsBetween(ArrayList<User> listUsers){
        int validUsers = 0;
        for (User user : listUsers) {
            if (userExists(user, listUsers)) validUsers++;
        }
        return validUsers;
    }

    public void print(){
        for (Message message : messages) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            System.out.println( message.getDate().format(formatter) + " " + message.getSenderUser().getName() + ": " + message.getContent());
        }
    }

    public ArrayList<User> listParticipants(){
        Collections.sort(this.getUsers());
        return this.getUsers();
    }

    public int totalNumberOfParticipants(){
        return this.users.size();
    }

    public boolean userExists(User user, ArrayList<User> listToSearch){
        for (User u : listToSearch) {
            if (u == user) return true;
        }
        return false;
    }

    public ArrayList<User> getUsers(){
        return this.users;
    }

    public void addUser(User user){
        this.users.add(user);
    }

    public void addMultipleUsers(ArrayList<User> users){
        for (User u : users) {
            this.users.add(u);
        }
    }

}
