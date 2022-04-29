import java.util.*;

public class Group extends Chat{ //mudar para composição ao invés de herança, talvez

    private ArrayList<User> users;
    private ArrayList<User> admUsers;
    private String groupName;

    public Group(String groupName, User admUser){
        this.users = new ArrayList<User>();
        this.groupName = groupName;
        this.admUsers = new ArrayList<User>();
        this.admUsers.add(admUser);
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


    public ArrayList<User> getAdmUsers(){
        return this.admUsers;
    }

}