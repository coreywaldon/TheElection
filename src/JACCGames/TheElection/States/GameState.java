package JACCGames.TheElection.States;

import JACCGames.TheElection.BuzzWord;
import JACCGames.TheElection.KeyToASCII.KeyCheck;
import JACCGames.TheElection.Player;
import JACCGames.TheElection.Resources.ResourceLoader;
import org.newdawn.slick.*;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.util.ArrayList;


/**
 * Created by cowaldon859 on 3/11/16.
 */
public class GameState extends BasicGameState implements Runnable {
    @Override
    public int getID() {return States.GAME;}
    Image GameBG = ResourceLoader.imageList.get("Game Background");
    Image BuzzBar = ResourceLoader.imageList.get("BuzzBar");
    Image Header = ResourceLoader.imageList.get("Header");
    long lastTime=0, lastTime2=0;
    public static int streak=1;
    public static int speed=4000;
    public static int timer=0;
    public static ArrayList<BuzzWord> buzzWords = new ArrayList<>();
    public static Player player = new Player("Trump", 30);
    public static int pointStreak=0;
    Input i;
    @Override
    public void init(GameContainer gc, StateBasedGame s) throws SlickException {
        i=gc.getInput();
        i.addKeyListener(new KeyCheck());
    }

    @Override
    public void render(GameContainer gc, StateBasedGame s, Graphics g) throws SlickException {
        g.setColor(org.newdawn.slick.Color.white);
        AngelCodeFont GothamBlack = new AngelCodeFont("res/GothamBlack.fnt", new Image("/res/GothamBlack_0.png"));
        AngelCodeFont Helvetica = new AngelCodeFont("res/Helvetica.fnt", new Image("/res/Helvetica_0.png"));

        GameBG.draw();

        if(lastTime-System.currentTimeMillis()<=-speed|lastTime==0){
            buzzWords.add(new BuzzWord(player.getWord(), gc, GothamBlack));
            lastTime=System.currentTimeMillis();
            speed*=0.9;
            if(speed<=2000){
                speed=2000;
            }
        }
        System.out.println(lastTime2);

        for(BuzzWord b : buzzWords)
            GothamBlack.drawString(gc.getWidth()/2-(GothamBlack.getWidth(b.word)/2), b.y, b.word);

        GothamBlack.drawString(50, 200, String.valueOf(player.votes));
        
        Header.draw();

        g.setColor(Color.black);
        GothamBlack.drawString(gc.getWidth()/2-58-(GothamBlack.getWidth(String.valueOf(timer))/2), 23, String.valueOf(timer), Color.black);
        GothamBlack.drawString(gc.getWidth()/2-62-(GothamBlack.getWidth(String.valueOf(timer))/2), 27, String.valueOf(timer), Color.black);
        GothamBlack.drawString(gc.getWidth()/2-58-(GothamBlack.getWidth(String.valueOf(timer))/2), 27, String.valueOf(timer), Color.black);
        GothamBlack.drawString(gc.getWidth()/2-62-(GothamBlack.getWidth(String.valueOf(timer))/2), 23, String.valueOf(timer), Color.black);

        GothamBlack.drawString(gc.getWidth()/2-60-(GothamBlack.getWidth(String.valueOf(timer))/2), 25, String.valueOf(timer));

        GothamBlack.drawString(gc.getWidth()-10-GothamBlack.getWidth(String.valueOf(player.votes)), 200, String.valueOf(player.votes));
        BuzzBar.draw();
    }
    public static boolean doRemove=false;
    @Override
    public void update(GameContainer gc, StateBasedGame s, int i) throws SlickException {
        if(lastTime2-System.currentTimeMillis()<=-1000){
            lastTime2=System.currentTimeMillis();
            timer++;
        }
        if(buzzWords.size()>0)
            System.out.println(buzzWords.get(0).word);
        for(BuzzWord b:buzzWords){
            b.update();
            if(b.y<140-b.gothamBlack.getHeight(b.word)){
                doRemove=true;
            }
        }
        if(doRemove) {
            buzzWords.remove(0);
            doRemove=false;
        }
    }

    @Override
    public void run() {

    }
}
