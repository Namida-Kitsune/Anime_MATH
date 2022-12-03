package Anime_MATH;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GamePlayFrame extends JFrame implements ReadFile, WriteFile{
    private final GamePlayPanel gamePlayPanel;
    private final String imageIconFileName, pathMaxLevel;
    private final int frameWidth, frameHeight;
    private final File fileMaxLevel;
    private int maxLevel;
    private final PlaySound playSound;
    GamePlayFrame(int frameWidth, int frameHeight, String imageIconFileName) {
        this.frameWidth = frameWidth;
        this.frameHeight = frameHeight;
        setSize(new Dimension(getFrameWidth(), getFrameHeight()));
        setResizable(false);
        setUndecorated(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.imageIconFileName = imageIconFileName;
        setIconImage(new ImageIcon(getImageIconFileName()).getImage());
        pathMaxLevel = "src/asset/data/MaxLevel.txt";
        fileMaxLevel = new File(getPathMaxLevel());
        readFile();
        gamePlayPanel = new GamePlayPanel();
        add(getGamePlayPanel());
        playSound = new PlaySound();

        getGamePlayPanel().getLblChoiceOne().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(getGamePlayPanel().getRandOperator() != 3){
                    if(getGamePlayPanel().getLblChoiceOne().getText().equals(String.format("%.0f", getGamePlayPanel().getResult()))){
                        getPlaySound().play("src/asset/sound/correct.wav");
                        getGamePlayPanel().setLevel(getGamePlayPanel().getLevel() + 1);
                        getGamePlayPanel().getLblLevel().setText(String.format("Level %d", getGamePlayPanel().getLevel()));
                        getGamePlayPanel().randomProblem();
                    }else {
                        if(getGamePlayPanel().getLevel() > getMaxLevel()){
                            setMaxLevel(getGamePlayPanel().getLevel());
                            writeFile();
                        }
                        getPlaySound().play("src/asset/sound/wrong.wav");
                        new GameFrame(1280, 720).setVisible(true);
                        dispose();
                    }
                }else {
                    if(getGamePlayPanel().getLblChoiceOne().getText().equals(String.format("%.2f", getGamePlayPanel().getResult()))){
                        getPlaySound().play("src/asset/sound/correct.wav");
                        getGamePlayPanel().setLevel(getGamePlayPanel().getLevel() + 1);
                        getGamePlayPanel().getLblLevel().setText(String.format("Level %d", getGamePlayPanel().getLevel()));
                        getGamePlayPanel().randomProblem();
                    }else {
                        if(getGamePlayPanel().getLevel() > getMaxLevel()){
                            setMaxLevel(getGamePlayPanel().getLevel());
                            writeFile();
                        }
                        getPlaySound().play("src/asset/sound/wrong.wav");
                        new GameFrame(1280, 720).setVisible(true);
                        dispose();
                    }
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                getPlaySound().play("src/asset/sound/selectMenu.wav");
                gamePlayPanel.getLblChoiceOne().setBackground(gamePlayPanel.getColors().get("myBlueSlimeHover"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                gamePlayPanel.getLblChoiceOne().setBackground(gamePlayPanel.getColors().get("myBlueSlime"));
            }
        });

        gamePlayPanel.getLblChoiceTwo().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(getGamePlayPanel().getRandOperator() != 3){
                    if(getGamePlayPanel().getLblChoiceTwo().getText().equals(String.format("%.0f", getGamePlayPanel().getResult()))){
                        getPlaySound().play("src/asset/sound/correct.wav");
                        getGamePlayPanel().setLevel(getGamePlayPanel().getLevel() + 1);
                        getGamePlayPanel().getLblLevel().setText(String.format("Level %d", getGamePlayPanel().getLevel()));
                        getGamePlayPanel().randomProblem();
                    }else {
                        if(getGamePlayPanel().getLevel() > getMaxLevel()){
                            setMaxLevel(getGamePlayPanel().getLevel());
                            writeFile();
                        }
                        getPlaySound().play("src/asset/sound/wrong.wav");
                        new GameFrame(1280, 720).setVisible(true);
                        dispose();
                    }
                }else {
                    if(getGamePlayPanel().getLblChoiceTwo().getText().equals(String.format("%.2f", getGamePlayPanel().getResult()))){
                        getPlaySound().play("src/asset/sound/correct.wav");
                        getGamePlayPanel().setLevel(getGamePlayPanel().getLevel() + 1);
                        getGamePlayPanel().getLblLevel().setText(String.format("Level %d", getGamePlayPanel().getLevel()));
                        getGamePlayPanel().randomProblem();
                    }else {
                        if(getGamePlayPanel().getLevel() > getMaxLevel()){
                            setMaxLevel(getGamePlayPanel().getLevel());
                            writeFile();
                        }
                        getPlaySound().play("src/asset/sound/wrong.wav");
                        new GameFrame(1280, 720).setVisible(true);
                        dispose();
                    }
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                getPlaySound().play("src/asset/sound/selectMenu.wav");
                gamePlayPanel.getLblChoiceTwo().setBackground(gamePlayPanel.getColors().get("myBlueSlimeHover"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                gamePlayPanel.getLblChoiceTwo().setBackground(gamePlayPanel.getColors().get("myBlueSlime"));
            }
        });

        gamePlayPanel.getLblChoiceThree().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(getGamePlayPanel().getRandOperator() != 3){
                    if(getGamePlayPanel().getLblChoiceThree().getText().equals(String.format("%.0f", getGamePlayPanel().getResult()))){
                        getPlaySound().play("src/asset/sound/correct.wav");
                        getGamePlayPanel().setLevel(getGamePlayPanel().getLevel() + 1);
                        getGamePlayPanel().getLblLevel().setText(String.format("Level %d", getGamePlayPanel().getLevel()));
                        getGamePlayPanel().randomProblem();
                    }else {
                        if(getGamePlayPanel().getLevel() > getMaxLevel()){
                            setMaxLevel(getGamePlayPanel().getLevel());
                            writeFile();
                        }
                        getPlaySound().play("src/asset/sound/wrong.wav");
                        new GameFrame(1280, 720).setVisible(true);
                        dispose();
                    }
                }else {
                    if(getGamePlayPanel().getLblChoiceThree().getText().equals(String.format("%.2f", getGamePlayPanel().getResult()))){
                        getPlaySound().play("src/asset/sound/correct.wav");
                        getGamePlayPanel().setLevel(getGamePlayPanel().getLevel() + 1);
                        getGamePlayPanel().getLblLevel().setText(String.format("Level %d", getGamePlayPanel().getLevel()));
                        getGamePlayPanel().randomProblem();
                    }else {
                        if(getGamePlayPanel().getLevel() > getMaxLevel()){
                            setMaxLevel(getGamePlayPanel().getLevel());
                            writeFile();
                        }
                        getPlaySound().play("src/asset/sound/wrong.wav");
                        new GameFrame(1280, 720).setVisible(true);
                        dispose();
                    }
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                getPlaySound().play("src/asset/sound/selectMenu.wav");
                gamePlayPanel.getLblChoiceThree().setBackground(gamePlayPanel.getColors().get("myBlueSlimeHover"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                gamePlayPanel.getLblChoiceThree().setBackground(gamePlayPanel.getColors().get("myBlueSlime"));
            }
        });

        gamePlayPanel.getLblChoiceFour().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(getGamePlayPanel().getRandOperator() != 3){
                    if(getGamePlayPanel().getLblChoiceFour().getText().equals(String.format("%.0f", getGamePlayPanel().getResult()))){
                        getPlaySound().play("src/asset/sound/correct.wav");
                        getGamePlayPanel().setLevel(getGamePlayPanel().getLevel() + 1);
                        getGamePlayPanel().getLblLevel().setText(String.format("Level %d", getGamePlayPanel().getLevel()));
                        getGamePlayPanel().randomProblem();
                    }else {
                        if(getGamePlayPanel().getLevel() > getMaxLevel()){
                            setMaxLevel(getGamePlayPanel().getLevel());
                            writeFile();
                        }
                        getPlaySound().play("src/asset/sound/wrong.wav");
                        new GameFrame(1280, 720).setVisible(true);
                        dispose();
                    }
                }else {
                    if(getGamePlayPanel().getLblChoiceFour().getText().equals(String.format("%.2f", getGamePlayPanel().getResult()))){
                        getPlaySound().play("src/asset/sound/correct.wav");
                        getGamePlayPanel().setLevel(getGamePlayPanel().getLevel() + 1);
                        getGamePlayPanel().getLblLevel().setText(String.format("Level %d", getGamePlayPanel().getLevel()));
                        getGamePlayPanel().randomProblem();
                    }else {
                        if(getGamePlayPanel().getLevel() > getMaxLevel()){
                            setMaxLevel(getGamePlayPanel().getLevel());
                            writeFile();
                        }
                        getPlaySound().play("src/asset/sound/wrong.wav");
                        new GameFrame(1280, 720).setVisible(true);
                        dispose();
                    }
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                getPlaySound().play("src/asset/sound/selectMenu.wav");
                gamePlayPanel.getLblChoiceFour().setBackground(gamePlayPanel.getColors().get("myBlueSlimeHover"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                gamePlayPanel.getLblChoiceFour().setBackground(gamePlayPanel.getColors().get("myBlueSlime"));
            }
        });
    }

    public GamePlayPanel getGamePlayPanel(){
        return gamePlayPanel;
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

    public String getPathMaxLevel(){
        return pathMaxLevel;
    }

    public File getFileMaxLevel(){
        return fileMaxLevel;
    }

    public int getMaxLevel(){
        return maxLevel;
    }

    public void setMaxLevel(int maxLevel){
        this.maxLevel = maxLevel;
    }

    // การใช้งาน try catch exceptions scanner และ readFile
    @Override
    public void readFile() {
        // การใช้งาน try catch exceptions
        try {
            Scanner scanner = new Scanner(getFileMaxLevel());
            setMaxLevel(Integer.parseInt(scanner.nextLine()));
            scanner.close();
        }catch (FileNotFoundException | NumberFormatException ignored){
            setMaxLevel(0);
        }
    }

    // การใช้งาน try catch exceptions scanner และ writeFile
    @Override
    public void writeFile(){
        try {
            FileWriter writer = new FileWriter(getPathMaxLevel());
            writer.write(String.format("%d",getMaxLevel()));
            writer.close();
        }catch (IOException ignored){}
    }

    public PlaySound getPlaySound() {
        return playSound;
    }
}
