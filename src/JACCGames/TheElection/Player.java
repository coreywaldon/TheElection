package JACCGames.TheElection;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by corey on 3/13/2016.
 */
public class Player {
    String name;
    ArrayList<String> words = new ArrayList<String>();
    int difficulty;
    public int votes;
    int streak;
    public Player(String name, int difficulty){
        this.name=name;
        this.difficulty=difficulty;
        String[] buzz = {"CHINA","WALL","AMERICA","MAKE AMERICA GREAT AGAIN",
                "MONEY","SELF SUPPORTED","NARCISSISM","C.E.O.","BIG BUSINESS",
                "DEPORT","MEXICO","BILLIONAIRE"};
        Collections.addAll(words, buzz);
    }

    public String getWord(){
        return words.get(new Random().nextInt(words.size()));
    }
}
