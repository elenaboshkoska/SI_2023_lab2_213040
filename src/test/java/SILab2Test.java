import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SILab2Test {
    private List<User> createList(User... elems) {
        return new ArrayList<>(Arrays.asList(elems));
    }

    @Test
    void everyBranchTest(){
        User nullUsernameUser = new User(null, "", " ");
        List<User> allUsers = createList();

        RuntimeException ex;
        ex= assertThrows(RuntimeException.class,() -> SILab2.function(null,allUsers));
        assertTrue(ex.getMessage().contains("Mandatory information missing!")); //ova e za prviot slucaj (null username)

        allUsers.add(new User("", "elena123", "elenaboskoska@gmail.com"));
        assertFalse(SILab2.function(nullUsernameUser, allUsers)); // vtoriot sucaj so prazen username i setiranje na mail na mestoto od username
        User newuser=new User("elena","password","elenaboskoska@gmail.com");
        allUsers.add(newuser);
        User newuser1=new User("belena","softver123","bosk@gmail.com");
        allUsers.add(newuser1);
        User newuser2=new User("bosElena","123","boskoska@gmail.com");
        allUsers.add(newuser2);
        User invalidEmailUser = new User("bosElena", "softversko inzenerstvo", "boskgmailcom");
        assertFalse(SILab2.function(invalidEmailUser, allUsers)); //tret slucaj

        User BlankPassword = new User ("elena", "softversko123!", "elenaboskoska@gmail.com");
        assertFalse(SILab2.function(BlankPassword, allUsers)); //cetvrt slucaj



    }

    @Test
    void multipleConditionTest(){
        // + nullUsernameUser [31:FXX]
        // + validUser [31:TTT] [40:TT]
        // + invalidEmailUser [40:FF]

        //[31:TXX]
        User nullEmailUser = new User(null, "", "");
        List<User> allUsers = createList();
        RuntimeException ex;
        ex= assertThrows(RuntimeException.class,() -> SILab2.function(null,allUsers));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));


       /* assertFalse(SILab2.function(nullEmailUser, allUsers));*/

        //[31:FTX]
        User existingUser = new User("elena",null, "ebosk@gmail.com");
        List<User> allUsers2 = createList();
        ex= assertThrows(RuntimeException.class,() -> SILab2.function(null,allUsers2));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

      /*  assertFalse(SILab2.function(existingUser, allUsers2));*/

        //[40:FFT]
        User tfUser = new User("elena", "softversko", null);

        ex= assertThrows(RuntimeException.class,() -> SILab2.function(null,allUsers2));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        User fffUser = new User ("elena", "softversko", "eb@gmail.com");
        ex = assertThrows(RuntimeException.class,() -> SILab2.function(null,allUsers2));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

    }
    @Test
    void functionalTest(){
        User validUser = new User("user", "", "ab@.@");
        List<User> allUsers = createList();

        assertFalse(SILab2.function(validUser, allUsers));

    }
}