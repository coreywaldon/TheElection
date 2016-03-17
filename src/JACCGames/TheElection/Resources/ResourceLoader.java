package JACCGames.TheElection.Resources;

import org.newdawn.slick.Image;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cowaldon859 on 3/11/16.
 */
public class ResourceLoader implements Runnable{
    public static Map<String, Image> imageList = new HashMap<>();
    public static Map<String, Music> trackList = new HashMap<>();

    public ResourceLoader(){
        Thread thread = new Thread(this);
        thread.run();
    }

    @Override
    public void run() {
        imageList = new HashMap<String, Image>();
        try {
            System.out.println("RUN!");
            imageList.put("Background", loadImage("res/Background.png"));
            imageList.put("Lower Third", loadImage("res/LowerThird.png"));
            imageList.put("Anchor", loadImage("res/Anchor.png"));
            imageList.put("Logo", loadImage("res/Logo.png"));
            imageList.put("Button", loadImage("res/Button.png"));
            imageList.put("ButtonHighlight", loadImage("res/ButtonHi.png"));
            imageList.put("Game Background", loadImage("res/GameBG.png"));
            imageList.put("BuzzBar", loadImage("res/BuzzBar.png"));
            imageList.put("Header", loadImage("res/Header.png"));
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    private Image loadImage(String path) throws SlickException {
        return new Image(path, false, Image.FILTER_LINEAR);
    }

}
