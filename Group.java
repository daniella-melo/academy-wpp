import java.util.*;

public class Group extends Chat{

    private ArrayList<User> users;
    private User admUser;
    private String groupName;

    public Group(String groupName, User admUser){
        this.users = new ArrayList<User>();
        this.groupName = groupName;
        this.admUser = admUser;
    }

    public boolean userExists(User user){
        for (User u : users) {
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

    public void setGroupName(String groupName){
        this.groupName = groupName;
    }

    public String getGroupName(){
        return this.groupName;
    }

    public void setAdmUser(User admUser){
        this.admUser = admUser;
    }

    public User getAdmUser(){
        return this.admUser;
    }

}