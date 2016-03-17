package JACCGames.TheElection;

import JACCGames.TheElection.States.MenuState;
import JACCGames.TheElection.States.States;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import JACCGames.TheElection.States.GameState;
import JACCGames.TheElection.Resources.ResourceLoader;
import java.io.File;

public class Main extends StateBasedGame implements Runnable {

    public static boolean _APPLET = true;

    private static Thread thread = new Thread();

    public static ResourceLoader loader;

    public Main(){super("Election");}
    public static void main(String[] args){
        _APPLET=false;

        File f = new File("natives");
        if(f.exists()) System.setProperty("org.lwjgl.librarypath", f.getAbsolutePath());


        try{
            AppGameContainer game = new AppGameContainer(new Main());
            game.setDisplayMode(Window.WIDTH, Window.HEIGHT, false);
            game.start();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void initStatesList(GameContainer gc) throws SlickException {
        gc.setTargetFrameRate(60);
        gc.setAlwaysRender(true);
        gc.setMaximumLogicUpdateInterval(60);
        gc.setVSync(true);
        gc.setShowFPS(true);

        loader = new ResourceLoader();
        this.addState(new MenuState());
        this.addState(new GameState());
        this.enterState(States.GAME);
    }


    @Override
    public void run() {

    }
}
