package pack;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;

public class ImgClass extends JFrame {

    public ImgClass() {
        URL url = null;
//        url = this.getClass().getResource("/img.png");
        try {
            url = new URL("file:img.png");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        JLabel img = new JLabel();
        img.setIcon(new ImageIcon(url));
        this.setTitle(url.getPath());

        add(img);
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ImgClass();

    }
}
