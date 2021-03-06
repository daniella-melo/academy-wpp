package src;

import java.util.*;

public class Group extends Chat{ 

    private ArrayList<User> admUsers;
    private String groupName;

    public Group(String groupName, User admUser){
        this.groupName = groupName;
        this.admUsers = new ArrayList<User>();
        this.admUsers.add(admUser);
        this.addUser(admUser);
        admUser.addGroup(this);
    }

    public void registerMessageToGroup(Message message){
        this.addMessage(message);
    }

    public void addAnotherAdmUser(User newAdm, User insertBy){
        if(userExists(insertBy, super.getUsers())){
            if (isAdm(insertBy)){
                if(this.userExists(newAdm, super.getUsers())){
                    if(!this.userExists(newAdm, this.getAdmUsers())){
                     this.admUsers.add(newAdm);
                    }
                }
            }
            else{
                System.out.println("Usuário " + insertBy.getName() + " não pode promover a administrador, pois não é administrador");
            }
        }
        else{
            System.out.println("Usuário " + insertBy.getName() + " não é integrante do grupo " + this.getGroupName());
        }
    }

    public void addUserToGroup(User newUser, User insertBy){
        if(userExists(insertBy, super.getUsers())){
            if (isAdm(insertBy)){
                if(!this.userExists(newUser,super.getUsers())){
                    this.addUser(newUser);
                    newUser.addGroup(this);
                }
            }
            else{
                System.out.println("Usuário " + insertBy.getName() + " não pode adicionar participantes ao grupo, pois não é administrador");
            }
        }
        else{
            //TODO: tratamento de exceções
            System.out.println("Usuário " + insertBy.getName() + " não é integrante do grupo " + this.getGroupName());
        }
    }

    private boolean isAdm(User user){
        for (User u : admUsers) {
            if (u.getName() == user.getName()) return true;
        }
        return false;
    }

    public void setGroupName(String groupName){
        this.groupName = groupName;
    }

    public String getGroupName(){
        return this.groupName;
    }

    public ArrayList<User> getAdmUsers(){
        return this.admUsers;
    }
}