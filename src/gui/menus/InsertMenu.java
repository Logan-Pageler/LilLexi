package gui.menus;

import java.awt.Dimension;
import java.awt.event.*;

import javax.imageio.ImageIO;
import javax.net.ssl.TrustManagerFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileSystemView;
import javax.swing.plaf.FileChooserUI;

import glyphs.graphical.Rectangle;
import gui.Control;
import gui.Document;
import gui.commands.AddGlyphCommand;
import gui.commands.Command;
import main.LilLexi;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.geom.AffineTransform;

/**
 * Class to create insert drop down menu and organize it. Also handles when
 * buttons are pressed
 * 
 * @author Logan Pageler
 */
public class InsertMenu extends JMenu {

    public InsertMenu(Control control) {
        setText("Insert");
        JMenuItem rectangle = new JMenuItem("Insert Rectangle");
        rectangle.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                LilLexi.FRAME.setEnabled(false);
                JFrame createRect = new JFrame("Set Size");
                JPanel panel = new JPanel();
                JLabel widthText = new JLabel("Width:");
                JTextField width = new JTextField("50");

                width.addKeyListener(new KeyAdapter() {
                    public void keyPressed(KeyEvent ke) {

                        if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9'
                                || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                            int num = Integer.parseInt(width.getText());
                            if (num > 400) {
                                num = 400;
                            }
                            if (num < 1) {
                                num = 1;
                            }
                            width.setEditable(true);
                        } else {
                            width.setEditable(false);
                        }
                    }
                });

                JLabel heightText = new JLabel("Width:");
                JTextField height = new JTextField("50");

                height.addKeyListener(new KeyAdapter() {
                    public void keyPressed(KeyEvent ke) {

                        if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9'
                                || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                            int num = Integer.parseInt(width.getText());
                            if (num > 400) {
                                num = 400;
                            }
                            if (num < 1) {
                                num = 1;
                            }
                            width.setEditable(true);
                        } else {
                            width.setEditable(false);
                        }
                    }
                });

                JButton submit = new JButton("Submit");
                submit.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        LilLexi.FRAME.setEnabled(true);
                        createRect.dispose();
                        control.addGlyph(new Rectangle(0, 0, Integer.parseInt(width.getText()),
                                Integer.parseInt(height.getText())));

                    }

                });

                createRect.addWindowListener(new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        LilLexi.FRAME.setEnabled(true);
                        e.getWindow().dispose();
                    }
                });

                createRect.setMinimumSize(new Dimension(500, 300));
                panel.add(widthText);
                panel.add(width);
                panel.add(heightText);
                panel.add(height);
                panel.add(submit);
                createRect.add(panel);

                createRect.setVisible(true);
            }

        });

        JMenuItem image = new JMenuItem("Insert Image");
        image.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                LilLexi.FRAME.setEnabled(false);

                JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

                // open file chooser
                int returnValue = jfc.showOpenDialog(null);
                LilLexi.FRAME.setEnabled(true);

                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    String path = jfc.getSelectedFile().getAbsolutePath();
                    BufferedImage image;
                    try {
                        image = ImageIO.read(new File(path));
                        int width = image.getWidth(null);

                        // scale image to0 big
                        if (width > 1000) {
                            BufferedImage dbi = new BufferedImage(400, 400 * image.getHeight() / image.getWidth(),
                                    image.getType());
                            Graphics2D g = dbi.createGraphics();
                            AffineTransform at = AffineTransform.getScaleInstance(400.0 / image.getWidth(),
                                    400.0 / image.getHeight());
                            g.drawRenderedImage(image, at);
                            image = dbi;
                        }
                        control.addGlyph(new glyphs.graphical.Image(image, 0, 0));

                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }

                }

            }
        });

        add(rectangle);
        add(image);

    }

}
