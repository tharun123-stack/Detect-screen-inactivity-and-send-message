import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.*;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Metrics extends Applet implements WindowListener
{
    
    Button btnSave;
    Label lbltextfield,lbl1;
    TextArea txttextarea;
    Frame fr;


    Metrics()
    {
        
        Font fonttxt = new Font("Calibri", Font.PLAIN, 16);
        Font fontlbl = new Font("Calibri",Font.BOLD, 14);
        Font fontbtn = new Font("Calibri",Font.BOLD, 16);
        Font fontTitle = new Font("Arial ",Font.BOLD,30);
        fr = new Frame("Window events demo . . .");
        fr.setLayout(new FlowLayout());
       fr.setLayout(null);
       fr.setSize(700, 700);
       
       fr.setBackground(Color.cyan);


        lbl1= new Label("You have joined **** Metrics class ****");
        lbl1.setFont(fontbtn);
        lbltextfield = new Label ("Type your answer here");
        lbltextfield.setFont(fontbtn);

        //txttextarea.setVisible(true);
        btnSave = new Button("Save");
        btnSave.setFont(fontbtn);
        
        TextField txttextarea = new TextField ("",100);
        //txttextarea = new TextArea("Type here");
        
        txttextarea.setFont(fonttxt);
        lbl1.setBounds(80,50,350,30);
        lbltextfield.setBounds(100,100,250,30);
        txttextarea.setBounds(130,170,150,30);

        btnSave.setBounds(60,500,150,35);
//        btnCancel.setBounds(200,320,150,35);

        fr.add(lbl1);   
        fr.add(lbltextfield);
       fr.add(txttextarea);
        txttextarea.setSize(450,200);
       fr.add(btnSave);
//       fr.add(btnCancel);
       fr.addWindowListener(this);
        fr.setVisible(true);

        DateFormat dfor = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        java.util.Date obj = new java.util.Date();
        System.out.println(dfor.format(obj));
        


        btnSave.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {

                //Connection con = null;
                //Statement st = null;   1



                if(ae.getSource() == btnSave)
                {


                    try {
                
    //                    Class.forName("com.mysql.jdbc.Driver");
      //                  con = DriverManager.getConnection("jdbc:mysql://localhost/library_system", "root", "password");
                           System.out.println("Reached 1");
                            Connection con = signin.initializeDatabase(); 
                            System.out.println("Reached 2");
   


                       // pstmt = con.prepareStatement ("INSERT INTO book_records VALUES (?, ?, ?, ?, ?, ?, ?)"); 
                       System.out.println("Reached 3");
                       PreparedStatement pstmt = con.prepareStatement("insert into work4 values(?, ?)"); 
                       System.out.println("Reached 4");
                       
                       pstmt.setString(1, txttextarea.getText());

                        pstmt.setString(2, dfor.format(obj));

                           System.out.println("Reached 6");   
                        pstmt.executeUpdate();
                        System.out.println("Reached 7");    
                      //  con.commit();
                        pstmt.close();
                        
                        con.close(); 
                        System.out.println("Reached 8");  
                    }
                    catch(Exception err)
                    {
                        JOptionPane.showMessageDialog(null, "Access Denied: "+err );
                    }
                }

               }
            }
        );
    }

public void windowActivated(WindowEvent ev)
{
    System.out.println("Window is activated now");
    try
    { 
    int a=0;
    DateFormat dfor = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
    Date obj = new Date();
    System.out.println(dfor.format(obj));
    Connection con = signin.initializeDatabase();
    PreparedStatement st = con.prepareStatement("insert into windowevent4  values (?, ?, ?) ");
    //values (0,'Windows-closed','" +dfor.format(obj)+ "' ")
    st.setInt(1, 0);
    st.setString(2, "Windows-Activated");
    st.setString(3, dfor.format(obj));
    st.executeUpdate();
    st.close();
    con.close(); 
    }
    catch(Exception e)
    {
        e.printStackTrace();
        System.out.println(e); 
    }
    
    
}




//implementation of windowClosed method
public void windowClosed(WindowEvent ev)
{
    System.out.println("Now, the window is closed");
    try
    { 
        DateFormat dfor = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Date obj = new Date();
        System.out.println(dfor.format(obj));
        Connection con = signin.initializeDatabase();
        PreparedStatement st = con.prepareStatement("insert into windowevent4  values (?,?,?) ");
        //values (0,'Windows-closed','" +dfor.format(obj)+ "' ")
        st.setInt(1, 0);
        st.setString(2, "Window-Closed");
        st.setString(3, dfor.format(obj));
        st.executeUpdate();
        st.close();
        con.close(); 
    }
    catch(Exception e)
    {
        e.printStackTrace();
        System.out.println(e); 
    }
}




//implementation of windowClosing method
public void windowClosing(WindowEvent ev)
{
//release all the resources
fr.dispose();
    System.out.println("Window is closing now");
    try
    { 
        DateFormat dfor = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Date obj = new Date();
        System.out.println(dfor.format(obj));
        Connection con = signin.initializeDatabase();
        PreparedStatement st = con.prepareStatement("insert into windowevent4  values (?,?,?) ");
        //values (0,'Windows-closed','" +dfor.format(obj)+ "' ")
        st.setInt(1, 0);
        st.setString(2, "Window-Closing");
        st.setString(3, dfor.format(obj));
        st.executeUpdate();
        st.close();
        con.close(); 
    }
    catch(Exception e)
    {
        e.printStackTrace();
        System.out.println(e); 
    }
}






//implementation of windowDeactivated method
public void windowDeactivated(WindowEvent ev)
{
    System.out.println("Window gets Deactivated");
    try
    { 
        DateFormat dfor = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Date obj = new Date();
        System.out.println(dfor.format(obj));
        Connection con = signin.initializeDatabase();
        PreparedStatement st = con.prepareStatement("insert into windowevent4 values (?,?,?) ");
        //values (0,'Windows-closed','" +dfor.format(obj)+ "' ")
        st.setInt(1, 0);
        st.setString(2, "Window-Deactivated");
        st.setString(3, dfor.format(obj));
        st.executeUpdate();
        st.close();
        con.close(); 
    }
    catch(Exception e)
    {
        e.printStackTrace();
        System.out.println(e); 
    }
}







//implementation of windowDeiconified method
public void windowDeiconified(WindowEvent ev)
{
    System.out.println("Window gets Deiconified");
    try
    { 
        DateFormat dfor = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Date obj = new Date();
        System.out.println(dfor.format(obj));
        Connection con = signin.initializeDatabase();
        PreparedStatement st = con.prepareStatement("insert into windowevent4 values (?,?,?) ");
        //values (0,'Windows-closed','" +dfor.format(obj)+ "' ")
        st.setInt(1, 0);
        st.setString(2, "Window-Deiconified");
        st.setString(3, dfor.format(obj));
        st.executeUpdate();
        st.close();
        con.close(); 
    }
    catch(Exception e)
    {
        e.printStackTrace();
        System.out.println(e); 
    }
}






//implementation of windowIconified method
public void windowIconified(WindowEvent ev)
{
    System.out.println("Window gets minimized or iconified");
    try
    { 
        DateFormat dfor = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Date obj = new Date();
        System.out.println(dfor.format(obj));
        Connection con = signin.initializeDatabase();
        PreparedStatement st = con.prepareStatement("insert into windowevent4  values (?,?,?) ");
        //values (0,'Windows-closed','" +dfor.format(obj)+ "' ")
        st.setInt(1, 0);
        st.setString(2, "Window-Iconified");
        st.setString(3, dfor.format(obj));
        st.executeUpdate();
        st.close();
        con.close(); 
    }
    catch(Exception e)
    {
        e.printStackTrace();
        System.out.println(e); 
    }
}







//implementation of windowOpened method
public void windowOpened(WindowEvent e)
{
    System.out.println("The window is opening for the very first time");
    try
    { 
        DateFormat dfor = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Date obj = new Date();
        System.out.println(dfor.format(obj));
        Connection con = signin.initializeDatabase();
        PreparedStatement st = con.prepareStatement("insert into windowevent4  values (?,?,?) ");
        //values (0,'Windows-closed','" +dfor.format(obj)+ "' ")
        st.setInt(1, 0);
        st.setString(2, "Window-Opened");
        st.setString(3, dfor.format(obj));
        st.executeUpdate();
        st.close();
        con.close(); 
    }
    catch(Exception ee)
    {
        ee.printStackTrace();
        System.out.println(e); 
    }
}


public static void main(String... ar)
{
    new Metrics();
}
}