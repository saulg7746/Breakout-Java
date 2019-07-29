import java.awt.EventQueue;

import javax.swing.JFrame;

public class Breakout extends JFrame{
    public static void main(String[] args) {
        
            Breakout game = new Breakout();
            game.add(new BreakoutBoard());
            game.setTitle("Breakout");
            game.setDefaultCloseOperation(EXIT_ON_CLOSE);
            game.setSize(1000, 550);
    		game.setLocationRelativeTo(null);
            game.setResizable(false);
            game.setVisible(true);
        ;
    }
}
