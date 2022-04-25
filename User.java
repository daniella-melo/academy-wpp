import java.util.*;

public class User{
    
    private String name;
    private List<Chat> chats;

    public User(String nome){
        this.name = nome;
        this.chats = new ArrayList<Chat>();
    }

    public void addChat(Chat chat){
        this.chats.add(chat);
    }
    
    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public List<Chat> getChats(){
        return this.chats;
    }

}