import javax.swing.*;

public class MainFrame extends JFrame{
    private JPanel rootPane;

    public MainFrame() {
        super("IFTTT");
        setContentPane(rootPane);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(800, 300);
        setSize(300,150);
        setResizable(false);
        setVisible(true);
    }
}
