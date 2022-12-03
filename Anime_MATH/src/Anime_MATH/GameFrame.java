package Anime_MATH;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameFrame extends JFrame {
    private final GamePanel gamePanel;
    private final String imageIconFileName;
    private final int frameWidth, frameHeight;
    private final PlaySound playSound;
    GameFrame(int frameWidth, int frameHeight){
        this.frameWidth = frameWidth;
        this.frameHeight = frameHeight;
        setSize(new Dimension(getFrameWidth(), getFrameHeight()));
        setResizable(false);
        setUndecorated(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        imageIconFileName = "src/asset/img/icon.png";
        setIconImage(new ImageIcon(getImageIconFileName()).getImage());
        gamePanel = new GamePanel();
        add(getGamePanel());
        playSound = new PlaySound();

        // การใช้งาน events
        gamePanel.getLblStart().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                getPlaySound().play("src/asset/sound/gameStart.wav");
                new GamePlayFrame(getFrameWidth(), getFrameHeight(), getImageIconFileName()).setVisible(true);
                dispose();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                getPlaySound().play("src/asset/sound/gameStart.wav");
                new GamePlayFrame(getFrameWidth(), getFrameHeight(), getImageIconFileName()).setVisible(true);
                dispose();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                getPlaySound().play("src/asset/sound/selectMenu.wav");
                gamePanel.getLblStart().setBackground(gamePanel.getColors().get("myBlueSlimeHover"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                gamePanel.getLblStart().setBackground(gamePanel.getColors().get("myBlueSlime"));
            }
        });

        gamePanel.getLblExit().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                dispose();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                getPlaySound().play("src/asset/sound/selectMenu.wav");
                gamePanel.getLblExit().setBackground(gamePanel.getColors().get("myBlueSlimeHover"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                gamePanel.getLblExit().setBackground(gamePanel.getColors().get("myBlueSlime"));
            }
        });
    }

    public GamePanel getGamePanel(){
        return gamePanel;
    }

    public String getImageIconFileName(){
        return imageIconFileName;
    }

    public int getFrameWidth(){
        return frameWidth;
    }

    public int getFrameHeight(){
        return frameHeight;
    }

    public PlaySound getPlaySound() {
        return playSound;
    }
}
