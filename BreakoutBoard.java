import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.awt.Graphics2D;
import javax.swing.Timer;
import javax.swing.JComponent;
import javax.swing.JPanel;


public class BreakoutBoard extends JPanel implements ActionListener, KeyListener{
	
	private Paddle paddle;
	private Ball ball;
	private Bricks[] bricks;	// used for the first layer of bricks
	private Bricks[] bricks2;	// used for the second layer of bricks
	private Bricks[] bricks3;	// used for the third layer of bricks 

	
    public BreakoutBoard() {
    	setBackground(Color.BLACK);
    	paddle = new Paddle(KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT, 1000/2);
    	ball = new Ball();
    	bricks = new Bricks[15]; // first layer will contain 15 bricks 
    	bricks2 = new Bricks[10];// second layer will contain 10 bricks 
    	bricks3 = new Bricks[15];// third layer will contain 15 bricks 

    	// adds the bricks with different sizes and locations into the corresponding layers 
    	for(int i = 0; i < 15; i++)
    		bricks[i] = (new Bricks((i*2)*34,50,45,30));
    	for(int i = 0; i < 10; i++)
    		bricks2[i] = (new Bricks(((i+1))*80,110,70,30));
    	for(int i = 0; i < 15; i++)
    		bricks3[i] = (new Bricks(((i*2))*34,160,45,30));
    	
    	// needed to start the game
    	Timer timer = new Timer(5, this);
        timer.start();
    	addKeyListener(this);
        setFocusable(true);

    };

    public void paintComponent(Graphics g )
    {
    	// paints the components
    	super.paintComponent(g);
    	paddle.paint(g);
    	ball.paint(g);
    	for(int i = 0; i < 15; i++)
    		bricks[i].paint(g);
    	for(int i = 0; i < 10; i++)
    		bricks2[i].paint(g);
    	for(int i = 0; i < 15; i++)
    		bricks3[i].paint(g);
    }

	@Override
	public void keyPressed(KeyEvent event) {
		// TODO Auto-generated method stub
		paddle.buttonPressed(event.getKeyCode());
		
	}

	@Override
	public void keyReleased(KeyEvent event) {
		// TODO Auto-generated method stub
		paddle.buttonReleased(event.getKeyCode());

	}


	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		// look at for the move implementation in the corresponding classes to see the logic of the game 
		paddle.move();
    	ball.move(paddle);
    	for(int i = 0; i < 15; i++)
    		bricks[i].move(ball);
    	for(int i = 0; i < 10; i++)
    		bricks2[i].move(ball);
    	for(int i = 0; i < 15; i++)
    		bricks3[i].move(ball);
    	// once it moves then repaint
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}