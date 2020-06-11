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

public class update {
    JFrame update = new JFrame("Student's academic");
    JLabel ld;
    JButton goback, se,show;
    JTextField updates;



        update() throws IOException {
            update.setLayout(null);
            update.setResizable(false);

            BufferedImage bf = ImageIO.read(new File("/Users/deth/Desktop/hello.jpeg"));

            update.setContentPane(new backImage(bf));


            ld=new JLabel("Name-search");
            ld.setBounds(280,20,100,30);
            update.add(ld);

            updates =new JTextField(20);
            updates.setBounds(380,20,170,30);
            update.add(updates);

            se=new JButton("Search");
            se.setBounds(580,20,120,30);
            update.add(se);
            se.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    String sname = updates.getText();
                    int c;
                    Connection con1;
                    PreparedStatement insert;
                    JTable ta=new JTable(20,11);
                    ta.setBounds(110,90,790,500);
                    update.add(ta);
                    {
                        try {
                            Class.forName("org.sqlite.JDBC");
                            con1 = DriverManager.getConnection("jdbc:sqlite:gpa.db");
                            insert = con1.prepareStatement("SELECT * FROM grade where name=\"" + sname + "\" ");
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
                                    v2.add(rs.getString("email"));
                                    v2.add(rs.getString("mobile"));
                                    v2.add(rs.getString("course"));
                                    v2.add(rs.getString("assignment"));
                                    v2.add(rs.getString("project"));
                                    v2.add(rs.getString("midexam"));
                                    v2.add(rs.getString("finalexam"));
                                    v2.add(rs.getString("grades"));
                                }
                                df.addRow(v2);
                            }
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }


                }
            });


            ld=new JLabel("id");
            ld.setBounds(110,50,100,30);
            update.add(ld);

            ld=new JLabel("name");
            ld.setBounds(180,50,100,30);
            update.add(ld);

            ld=new JLabel("sex");
            ld.setBounds(250,50,100,30);
            update.add(ld);

            ld=new JLabel("email");
            ld.setBounds(310,50,100,30);
            update.add(ld);

            ld=new JLabel("mobile");
            ld.setBounds(400,50,100,30);
            update.add(ld);

            ld=new JLabel("course");
            ld.setBounds(460,50,100,30);
            update.add(ld);

            ld=new JLabel("assignment");
            ld.setBounds(530,50,100,30);
            update.add(ld);

            ld=new JLabel("project");
            ld.setBounds(610,50,100,30);
            update.add(ld);

            ld=new JLabel("midexam");
            ld.setBounds(670,50,100,30);
            update.add(ld);

            ld=new JLabel("finalexam");
            ld.setBounds(740,50,100,30);
            update.add(ld);

            ld=new JLabel("grades");
            ld.setBounds(830,50,100,30);
            update.add(ld);

            int c;
            Connection conn;
            PreparedStatement pst;
            JTable ta = new JTable(20, 11);
           ta.setBounds(110, 90, 790, 500);
           JScrollPane sc=new JScrollPane(ta);
           sc.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
           sc.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
           update.getContentPane().add(sc);
            update.add(ta);
            try{
                Class.forName("org.sqlite.JDBC");
                conn=DriverManager.getConnection("jdbc:sqlite:gpa.db");
                pst=conn.prepareStatement("SELECT * FROM grade");
                ResultSet rs=pst.executeQuery();
                ResultSetMetaData rss = rs.getMetaData();
                c = rss.getColumnCount();
                DefaultTableModel df = (DefaultTableModel) ta.getModel();
                df.setRowCount(0);

                while (rs.next()) {
                    Vector v = new Vector();
                    for (int i = 1; i <= c; i++) {
                        v.add(rs.getString("id"));
                        v.add(rs.getString("name"));
                        v.add(rs.getString("sex"));
                        v.add(rs.getString("email"));
                        v.add(rs.getString("mobile"));
                        v.add(rs.getString("course"));
                        v.add(rs.getString("assignment"));
                        v.add(rs.getString("project"));
                        v.add(rs.getString("midexam"));
                        v.add(rs.getString("finalexam"));
                        v.add(rs.getString("grades"));
                    }
                    df.addRow(v);
                }


            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }





//

            JButton save=new JButton("Save");
            save.setBounds(500,600,100,30);
            update.add(save);
            save.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    Connection con3;
                    PreparedStatement pst3;
                    try{
                        Class.forName("org.sqlite.JDBC");
                        con3=DriverManager.getConnection("jdbc:sqlite:gpa.db");
                        DefaultTableModel df=(DefaultTableModel)ta.getModel();
                        int index=ta.getSelectedRow();
                        String name=df.getValueAt(index,1).toString();
                        String gender=df.getValueAt(index,2).toString();
                        String email=df.getValueAt(index,3).toString();
                        String mobile=df.getValueAt(index,4).toString();
                        String course=df.getValueAt(index,5).toString();
                        String assign=df.getValueAt(index,6).toString();
                        String pro=df.getValueAt(index,7).toString();
                        String mid=df.getValueAt(index,8).toString();
                        String fin=df.getValueAt(index,9).toString();
                        String gra=df.getValueAt(index,10).toString();

                        String value=(ta.getModel().getValueAt(index,0)).toString();
                        String query="UPDATE grade SET name=?,sex=?,email=?,mobile=?,course=?,assignment=?,project=?,midexam=?,finalexam=?,grades=? WHERE id= "+value;
                        pst3=con3.prepareStatement(query);
                        pst3.setString(1,name);
                        pst3.setString(2,gender);
                        pst3.setString(3,email);
                        pst3.setString(4,mobile);
                        pst3.setString(5,course);
                        pst3.setString(6,assign);
                        pst3.setString(7,pro);
                        pst3.setString(8,mid);
                        pst3.setString(9,fin);
                        pst3.setString(10,gra);
                        pst3.executeUpdate();
                        JOptionPane.showMessageDialog(null,"Save Successfully");
                    }
                    catch(Exception e){
                        JOptionPane.showMessageDialog(null,"Select a data to modify and save");
                    }
                    }


            });



            JButton delete=new JButton("Delete");
            delete.setBounds(400,600,100,30);
            update.add(delete);
            delete.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {

                    int row=ta.getSelectedRow();
                    String cell=ta.getModel().getValueAt(row,0).toString();
                    String sql="DELETE FROM grade WHERE id= "+cell;
                    Connection con2=null;
                    PreparedStatement pst2=null;
                    try{
                        Class.forName("org.sqlite.JDBC");
                        con2=DriverManager.getConnection("jdbc:sqlite:gpa.db");
                        pst2=con2.prepareStatement(sql);
                        pst2.executeUpdate();
                        JOptionPane.showMessageDialog(null,"DELETED SUCCESSFULLY");
                    }
                    catch(Exception e){
                        JOptionPane.showMessageDialog(null,e);
                    }
                    finally {
                        try{
                            pst2.close();
                            con2.close();
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
                            JOptionPane.showMessageDialog(null,"Select the row to delete");
                        }
                    }
                }
            });



            show=new JButton("show_all data");
            show.setBounds(250,600,150,30);
            update.add(show);

            show.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    int c;
                    Connection con1;
                    PreparedStatement insert;
                    JTable ta=new JTable(20,11);
                    ta.setBounds(110,90,790,500);
                    update.add(ta);


                    try{
                        Class.forName("org.sqlite.JDBC");
                        con1= DriverManager.getConnection("jdbc:sqlite:gpa.db");
                        insert=con1.prepareStatement("SELECT * FROM grade ");
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
                                v2.add(rs.getString("email"));
                                v2.add(rs.getString("mobile"));
                                v2.add(rs.getString("course"));
                                v2.add(rs.getString("assignment"));
                                v2.add(rs.getString("project"));
                                v2.add(rs.getString("midexam"));
                                v2.add(rs.getString("finalexam"));
                                v2.add(rs.getString("grades"));
                            }
                            df.addRow(v2);
                        }
                    }
                    catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                }
            });




            goback = new JButton("goback");
            goback.setBounds(110, 600, 100, 30);
            goback.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    try {
                        update.dispose();
                        hello1 he = new hello1();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            });

            update.add(goback);

            update.setVisible(true);
            update.setSize(1024, 683);
            update.setLocationRelativeTo(null);
            update.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        }
    }

