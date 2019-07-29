import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Paddle {
	
	private static int WIDTH = 100;
	private static int HEIGHT = 20;

	private int leftPressed, rightPressed; 
	// x and y refer to the location of the paddle on the screen
	// xMovement refers to direction (+ or -) the paddle will move in
	private int x, xMovement;
	private int y;
	
	// the paddle will get faster 
	public int speed = 1;
	
	public Paddle (int left, int right, int x)
	{

		this.x = x;
		this.leftPressed = left;
		this.rightPressed = right;
		y = 450;
		
	}
	
	public void move()
	{
		// allows the paddle to move in its x direction 
		// also gives speed its purpose
		if(xMovement > 0 || xMovement < 0)
			x += xMovement*speed;
	}
	public void buttonPressed(int keyCode)
	{
		if(keyCode == leftPressed)
			xMovement = -3;
		else if (keyCode == rightPressed)
			xMovement = 3;
	}
	
	public void buttonReleased(int keyCode)
	{
		if(keyCode == leftPressed || keyCode == rightPressed )
			xMovement = 0;
	}
	
	// This function is used to get a rectangle object from paddle
	// this is crucial for using the Intersects(Rectangle rec) function in the rectangle class 
	public Rectangle getRectangle()
	{
		return new Rectangle (x ,y, WIDTH, HEIGHT);
	}
	
	
	public void paint(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.fillRect(x, y, WIDTH, HEIGHT);
		
	}
	

}
