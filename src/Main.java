package src;

import java.util.ArrayList;

public class Main{

    public static void main(String [] args){ 
        User izabella = new User("izabella");
        User daniella = new User("daniella");
 
        izabella.sendMessageToSingleUser(daniella, "Oi Dani", MessageEnum.TEXT);
        daniella.sendMessageToSingleUser(izabella, "Oi Iza", MessageEnum.TEXT);
       
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

        //TESTANDO GRUPOS
        System.out.println("\n--------------------------------");
        User nicole  = new User("nicole");
        User kayla  = new User("kayla");

        Group espiasDemais = new Group("espiasDemais", daniella);
        daniella.sendMessageToGroup(espiasDemais, "Criei o grupo", MessageEnum.TEXT);
        espiasDemais.addUserToGroup(nicole, daniella); //vai conseguir adicionar
        espiasDemais.addUserToGroup(kayla, izabella); //não irá conseguir adicionar

        nicole.sendMessageToGroup(espiasDemais, "Ola grupo", MessageEnum.TEXT);
        espiasDemais.addAnotherAdmUser(nicole, daniella); //irá conseguir 
        espiasDemais.addUserToGroup(kayla, nicole); //vai conseguir adicionar

        System.out.println("\n--Chats do grupo " + espiasDemais.getGroupName() + "--");
        espiasDemais.print();

        System.out.println("\n--Administradores do grupo " + espiasDemais.getGroupName() + "--");
        for (User adm : espiasDemais.getAdmUsers()) {
            System.out.println(adm.getName());
        }

        System.out.println("\n--Lista de Participantes deste Grupo:--");
        for (User user :  espiasDemais.listParticipants()) {
             System.out.println(user.getName());
        }

        System.out.println("Número de Participantes: " + espiasDemais.totalNumberOfParticipants());

        System.out.println("\n--Lista de Administradores deste Grupo:--");
        for (User user :  espiasDemais.getAdmUsers()) {
             System.out.println(user.getName());
        }
 
        //Extras
        daniella.listAllChatsAndGroups();
        
        kayla.listAllChatsAndGroups();
        kayla.leaveGroup(espiasDemais);

        kayla.listAllChatsAndGroups();
    
        kayla.sendMessageToSingleUser(daniella, "Oi Dani", MessageEnum.TEXT);
        kayla.listAllChatsAndGroups();
        daniella.listAllChatsAndGroups();
    }
}