package  Anime_MATH;

import javax.sound.sampled.*;
import java.io.File;

public class PlaySound {
    void play(String fileDir){
        try {
            File file = new File(fileDir);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        }catch (Exception ignored){}
    }
}
