import javax.swing.*;
import java.awt.*;

public class GameMap extends JPanel {
    public static final int GAME_MODE_HVH=0;
    public static final int GAME_MODE_HVA=1;

    GameMap(){

    }

    void startGame(int modeGame, int mapSizeX, int mapSizeY, int winLength){
        System.out.println("mode= " + modeGame + "\nmapSizeX= "+mapSizeX + "\nmapSizeY= "+mapSizeY+"\nwinLength= "+winLength);
        this.setBackground(Color.black);
    }

}
