/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrera;

import javax.swing.Timer;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import static java.awt.event.KeyEvent.*;

/**
 *
 * @author User
 */
public class Carrera extends JFrame{

    public Carrera() {
        add(new Control());
    }

    class Control extends JPanel implements KeyListener {

        private Carro carPanel = new Carro();
        private JButton jbtSuspend = new JButton("Parar");
        private JButton jbtResume = new JButton("Reanudar");

        public Control() {
            // Group buttons in a panel
            JPanel panel = new JPanel();
            panel.add(jbtSuspend);
            panel.add(jbtResume);
            // Add ball and buttons to the panel
            carPanel.setBorder(
                    new javax.swing.border.LineBorder(Color.red));
            setLayout(new BorderLayout());
            add(carPanel, BorderLayout.CENTER);
            add(panel, BorderLayout.SOUTH);
            // Register listeners
            jbtSuspend.addActionListener(new Listener());
            jbtResume.addActionListener(new Listener());
            addKeyListener(this);
        }

        class Listener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == jbtSuspend) {
                    carPanel.suspend();
                } else if (e.getSource() == jbtResume) {
                    carPanel.resume();
                }

            }
        }

        public void keyTyped(KeyEvent e) {
        }

        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();

            if (key == KeyEvent.VK_UP) {

                carPanel.setDelay(1);
            }

            if (key == KeyEvent.VK_DOWN) {
                carPanel.setDelay(20);
            }
        }

        public void keyReleased(KeyEvent e) {
        }

    }

    /**
     * Main method
     */
    public static void main(String[] args) {
        // JFrame frame = new JFrame();
        JFrame frame = new Carrera();
        //frame.add(applet);
        frame.setTitle("Carrera");
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1100, 600);
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setVisible(true);
    }
}
