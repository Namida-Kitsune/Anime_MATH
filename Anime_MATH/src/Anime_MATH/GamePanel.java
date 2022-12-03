package Anime_MATH;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class GamePanel extends JPanel implements ReadFile{
    private int maxLevel;
    private final String pathMaxLevel, fontName;
    private final File fileMaxLevel;
    // การใช้งาน arraylist และ generics
    private final ArrayList<Font> fonts;
    // การใช้งาน hashmap และ generics
    private final HashMap<String, Color> colors;
    private final JLabel lblWelcome, lblStart, lblExit, lblMaxLevel, lblBackground;
    GamePanel(){
        setLayout(null);
        fontName = "Prompt";
        pathMaxLevel = "src/asset/data/MaxLevel.txt";
        colors = new HashMap<>();
        setColors("myBlack", new Color(0,0,0,125));
        setColors("myWhite", new Color(255,255,255));
        setColors("myBlueSlime", new Color(101, 177, 253));
        setColors("myBlueSlimeHover", new Color(255, 0, 0));

        // การใช้งาน array
        int[] sizeFonts = {36, 60, 72, 120};
        fileMaxLevel = new File(getPathMaxLevel());
        fonts = new ArrayList<>();

        // การใช้งาน foreach
        for(int sizeFont : sizeFonts){
            fonts.add(new Font(getFontName(), Font.PLAIN, sizeFont));
        }
        readFile();

        lblBackground = new JLabel(new ImageIcon("src/asset/img/backGroundStart.jpg"));
        lblWelcome = new JLabel("<html><font color=white><font color=red>A</font>nime M<font color=red>A</font>TH</font></html>",SwingConstants.CENTER);
        lblStart = new JLabel("<html><font color=white>Start</font></html>", SwingConstants.CENTER);
        lblExit = new JLabel("<html><font color=white>Exit</font></html>", SwingConstants.CENTER);
        lblMaxLevel = new JLabel(String.format("<html><font color=white><font color=red>MAX</font> Level %d</font></html>", getMaxLevel()), SwingConstants.CENTER);

        getLblWelcome().setBackground(getColors().get("myBlack"));
        getLblStart().setBackground(getColors().get("myBlueSlime"));
        getLblExit().setBackground(getColors().get("myBlueSlime"));
        getLblMaxLevel().setBackground(getColors().get("myBlueSlime"));

        getLblWelcome().setFont(getFonts(2));
        getLblStart().setFont(getFonts(2));
        getLblExit().setFont(getFonts(2));
        getLblMaxLevel().setFont(getFonts(0));

        getLblBackground().setBounds(0,0,1280,720);
        getLblWelcome().setBounds(390,120,500,100);
        getLblStart().setBounds(390,270,500,100);
        getLblExit().setBounds(390,420,500,100);
        getLblMaxLevel().setBounds(45,570,300,100);

        getLblBackground().setOpaque(true);
        getLblWelcome().setOpaque(true);
        getLblStart().setOpaque(true);
        getLblExit().setOpaque(true);
        getLblMaxLevel().setOpaque(true);

        add(getLblWelcome());
        add(getLblStart());
        add(getLblExit());
        add(getLblMaxLevel());
        add(getLblBackground());
    }

    public JLabel getLblWelcome(){
        return lblWelcome;
    }

    public JLabel getLblStart(){
        return lblStart;
    }

    public JLabel getLblExit(){
        return lblExit;
    }

    public JLabel getLblMaxLevel(){
        return lblMaxLevel;
    }

    public JLabel getLblBackground(){
        return lblBackground;
    }

    public String getPathMaxLevel(){
        return pathMaxLevel;
    }

    public File getFileMaxLevel(){
        return fileMaxLevel;
    }

    public String getFontName(){
        return fontName;
    }

    public Font getFonts(int index){
        return this.fonts.get(index);
    }

    public void setColors(String colorName, Color color){
        this.colors.put(colorName, color);
    }

    public HashMap<String, Color> getColors(){
        return colors;
    }

    public int getMaxLevel(){
        return maxLevel;
    }

    public void setMaxLevel(int maxLevel){
        this.maxLevel = maxLevel;
    }

    @Override
    public void readFile() {
        // การใช้งาน try catch exceptions scanner และ readFile
        try {
            Scanner scanner = new Scanner(getFileMaxLevel());
            setMaxLevel(Integer.parseInt(scanner.nextLine()));
            scanner.close();
        }catch (FileNotFoundException | NumberFormatException ignored){
            setMaxLevel(0);
        }
    }

}
