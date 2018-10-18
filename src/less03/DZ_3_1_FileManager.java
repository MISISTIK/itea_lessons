package less03;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.sql.Date;
import java.util.*;
import java.util.List;

public class DZ_3_1_FileManager extends JFrame {

    private JList<String> list = new JList<>();
    private String path = System.getProperty("user.dir").replace('\\', '/');
    private JTextField tf = new JTextField();
    private JTextPane tp = new JTextPane();
    private List<String> txtList = Arrays.asList("txt", "log", "java", "xml", "properties", "gitignore", "sh", "ini");
    private List<String> imgList = Arrays.asList("jpg", "jpeg", "png", "ico", "bmp");


    private void folderAction() {
        String sel = list.getSelectedValue();
        if (sel != null) {
            if (sel.equals("..")) {
                String dir = new File(path).getParent();
                if (dir != null) {
                    path = dir;
                    list.setListData(getDirList(path));
                }
            }
            if (sel.contains("DIR")) {
                String dir = sel.replace("DIR", "").trim();
                if (new File(path + "/" + dir).exists()) {
                    path = path.equals("/") ? "/" + dir : path + "/" + dir;
                    list.setListData(getDirList(path));
                }
            } else {
                sel = sel.replace("DIR", "").trim();
                File f = new File(path + "/" + sel);
                if (f.isFile()) {
                    String ext = (f.getName().substring(f.getName().lastIndexOf(".") + 1));
                    if (txtList.contains(ext)) {
                        try {
                            Scanner in = new Scanner(f);
                            in.useDelimiter("\n");
                            StringBuilder sb = new StringBuilder();
                            while (in.hasNext()) {
                                sb.append(in.next()).append("\n");
                            }
                            tp.setText(sb.toString());
                        } catch (FileNotFoundException e) {
                            JOptionPane.showMessageDialog(this, path + "/" + sel + " not found");
                            e.printStackTrace();
                        }
                    }
                    if (imgList.contains(ext)) {
                        tp.setText("");
                        tp.insertIcon(new ImageIcon(path + "/" + sel));
                    }
                }
                tf.setText(path);
            }
        }
    }

    private String getFileInfoString(File file) {
        return "Name: " + file.getName() + "\n" +
                "Absolute path: " + file.getAbsolutePath() + "\n" +
                "Size: " + file.length() + " bytes" + "\n" +
                (file.isDirectory() ? "Type: DIR" : "Type: FILE") + "\n" +
                "Hidden?: " + file.isHidden() + "\n" +
                "LastModified: " + new Date(file.lastModified()) + "\n";
    }

    private void getInfoAction() {
        String sel = list.getSelectedValue().replace("DIR", "").trim();
        if (sel != null) {
            if (!sel.equals("..")) {
                tp.setText(getFileInfoString(new File(path + "/" + sel)));
            }
        }
    }

    private String[] getDirList(String path) {
        File dir = new File(path);
        if (dir.exists()) {
            if (dir.isDirectory()) {
                File[] files = dir.listFiles();
                List<String> res = new ArrayList<>();
                res.add("..");
                String fname;
                int fnameMaxLength = 30;
                for (File f : Objects.requireNonNull(files)) {
                    fname = (f.getName().length() > fnameMaxLength + 3) ? f.getName().substring(0, fnameMaxLength) + "..." : f.getName();
                    if (f.isDirectory()) {
                        res.add(String.format("%-" + fnameMaxLength + "s%-10s", fname, "DIR"));
                    }
                }
                for (File f : files) {
                    if (f.isFile()) {
                        res.add(f.getName());
                    }
                }
                return res.toArray(new String[0]);
            } else {
                JOptionPane.showMessageDialog(null, path + " is not a directory");
                System.exit(0);
            }
        } else {
            JOptionPane.showMessageDialog(null, path + " is not exists");
            System.exit(0);
        }
        return null;
    }

    public DZ_3_1_FileManager() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int width = 800;
        int height = 600;
        setSize(width, height);
        setLocation((int) (screenSize.getWidth() / 2) - (width / 2), (int) (screenSize.getHeight() / 2) - (height / 2));

        tp.setEditable(false);

        JButton buttonCopy = new JButton();
        buttonCopy.setPreferredSize(new Dimension(100, 20));
        buttonCopy.setText("Copy F5");

        JButton buttonMove = new JButton();
        buttonMove.setPreferredSize(new Dimension(100, 20));
        buttonMove.setText("Move F6");

        JButton buttonNewFolder = new JButton();
        buttonNewFolder.setPreferredSize(new Dimension(150, 20));
        buttonNewFolder.setText("New folder F7");
        buttonNewFolder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String newFolderName = JOptionPane.showInputDialog("Input the new folder's name:");
                try {
                    if (newFolderName.matches("[[\\w]~@#$%^\\-_(){}'`]+")) {
                        if (new File(path + "/" + newFolderName).mkdir()) {
                            JOptionPane.showMessageDialog(null, "Folder " + newFolderName + " was created");
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Name \"" + newFolderName + "\" not valid as a folder name");
                    }
                } catch (NullPointerException ignored) {
                    ;
                }

            }
        });

        String[] sl = getDirList(path);
        list.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        list.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                if (evt.getClickCount() == 1) {
                    getInfoAction();
                }
                if (evt.getClickCount() == 2) {
                    folderAction();
                }
            }
        });

        list.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    folderAction();
                }
                if (e.getKeyCode() == KeyEvent.VK_F7) {
                    buttonNewFolder.doClick();
                }
                if (e.getKeyCode() == KeyEvent.VK_UP && list.getSelectedValue() == null) {
                    list.setSelectedIndex(0);
                }
                if (list.getSelectedValue() != null && (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN)) {
                    getInfoAction();
                }
            }
        });
        list.setListData(sl);


        JScrollPane scrollPane = new JScrollPane(tp);

        tf.setText(path);
        tf.setAction(
                new AbstractAction("Enter") {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String tf_text = tf.getText();
                        if (new File(tf_text).exists()) {
                            if (new File(tf_text).isDirectory()) {
                                path = tf_text;
                                list.setListData(getDirList(path));
                            } else {
                                JOptionPane.showMessageDialog(null, tf.getText() + " is not a directory");
                            }

                        } else {
                            JOptionPane.showMessageDialog(null, tf.getText() + " doesn't exists");
                        }
                        tf.setText(path);
                    }
                }
        );
//        tf.setEditable(false);


        JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, list, scrollPane);
        sp.setDividerSize(5);
        sp.setOneTouchExpandable(true);
        sp.setDividerLocation(width / 2);

        JSplitPane spv = new JSplitPane(JSplitPane.VERTICAL_SPLIT, tf, sp) {
            private final int location = 25;

            {
                setDividerLocation(location);
                setDividerSize(5);
            }

            @Override
            public int getDividerLocation() {
                return location;
            }

            @Override
            public int getLastDividerLocation() {
                return location;
            }
        };




        JPanel infoPanel = new JPanel(new FlowLayout());
        infoPanel.add(buttonCopy);
        infoPanel.add(buttonMove);
        infoPanel.add(buttonNewFolder);

        int minusValue = 40;
        JSplitPane spDownBar = new JSplitPane(JSplitPane.VERTICAL_SPLIT, spv, infoPanel) {
            {
                setDividerLocation(getHeight() - minusValue);
                setDividerSize(5);
            }

            @Override
            public int getDividerLocation() {
                return getHeight() - minusValue;
            }

            @Override
            public int getLastDividerLocation() {
                return getHeight() - minusValue;
            }

        };

        addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent evt) {
                spDownBar.setDividerLocation(getHeight() - minusValue);
                sp.setDividerLocation(getWidth() / 2);
            }
        });


        add(spDownBar);
        setVisible(true);
    }

    public static void main(String[] args) {
        new DZ_3_1_FileManager();
    }
}
