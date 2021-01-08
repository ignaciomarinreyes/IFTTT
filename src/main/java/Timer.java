import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Timer extends JFrame {
    private JPanel rootPane;
    private JButton start;
    private JButton pause;
    private JButton stop;
    private JLabel timer;
    private JLabel valueTimer;

    public Timer() {
        super("IFTTT");
        setContentPane(rootPane);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(800, 300);
        setSize(300,150);
        setResizable(false);
        setVisible(true);
        t = new javax.swing.Timer(10, actions);
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t.start();
                start.setEnabled(false);
                start.setText("Resume");
                pause.setEnabled(true);
                stop.setEnabled(true);
            }
        });
        pause.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t.stop();
                start.setEnabled(true);
                pause.setEnabled(false);
            }
        });
        stop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(t.isRunning())
                {
                    t.stop();
                    start.setEnabled(true);
                }
                start.setText("Start");
                pause.setEnabled(false);
                stop.setEnabled(false);
                h=0; m=0; s=0; cs=0;
                updateLabel();
            }
        });
    }

    private javax.swing.Timer t;
    private int h, m, s, cs;
    private ActionListener actions = new ActionListener(){

        @Override
        public void actionPerformed(ActionEvent ae) {
            ++cs;
            if(cs==100){
                cs = 0;
                ++s;
            }
            if(s==60)
            {
                s = 0;
                ++m;
            }
            if(m==60)
            {
                m = 0;
                ++h;
            }
            updateLabel();
        }

    };

    private void updateLabel() {
        String time = (h<=9?"0":"")+h+":"+(m<=9?"0":"")+m+":"+(s<=9?"0":"")+s+":"+(cs<=9?"0":"")+cs;
        valueTimer.setText(time);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
