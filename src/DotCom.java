import java.util.ArrayList;

public class DotCom {
    private ArrayList<String> Location = new ArrayList<>();
    private String name;

    public void setName(String input){
         this.name = input;
    }

    public void getLocation(ArrayList<String> locs){
        Location = locs;
    }
    public String checkYourself(String userInput){
        String result = "miss";
        if(Location.contains(userInput)){
            result = "hit";
            Location.remove(userInput);
            if(Location.isEmpty()) {
                result = "kill";
                System.out.println("You have sunk " + this.name + ".");
            }
        }
        return result;
    }
}
