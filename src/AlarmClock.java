import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AlarmClock {
    JLabel timeLabel;
    SimpleDateFormat timeInLabel;
    String time;
    SimpleDateFormat dayInLabel;
    JLabel dayLabel;
    String day;
    JLabel comboBox = new JLabel();
    JLabel comboBox1 = new JLabel();
    JFrame alarmClock = new JFrame("Будильник");
    JLabel setTime = new JLabel("Время будильника");
    JLabel setDate = new JLabel("Дата будильника");
    JButton button = new JButton("Запись");
    JComboBox hours;
    JComboBox minutes;
    JComboBox seconds;
    JComboBox dayInMonth;
    JComboBox month;
    String writeHours;
    String writeMinutes;
    String writeSeconds;
    String writeDayInMonth;
    String writeMonth;
    String[] hoursArr = new String[25];
    String[] minutesArr = new String[60];
    String[] secondsArr = new String[60];

    String[] dayInMonthArr = new String[32];
    String[] monthArr = {"января","февраля","марта","апреля","мая","июня","июля","августа","сентября","октября","ноября","декабря"};
    AlarmClock(){
        ImageIcon imageIcon = new ImageIcon("clock.png");
        alarmClock.setIconImage(imageIcon.getImage());
        alarmClock.setSize(420,160);

        for (int i = 0; i <= 24; i++){
            hoursArr[i] = i+"";
        }
        for (int i = 0; i <= 59; i++){
            minutesArr[i] = i+"";
        }
        for (int i = 0; i <= 59; i++){
            secondsArr[i] =i+"";
        }
        for (int i = 1; i <= 31; i++){
            dayInMonthArr[i]=i+"";
        }

        timeInLabel = new SimpleDateFormat("HH:mm:ss");
        timeLabel = new JLabel();

        dayInLabel = new SimpleDateFormat("d:MMMM");
        dayLabel = new JLabel();
        dayLabel.setFont(new Font("Times New Roman",Font.BOLD,0));
        dayLabel.setForeground(Color.white);

        setTime.setBounds(80, 0, 200, 220);
        setTime.setFont(new Font("ROCKWELL",Font.PLAIN,20));
        setTime.setText("00:00:00");

        setDate.setBounds(230, 0, 200, 220);
        setDate.setFont(new Font("Times New Roman",Font.PLAIN,20));
        setDate.setText("0:месяц");

        button.setBounds(0,100, 60, 20);
        button.addActionListener(this::actionPerformed);
        button.setBorder(BorderFactory.createLineBorder(Color.black));
        button.setHorizontalAlignment(JButton.LEFT);
        button.setVerticalAlignment(JButton.TOP);

        hours = new JComboBox<>(hoursArr);
        hours.addActionListener(this::hoursInput);
        hours.setBounds(5,30,50,20);
        minutes = new JComboBox<>(minutesArr);
        minutes.addActionListener(this::minutesInput);
        minutes.setBounds(60,30,50,20);
        seconds = new JComboBox<>(secondsArr);
        seconds.addActionListener(this::secondsInput);
        seconds.setBounds(115,30,50,20);
        dayInMonth = new JComboBox<>(dayInMonthArr);
        dayInMonth.addActionListener(this::dayInMonthInput);
        dayInMonth.setBounds(30, 30, 50, 20);
        month = new JComboBox<>(monthArr);
        month.addActionListener(this::monthInput);
        month.setBounds(90, 30, 100,20);


        comboBox.setText("Часы : Минуты : Секунды");
        comboBox.setBounds(0,10, 200, 200);
        comboBox.setHorizontalAlignment(JLabel.LEFT);
        comboBox.setVerticalAlignment(JLabel.TOP);
        comboBox.add(hours);
        comboBox.add(minutes);
        comboBox.add(seconds);

        comboBox1.setText("День месяца : Месяц");
        comboBox1.setBounds(200,10, 200, 200);
        comboBox1.setHorizontalAlignment(JLabel.CENTER);
        comboBox1.setVerticalAlignment(JLabel.TOP);
        comboBox1.add(dayInMonth);
        comboBox1.add(month);

        alarmClock.add(button);
        alarmClock.add(setTime);
        alarmClock.add(setDate);
        alarmClock.add(comboBox);
        alarmClock.add(comboBox1);
        alarmClock.add(timeLabel);
        alarmClock.add(dayLabel);

        alarmClock.setVisible(true);
        updateAllDate();

    }
    public void hoursInput(ActionEvent e){
        if (e.getSource()==hours){
            writeHours = (String) hours.getSelectedItem();
            for (int i = 0; i <= 9; i++){
                if (hours.getSelectedItem().equals(i+"")){
                    writeHours = "0" + hours.getSelectedItem();
                }
            }
        }
    }
    public void minutesInput(ActionEvent e){
        if (e.getSource()==minutes){
            writeMinutes = (String) minutes.getSelectedItem();
            for (int i = 0; i <= 9; i++){
                if (minutes.getSelectedItem().equals(i+"")){
                    writeMinutes = "0" + minutes.getSelectedItem();
                }
            }
        }
    }
    public void secondsInput(ActionEvent e){
        if (e.getSource()==seconds){
            writeSeconds = (String) seconds.getSelectedItem();
            for (int i = 0; i <= 9; i++){
                if (seconds.getSelectedItem().equals(i+"")){
                    writeSeconds = "0" + seconds.getSelectedItem();
                }
            }
        }
    }
    public void dayInMonthInput(ActionEvent e){
        if (e.getSource()==dayInMonth){
            writeDayInMonth= (String) dayInMonth.getSelectedItem();
        }
    }
    public void monthInput(ActionEvent e){
        if (e.getSource()==month){
            writeMonth = (String) month.getSelectedItem();
        }
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==button){
            setTime.setText(writeHours+":"+writeMinutes+":"+writeSeconds);
            setDate.setText(writeDayInMonth+":"+writeMonth);
        }
    }
    public void updateAllDate() {
        while (true){
            time = timeInLabel.format(Calendar.getInstance().getTime());
            timeLabel.setText(time);
            day = dayInLabel.format(Calendar.getInstance().getTime());
            dayLabel.setText(day);
            if (time.equals(setTime.getText())){
                if (day.equals(setDate.getText())){
                    new Message();
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
