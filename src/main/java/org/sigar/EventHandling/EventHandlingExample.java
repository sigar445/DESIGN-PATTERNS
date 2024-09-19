package org.sigar.EventHandling;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EventHandlingExample extends JFrame implements ActionListener {
    JButton button;

    public EventHandlingExample() {
        button = new JButton("Click Me");
        button.setBounds(50, 100, 95, 30);

        // Register the listener
        button.addActionListener(this);

        add(button);
        setSize(300, 200);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

    // Implementing the actionPerformed method of ActionListener
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(this, "Button Clicked!");
    }

    public static void main(String[] args) {
        new EventHandlingExample();
    }
}

