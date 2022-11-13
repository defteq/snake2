import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameLogic extends JPanel implements ActionListener{
    private final int SIZE = 320;
    private int DOT_SIZE = 32;
    private int ALL_DOTS = 320;

    private  int x_snake;
    private  int y_snake;

    private boolean left = false;
    private boolean right = true;
    private boolean up = false;
    private boolean down = false;

    private Image snake_images;
    private Timer timer;
    private boolean in_game = true;

    public GameLogic(){
        setBackground(Color.LIGHT_GRAY);
        LoadImages();
        IntGame();
        setFocusable(true);
        addKeyListener(new FiledKeyListener());
    }


    public void LoadImages(){
        ImageIcon snake_img = new  ImageIcon("snake.png");
        snake_images = snake_img.getImage();
    }
    public void IntGame(){
        x_snake = 48;
        y_snake = 48;
        timer = new Timer(250,  this);
        timer.start();
    }
    public void printCoponets(Graphics g){
        super.paintComponents(g);
        g.drawImage(snake_images, x_snake, y_snake, this);
    }


    public void actionComponents(ActionEvent e) {
        if(in_game){
            move();
        }
        repaint();
    }

    private void move() {
        if (left){
            x_snake = x_snake - DOT_SIZE;
        }
        if (right){
            x_snake = x_snake + DOT_SIZE;
        }
        if (up){
            y_snake = y_snake - DOT_SIZE;

        }
        if (down){
            y_snake = y_snake + DOT_SIZE;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (in_game){
            move();
        }
        repaint();
    }


    class FiledKeyListener extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e){
            super.keyPressed(e);
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_LEFT && !right){
                up = false;
                left = true;
                down = false;
            }
            if (key == KeyEvent.VK_RIGHT && !left){
                up = false;
                right = true;
                down = false;
            }
            if (key == KeyEvent.VK_UP && !down){
                right = false;
                left = true;
                down = false;
            }
            if (key == KeyEvent.VK_LEFT && !right){
                up = false;
                left = true;
                down = false;
            }
        }
    }
}
