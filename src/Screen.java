import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;

import javax.swing.*;

public class Screen extends JPanel implements Runnable{
	public Thread thread = new Thread(this);
	
	public static Image[] tileset_ground = new Image[10];
	public static Image[] tileset_air = new Image[10];
	
	public static int myWidth, myHeight;
	
	public static boolean isFirst = true;
	
	public static Room room;
	
	public Screen(){
		thread.start();
	}
	
	public void define(){
		myWidth = getWidth();
		myHeight = getHeight();
		room = new Room();
		
		for(int i=0;i<tileset_ground.length;i++){
			tileset_ground[i] = new ImageIcon("res/tileset.png").getImage();
			tileset_ground[i] = createImage(new FilteredImageSource(tileset_ground[i].getSource(), new CropImageFilter(0,i*26,26,26)));
		}
		
		for(int i=0;i<tileset_air.length;i++){
			tileset_air[i] = new ImageIcon("res/tileset_air.png").getImage();
			tileset_air[i] = createImage(new FilteredImageSource(tileset_ground[i].getSource(), new CropImageFilter(0,i*26,26,26)));
		}
		
	}
	
	public void paintComponent(Graphics g){
		if(isFirst){
			define();
			
			isFirst = false;
		}
		
		g.clearRect(0, 0, getWidth(), getHeight());
		room.draw(g);
	}
	
	
	
	public void run(){
		while(true){
			if(!isFirst){
				room.physic();
			}
			repaint();
			
			try{
				Thread.sleep(1);
			}catch(Exception e){}
		}
	}
}
