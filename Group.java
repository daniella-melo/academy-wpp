import java.util.*;

public class Group extends SingleChat{ 

    private ArrayList<User> admUsers;
    private String groupName;

    public Group(String groupName, User admUser){
        this.groupName = groupName;
        this.admUsers = new ArrayList<User>();
        this.admUsers.add(admUser);
        this.addUser(admUser);
    }

    public void registerMessageToGroup(Message message){
        this.addMessage(message);
    }

    public void addAnotherAdmUser(User newAdm, User insertBy){
            if (isAdm(insertBy)){
                if(this.userExists(newAdm, this.getAllParticipants())){
                    if(!this.userExists(newAdm, this.getAdmUsers())){
                     this.admUsers.add(newAdm);
                    }
                }
            }
            else{
                System.out.println("Usuário " + insertBy.getName() + " não pode promover a administrador, pois não é administrador");
            }
    }

    public void addUserToGroup(User newUser, User insertBy){
            if (isAdm(insertBy)){
                if(!this.userExists(newUser, this.getAllParticipants())){
                    this.addUser(newUser);
                    newUser.addGroup(this);
                }
            }
            else{
                System.out.println("Usuário " + insertBy.getName() + " não pode adicionar participantes ao grupo, pois não é administrador");
            }
    }

    public ArrayList<User> getAllParticipants(){
       return super.getUsers();
    }

    public boolean isAdm(User user){
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