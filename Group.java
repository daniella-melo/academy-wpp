import java.util.*;

public class Group extends Chat{ 

    private ArrayList<User> admUsers;
    private String groupName;

    public Group(String groupName, User admUser){
        this.groupName = groupName;
        this.admUsers = new ArrayList<User>();
        this.admUsers.add(admUser);
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