import java.util.ArrayList;

public class DotComBust {
    private helper Gamer = new helper();
    private ArrayList<DotCom> DotComList = new ArrayList<DotCom>();
    private int guessNum;

    private void setUp(){
         this.guessNum = 0;

         DotCom C1 = new DotCom();
         C1.setName("www.baidu.com");
         DotComList.add(C1);

         DotCom C2 = new DotCom();
         C2.setName("cs.nju.edu.cn");
         DotComList.add(C2);

         DotCom C3 = new DotCom();
         C3.setName("github.com");
         DotComList.add(C3);

         for(DotCom dc: DotComList){
             dc.getLocation(Gamer.placeLocs(3));
         }
    }
    private void finishGame(){
         System.out.println("All dotcoms are dead. You took "+ guessNum + " guesses.");
    }

    private void checkUserGuess(String input){
        guessNum++;
        String result = "ladida";
        for(DotCom dc: DotComList){
            result = dc.checkYourself(input);
            if(result.equals("hit")){
                break;
            }
            else if(result.equals("kill")){
                DotComList.remove(dc);
                break;
            }
        }
        System.out.println(result);
    }

    private void startGame(){
        while(!DotComList.isEmpty()){
            String input = Gamer.getUserInput("Enter your guess.");
            checkUserGuess(input);
        }
        finishGame();
    }

    public static void main(String[] args){
        DotComBust Game = new DotComBust();
        System.out.println("Game start.");
        System.out.println("Enter your guess from A1 to G7");
        System.out.println("There are altogether 3 websites, each with 3 slots.");
        System.out.println("Come on and sunk them all.");
        Game.setUp();
        Game.startGame();
    }
}
