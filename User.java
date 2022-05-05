import java.util.*;

public class User implements Comparable<User>{
    
    private String name;
    private ArrayList<Chat>  chats;
    private ArrayList<Group> groups;

    public User(String nome){
        this.name = nome;
        this.chats = new ArrayList<Chat>();
    }

    public void addChat(Chat chat){
        this.chats.add(chat);
    }

    public void addGroup(Group group){
        this.chats.add(group);
    }

    public void sendMessageToSingleUser(User to, String content, MessageEnum type){
        Message message = new Message(content, to, this, type);
        this.registerMessageToSingleUser(message, to);
        to.receiveMessage(this, content, type);
    }

    public void receiveMessage(User from, String content, MessageEnum type){
        Message message = new Message(content, this, from, type);

        this.registerMessageToSingleUser(message, from);
    }

    public void registerMessageToSingleUser(Message message, User foreign){
        ArrayList<User> listUsers = new ArrayList<>();
        listUsers.add(this);
        listUsers.add(foreign);

        if(!this.getChats().isEmpty()){
            //verificar se ja existe um chat entre os dois usuarios
            for(int i = 0; i < chats.size(); i++){
                if(chats.get(i).existsBetween(listUsers) == listUsers.size()) {
                    //adiciona a mensagem no chat
                    chats.get(i).addMessage(message);
                    return;
                } 
            }
        }
        Chat newChat = new Chat();
        newChat.addMessage(message);
        newChat.addMultipleUsers(listUsers);
        this.addChat(newChat);
    }

    public void sendMessageToGroup(Group to, String content, MessageEnum type){
        if(to.userExists(this, to.getUsers())){
            //pode enviar mensagem
            Message message = new Message(content, to, this, type);
            to.registerMessageToGroup(message);
        }
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public ArrayList<Chat> getChats(){
        return this.chats;
    }

    public ArrayList<Group> getGroups(){
        return this.groups;
    }

    @Override
    public int compareTo(User u){
        int compareInt = this.getName().compareTo(u.getName());
        if(compareInt < 0) return -1; //this vem antes
        if(compareInt > 0) return 1; //u vem antes
        return 0; //iguais
    }
}