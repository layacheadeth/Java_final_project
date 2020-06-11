package form;

import org.w3c.dom.CDATASection;

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
import java.util.ArrayList;
import java.util.Vector;


public class output  {
    JFrame output = new JFrame("Student's general data");
    JButton goback,show;
    JLabel la;
    JLabel lc;
    JButton se;
    JTextField searches;

    output() throws IOException {
        output.setLayout(null);
        output.setResizable(false);

        BufferedImage bf = ImageIO.read(new File("/Users/deth/Desktop/hello.jpeg"));

        output.setContentPane(new backImage(bf));

        la=new JLabel("Id");
        la.setBounds(110,60,100,30);
        output.add(la);

        la=new JLabel("Name");
        la.setBounds(235,60,100,30);
        output.add(la);

        la=new JLabel("Gender");
        la.setBounds(360,60,100,30);
        output.add(la);

        la=new JLabel("Mobile");
        la.setBounds(500,60,100,30);
        output.add(la);

        la=new JLabel("Course");
        la.setBounds(650,60,100,30);
        output.add(la);

        la=new JLabel("Email");
        la.setBounds(780,60,100,30);
        output.add(la);

        lc=new JLabel("Name-search");
        lc.setBounds(280,20,100,30);
        output.add(lc);

        searches=new JTextField(20);
        searches.setBounds(380,20,170,30);
        output.add(searches);

        int c;
        Connection con1=null;
        PreparedStatement insert=null;
        JTable ta=new JTable(50,6);
        ta.setBounds(110,90,790,500);
        JScrollPane sc=new JScrollPane(ta);
        sc.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        sc.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        output.getContentPane().add(sc);
        output.add(ta);


        try{
            Class.forName("org.sqlite.JDBC");
            con1= DriverManager.getConnection("jdbc:sqlite:University.db");
            insert=con1.prepareStatement("SELECT * FROM courses ");
            ResultSet rs=insert.executeQuery();
            ResultSetMetaData rss=rs.getMetaData();
            c=rss.getColumnCount();

            DefaultTableModel df=(DefaultTableModel)ta.getModel();
            df.setRowCount(0);

            while(rs.next()){
                Vector v2=new Vector();
                for(int i=1;i<=c;i++){
                    v2.add(rs.getString("id"));
                    v2.add(rs.getString("name"));
                    v2.add(rs.getString("sex"));
                    v2.add(rs.getString("mobile"));
                    v2.add(rs.getString("course"));
                    v2.add(rs.getString("email"));
                }
                df.addRow(v2);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            try{
                con1.close();
               insert.close();
            }
            catch (Exception e){

            }
        }


        se=new JButton("Search");
        se.setBounds(580,20,120,30);
        output.add(se);
        se.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String sname = searches.getText();
                int c;
                Connection con1;
                PreparedStatement insert;
                JTable ta=new JTable(50,6);
                ta.setBounds(110,90,790,500);
                output.add(ta);
                {
                    try {
                        Class.forName("org.sqlite.JDBC");
                        con1 = DriverManager.getConnection("jdbc:sqlite:University.db");
                        insert = con1.prepareStatement("SELECT * FROM courses where name=\"" + sname + "\" ");
                        ResultSet rs = insert.executeQuery();
                        ResultSetMetaData rss = rs.getMetaData();
                        c = rss.getColumnCount();

                        DefaultTableModel df = (DefaultTableModel) ta.getModel();
                        df.setRowCount(0);

                        while (rs.next()) {
                            Vector v2 = new Vector();
                            for (int i = 1; i <= c; i++) {
                                v2.add(rs.getString("id"));
                                v2.add(rs.getString("name"));
                                v2.add(rs.getString("sex"));
                                v2.add(rs.getString("mobile"));
                                v2.add(rs.getString("course"));
                                v2.add(rs.getString("email"));
                            }
                            df.addRow(v2);
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }


            }
        });














        goback =new JButton("goback");
        goback.setBounds(110,630,100,30);
        output.add(goback);

        ActionListener al=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try{
                    output.dispose();
                    hello1 he=new hello1();
                }
                catch(IOException e){
                    throw new RuntimeException(e);
                }
            }
        };
        goback.addActionListener(al);


        JButton save=new JButton("Save");
        save.setBounds(500,630,100,30);
        output.add(save);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Connection con3;
                PreparedStatement pst3;
                try{
                    Class.forName("org.sqlite.JDBC");
                    con3=DriverManager.getConnection("jdbc:sqlite:University.db");
                    DefaultTableModel df=(DefaultTableModel)ta.getModel();
                    int index=ta.getSelectedRow();
                    String name=df.getValueAt(index,1).toString();
                    String gender=df.getValueAt(index,2).toString();
                    String mobile=df.getValueAt(index,3).toString();
                    String course=df.getValueAt(index,4).toString();
                    String email=df.getValueAt(index,5).toString();


                    String value=(ta.getModel().getValueAt(index,0)).toString();
                    String query="UPDATE courses SET name=?,sex=?,mobile=?,course=?,email=? WHERE id= "+value;
                    pst3=con3.prepareStatement(query);
                    pst3.setString(1,name);
                    pst3.setString(2,gender);
                    pst3.setString(3,mobile);
                    pst3.setString(4,course);
                    pst3.setString(5,email);
                    pst3.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Save Successfully");
                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(null,"Select a data to modify and save");
                }
            }



        });



        JButton delete=new JButton("Delete");
        delete.setBounds(400,630,100,30);
        output.add(delete);
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                Connection con2=null;
                PreparedStatement pst2=null;


               int row=ta.getSelectedRow();
               String cell=ta.getModel().getValueAt(row,0).toString();
               String sql="DELETE FROM courses WHERE id= "+cell;


               try{
                   Class.forName("org.sqlite.JDBC");
                   con2=DriverManager.getConnection("jdbc:sqlite:University.db");
                   pst2=con2.prepareStatement(sql);
                   pst2.executeUpdate();
                   JOptionPane.showMessageDialog(null,"Deleted successfully");
               }
               catch(Exception e){
                   JOptionPane.showMessageDialog(null,e);
               }
               finally {
                   try {
                       con2.close();
                       pst2.close();
                   }
                   catch (Exception e){

                   }
               }

                DefaultTableModel df=(DefaultTableModel)ta.getModel();

                if(ta.getSelectedRowCount()==1){
                    df.removeRow(ta.getSelectedRow());
                }
                else{
                    if(ta.getSelectedRowCount()==0){
                        JOptionPane.showMessageDialog(null,"This table is empty");
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Select row to delete");
                    }
                }


            }
        });

         show=new JButton("show_all data");
        show.setBounds(250,630,150,30);
        output.add(show);

        show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int c;
                Connection con1=null;
                PreparedStatement insert=null;
                JTable ta=new JTable(50,6);
                ta.setBounds(110,90,790,500);
                output.add(ta);


                try{
                    Class.forName("org.sqlite.JDBC");
                    con1= DriverManager.getConnection("jdbc:sqlite:University.db");
                    insert=con1.prepareStatement("SELECT * FROM courses ");
                    ResultSet rs=insert.executeQuery();
                    ResultSetMetaData rss=rs.getMetaData();
                    c=rss.getColumnCount();

                    DefaultTableModel df=(DefaultTableModel)ta.getModel();
                    df.setRowCount(0);

                    while(rs.next()){
                        Vector v2=new Vector();
                        for(int i=1;i<=c;i++){
                            v2.add(rs.getString("id"));
                            v2.add(rs.getString("name"));
                            v2.add(rs.getString("sex"));
                            v2.add(rs.getString("mobile"));
                            v2.add(rs.getString("course"));
                            v2.add(rs.getString("email"));
                        }
                        df.addRow(v2);
                    }
                }
                catch(Exception e){
                    System.out.println(e.getMessage());
                }
                finally {
                    try{
                        insert.close();
                        con1.close();
                    }
                    catch (Exception e){

                    }
                }
            }
        });




        output.setVisible(true);
        output.setSize(1024,683);
        output.setLocationRelativeTo(null);
        output.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


}



