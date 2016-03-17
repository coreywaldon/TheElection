package JACCGames.TheElection;

import JACCGames.TheElection.States.GameState;
import org.newdawn.slick.AngelCodeFont;
import org.newdawn.slick.GameContainer;

/**
 * Created by corey on 3/16/2016.
 */
public class BuzzWord {
    public int y;
    public String word = "";
    public AngelCodeFont gothamBlack;
    public BuzzWord(String word, GameContainer gc, AngelCodeFont gothamBlack){
        y=gc.getHeight()-(gothamBlack.getHeight(word)+50);
        this.gothamBlack=gothamBlack;
        this.word = word;
    }
    public void update(){
        y-=GameState.streak;
    }
    public void removeLetter(){
        if(word.length()==1) {
            GameState.doRemove = true;
            GameState.player.votes+=GameState.pointStreak*100;
        }
        else word = new StringBuilder(word).deleteCharAt(0).toString();

    }
}
