package form;



//First JFrame

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
//ww  w  .  j av a2s  . com
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;



import javax.swing.*;
import javax.xml.namespace.QName;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.sql.*;

class backImage extends JComponent {

    Image i;

    //Creating Constructer
    public backImage(Image i) {
        this.i = i;

    }

    //Overriding the paintComponent method
    @Override
    public void paintComponent(Graphics g) {

        g.drawImage(i, 0, 0, getWidth(),getHeight(),this);  // Drawing image using drawImage method

    }
}



public class hello  {
    JFrame f1 = new JFrame("Bee_school");
    JLabel l1, l2;
    JTextField t1;
    JPasswordField t2;
    JButton b1;


    hello() throws IOException{


        BufferedImage bf = ImageIO.read(new File("/Users/deth/Desktop/hello.jpeg"));

        f1.setContentPane(new backImage(bf));






        f1.setResizable(false);

        JLabel laa=new JLabel("Bee_school");
        Font font = new Font("Courier", Font.ITALIC,50);



        //set font for JLabel
        laa.setFont(font);
        laa.setBounds(370,150,300,70);
        f1.add(laa);

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

        l1 = new JLabel("User Name");
        l2 = new JLabel("Password");
        t1 = new JTextField(20);
        t2 = new JPasswordField(20);
        b1 = new JButton("Log-in");
        JButton b2=new JButton("Add-new");

        f1.setSize(1024, 683);
        f1.setLocationRelativeTo(null);
        f1.setVisible(true);
        f1.setLayout(null);

        f1.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        f1.add(l1);
        f1.add(t1);
        f1.add(l2);
        f1.add(t2);
        f1.add(b1);
        f1.add(b2);




        l1.setBounds(280, 250, 100, 45);
        t1.setBounds(370, 250, 300, 45);
        l2.setBounds(280, 300, 100, 45);
        t2.setBounds(370, 300, 300, 45);
        b1.setBounds(370, 390, 100, 30);
        b2.setBounds(500,390,100,30);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String user = t1.getText();
                String pass = t2.getText();
                Connection conn;
                PreparedStatement pst;

                if(user==null || pass==null){
                    JOptionPane.showMessageDialog(null,"The Username and Password shouldn't be blank");
                }
                else{
                    try {
                        Class.forName("org.sqlite.JDBC");
                        conn = DriverManager.getConnection("jdbc:sqlite:admin.db");
                        pst = conn.prepareStatement("SELECT * FROM User where name=? and mobile=?");
                        pst.setString(1, user);
                        pst.setString(2, pass);
                        ResultSet rs = pst.executeQuery();

                        if(rs.next()){
                            f1.dispose();
                            hello1 he=new hello1();
                        }else{
                            JOptionPane.showMessageDialog(null,"The username or password is incorrect");

                        }
                    }
                    catch(Exception e1){
                        System.out.println(e1.getMessage());
                    }

                }
            }
        });


        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try{
                    f1.dispose();
                    User u1=new User();
                }
                catch(Exception e){
                    throw new RuntimeException();
                }
            }
        });


    }






        public static void main(String[] args) throws IOException {



            hello p1 = new hello();
        }



}


//Second JFrame
