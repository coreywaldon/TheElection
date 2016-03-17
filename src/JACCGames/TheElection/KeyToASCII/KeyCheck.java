package JACCGames.TheElection.KeyToASCII;

import JACCGames.TheElection.States.GameState;
import org.newdawn.slick.Input;
import org.newdawn.slick.KeyListener;

/**
 * Created by corey on 3/13/2016.
 */
public class KeyCheck implements KeyListener{

    @Override
    public void keyPressed(int i, char c) {
        if (GameState.buzzWords.size()>0&&(c + "").toLowerCase().charAt(0) == GameState.buzzWords.get(0).word.toLowerCase().charAt(0)) {
            GameState.buzzWords.get(0).removeLetter();
            GameState.pointStreak++;
        }else GameState.pointStreak=0;
        System.out.print(c);
    }

    @Override
    public void keyReleased(int i, char c) {

    }

    @Override
    public void setInput(Input input) {

    }

    @Override
    public boolean isAcceptingInput() {
        return true;
    }

    @Override
    public void inputEnded() {

    }

    @Override
    public void inputStarted() {

    }
}
