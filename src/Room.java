import java.awt.Graphics;

public class Room {
	public int worldWidth = 10;
	public int worldHeight = 6;
	public int blockSize = 32;
	
	public Block[][] block;
	
	public Room(){
		define();
		
	}
	
	public void define(){
		block = new Block[worldWidth][worldHeight];
		
		for(int y=0;y<block.length;y++){
			
		}
	}
	
	public void physic(){
		
	}
	
	public void draw(Graphics g){
		
	}

}
