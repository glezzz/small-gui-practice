package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {

    //put in scope of all methods
    private int count = 0;
    private JFrame frame;
    private JButton button;
    private JButton resetButton;
    private JLabel label;
    private JPanel panel;


    public GUI() {
        //this is the window
        frame = new JFrame();

        button = new JButton("Click me");
        resetButton = new JButton("Reset");
        button.addActionListener(this);
        resetButton.addActionListener(new SecondButton());

        label = new JLabel("Number of clicks: 0");

        //panel inside the window, here go all the things you want to add to the panel
        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(button);
        panel.add(resetButton);
        panel.add(label);

        frame.add(panel, BorderLayout.CENTER);
        //determines what happens when click close button
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("My GUI");
        frame.pack();
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        count++;
        label.setText("Number of clicks: " + count);
    }

    class SecondButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            count = 0;
            label.setText("Number of clicks: " + count);

        }
    }
}
