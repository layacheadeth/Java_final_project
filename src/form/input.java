package form;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.Vector;

public class input implements ActionListener {
    public JFrame input= new JFrame("Student's Registration");
    JLabel la;
    JButton goback,submit;
    JTextField name;
    JTextField mobile;
    JComboBox course;

    input() throws IOException  {
        input.setLayout(null);
        input.setResizable(false);
        BufferedImage bf = ImageIO.read(new File("/Users/deth/Desktop/hello.jpeg"));

        input.setContentPane(new backImage(bf));

        JLabel laa=new JLabel("Courses only");
        Font font = new Font("Courier", Font.ITALIC,35);

        //set font for JLabel
        laa.setFont(font);
        laa.setBounds(370,80,300,70);
        input.add(laa);

        la=new JLabel("name");
        la.setBounds(280,150,100,30);
        input.add(la);

        name=new JTextField(20);
        name.setBounds(370,150,210,50);
        input.add(name);

        la=new JLabel("gender");
        la.setBounds(590,150,100,30);
        input.add(la);

        String s2[]={"Male","Female"};
        JComboBox sex=new JComboBox(s2);
        sex.setBounds(630,150,80,40);
        input.add(sex);


        la=new JLabel("mobile");
        la.setBounds(280,200,100,30);
        input.add(la);

        mobile=new JTextField(20);
        mobile.setBounds(370,200,350,50);
        input.add(mobile);


        la=new JLabel("course");
        la.setBounds(280,250,100,30);
        input.add(la);

        String co[] ={"C++","Java","Python","C#","C"};
        course=new JComboBox(co);
        course.setBounds(370,250,350,50);
        input.add(course);

        la=new JLabel("Email");
        la.setBounds(280,300,100,30);
        input.add(la);

        JTextField email=new JTextField(20);
        email.setBounds(370,300,350,50);
        input.add(email);

        la=new JLabel("Father's name");
        la.setBounds(280,350,100,30);
        input.add(la);

        JTextField father=new JTextField(20);
        father.setBounds(370,350,200,50);
        input.add(father);

        la=new JLabel("Job");
        la.setBounds(580,350,80,30);
        input.add(la);

        JTextField jobm=new JTextField(20);
        jobm.setBounds(610,350,100,50);
        input.add(jobm);


        la=new JLabel("Mother's name");
        la.setBounds(280,400,100,30);
        input.add(la);

        JTextField mother=new JTextField(20);
        mother.setBounds(370,400,200,50);
        input.add(mother);

        la=new JLabel("Job");
        la.setBounds(580,400,80,30);
        input.add(la);

        JTextField jobg=new JTextField(20);
        jobg.setBounds(610,400,100,50);
        input.add(jobg);

        la=new JLabel("Address");
        la.setBounds(280,450,100,30);
        input.add(la);

        JTextField address=new JTextField(20);
        address.setBounds(370,450,350,50);
        input.add(address);







        submit=new JButton("submit");
        submit.setBounds(260,560,100,30);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                String name1 = name.getText();
                String sex1 = sex.getSelectedItem().toString();
                String mobile1 = mobile.getText();
                String course1 = course.getSelectedItem().toString();
                String email1 = email.getText();
                String father1=father.getText();
                String job1=jobm.getText();
                String mother1=mother.getText();
                String job2=jobg.getText();
                String address1=address.getText();

                    Connection con1;
                    PreparedStatement insert;

                    try {
                        Class.forName("org.sqlite.JDBC");
                        con1 = DriverManager.getConnection("jdbc:sqlite:University.db");
                        insert = con1.prepareStatement("INSERT INTO courses(name,sex,mobile,course,email,father,job1,mother,job2,address) VALUES(?,?,?,?,?,?,?,?,?,?)");
                        insert.setString(1, name1);
                        insert.setString(2, sex1);
                        insert.setString(3, mobile1);
                        insert.setString(4, course1);
                        insert.setString(5, email1);
                        insert.setString(6,father1);
                        insert.setString(7,job1);
                        insert.setString(8,mother1);
                        insert.setString(9,job2);
                        insert.setString(10,address1);
                        insert.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Record added");
                        name.setText("");
                        mobile.setText("");
                        course.setSelectedIndex(-1);
                        email.setText("");
                        father.setText("");
                        jobm.setText("");
                        mother.setText("");
                        jobg.setText("");
                        address.setText("");
                        name.requestFocus();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
        });









        input.getContentPane().add(submit);



        goback=new JButton("goback");
        goback.setBounds(370,560,100,30);
        input.getContentPane().add(goback);
        goback.addActionListener(this);







        input.setVisible(true);
        input.setSize(1024,683);
        input.setLocationRelativeTo(null);
        input.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        try {
            input.dispose();
            hello1 he = new hello1();
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }

//    public static void table_update(){
//        int c;
//        Connection con1;
//        PreparedStatement insert;
//        JTable ta=new JTable();
//        ta.setBounds(330,30,500,400);
//        input.add(ta);
//        try{
//            Class.forName("org.sqlite.JDBC");
//            con1= DriverManager.getConnection("jdbc:sqlite:University.db");
//            insert=con1.prepareStatement("SELECT * FROM course ");
//            ResultSet rs=insert.executeQuery();
//            ResultSetMetaData rss=rs.getMetaData();
//            c=rss.getColumnCount();
//
//            DefaultTableModel df=(DefaultTableModel)ta.getModel();
//            df.setRowCount(0);
//
//            while(rs.next()){
//                Vector v2=new Vector();
//                for(int i=1;i<=c;i++){
//                    v2.add(rs.getString("id"));
//                    v2.add(rs.getString("name"));
//                    v2.add(rs.getString("mobile"));
//                    v2.add(rs.getString("course"));
//                }
//                df.addRow(v2);
//            }
//        }
//        catch(Exception e){
//            System.out.println(e.getMessage());
//        }
//    }
}

