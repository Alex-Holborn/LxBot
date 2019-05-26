package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui extends JFrame implements ActionListener {

    private Main main;

    Gui(Main m){
        main = m;
        setSize(400, 400);
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();





        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
