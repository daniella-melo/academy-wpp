import java.time.format.DateTimeFormatter;
import java.util.*;

public class Chat{
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
        ArrayList<User> allUsers = getAllParticipants();
        Collections.sort(allUsers);
        return allUsers;
    }

    public ArrayList<User> getAllParticipants(){
        ArrayList<User> auxUsers = new ArrayList<>();
        for (Message message : messages) {
            User receiver = message.getReceiverUser();
            User sender = message.getSenderUser();

            if(userExists(receiver, this.users) && !userExists(receiver, auxUsers)) auxUsers.add(receiver);
            if(userExists(sender, this.users) && !userExists(sender, auxUsers)) auxUsers.add(sender);
        }
        return auxUsers;
    }

    public int totalNumberOfParticipants(){
        return this.users.size();
    }

    public boolean userExists(User user, ArrayList<User> listToSearch){
        for (User u : listToSearch) {
            if (u.getName() == user.getName()) return true;
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