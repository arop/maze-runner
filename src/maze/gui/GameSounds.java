package maze.gui;

import java.io.File;
import java.util.HashMap;

import javax.sound.sampled.*;

/**
 * Esta classe serve de base para a utilização dos diferentes sons do jogo
 * @author André Pires, Filipe Gama
 *
 */
public class GameSounds {
	private static HashMap<String, Clip> sounds= new HashMap<String, Clip>();

	private static boolean silent = false;
	private static int interval;


	public static void init() {
		interval = 0;
	}


	public static void toggleSound() {
		silent = !silent;
	}

	public static void playSound(String soundName) {
		play(soundName, interval);
	}

	public static void play(String soundName, int i) {
		if(!silent){
			Clip x = sounds.get(soundName);
			if(x == null) return;
			if(x.isRunning()) x.stop();
			x.setFramePosition(i);
			while(!x.isRunning()) x.start();
		}
	}

	public static void loadSound(String filename, String soundName) {
		Clip clip;
		try {
			File f = new File(filename);
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(f);
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			sounds.put(soundName, clip);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}


	public static void adjustVolume(String soundName, float f) {
		Clip x = sounds.get(soundName);
		if(x == null) return;
		FloatControl volume = (FloatControl) x.getControl(FloatControl.Type.MASTER_GAIN);
		volume.setValue(f);
	}

	public static void stop(String soundName) {
		if(sounds.get(soundName) == null) return;
		if(sounds.get(soundName).isRunning()) sounds.get(soundName).stop();
	}

	public static void loop(String s) {
		loop(s, interval, interval, sounds.get(s).getFrameLength() - 1);
	}

	public static void loop(String s, int frame, int start, int end) {
		Clip c = sounds.get(s);
		if(c == null) return;
		if(c.isRunning()) c.stop();
		c.setLoopPoints(start, end);
		c.setFramePosition(frame);
		c.loop(Clip.LOOP_CONTINUOUSLY);
	}

}