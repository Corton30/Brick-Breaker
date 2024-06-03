package mygame.GUI;


import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class SoundEffect {

    private Clip clip;
    private boolean isMuted = false;

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
        if (!isMuted) {
            clip.start();
        }
    }

    public void stop() {
        clip.stop();
    }

    public void toggleMute() {
        isMuted = !isMuted;
    }
}