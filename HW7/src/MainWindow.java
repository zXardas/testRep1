import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {
private final int WIN_HEIGHT=500;
private final int WIN_WIDTH=500;
private final int WIN_POS_X=700;
private final int WIN_POS_Y=500;
private Settings settingsWindow;
private GameMap gameMap;
    MainWindow(){
    setVisible(true);
    setTitle("Hello world!");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setResizable(false);
    setSize(WIN_WIDTH,WIN_HEIGHT);
    setLocation(WIN_POS_X,WIN_POS_Y);

    JPanel containerFrbuttons= new JPanel();
    JButton startbtn = new JButton("Start!");
    JButton exitbtn = new JButton("Exit");
    containerFrbuttons.setLayout(new GridLayout(1,2));

    gameMap = new GameMap();
    containerFrbuttons.add(startbtn);
    containerFrbuttons.add(exitbtn);
    add(containerFrbuttons,BorderLayout.SOUTH);
    add(gameMap);

    Settings settingsWindow = new Settings(this);

    startbtn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("active");
            settingsWindow.setVisible(true);

        }
    });

    exitbtn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    });
    }

    void startGameWithUserSettings(int modeGame,int mapSizeX, int mapSizeY, int winLength){
        gameMap.startGame(modeGame,mapSizeX,mapSizeY,winLength);

    }


}

