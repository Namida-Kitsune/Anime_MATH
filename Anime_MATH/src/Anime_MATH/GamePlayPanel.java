package Anime_MATH;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class GamePlayPanel extends JPanel implements MethodRandom{
    private int level, randOperator, randAdd, randSubtract, randChoiceForResult;
    private double randOperandOne, randOperandTwo, result;
    private final Random random;
    private final String fontName;
    private final ArrayList<Font> fonts;
    private final HashMap<String, Color> colors;
    private final String[] operator;
    private final JLabel lblLevel, lblProblem, lblChoiceOne, lblChoiceTwo, lblChoiceThree, lblChoiceFour;
    private final double[] choices;
    GamePlayPanel(){
        setLayout(null);
        level = 0;
        operator = new String[4];
        choices = new double[4];
        operator[0] = "+";
        operator[1] = "-";
        operator[2] = "x";
        operator[3] = "/";
        random = new Random();
        fontName = "Prompt";
        colors = new HashMap<>();
        setColors("myBlack", new Color(0,0,0,125));
        setColors("myWhite", new Color(255,255,255));
        setColors("myBlueSlime", new Color(101, 177, 253));
        setColors("myBlueSlimeHover", new Color(255, 0, 0));

        int[] sizeFonts = {36, 60, 72, 120};
        fonts = new ArrayList<>();

        for(int sizeFont : sizeFonts){
            fonts.add(new Font(getFontName(), Font.PLAIN, sizeFont));
        }

        setBackground(getColors().get("myWhite"));

        lblLevel = new JLabel(String.format("Level %d", getLevel()), SwingConstants.CENTER);
        lblChoiceOne = new JLabel("", SwingConstants.CENTER);
        lblChoiceTwo = new JLabel("", SwingConstants.CENTER);
        lblChoiceThree = new JLabel("", SwingConstants.CENTER);
        lblChoiceFour = new JLabel("", SwingConstants.CENTER);
        lblProblem = new JLabel("", SwingConstants.CENTER);

        getLblLevel().setBackground(getColors().get("myBlueSlime"));
        getLblChoiceOne().setBackground(getColors().get("myBlueSlime"));
        getLblChoiceTwo().setBackground(getColors().get("myBlueSlime"));
        getLblChoiceThree().setBackground(getColors().get("myBlueSlime"));
        getLblChoiceFour().setBackground(getColors().get("myBlueSlime"));

        getLblLevel().setFont(getFonts(1));
        getLblProblem().setFont(getFonts(3));
        getLblChoiceOne().setFont(getFonts(1));
        getLblChoiceTwo().setFont(getFonts(1));
        getLblChoiceThree().setFont(getFonts(1));
        getLblChoiceFour().setFont(getFonts(1));

        getLblLevel().setForeground(getColors().get("myWhite"));
        getLblProblem().setForeground(getColors().get("myBlueSlime"));
        getLblChoiceOne().setForeground(getColors().get("myWhite"));
        getLblChoiceTwo().setForeground(getColors().get("myWhite"));
        getLblChoiceThree().setForeground(getColors().get("myWhite"));
        getLblChoiceFour().setForeground(getColors().get("myWhite"));

        getLblLevel().setBounds(0,0,1280,100);
        getLblProblem().setBounds(0,200,1280,100);
        getLblChoiceOne().setBounds(90,400,500,100);
        getLblChoiceTwo().setBounds(690,400,500,100);
        getLblChoiceThree().setBounds(90,550,500,100);
        getLblChoiceFour().setBounds(690,550,500,100);

        getLblLevel().setOpaque(true);
        getLblChoiceOne().setOpaque(true);
        getLblChoiceTwo().setOpaque(true);
        getLblChoiceThree().setOpaque(true);
        getLblChoiceFour().setOpaque(true);

        randomProblem();
        add(getLblLevel());
        add(getLblProblem());
        add(getLblChoiceOne());
        add(getLblChoiceTwo());
        add(getLblChoiceThree());
        add(getLblChoiceFour());
    }

    public JLabel getLblLevel(){
        return lblLevel;
    }

    public JLabel getLblProblem(){
        return lblProblem;
    }

    public JLabel getLblChoiceOne(){
        return lblChoiceOne;
    }

    public JLabel getLblChoiceTwo(){
        return lblChoiceTwo;
    }

    public JLabel getLblChoiceThree(){
        return lblChoiceThree;
    }
    public JLabel getLblChoiceFour(){
        return lblChoiceFour;
    }

    public int getLevel(){
        return level;
    }

    public void setLevel(int level){
        this.level = level;
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

    public Random getRandom(){
        return random;
    }

    public String[] getOperator(){
        return operator;
    }

    public int getRandOperator(){
        return randOperator;
    }

    public void setRandOperator(int randOperator){
        this.randOperator = randOperator;
    }

    public double getRandOperandOne(){
        return randOperandOne;
    }

    public void setRandOperandOne(double randOperandOne){
        this.randOperandOne = randOperandOne;
    }

    public double getRandOperandTwo(){
        return randOperandTwo;
    }

    public void setRandOperandTwo(double randOperandTwo){
        this.randOperandTwo = randOperandTwo;
    }

    public double getResult(){
        return result;
    }

    public void setResult(double result){
        this.result = result;
    }

    public double[] getChoices(){
        return choices;
    }

    public int getRandChoiceForResult(){
        return randChoiceForResult;
    }

    public void setRandChoiceForResult(int randChoiceForResult){
        this.randChoiceForResult = randChoiceForResult;
    }

    public int getRandAdd(){
        return randAdd;
    }

    public void setRandAdd(int randAdd){
        this.randAdd = randAdd;
    }

    public int getRandSubtract(){
        return randSubtract;
    }

    public void setRandSubtract(int randSubtract){
        this.randSubtract = randSubtract;
    }

    //บรรทัดแรกอัลกอริทึมหลัก
    @Override
    public void randomProblem() {
        setRandOperator(getRandom().nextInt(0,4));
        // การใช้งาน if - else
        if(getLevel() < 90){
            setRandOperandOne(getRandom().nextInt(0,10+getLevel()));
            if(getRandOperator() != 3){
                setRandOperandTwo(getRandom().nextInt(0,10+getLevel()));
            }else {
                setRandOperandTwo(getRandom().nextInt(1,10+getLevel()));
            }
        }else {
            setRandOperandOne(getRandom().nextInt(0,100));
            if(getRandOperator() != 3){
                setRandOperandTwo(getRandom().nextInt(0,100));
            }else {
                setRandOperandTwo(getRandom().nextInt(1,100));
            }
        }

        // การใช้งาน switch
        switch (getRandOperator()) {
            case 0 -> setResult(getRandOperandOne() + getRandOperandTwo());
            case 1 -> setResult(getRandOperandOne() - getRandOperandTwo());
            case 2 -> setResult(getRandOperandOne() * getRandOperandTwo());
            default -> setResult(getRandOperandOne() / getRandOperandTwo());
        }
        getLblProblem().setText(String.format("%.0f %s %.0f = ?", getRandOperandOne(), getOperator()[getRandOperator()], getRandOperandTwo()));
        randomChoice();
    }
    //บรรทัดสุดท้ายอัลกอริทึมหลัก
    @Override
    public void randomChoice() {
        setRandChoiceForResult(getRandom().nextInt(0, 4));
        // การใช้งาน for
        for(int i = 0; i < 4; i++){
            if(i != getRandChoiceForResult()){
                setRandAdd(getRandom().nextInt(1, 10));
                randSubtractNotSameRandAdd();
                getChoices()[i] = getResult() + getRandAdd() - getRandSubtract();
            }else {
                getChoices()[i] = getResult();
            }
        }

        if (getRandOperator() != 3) {
            getLblChoiceOne().setText(String.format("%.0f", getChoices()[0]));
            getLblChoiceTwo().setText(String.format("%.0f", getChoices()[1]));
            getLblChoiceThree().setText(String.format("%.0f", getChoices()[2]));
            getLblChoiceFour().setText(String.format("%.0f", getChoices()[3]));
        } else {
            getLblChoiceOne().setText(String.format("%.2f", getChoices()[0]));
            getLblChoiceTwo().setText(String.format("%.2f", getChoices()[1]));
            getLblChoiceThree().setText(String.format("%.2f", getChoices()[2]));
            getLblChoiceFour().setText(String.format("%.2f", getChoices()[3]));
        }

    }

    @Override
    public void randSubtractNotSameRandAdd() {
        do{
            setRandSubtract(getRandom().nextInt(1, 10));
        }while (getRandAdd() == getRandSubtract());
    }
}
