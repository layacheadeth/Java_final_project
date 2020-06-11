package form;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class help {
    JFrame f1=new JFrame("helps");
    help() throws IOException {

        BufferedImage bf = ImageIO.read(new File("/Users/deth/Desktop/hello.jpeg"));

        f1.setContentPane(new backImage(bf));
        f1.setResizable(false);

        JTextArea te=new JTextArea("In the user login\n" +
                "1. Click add new to create user \n" +
                "2. If you already have one, just fill in\n" +
                "3. If you are not staff in school, you won't be able to log in\n" +
                "In the menu\n"+
                "note1: Whenever you delete a data from menu 2, make sure to also delete from\n menu4. (we are trying to figure a better way now)\n"+
                "\nnote2: the student's grade form will only validate to enter due to 2 condition.\n "+
                "1. when the student is already registered\n"+
                "2. When the student is already registered but not yet get a grade after exam\n");
        JScrollPane scroll=new JScrollPane(te);
        scroll.setBounds(280,100,500,500);
        te.setEditable(false);
        f1.add(scroll);

        JButton goback=new JButton("goback");
        goback.setBounds(110,600,100,30);
        goback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try{
                    f1.dispose();
                    hello he=new hello();
                }
                catch (IOException e){
                    throw new RuntimeException(e);
                }
            }
        });
        f1.add(goback);


        f1.setLayout(null);
        f1.setLocationRelativeTo(null);
        f1.setSize(1024,683);
        f1.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        f1.setVisible(true);

    }
}
