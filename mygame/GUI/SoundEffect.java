package mygame.GUI;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;




import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class SoundEffect {

    private Clip clip;

    public SoundEffect(String soundFileName) {
        try {
            URL url = this.getClass().getClassLoader().getResource(soundFileName);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
            clip = AudioSystem.getClip();
            clip.open(audioIn);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void play() {
        if (clip.isRunning())
            clip.stop();   // Stop the player if it is still running
        clip.setFramePosition(0); // rewind to the beginning
        clip.start();     // Start playing
    }
}

//import java.io.File;
//
//public class SoundEffect {
//    public static void checkFileExists(String filePath) {
//        File file = new File(filePath);
//        if (file.exists()) {
//            System.out.println("File exists: " + filePath);
//        } else {
//            System.out.println("File does not exist: " + filePath);
//        }
//    }
//}

