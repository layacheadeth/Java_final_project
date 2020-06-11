package form;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class User {
JFrame user=new JFrame("Add-new");
JLabel la;
JButton goback,submit;
JTextField name,mobile,email;

User() throws IOException {
    user.setLayout(null);
    user.setResizable(false);

    BufferedImage bf = ImageIO.read(new File("/Users/deth/Desktop/hello.jpeg"));

    user.setContentPane(new backImage(bf));
    user.setSize(1024,683);
    user.setVisible(true);
    user.setLocationRelativeTo(null);
    user.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

    JLabel la=new JLabel("name");
    la.setBounds(280,150,100,30);
    user.add(la);

    name=new JTextField(20);
    name.setBounds(370,150,210,50);
    user.add(name);

    la=new JLabel("gender");
    la.setBounds(590,150,100,30);
    user.add(la);

    JTextField sex=new JTextField(20);
    sex.setBounds(630,150,80,40);
    user.add(sex);


    la=new JLabel("mobile");
    la.setBounds(280,200,100,30);
    user.add(la);

    mobile=new JTextField(20);
    mobile.setBounds(370,200,350,50);
    user.add(mobile);


    la=new JLabel("Email");
    la.setBounds(280,250,100,30);
    user.add(la);

    email=new JTextField(20);
    email.setBounds(370,250,350,50);
    user.add(email);

    la=new JLabel("Position");
    la.setBounds(280,300,100,30);
    user.add(la);

    String s1[]={"CEO","Office_staff","Teacher","Manager"};
    JComboBox pos=new JComboBox(s1);
    pos.setBounds(370,300,350,50);
    user.add(pos);


    submit=new JButton("submit");
    submit.setBounds(370,360,100,30);
    user.add(submit);
    submit.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            String name1 = name.getText();
            String sex1 = sex.getText();
            String mobile1 = mobile.getText();
            String email1 = email.getText();
            String pos1 = pos.getSelectedItem().toString();

            Connection con;
            PreparedStatement insert;

            if (name1.isEmpty() || sex1.isEmpty() || mobile1.isEmpty() || email1.isEmpty() || pos1.isEmpty()) {
                JOptionPane.showMessageDialog(null, "All field is mandatory");
            } else {
                try {
                    Class.forName("org.sqlite.JDBC");
                    con = DriverManager.getConnection("jdbc:sqlite:admin.db");
                    insert = con.prepareStatement("INSERT INTO User(name,sex,mobile,email,position) VALUES(?,?,?,?,?)");
                    insert.setString(1, name1);
                    insert.setString(2, sex1);
                    insert.setString(3, mobile1);
                    insert.setString(4, email1);
                    insert.setString(5, pos1);
                    insert.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Your account is your name\n your password is your mobile number you filled");
                    name.setText("");
                    sex.setText("");
                    mobile.setText("");
                    email.setText("");
                    name.requestFocus();

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    });




    goback=new JButton("goback");
    goback.setBounds(470,360,100,30);
    user.add(goback);
    goback.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            try{
                user.dispose();
                hello h=new hello();
            }
            catch(Exception e){
                throw new RuntimeException();
            }
        }
    });




}



}
