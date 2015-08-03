/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author JakeYang
 */
public class Lab1 extends JPanel implements ActionListener {

    private static final int DEFULT_WIDTH = 800;
    private static final int DEFULT_HEIGHT = 600;
    private final JTextArea textArea;
    private final JMenuItem openMenuItem;
    private final JMenuItem saveMenuItem;
    private final JMenuItem exitMenuItem;
    private final JFileChooser fileChooser;
    private File file;

    public Lab1(JFrame frame) {
        super(new BorderLayout());
        setPreferredSize(new Dimension(DEFULT_WIDTH, DEFULT_HEIGHT));

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        fileMenu.getAccessibleContext().setAccessibleDescription("the main menu is this program");
        menuBar.add(fileMenu);

        openMenuItem = new JMenuItem("Open", KeyEvent.VK_O);
        openMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        fileMenu.getAccessibleContext().setAccessibleDescription("Opens a file via an open file diglogue");
        openMenuItem.addActionListener(this);
        fileMenu.add(openMenuItem);

        fileMenu.addSeparator();

        saveMenuItem = new JMenuItem("Save as", KeyEvent.VK_S);
        saveMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        fileMenu.getAccessibleContext().setAccessibleDescription("Save as a file via an open file diglogue");
        saveMenuItem.addActionListener(this);
        fileMenu.add(saveMenuItem);

        fileMenu.addSeparator();

        exitMenuItem = new JMenuItem("Exit", KeyEvent.VK_Q);
        exitMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
        fileMenu.getAccessibleContext().setAccessibleDescription("Exits the program");
        exitMenuItem.addActionListener(this);
        fileMenu.add(exitMenuItem);

        frame.setJMenuBar(menuBar);

        textArea = new JTextArea(5, 20);
        textArea.addKeyListener(new KeyListener());

        JScrollPane jscrolpane = new JScrollPane(textArea);
        add(jscrolpane, BorderLayout.CENTER);

        fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
        FileNameExtensionFilter fileNameExtensionFilter = new FileNameExtensionFilter(".txt(Text File", "txt");
        fileChooser.setFileFilter(fileNameExtensionFilter);
    }

    @Override

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exitMenuItem) {
            System.exit(0);
        } else if (e.getSource() == openMenuItem) {
            int returnVal = fileChooser.showOpenDialog(Lab1.this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                file = fileChooser.getSelectedFile();
                Charset charset = Charset.forName("US-ASCII");
                try {
                    BufferedReader reader = Files.newBufferedReader(file.toPath(), charset);
                    textArea.setText("");
                    String line;
                    while ((line = reader.readLine()) != null) {
                        textArea.append(line + "\n");
                    }
                } catch (IOException ex) {
                    System.out.println(ex.toString());

                }
            }
        } else if (e.getSource() == saveMenuItem) {
            int returnVal = fileChooser.showSaveDialog(Lab1.this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                file = new File(fileChooser.getSelectedFile() + ".txt");
                // file = fileChooser.getSelectedFile();
                Charset charset = Charset.forName("US-ASCII");
                try {
                    BufferedWriter writer = Files.newBufferedWriter(file.toPath(), charset);
                    writer.write(textArea.getText(), 0, textArea.getText().length());
                    writer.flush();
                } catch (IOException ex) {
                    System.out.println(ex.toString());
                }
            }
        }
    }

    private class KeyListener extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.isControlDown()) {
                if (e.getKeyCode() == KeyEvent.VK_C) {
                    textArea.setText("");
                }
            }
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        JFrame frame = new JFrame("Lab 1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Lab1 lab1 = new Lab1(frame);
        frame.setContentPane(lab1);
        frame.pack();
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        frame.setLocation((int) (toolkit.getScreenSize().getWidth() - frame.getSize().getWidth()) / 2, (int) (toolkit.getScreenSize().getHeight() - frame.getSize().getHeight()) / 2);
        frame.setVisible(true);

    }

}
