package form;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class hello1
{
    JFrame f1=new JFrame("Menu");
    Font font = new Font("Courier", Font.ITALIC,30);

    hello1 () throws IOException
    {
        f1.setLayout(null);

        BufferedImage bf = ImageIO.read(new File("/Users/deth/Desktop/hello.jpeg"));

        f1.setContentPane(new backImage(bf));

        f1.setResizable(false);




        JLabel he=new JLabel("helps");
        he.setBounds(930,10,100,30);
        f1.add(he);
        he.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                try{
                    f1.dispose();
                    help hew=new help();
                }
                catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {

            }
        });


        JLabel input=new JLabel("1.Course's Registration\n");
        input.setBounds(340,160,500,30);
        input.setFont(font);
        input.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent)  {
                try {
                    f1.dispose();
                    input in = new input();
                }
                catch (IOException e){
                    throw new RuntimeException(e);
                }
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {
               try{
                f1.dispose();
               input in=new input();

            }
               catch (IOException e){
                   throw new RuntimeException(e);
               }
            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {


            }
        });

        f1.add(input);



        JLabel output=new JLabel("\n2.Student's data");
        output.setBounds(320,230,500,30);
        output.setFont(font);
        output.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                try {
                    f1.dispose();
                    output out = new output();
                }
                catch (IOException e){
                    throw new RuntimeException(e);
                }
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {
                try {
                    f1.dispose();
                    output out = new output();
                }
                catch (IOException e){
                    throw new RuntimeException(e);
                }
            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {

            }
        });


        f1.add(output);

        JLabel search=new JLabel("\n3.Student's grade");
        search.setBounds(320,300,500,30);
        search.setFont(font);
        search.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                try {
                    f1.dispose();
                    search sea = new search();
                }
                catch (IOException e){
                    throw new RuntimeException(e);
                }
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {
                try {
                    f1.dispose();
                    search sea = new search();
                }
                catch (IOException e){
                    throw new RuntimeException(e);
                }
            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {

            }
        });


        f1.add(search);

        JLabel update=new JLabel("\n4.Student's academic's result");
        update.setBounds(320,370,500,30);
        update.setFont(font);
        update.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {

                try {
                    f1.dispose();
                    update up = new update();
                }

                catch (IOException e){
                    throw new RuntimeException(e);
                }
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {
                try {
                    f1.dispose();
                    update up = new update();
                }
                catch (IOException e){
                    throw new RuntimeException(e);
                }
            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {

            }
        }
        );

        f1.add(update);

        f1.setVisible(true);
        f1.setSize(1024,683);
        f1.setLocationRelativeTo(null);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);





    }
}