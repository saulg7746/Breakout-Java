import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Ball 
{
		private static int WIDTH = 20, HEIGHT = 20;
		// The location of the ball on the screen
		private int x, y; 
		
		// Since the ball will be moving in all directions it has to have an xMovement and yMovement
		// They are negative since the ball will start from the bottom right corner of the screen 
		// and will keep spawning at that point 
		private int xMovement = -2, yMovement = -2;
		
		// The ball will get faster according to the number of bricks in destroys
		private double speed = 1;
		public int bricksDestroyed = 0;
		
		public Ball ()
		{
			x = 900;
			y = 500;
		}
		
		public void move(Paddle paddle)
		{
			x += xMovement*(speed);
			y += yMovement*(speed);
			// if the ball bumps the right
			if(x > 1000 - HEIGHT )
				xMovement = -2;
			// if the ball goes past the paddle (bottom)
			else if(y > 550- HEIGHT -19)
			{
				x = 900;
				y = 500;
				xMovement = -2;
				yMovement = -2;
			}
			// if the ball bumps the left
			else if (x < 0)
				xMovement = 2;
			// if the ball bumps the top
			else if (y < 0)
				yMovement = 2;
			// if the ball hits the paddle
			else if((this.getRectangle()).intersects(paddle.getRectangle()))
			{
				// it MUST bounce so yMovement MUST be < 0
				yMovement = -2;
				// The paddle is broken into 4 parts and will bounce in the direction according to where it hit the paddle
				if(this.getRectangle().getX()+ (WIDTH-2) < paddle.getRectangle().getX() + (paddle.getRectangle().width/4))
					xMovement = -2;
				else if(this.getRectangle().getX()+ (WIDTH-2) < paddle.getRectangle().getX() + (paddle.getRectangle().width/4)*2)
					xMovement = -1;
				else if(this.getRectangle().getX()+ (WIDTH-2) < paddle.getRectangle().getX() + (paddle.getRectangle().width/4)*3)
					xMovement = 1;
				else
					xMovement = 2;
			}
			// speeds up the paddle and the ball 
			if(bricksDestroyed > 15)
			{
				speed = 1.5;
				paddle.speed = 2;
			}
			if(bricksDestroyed > 30)
			{
				speed = 2.0;
				paddle.speed = 3;
			}
		}
		
		// some "getters" and "setters"
		public void setSpeed (double newSpeed)
		{
			this.speed = newSpeed;
			
		}
		public void xMovement(int newMovement)
		{
			xMovement = newMovement;
		}
		public void yMovement(int newMovement)
		{
			yMovement = newMovement;
		}
		public int getYMovement()
		{
			return yMovement;
			
		}
		public int getXMovement()
		{
			return xMovement;
			
		}
		
		// Used to get a rectangle property from the ball (Intersects(Rectangle rec))
		public Rectangle getRectangle()
		{
			return new Rectangle (x, y, WIDTH, HEIGHT);
		}
		
		
		public void paint(Graphics g)
		{
			g.setColor(Color.RED);
			g.fillRect(x, y, WIDTH, HEIGHT);
		}
		
		
		

}
