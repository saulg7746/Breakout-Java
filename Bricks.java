import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Bricks 
{
	private int x, y;
	private int width, height;
	private boolean destroyed = false;
	// Used to determine its color
	private Random rand;
	private Color color;
	public Bricks(int x, int y, int width, int height)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		//r randomly sets its color just for fun :)
		rand = new Random();
		int randomInt = rand.nextInt(5);
		switch(randomInt+1)
		{
			case 1:	this.color = (Color.BLUE); break;
			case 2: this.color = (Color.DARK_GRAY); break;
			case 3: this.color = (Color.MAGENTA); break;
			case 4: this.color = (Color.LIGHT_GRAY); break;
			case 5: this.color = (Color.GREEN); break;
			default: break;
			
		}
	}
	
	
	// Crucial for Intersects(Rectangle rec)
	public Rectangle getRectangle()
	{
		return new Rectangle (x, y, width, height);
	}
	
	
	public void move(Ball ball)
	{
		// if the brick is hit by the ball and was NOT destroyed before 
		if((this.getRectangle()).intersects(ball.getRectangle()) && destroyed == false)
		{
			// its is destroyed
			destroyed = true;
			// if the brick is hit from ONLY the bottom
			if(this.getRectangle().getY() < ball.getRectangle().getY() 
					&& ball.getRectangle().getX() > this.getRectangle().getX() 
					&& ball.getRectangle().getX() < this.getRectangle().getX() + this.width)
				ball.yMovement(2);
			// if the brick is hit from ONLY the top
			else if(this.getRectangle().getY() > ball.getRectangle().getY()
					&& ball.getRectangle().getX() > this.getRectangle().getX() 
					&& ball.getRectangle().getX() < this.getRectangle().getX() + this.width)
				ball.yMovement(-2);
			// if the brick is hit from anywhere else (sides) then the ball bounces completely
			else
			{
				ball.yMovement(ball.getYMovement()*-1);
				ball.xMovement(ball.getXMovement()*-1);
			}
			
			ball.bricksDestroyed++;

		}

	}
	public void paint(Graphics g)
	{
		if(!destroyed)
		{
			g.setColor(this.color);
			g.fillRect(x, y, width, height);
		}
		
	}
}
