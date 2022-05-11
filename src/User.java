package src;

import java.util.*;

public class User implements Comparable<User>{
    
    private String name;
    private ArrayList<Chat>  chats;
    private ArrayList<Group> groups;
    private ArrayList<Chat> archivedChats;

    public User(String nome){
        this.name = nome;
        this.chats = new ArrayList<Chat>();
        this.groups = new ArrayList<Group>();
        this.archivedChats = new ArrayList<Chat>();
    }

    public void addChat(Chat chat){
        this.chats.add(chat);
    }

    public void addGroup(Group group){
        this.groups.add(group);
    }

    public void addArchivedChat(Chat chat){
        this.archivedChats.add(chat);
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

    public ArrayList<Chat> getArchivedChats(){
        return this.archivedChats;
    }

    @Override
    public int compareTo(User u){
        int compareInt = this.getName().compareTo(u.getName());
        if(compareInt < 0) return -1; //this vem antes
        if(compareInt > 0) return 1; //u vem antes
        return 0; //iguais
    }

    public void listAllChatsAndGroups(){
        System.out.println("\nChats que o usuário " + this.getName() + " participa:" );
        for (Chat chat : chats) {
            System.out.println("Chat com: " + getOtherUser(chat).getName());
        }
        System.out.println("\nGrupos que o usuário " + this.getName() + " participa:" );
        for (Group group : groups) {
            System.out.println("Nome do grupo: " + group.getGroupName());
        }
    }

    private User getOtherUser(Chat chat){
        for (User user : chat.getUsers()) {
            if(user.getName() != this.getName()) return user;
        }
        return null;
    }

    public Chat getSpecificChat(User user){
        for (Chat chat : chats) {
            for (User u : chat.getUsers()) {
                if(u.equals(user)) return chat;
            }
        }
        return null;
    }

    public void deleteChat(User user){
        Chat chatToDelete = getSpecificChat(user);
        if(chatToDelete != null){
            this.chats.remove(chatToDelete);
            System.out.println(this.getName() + " deletou conversa com " +  user.getName());
        }
        else{
            System.out.println("Não há como deletar o chat entre " + this.getName() + " e " + user.getName() + " pois não existe");
        }
    }

    public void leaveGroup(Group group){
        for (Group g : this.getGroups()) {
            if(g.equals(group)){
                this.getGroups().remove(group);
                System.out.println(this.getName() + " saiu do grupo " +  group.getGroupName());
                return;
            } 
        }
        System.out.println("Não é possível sair do grupo " + group.getGroupName() +", pois suário não faz parte");
    }

    public void archiveChat(User user){
        Chat chatToArchive = getSpecificChat(user);
        if(chatToArchive != null){
            this.archivedChats.add(chatToArchive);
            this.chats.remove(chatToArchive);
            System.out.println(this.getName() + " arquivou a conversa com " +  user.getName());
        }
        else{
            System.out.println("Não há como arquivar o chat entre " + this.getName() + " e " + user.getName() + " pois não existe");
        }
    }

    public void recoverArchivedChat(User user){
        Chat chat = getSpecificArchivedChat(user);
        if(chat != null){
            this.chats.add(chat);
            this.archivedChats.remove(chat);
            System.out.println(this.getName() + " desarquivou a conversa com " +  user.getName());
        }
        else{
            System.out.println("Não há como desarquivar o chat entre " + this.getName() + " e " + user.getName() + " pois não existe");
        }
    }

    public Chat getSpecificArchivedChat(User user){
        for (Chat chat : archivedChats) {
            for (User u : chat.getUsers()) {
                if(u.equals(user)) return chat;
            }
        }
        return null;
    }

}