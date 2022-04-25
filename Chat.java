import java.util.*;

public class Chat{
    private List<Message> messages;

    public Chat(){
        this.messages = new ArrayList<Message>();
    }

    public List<Message> getMessages(){
        return this.messages;
    }

}