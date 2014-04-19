package maze.gui;

import java.io.File;
import java.util.HashMap;

import javax.sound.sampled.*;


public class GameSounds {
	private static int gap;
	private static HashMap<String, Clip> clips= new HashMap<String, Clip>();
	private static boolean silent = false;

	public static void init() {
		gap = 0;
	}

	public GameSounds(String s)
	{
		try{

		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void toggleSound() {
		silent = !silent;
	}


	public static void load(String s, String n) {
		Clip clip;
		try {
			File f = new File(s);
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(f);
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clips.put(n, clip);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void play(String s) {
		play(s, gap);
	}

	public static void play(String s, int i) {
		if(!silent){
			Clip c = clips.get(s);
			if(c == null) return;
			if(c.isRunning()) c.stop();
			c.setFramePosition(i);
			while(!c.isRunning()) c.start();
		}
	}

	public static void setVolume(String s, float f) {
		Clip c = clips.get(s);
		if(c == null) return;
		FloatControl vol = (FloatControl) c.getControl(FloatControl.Type.MASTER_GAIN);
		vol.setValue(f);
	}

	public static void stop(String s) {
		if(clips.get(s) == null) return;
		if(clips.get(s).isRunning()) clips.get(s).stop();
	}

	public static void resume(String s) {
		if(clips.get(s).isRunning()) return;
		clips.get(s).start();
	}

	public static void resumeLoop(String s) {
		Clip c = clips.get(s);
		if(c == null) return;
		c.loop(Clip.LOOP_CONTINUOUSLY);
	}

	public static void loop(String s) {
		loop(s, gap, gap, clips.get(s).getFrameLength() - 1);
	}


	public static void loop(String s, int frame, int start, int end) {
		Clip c = clips.get(s);
		if(c == null) return;
		if(c.isRunning()) c.stop();
		c.setLoopPoints(start, end);
		c.setFramePosition(frame);
		c.loop(Clip.LOOP_CONTINUOUSLY);
	}

}