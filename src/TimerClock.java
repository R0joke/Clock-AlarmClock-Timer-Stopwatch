import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimerClock extends JFrame implements ActionListener {
    JFrame frame = new JFrame("Таймер");
    JTextField secondsText = new JTextField();
    JTextField minutesText = new JTextField();
    JTextField hoursText = new JTextField();
    JLabel timeLabelInput = new JLabel("часы:минуты:секунды");
    JButton button = new JButton("Запись");
    JButton buttonStart = new JButton("Запуск");
    JLabel timeLabel = new JLabel();
    String writeSeconds;
    String writeMinutes;
    String writeHours;
    int seconds = 0;
    int minutes = 0;
    int hours = 0;
    int elapsedTime = 0;
    boolean tf = true;
    String hours_string = String.format("%02d", hours);
    String minutes_string = String.format("%02d", minutes);
    String seconds_string = String.format("%02d", seconds);

    Timer timer = new Timer(1000, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            elapsedTime = elapsedTime+1000;
            if (tf){
                hours = Integer.parseInt(writeHours);
                minutes = Integer.parseInt(writeMinutes);
            }
            seconds = Integer.parseInt(writeSeconds) - (elapsedTime / 1000) % 60;
            if (seconds<=-1){
                tf = false;
                seconds = (60+Integer.parseInt(writeSeconds))-(elapsedTime/1000)%60;
                minutes = Integer.parseInt(writeMinutes) - (elapsedTime / 60000) % 60;
                minutes -= 1;
            }
            if (minutes<=-1){
                minutes = (59+Integer.parseInt(writeMinutes))-(elapsedTime / 60000) % 60;
                hours = Integer.parseInt(writeHours) - (elapsedTime / 3600000);
                hours -= 1;
            }
            if (hours<=-1){
                hours = 0;
                minutes = 0;
                seconds = 0;
                new Message();
            }
            hours_string = String.format("%02d", hours);
            minutes_string = String.format("%02d", minutes);
            seconds_string = String.format("%02d", seconds);
            timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
        }
    });
    TimerClock(){
        ImageIcon imageIcon = new ImageIcon("clock.png");
        frame.setIconImage(imageIcon.getImage());
        frame.setSize(420,120);
        JPanel panel = new JPanel();

        secondsText.setPreferredSize(new Dimension(50, 20));
        secondsText.setBorder(BorderFactory.createLineBorder(Color.black));
        minutesText.setPreferredSize(new Dimension(50, 20));
        minutesText.setBorder(BorderFactory.createLineBorder(Color.black));
        hoursText.setPreferredSize(new Dimension(50, 20));
        hoursText.setBorder(BorderFactory.createLineBorder(Color.black));

        timeLabelInput.add(hoursText);
        timeLabelInput.add(minutesText);
        timeLabelInput.add(secondsText);
        timeLabelInput.setBorder(BorderFactory.createLineBorder(Color.black));
        
        timeLabelInput.setHorizontalTextPosition(JLabel.LEFT);

        button.addActionListener(this);
        button.setBorder(BorderFactory.createLineBorder(Color.black));
        button.setHorizontalAlignment(JButton.LEFT);
        button.setVerticalAlignment(JButton.TOP);
        button.setBounds(330, 0, 130, 50);
        buttonStart.addActionListener(this::actionPerformedStart);
        buttonStart.setBorder(BorderFactory.createLineBorder(Color.black));
        buttonStart.setHorizontalAlignment(JButton.CENTER);
        buttonStart.setVerticalAlignment(JButton.TOP);
        buttonStart.setBounds(200, 0, 130, 50);

        timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
        timeLabel.setFont(new Font("Minecraft",Font.PLAIN,35));
        timeLabel.setBorder(BorderFactory.createBevelBorder(1));
        timeLabel.setHorizontalAlignment(JLabel.LEFT);
        timeLabel.setVerticalAlignment(JLabel.TOP);
        timeLabel.setBorder(BorderFactory.createLineBorder(Color.black));

        panel.add(timeLabel);
        panel.add(button);
        panel.add(buttonStart);
        panel.setBounds(0, 0, 420, 60);

        frame.setFocusable(true);
        frame.setResizable(false);
        frame.add(panel);
        frame.add(timeLabel);
        frame.add(button);
        frame.add(buttonStart);
        frame.add(timeLabelInput);
        frame.add(hoursText);
        frame.add(minutesText);
        frame.add(secondsText);
        frame.setLayout(new FlowLayout());
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(((d.width /2)-frame.getWidth()/2) , ((d.height/2)-frame.getHeight()/2));
        frame.setVisible(true);
    }
    public void actionPerformedStart(ActionEvent e) {
        if (e.getSource()==buttonStart){
            timer.start();
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==button){
            writeSeconds = secondsText.getText();
            seconds_string = writeSeconds;
            writeMinutes = minutesText.getText();
            minutes_string = writeMinutes;
            writeHours = hoursText.getText();
            hours_string = writeHours;
            timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
        }
    }
}
