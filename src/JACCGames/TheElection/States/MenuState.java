package JACCGames.TheElection.States;

import JACCGames.TheElection.Main;
import JACCGames.TheElection.Window;
import JACCGames.TheElection.Resources.ResourceLoader;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.util.HashMap;

/**
 * Created by cowaldon859 on 3/11/16.
 */
public class MenuState extends BasicGameState implements Runnable {
    @Override
    public int getID() {return States.MENU;}

    @Override
    public void init(GameContainer gc, StateBasedGame s) throws SlickException {

    }
    @Override
    public void render(GameContainer gc, StateBasedGame s, Graphics g) throws SlickException {
        g.setColor(Window.BGColor);
        g.setBackground(Window.BGColor);
        Image logo = ResourceLoader.imageList.get("Logo");
        logo.setFilter(Image.FILTER_LINEAR);
        logo.draw((gc.getWidth() / 2) - (logo.getWidth() * 0.25f), 0f, 0.5f);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame s, int i) throws SlickException {
    }

    @Override
    public void run() {
    }
}
