import java.util.ArrayList;

public class Main{

    public static void main(String [] args){ 
        User daniella = new User("daniella");
        User izabella = new User("izabella");

        daniella.sendMessage(izabella, "Oi Iza", MessageEnum.TEXT);
        izabella.sendMessage(daniella, "Oi Dani", MessageEnum.TEXT);

        ArrayList<Chat> chats = new ArrayList<>();
        chats =  daniella.getChats();
        System.out.println("\n--Chats de " + daniella.getName() + "--");
        for (Chat chat : chats) {
           chat.print();
        }
       
        System.out.println("\n--Chats de " + izabella.getName() + "--");
        chats =  izabella.getChats();
        for (Chat chat : chats) {
            chat.print();
        }
        
    }
}