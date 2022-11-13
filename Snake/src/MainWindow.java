import javax.swing.*;

public class MainWindow extends JFrame {
    public MainWindow(){
        setTitle("змейка");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocation(750, 400);
        add(new GameLogic());
        setVisible(true);
    }
    public static void main(String[] args) {
       MainWindow window = new MainWindow();
    }
}