import java.awt.Color;
import java.awt.Graphics;

import javax.swing.*;

public class Screen extends JPanel implements Runnable{
	public Thread thread = new Thread(this);
	
	public static int myWidth, myHeight;
	
	public static boolean isFirst = true;
	
	public Screen(){
		thread.start();
	}
	
	public void define(){
		
	}
	
	public void paintComponent(Graphics g){
		if(isFirst){
			define();
		}
		
		g.clearRect(0, 0, getWidth(), getHeight());
	}
	
	
	public static int fpsFrame = 0, fps = 1000000;
	public void run(){
		while(true){
			if(!isFirst)
			repaint();
			
			try{
				Thread.sleep(1);
			}catch(Exception e){}
		}
	}
}
