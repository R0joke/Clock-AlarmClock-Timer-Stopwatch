import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.metal.MetalLookAndFeel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Frame extends JFrame implements ActionListener {
    SimpleDateFormat timeInLabel;
    String time;
    String day;
    JLabel timeLabel;
    SimpleDateFormat dayInLabel;
    JLabel dayLabel;
    JButton stopwatch = new JButton("Секундомер");
    JButton timer = new JButton("Таймер");
    JButton alarmClock = new JButton("Будильник");
    JFrame frame = new JFrame("Clock");
    Frame() throws IOException {
        JFrame.setDefaultLookAndFeelDecorated(true);
        UIManager.put("activeCaption", new javax.swing.plaf.ColorUIResource(Color.black));
        UIManager.put("activeCaptionText", new javax.swing.plaf.ColorUIResource(Color.white));
        frame.setUndecorated(true);
        frame.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
        JPanel panel = new JPanel();
        panel.setBackground(Color.white);
        frame.setContentPane(panel);
        MetalLookAndFeel.setCurrentTheme(new MyDefaultMetalTheme());
        try {
            UIManager.setLookAndFeel(new MetalLookAndFeel());
        } catch (Exception e) {e.printStackTrace();}
        SwingUtilities.updateComponentTreeUI(frame);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setResizable(false);

        ImageIcon imageIcon = new ImageIcon("clock.png");
        frame.setIconImage(imageIcon.getImage());

        frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("background.png")))));

        timeInLabel = new SimpleDateFormat("HH:mm:ss");
        dayInLabel = new SimpleDateFormat("EEEE, d MMMM yyyy" + " г.");

        timeLabel = new JLabel();
        dayLabel = new JLabel();

        timeLabel.setFont(new Font("Minecraft",Font.BOLD,50));
        timeLabel.setForeground(Color.white);
        timeLabel.setBounds(0, 0, 1024, 150);
        timeLabel.setHorizontalAlignment(JLabel.CENTER);

        dayLabel.setFont(new Font("MACHINE",Font.PLAIN,35));
        dayLabel.setForeground(Color.white);
        dayLabel.setBounds(0, 70, 1024, 100);
        dayLabel.setHorizontalAlignment(JLabel.CENTER);

        stopwatch.setBounds(135, 300, 150,150);
        stopwatch.setIcon(new ImageIcon(ImageIO.read(new File("sw.png"))));
        stopwatch.setForeground(Color.white);
        stopwatch.setBackground(Color.black);
        stopwatch.setFocusable(false);
        stopwatch.setOpaque(true);
        stopwatch.addActionListener(this::actionPerformed);
        stopwatch.setHorizontalTextPosition(JButton.CENTER);
        stopwatch.setVerticalTextPosition(JButton.TOP);

        timer.setIcon(new ImageIcon(ImageIO.read(new File("timer.png"))));
        timer.setBounds(435, 300, 150, 150);
        timer.setForeground(Color.white);
        timer.setBackground(Color.black);
        timer.setFocusable(false);
        timer.setOpaque(true);
        timer.addActionListener(this::actionPerformedTimer);
        timer.setHorizontalTextPosition(JButton.CENTER);
        timer.setVerticalTextPosition(JButton.TOP);

        alarmClock.setIcon(new ImageIcon(ImageIO.read(new File("ac.png"))));
        alarmClock.setBounds(735, 300, 150, 150);
        alarmClock.setForeground(Color.white);
        alarmClock.setBackground(Color.black);
        alarmClock.setFocusable(false);
        alarmClock.setOpaque(true);
        alarmClock.addActionListener(this::actionPerformedAlarmClock);
        alarmClock.setHorizontalTextPosition(JButton.CENTER);
        alarmClock.setVerticalTextPosition(JButton.TOP);

        frame.add(alarmClock);
        frame.add(timeLabel);
        frame.add(dayLabel);
        frame.add(stopwatch);
        frame.add(timer);

        frame.pack();
        frame.setVisible(true);
        updateAllDate();
    }
    public void updateAllDate() {
        while (true){
            time = timeInLabel.format(Calendar.getInstance().getTime());
            timeLabel.setText(time);
            day = dayInLabel.format(Calendar.getInstance().getTime());
            dayLabel.setText(day);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void actionPerformedAlarmClock(ActionEvent e) {
        if (e.getSource()==alarmClock){
            JFrame.setDefaultLookAndFeelDecorated(false);
            new AlarmClock();
        }
    }
    public void actionPerformedTimer(ActionEvent e) {
        if (e.getSource()==timer){
            JFrame.setDefaultLookAndFeelDecorated(false);
            new TimerClock();
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==stopwatch){
            JFrame.setDefaultLookAndFeelDecorated(false);
            new Stopwatch();
        }
    }
}