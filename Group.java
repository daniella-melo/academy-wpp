import java.util.*;

public class Group extends Chat{ 

    private ArrayList<User> admUsers;
    private String groupName;

    public Group(String groupName, User admUser){
        this.groupName = groupName;
        this.admUsers = new ArrayList<User>();
        this.admUsers.add(admUser);
    }

    public void registerMessageToGroup(Message message){
        this.addMessage(message);
    }

    public void addAnotherAdmUser(User newAdm, User askedBy){
        for (User user : admUsers) {
            if (isAdm(askedBy)){
                if(this.userExists(newAdm, this.getAllParticipants())){
                    this.admUsers.add(newAdm);
                }
            }
        }
    }

    public void addUserToGroup(User newUser, User askedBy){
        for (User user : admUsers) {
            if (isAdm(askedBy)){
                this.addUser(newUser);
                user.addGroup(this);
            }
        }
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