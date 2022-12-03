/**
 * โปรเจคนี้ชื่อ Anime MATH เป็นเกมตอบคำถามคณิตศาสตร์เหมาะกับเด็กอายุ 13 ปีขึ้นไป
 * ผู้จัดทำ
 * Namida Kitsune
 * ตัวอย่างหลักการเขียนโปรแกรมที่ใช้งานจะแสดงความคิดเห็น (Comment) ไว้ในบางจุดของ SourceCode ทั้งหมด โดยหลักการที่ใช้จะมีดังนี้
 * print, if, else, for, foreach, do-while, array, arraylist, hashmap, inheritance, interfaces,
 * abstract, exception, gui, events
 * */
package Anime_MATH;

import java.awt.*;
// การใช้งาน inheritance
public class Main extends PersonalInformation{
    private final GameFrame gameFrame;
    Main(){
        // การใช้งาน print
        System.out.printf("%s%n",name());
        // การใช้งาน gui
        gameFrame = new GameFrame(1280, 720);
        getGameFrame().setVisible(true);
    }

    public GameFrame getGameFrame(){
        return gameFrame;
    }

    @Override
    public String name() {
        return "Namida Kitsune";
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(Main::new);
    }
}
