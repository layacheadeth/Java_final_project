package form;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.Vector;

public class search {
    JFrame search =new JFrame("Student's registration");
    JLabel lc;
    JButton goback,se;
    JTextField searches;

    JButton submit;
    JTextField name;
    JTextField mobile;
    JComboBox course;
  String name2;
  String mobile2;

  public String getName2(){
      return name2;
  }
  public  void setName2(String name2){
      this.name2=this.name.getText();
  }
  public String getMobile2(){
      return mobile2;
  }
  public void setMobile2(String mobile2){
      this.mobile2=this.mobile.getText();
  }

    search() throws IOException {
        search.setLayout(null);
        search.setResizable(false);

        BufferedImage bf = ImageIO.read(new File("/Users/deth/Desktop/hello.jpeg"));

        search.setContentPane(new backImage(bf));





        lc = new JLabel("name");
        lc.setBounds(280, 150, 100, 30);
        search.add(lc);

        name = new JTextField(20);
        name.setBounds(370, 150, 210, 50);
        search.add(name);

        lc = new JLabel("gender");
        lc.setBounds(590, 150, 100, 30);
        search.add(lc);


        String gen[]={"Male","Female"};
        JComboBox sex = new JComboBox(gen);
        sex.setBounds(630, 150, 80, 40);
        search.add(sex);


        lc = new JLabel("mobile");
        lc.setBounds(280, 200, 100, 30);
        search.add(lc);

        mobile = new JTextField(20);
        mobile.setBounds(370, 200, 350, 50);
        search.add(mobile);

        lc=new JLabel("course");
        lc.setBounds(280,250,100,30);
        search.add(lc);

        String co[]={"C++","C","Python","Java","C#"};
        course=new JComboBox(co);
        course.setBounds(370,250,350,50);
        search.add(course);

        lc = new JLabel("email");
        lc.setBounds(280, 300, 100, 30);
        search.add(lc);

        JTextField email = new JTextField(20);
        email.setBounds(370, 300, 350, 50);
        search.add(email);








        JButton submit=new JButton("submit");
        submit.setBounds(370,400,100,30);
        search.add(submit);



        submit.addActionListener(new ActionListener() {
                                     @Override
                                     public void actionPerformed(ActionEvent actionEvent) {
                                         String name2 = name.getText();
                                         String sex1=sex.getSelectedItem().toString();
                                         String mobile2 = mobile.getText();
                                         String course2=course.getSelectedItem().toString();
                                         String email2=email.getText();







                                         Connection conn,con1;
                                         PreparedStatement pst,pst1;
                                         if (name2 == null || mobile2 == null|| sex1==null) {
                                             JOptionPane.showMessageDialog(null, "All the field is mandatory and needed to be filled ");
                                         } else {
                                             try {
                                                 Class.forName("org.sqlite.JDBC");
                                                 conn = DriverManager.getConnection("jdbc:sqlite:University.db");
                                                 con1=DriverManager.getConnection("jdbc:sqlite:gpa.db");

                                                 pst = conn.prepareStatement("SELECT * FROM courses where name=? and mobile=? and course=? and email=?");
                                                pst1=con1.prepareStatement("SELECT * FROM grade where name=?");
                                                 pst.setString(1, name2);
                                                 pst.setString(2, mobile2);
                                                 pst.setString(3,course2);
                                                 pst.setString(4,email2);
                                                 pst1.setString(1,name2);

                                                 ResultSet rs = pst.executeQuery();
                                                 ResultSet rs1=pst1.executeQuery();

                                                 if (rs.next()) {
                                                     if(!rs1.next()) {

                                                         search.dispose();
                                                         course_form ce = new course_form(name2, sex1, mobile2,course2,email2);

                                                     }
                                                     else{
                                                         JOptionPane.showMessageDialog(null,"data already existed");
                                                     }


                                                 } else {
                                                     JOptionPane.showMessageDialog(null, "Fault information");
                                                 }
                                             } catch (Exception es) {
                                                 System.out.println(es.getMessage());
                                             }
                                         }

                                     }
                                 });





        goback=new JButton("goback");
        goback.setBounds(270,400,100,30);
        goback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try{
                    search.dispose();
                    hello1 he=new hello1();
                }
                catch (IOException e){
                    throw new RuntimeException(e);
                }
            }
        });
        search.add(goback);




        search.setVisible(true);
        search.setSize(1024,683);
        search.setLocationRelativeTo(null);
        search.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

}

    public JButton getSubmit() {
        return submit;
    }

    public void setSubmit(JButton submit) {
        this.submit = submit;
    }
}


