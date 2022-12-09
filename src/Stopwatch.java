import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Stopwatch implements ActionListener{
    int elapsedTime = 0;
    int seconds = 0;
    int minutes = 0;
    int hours = 0;
    boolean started = false;
    String hours_string = String.format("%02d", hours);
    String minutes_string = String.format("%02d", minutes);
    String seconds_string = String.format("%02d", seconds);
    //String milliseconds_string = String.format("%02d", milliseconds);
    Timer timer = new Timer(1000, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            elapsedTime = elapsedTime+1000;
            hours = (elapsedTime/3600000);
            minutes = (elapsedTime/60000) % 60;
            seconds = (elapsedTime/1000) % 60;
            hours_string = String.format("%02d", hours);
            minutes_string = String.format("%02d", minutes);
            seconds_string = String.format("%02d", seconds);
            timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
        }
    });
    JFrame frame = new JFrame("Секундомер");
    JButton startButton = new JButton("СТАРТ");
    JButton resetButton = new JButton("СБРОСИТЬ");
    JLabel timeLabel = new JLabel();
    Stopwatch() {
        ImageIcon imageIcon = new ImageIcon("clock.png");
        frame.setIconImage(imageIcon.getImage());
        frame.setSize(350,150);
        frame.setLayout(new FlowLayout());
        timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
        timeLabel.setBounds(0,0,200,100);
        timeLabel.setFont(new Font("Minecraft",Font.PLAIN,35));
        timeLabel.setBorder(BorderFactory.createBevelBorder(1));
        timeLabel.setHorizontalAlignment(JTextField.CENTER);
        startButton.setBounds(0,0,100,50);
        startButton.setFont(new Font("MACHINE",Font.PLAIN,20));
        startButton.addActionListener(this);
        resetButton.setBounds(0,50,100,50);
        resetButton.setFont(new Font("MACHINE",Font.PLAIN,20));
        resetButton.addActionListener(this);
        frame.add(startButton);
        frame.add(resetButton);
        frame.add(timeLabel);
        //frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(((d.width /2)-frame.getWidth()/2) , ((d.height/2)-frame.getHeight()/2));
        timeLabel.setOpaque(false);
        startButton.setOpaque(false);
        resetButton.setOpaque(false);
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==startButton) {
            if(started==false) {
                started=true;
                startButton.setText("ОСТАНОВИТЬ");
                start();
            }
            else {
                started=false;
                startButton.setText("СТАРТ");
                stop();
            }
        }
        if(e.getSource()==resetButton) {
            started=false;
            startButton.setText("СТАРТ");
            reset();
        }
    }
    void start() {
        timer.start();
    }
    void stop() {
        timer.stop();
    }
    void reset() {
        timer.stop();
        elapsedTime=0;
        hours=0;
        minutes=0;
        seconds=0;
        //milliseconds=0;
        hours_string = String.format("%02d", hours);
        minutes_string = String.format("%02d", minutes);
        seconds_string = String.format("%02d", seconds);
        //milliseconds_string = String.format("%02d", milliseconds);
        timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
    }
}