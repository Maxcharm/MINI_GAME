import java.io.*;
import java.util.ArrayList;

public class helper {
    private int gridSize = 49;
    private int gridLength = 7;
    private int [] grid = new int[gridSize];

    public ArrayList<String> placeLocs(int locNum){
         ArrayList<String> result = new ArrayList<>();
         int flag = 0;
         int start = 0;
         int V = 1;
         while(flag == 0){
             start = (int)(Math.random() * this.gridSize);
             //System.out.println("start from " + start);
             int startV = start / gridLength;
             int startH = start % gridLength;
             V = (int)(Math.random() * 2);
             //System.out.println("vertical is " + V);
             for(int i = 0; i < locNum; i++){
                  if((V == 1 && (startV + i >= gridLength)) || (V == 0 && (startH + i >= gridLength ))){
                      break;
                  }
                  else if(V == 0 && grid[start + i] == 1 || V == 1 && grid[start + gridLength * i] == 1){
                      break;
                  }

                  else if(i == locNum - 1) {
                      if(V == 1){
                          for(int j = 0; j < locNum; j++)
                              grid[start + j * gridLength] = 1;
                      }
                      else{
                          for(int j = 0; j < locNum; j++)
                              grid[start + j] = 1;
                      }
                      flag = 1;
                  }
             }
         }
         if( V == 1){
             char v = (char)(start / gridLength + (int)'A');
             for(int i = 0; i < locNum; i++){
                 String currentLoc = v + String.valueOf((start + i) % gridLength + 1);
                 //System.out.println("I am "+ currentLoc + V);
                 result.add(currentLoc);
             }
         }
         else{
             String h = String.valueOf(start % gridLength + 1);
             for(int i = 0; i < locNum; i++){
                 String currentLoc = (char)(start / gridLength + i + (int)'A') + h;
                 //System.out.println("I am "+ currentLoc + V);
                 result.add(currentLoc);
             }
         }
         return result;
    }

    public static String getUserInput(String line){
        System.out.println(line);
        String input = null;
        BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
        try {
            input = in.readLine();
        }catch(IOException e){
            System.out.println("IOException " + e);
        }
        return input;
    }
}
