import javax.sound.sampled.*;
import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.http.WebSocket;
import java.net.http.WebSocket.Listener;

public class Message{
    JFrame message = new JFrame("Оповещение");
    private boolean released = false;
    private AudioInputStream stream = null;
    private Clip clip = null;
    private FloatControl volumeControl = null;
    private boolean playing = false;
    Message() {
        ImageIcon imageIcon = new ImageIcon("clock.png");
        message.setIconImage(imageIcon.getImage());
        message.setSize(420,420);
        JLabel jLabel = new JLabel();
        jLabel.setText("ОПОВЕЩЕНИЕ");
        jLabel.setFont(new Font("Times New Roman", Font.BOLD, 100));
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        message.add(jLabel);
        message.pack();
        message.setLocation(((d.width /2)-message.getWidth()/2) , ((d.height/2)-message.getHeight()/2));
        message.setVisible(true);
    }
    public boolean isReleased() {
        return released;
    }
    public void close() {
        if (clip != null)
            clip.close();

        if (stream != null)
            try {
                stream.close();
            } catch (IOException exc) {
                exc.printStackTrace();
            }
    }
}
