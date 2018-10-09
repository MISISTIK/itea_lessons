package less01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.ResourceBundle;

public class DZ_2 {
    public static void main(String[] args) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        JTextArea txt = new JTextArea();
        int xPos = 450;
        int yPos = 450;
        int txt_width = 50;
        int txt_height = 50;
        txt.setBounds(xPos, yPos, txt_width, txt_height);
        txt.setText("");

        ActionListener al = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String[] s = e.getActionCommand().split(",");
                ResourceBundle messages = ResourceBundle.getBundle("PudgeMessages", new Locale(s[0], s[1]));
                txt.setText(messages.getString("m1") + "\n" + messages.getString("m2") + "\n" + messages.getString("m3"));

                String[] m = {
                        messages.getString("m1"),
                        messages.getString("m2"),
                        messages.getString("m3")
                };

                print(m[0]);
                print(m[1]);
                print(m[2]);

            }
        };

        JRadioButton rb_en = new JRadioButton("US");
        rb_en.setActionCommand("en,US");
        rb_en.setSelected(true);
        rb_en.addActionListener(al);

        JRadioButton rb_fr = new JRadioButton("FR");
        rb_fr.setActionCommand("fr,FR");
        rb_fr.addActionListener(al);

        JRadioButton rb_de = new JRadioButton("DE");
        rb_de.setActionCommand("de,DE");
        rb_de.addActionListener(al);

        ButtonGroup group = new ButtonGroup();
        group.add(rb_en);
        group.add(rb_fr);
        group.add(rb_de);

        JLabel label = new JLabel("");


        JPanel p = new JPanel();
        p.add(rb_en);
        p.add(rb_fr);
        p.add(rb_de);

        JFrame frame = new JFrame("Frame example");
        frame.setLayout(new GridLayout(2, 2));
        int width = 600;
        int height = 600;
//        print(String.valueOf(screenSize.getWidth()));
//        print(String.valueOf(screenSize.getHeight()));

        ResourceBundle messages = ResourceBundle.getBundle("PudgeMessages", new Locale("de", "DE"));
        txt.setText(messages.getString("m1") + "\n" + messages.getString("m2") + "\n" + messages.getString("m3"));

        String[] m = {
                messages.getString("m1"),
                messages.getString("m2"),
                messages.getString("m3")
        };


        frame.add(p);
        frame.add(label);
        frame.add(new JLabel(new ImageIcon("resources/img/pudge_img.png")));
        frame.add(txt);

        frame.setResizable(false);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocation((int) (screenSize.getWidth() / 2) - (width / 2), (int) (screenSize.getHeight() / 2) - (height / 2));

    }

    private static void print(String s) {
        System.out.println(s);
    }

}
