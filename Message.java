import java.time.LocalDateTime;

public class Message{

    private String content;
    private LocalDateTime date;
    private User receiverUser;
    private User senderUser;
    private MessageEnum type;

    public Message(String content, User receiverUser, User senderUser, MessageEnum type){
        this.content = content;
        this.date = LocalDateTime.now();
        this.receiverUser = receiverUser;
        this.senderUser = senderUser;
    }

    public void setContent(String content){
        this.content = content;
    }

    public void setDate(LocalDateTime date){
        this.date = date;
    }

    public void setReceiverUser(User user){
        this.receiverUser = user;
    }

    public void setSenderUser(User user){
        this.senderUser = user;
    }

    public void setSenderUser(MessageEnum type){
        this.type = type;
    }

    public String getContent(){
        return this.content;
    }

    public LocalDateTime getDate(){
        return this.date;
    }

    public User getReceiverUser(){
        return this.receiverUser;
    }

    public User getSenderUser(){
        return this.senderUser;
    }

    public MessageEnum getType(){
        return this.type;
    }
}