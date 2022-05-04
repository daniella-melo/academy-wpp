import java.time.format.DateTimeFormatter;
import java.util.*;

public class SingleChat extends Chat{
  
    public void print(){
        for (Message message : super.getMessages()) {
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
        for (Message message :  super.getMessages()) {
            User receiver = message.getReceiverUser();
            User sender = message.getSenderUser();

            if(userExists(receiver, super.getUsers()) && !userExists(receiver, auxUsers)) auxUsers.add(receiver);
            if(userExists(sender,super.getUsers()) && !userExists(sender, auxUsers)) auxUsers.add(sender);
        }
        return auxUsers;
    }
}