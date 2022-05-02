import java.util.ArrayList;

public class Main{

    public static void main(String [] args){ 
        User izabella = new User("izabella");
        User daniella = new User("daniella");
 
        izabella.sendMessage(daniella, "Oi Dani", MessageEnum.TEXT);
        daniella.sendMessage(izabella, "Oi Iza", MessageEnum.TEXT);
       
        ArrayList<Chat> chats = new ArrayList<>();
        chats =  daniella.getChats();

        System.out.println("\n--Chats de " + izabella.getName() + "--");
        chats =  izabella.getChats();
        for (Chat chat : chats) {
            chat.print();
        }

        System.out.println("\n--Chats de " + daniella.getName() + "--");
        for (Chat chat : chats) {
           chat.print();
           System.out.println("\n Lista de Participantes deste chat: ");
           for (User user : chat.listParticipants()) {
                System.out.println(user.getName());
           }
          
           System.out.println("\n Número de Participantes deste chat: " + chat.totalNumberOfParticipants());
        }
    }
}