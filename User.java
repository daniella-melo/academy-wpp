import java.util.*;

public class User implements Comparable<User>{
    
    private String name;
    private ArrayList<Chat>  chats;

    public User(String nome){
        this.name = nome;
        this.chats = new ArrayList<Chat>();
    }

    public void addChat(Chat chat){
        this.chats.add(chat);
    }

    public void sendMessage(User to, String content, MessageEnum type){
        Message message = new Message(content, to, this, type);
        this.registerMessage(message, to);
        to.receiveMessage(this, content, type);
    }

    public void receiveMessage(User from, String content, MessageEnum type){
        Message message = new Message(content, this, from, type);
        this.registerMessage(message, from);
    }

    public void registerMessage(Message message, User foreign){
        if(!this.getChats().isEmpty()){
            //verificar se ja existe um chat entre os dois usuarios
            for(int i = 0; i < chats.size(); i++){
                if(chats.get(i).exists(this, foreign)) {
                    //adiciona a mensagem no chat
                    chats.get(i).addMessage(message);
                    return;
                } 
            }
        }
        Chat newChat = new Chat();
        newChat.addMessage(message);
        this.addChat(newChat);
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public ArrayList<Chat>  getChats(){
        return this.chats;
    }

    @Override
    public int compareTo(User u) {
        if(this.equals(u)) return 1;
        return 0;
    }

 
}