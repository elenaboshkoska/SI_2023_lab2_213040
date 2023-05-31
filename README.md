# Елена Бошкоска 213040

2.![image](https://github.com/elenaboshkoska/SI_2023_lab2_213040/assets/108356236/abf88fc6-8e2a-4a9a-9aa0-849a017aaac6)

3. Цикломатската комплексност на графот е добиена со формулата P+1 каде што P е бројот на предикатни јазли. Исто така цикломатската комплексност може да се добие со броење на регионите во графот кој што е нацртан како резултат на дадениот код.
4. Најпрво според EveryBranch, односно според графот ги напишав сите гранки кои се добиваат од графот, а треба да бидат опфатени од соодветни тест случаи. Минималниот број на тестови кои ги добив се 5, а истите ќе ги образложам во продолжение поединечно.
  4.1. На првава слика е опфатен првиот случај, каде што потребно е user да биде null. Овој тест ќе помине на две разгранувања, а тоа се јазлите 36 -37 и 37 -75.

![image](https://github.com/elenaboshkoska/SI_2023_lab2_213040/assets/108356236/e0562e61-1aff-437c-b955-cea59ecd9e19)

Следен тест случај е username= bosElena, mail:boskgmailcom, password: softversko inzenerstvo односно овде го опфаќам случајот на невалиден е-маил.
  4.2. Она што го добив е следното:
  
![image](https://github.com/elenaboshkoska/SI_2023_lab2_213040/assets/108356236/46356232-7003-4c1b-a6ab-cc1193cb3be9)



Следниот случај е празен username="", а постоење на барем еден корисник во листата, чиј username ќе се сетира соодветно на маилот. (случајот на линија 40).

 4.3. Следи приказ на чекорите кои се опфатени со овој услов:

![image](https://github.com/elenaboshkoska/SI_2023_lab2_213040/assets/108356236/f2eecd1f-1563-4173-8772-8546ea057100)

 4.4.Четврт тест случај :
 
![image](https://github.com/elenaboshkoska/SI_2023_lab2_213040/assets/108356236/4f3bae89-5d68-4ec2-b85c-7db11dd43050)

4.5 Петти, а воедно и последен тест случај:

![image](https://github.com/elenaboshkoska/SI_2023_lab2_213040/assets/108356236/ee55797e-57d4-4778-944c-6bce28bdbc0d)

5. Според Multiple Condition критериумот за условот
if (user==null || user.getPassword()==null || user.getEmail()==null) бројот на тест случаи кој го добив е 4.

5.1 T X X - според ова ако првиот услов е исполнет тоа значи дека нема потреба да оди на следните затоа што се работи за OR (II) услов, доволно е само еден да биде точен. Пример: user=null;

5.2 F T X - ако првиот услов не е исполнет, односно user!=null тогаш се преминува на следен услов се со цел да се провери дали тој е точен. Во нашиот тест случај, точен е и според тоа нема потреба да отиде на следен и да го проверува.Пример: user="Elena"; password = null;

5.3 F F T -  Според ова првиот и вториот случај не се точни, па затоа мора да го провери и третиот случај кој е точен. Пример: user="Elena" password="softverskoi!"; mail = null;

5.4 F F F  -последен тест случај. Според овој тест случај, сите изрази се неточни па програмата повторно треба да фрли исклучок.

6. Тест случаи

Тестирам 5 случаи за Every Branch и 3 случаи за Multiple Condition. 
Во првиот пример во случајот каде што треба да ми врати exception, тоа го правам со помош на assertTrue кој ќе ми врати точно доколку пораката ја содржи таа содржина. Кога ова го истестирав, тестот помина успешно. Следи код кој го имплементирав за да успеам да напишам точен тест за овој случај:

RuntimeException ex;
        ex= assertThrows(RuntimeException.class,() -> SILab2.function(null,allUsers));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));
        
Следните тестови се базираат на случаите кои треба да се опфатени, односно тестовите се исти како примерите кои ги дадов погоре. Истите ги напишав во одделните тестови со кои ги истестирав и успешно ги опфатив сите случаи според Every Branch.

Во однос на Мultiple Condition исто така направив три теста кои поминаа успешно, а се базираат на она кое го напишав погоре. За условот T X X го напишав следниот тест: 

User nullEmailUser = new User(null, "", "");
        List<User> allUsers = createList();
        RuntimeException ex;
        ex= assertThrows(RuntimeException.class,() -> SILab2.function(null,allUsers));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));
  
Во сите три теста потребно е програмата да фрли exception, па според тоа и тестот е направен со проверка на содржината на пораката.
  
  Следниот случај, FTX го поткрепив со следниот тест пример:
  
      User existingUser = new User("elena",null, "ebosk@gmail.com");
        List<User> allUsers2 = createList();
        ex= assertThrows(RuntimeException.class,() -> SILab2.function(null,allUsers2));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

  FFT е поткрепен со следниот тест пример:
   User tfUser = new User("elena", "softversko", null);

        ex= assertThrows(RuntimeException.class,() -> SILab2.function(null,allUsers2));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));
  
  И последниот FFF е поткрепен со следниот тест пример:
  
   User fffUser = new User ("elena", "softversko", "eb@gmail.com");
        ex = assertThrows(RuntimeException.class,() -> SILab2.function(null,allUsers2));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));
  
  
  
  
