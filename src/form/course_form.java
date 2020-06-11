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
import java.sql.ResultSet;

public class course_form  {
    JFrame f=new JFrame("course's form ");



    String name2,sex1,mobile2,course2,email2;

    course_form(String name2, String sex1, String mobile2,String course2,String email2)throws IOException {
        this.name2=name2;
        this.sex1=sex1;
        this.mobile2=mobile2;
        this.course2=course2;
        this.email2=email2;


        BufferedImage bf = ImageIO.read(new File("/Users/deth/Desktop/hello.jpeg"));

        f.setContentPane(new backImage(bf));
        f.setResizable(false);
        Connection conn=null,con1=null,con2=null,con3=null,con4=null,con5=null;
        PreparedStatement pst=null,pst1=null,pst2=null,pst3=null,pst4=null,pst5=null;
        ResultSet rs=null,rs1=null,rs2=null,rs3=null,rs4=null,rs5=null;



        JLabel la4=new JLabel("name");
        la4.setBounds(280,100,100,30);
        f.add(la4);

        JTextField co=new JTextField(20);
        co.setBounds(370,100,150,40);
        co.setText(name2);
        co.setEditable(false);
        f.add(co);



//




        JLabel la5=new JLabel("sex");
        la5.setBounds(500,100,100,30);
        f.add(la5);

        JTextField co1=new JTextField(20);
        co1.setBounds(600,100,150,40);
        co1.setText(sex1);
        co1.setEditable(false);
        f.add(co1);

//

        JLabel la6=new JLabel("email");
        la6.setBounds(280,150,100,30);
        f.add(la6);

        JTextField co2=new JTextField(20);
        co2.setBounds(370,150,150,40);
        co2.setText(email2);
        co2.setEditable(false);
        f.add(co2);



        JLabel la7=new JLabel("mobile");
        la7.setBounds(280,200,100,30);
        f.add(la7);

        JTextField co3=new JTextField(20);
        co3.setBounds(370,200,150,40);
        co3.setText(mobile2);
        co3.setEditable(false);
        f.add(co3);


//

        JLabel la8=new JLabel("course");
        la8.setBounds(280,250,100,30);
        f.add(la8);



        JTextField co4=new JTextField();
        co4.setBounds(370,250,150,40);
        co4.setText(course2);
        f.add(co4);



        JLabel la=new JLabel("assignment");
        la.setBounds(280,300,100,30);
        f.add(la);

        JTextField assign=new JTextField(5);
        assign.setBounds(370,300,150,40);
        f.add(assign);

        JLabel la1=new JLabel("project");
        la1.setBounds(280,350,100,30);
        f.add(la1);

        JTextField pro=new JTextField(5);
        pro.setBounds(370,350,150,40);
        f.add(pro);

        JLabel la2=new JLabel("midexam");
        la2.setBounds(280,400,100,30);
        f.add(la2);

        JTextField mid=new JTextField(5);
        mid.setBounds(370,400,150,40);
        f.add(mid);
        JLabel la3=new JLabel("finalexam");
        la3.setBounds(280,450,100,30);
        f.add(la3);

        JTextField fin=new JTextField(5);
        fin.setBounds(370,450,150,40);
        f.add(fin);

        JButton submit=new JButton("submit");
        submit.setBounds(370,600,100,30);
        f.add(submit);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String coa = co.getText();
                String cob = co1.getText();
                String coc = co2.getText();
                String cod = co3.getText();
                String coe = co4.getText();
                String assign2 = assign.getText();
                String pro2 = pro.getText();
                String mid2 = mid.getText();
                String fin2 = fin.getText();

                int assign1 = Integer.parseInt(assign.getText());
                int pro1 = Integer.parseInt(pro.getText());
                int mid1 = Integer.parseInt(mid.getText());
                int fin1 = Integer.parseInt(fin.getText());

                Connection con1 = null;
                PreparedStatement pst1 = null;
                String grade = null;

                if (assign2.trim().isEmpty() || pro2.trim().isEmpty() || mid2.trim().isEmpty() || fin2.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "You need to fill in those");
                } else {

                    double avg;
                    avg = (assign1 + pro1 + mid1 + fin1) / 4.0;

                    if (avg < 100 && avg > 90) {
                        grade = "A";
                    } else if (avg < 90 && avg > 80) {
                        grade = "B";
                    } else if (avg < 80 && avg > 70) {
                        grade = "C";
                    } else if (avg < 70 && avg > 60) {
                        grade = "D";
                    } else if (avg < 60 && avg > 50) {
                        grade = "E";
                    } else if (avg < 50) {
                        grade = "F";
                    } else {
                        grade = "Error wrong input";
                    }


                    try {
                        Class.forName("org.sqlite.JDBC");
                        con1 = DriverManager.getConnection("jdbc:sqlite:gpa.db");
                        pst1 = con1.prepareStatement("INSERT INTO grade(name,sex,email,mobile,course,assignment,project,midexam,finalexam,grades) VALUES(?,?,?,?,?,?,?,?,?,?)");
                        pst1.setString(1, coa);
                        pst1.setString(2, cob);
                        pst1.setString(3, coc);
                        pst1.setString(4, cod);
                        pst1.setString(5, coe);
                        pst1.setInt(6, assign1);
                        pst1.setInt(7, pro1);
                        pst1.setInt(8, mid1);
                        pst1.setInt(9, fin1);
                        pst1.setString(10, grade);

                        pst1.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Record added");
                        co.setText("");
                        co1.setText("");
                        co2.setText("");
                        co3.setText("");
                        co4.setText("");
                        assign.setText("");
                        pro.setText("");
                        mid.setText("");
                        fin.setText("");
                    } catch (Exception e) {
                       JOptionPane.showMessageDialog(null,"All field must be completed");
                    } finally {
                        try {
                            pst5.close();
                            con5.close();
                            rs5.close();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }


                }
            }

        });

        JButton goback=new JButton("goback");
        goback.setBounds(270,600,100,30);
        goback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try{
                    f.dispose();
                    hello1 he=new hello1();
                }
                catch (IOException e){
                    throw new RuntimeException(e);
                }
            }
        });
        f.add(goback);



        f.setLocationRelativeTo(null);
        f.setLayout(null);
        f.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        f.setSize(1024,683);
        f.setVisible(true);
    }

}

