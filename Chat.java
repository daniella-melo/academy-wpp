import java.util.*;

public class Chat{
    private ArrayList<Message> messages;
    
    public Chat(){
        this.messages = new ArrayList<Message>();
    }

    public ArrayList<Message> getMessages(){
        return this.messages;
    }

    public void addMessage(Message message){
        this.messages.add(message);
    }
    
    public boolean exists(User user1, User user2){
        for (Message message : messages) {
            if((message.getReceiverUser() == user1 || message.getReceiverUser() == user1) && 
            (message.getSenderUser() == user2 || message.getSenderUser() == user2)) return true;
        }
        return false;
    }

    public void print(){
        for (Message message : messages) {
            System.out.println("formatar data aqui " + message.getSenderUser().getName() + ": " + message.getContent());
        }
    }
}