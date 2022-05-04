import java.util.ArrayList;

public class Main{

    public static void main(String [] args){ 
        User izabella = new User("izabella");
        User daniella = new User("daniella");
 
        izabella.sendMessageToSingleUser(daniella, "Oi Dani", MessageEnum.TEXT);
        daniella.sendMessageToSingleUser(izabella, "Oi Iza", MessageEnum.TEXT);
       
        ArrayList<SingleChat> chats = new ArrayList<>();
        chats =  daniella.getChats();

        System.out.println("\n--Chats de " + izabella.getName() + "--");
        chats =  izabella.getChats();
        for (SingleChat chat : chats) {
            chat.print();
        }

        System.out.println("\n--Chats de " + daniella.getName() + "--");
        for (SingleChat chat : chats) {
           chat.print();
           System.out.println("\n Lista de Participantes deste chat: ");
           for (User user : chat.listParticipants()) {
                System.out.println(user.getName());
           }
          
           System.out.println("\n Número de Participantes deste chat: " + chat.totalNumberOfParticipants());
        }

        //TESTANDO GRUPOS
        System.out.println("\n--------------------------------");
        User nicole  = new User("nicole");
        User kayla  = new User("kayla");

        Group espiasDemais = new Group("espiasDemais", daniella);
        daniella.sendMessageToGroup(espiasDemais, "Criei o grupo", MessageEnum.TEXT);
        espiasDemais.addUserToGroup(nicole, daniella); //vai conseguir adicionar
        espiasDemais.addUserToGroup(kayla, izabella); //não irá conseguir adicionar

        nicole.sendMessageToGroup(espiasDemais, "Ola grupo", MessageEnum.TEXT);

        System.out.println("\n--Chats do grupo " + espiasDemais.getGroupName() + "--");
        espiasDemais.print();

        System.out.println("\n Lista de Participantes deste Grupo: (Só deve ter Nicole e Daniella) ");
        for (User user :  espiasDemais.listParticipants()) {
             System.out.println(user.getName());
        }

        System.out.println("\n Número de Participantes deste chat: " + espiasDemais.totalNumberOfParticipants());
    }
}