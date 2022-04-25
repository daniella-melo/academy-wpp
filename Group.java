import java.util.*;

public class Group extends Chat{

    private List<User> users;

    public Group(){
        this.users = new ArrayList<User>();
    }

    public List<User> getUsers(){
        return this.users;
    }

    public void addUser(User user){
        this.users.add(user);
    }
}