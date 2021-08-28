<%@page import="java.sql.PreparedStatement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Metrics class</title>
                <style>
.button1 {
                    background-color: red; /* Green */
                    border: none;
                    color: white;
                    padding: 10px 32px;
                    text-align: center;
                    text-decoration: none;
                    display: inline-block;
                    font-size: 16px;
                    margin: 10px 0px 0px 20px;
                    border-radius: 6px;
                    }
                    .button1:hover{
                          background-color: yellow;
                            color:black;
                        
                    }
        </style>
    </head>
    <body>
    <CENTER>
        <h2>METRICS</H2>
        <h2><u>Student log activity:</u></h2>
        
            <%@page import="java.sql.DriverManager"%>
            <%@page import="java.sql.ResultSet"%>
            <%@page import="java.sql.Statement"%>
            <%@page import="java.sql.Connection"%>
            <%! String a1;
            %>
            <b> Student: </b> 
            <%
                String id = request.getParameter("b1");
                String dbDriver = "com.mysql.jdbc.Driver"; 
                String dbURL = "jdbc:mysql:// localhost:3306/"; 
                String dbName = "userdata"; 
                String disableSSL="?useSSL=false&allowPublicKeyRetrieval=true";
                String dbUsername = "root"; 
                String dbPassword = "tharunraj"; 
                Class.forName(dbDriver); 
                Connection con = DriverManager.getConnection(dbURL + dbName + disableSSL, dbUsername, dbPassword); 

                try {
                Class.forName(dbDriver);
                PreparedStatement st = con.prepareStatement("SELECT name from studentdetails2 where status=0");
                
                Statement st1 = con.createStatement();
                String query = "SELECT * from studentdetails2 where status=0";
                ResultSet rs = st.executeQuery(query);
                if (rs.next())
                {
                out.println(rs.getString("name")+".");
                a1 = rs.getString("name");
                }
                }
                catch (ClassNotFoundException e) 
                {
                    e.printStackTrace();
                }
                

            %>
            
            <br/><br/>
            <u><h2> Log Status: </h2></u><br/>
            
            <%
            /*String id = request.getParameter("b1");
            String dbDriver = "com.mysql.jdbc.Driver"; 
            String dbURL = "jdbc:mysql:// localhost:3306/"; 
            String dbName = "userdata"; 
            String disableSSL="?useSSL=false&allowPublicKeyRetrieval=true";
            String dbUsername = "root"; 
            String dbPassword = "Akhilarrv@123"; 
            Class.forName(dbDriver); 
            Connection con = DriverManager.getConnection(dbURL + dbName + disableSSL, dbUsername, dbPassword); */
            
            try {
            Class.forName(dbDriver);
            
            Statement st2 = con.createStatement();
            String query2 = "SELECT action,time FROM windowevent4 where status4=0;";
            
            //SELECT * FROM windowevent1 ORDER BY action1,time LIMIT 20;
            //out.println(st.getString("name"));
            
            ResultSet rs2 = st2.executeQuery(query2);
            int i=0;
            
            for (i=0;i<15;i++)
            {
            if (rs2.next())
            {
                out.println(rs2.getString("action")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Time:"+rs2.getString("time"));
                
            %><br/><%    
                
            }
            
            else
            {
                out.println("No Data Found");
                break;
            }
            }
            } 
            catch (ClassNotFoundException e) 
            {
            e.printStackTrace();
            }
            %>  
            
            <%
                try
                {
                                 
                    Statement st = con.createStatement();
                    String query1 = "delete from windowevent4";
                    int rs1 = st.executeUpdate(query1);
                    st.close(); 
                    
                
                }
                     
                catch (Exception e) 
                { 
                    e.printStackTrace();
                    out.println(e);
                }
                
            %>
                

            <%
                try
                {
                
                    int s4 = 1;
                    Statement st4 = con.createStatement();
                    String query1 = "update studentdetails2 set status = '" +s4+ "' where name = '" +a1+ "' ";
                    int rs1 = st4.executeUpdate(query1);
                    st4.close(); 
                    
                
                }
                     
                catch (Exception e) 
                { 
                    e.printStackTrace();
                    out.println(e);
                }
            %>
            
            
            
            
                        <h2><u> The work done by Student:</U></h2>
            <%
                

            Statement stm = con.createStatement();
            String query = "SELECT * FROM work4";

           
            ResultSet rs = stm.executeQuery(query);
            
            for (int i=0;i<15;i++)
            {
            if (rs.next())
            {
                out.println(rs.getString("textarea")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Time:"+rs.getString("date&time"));
                
            %><br/><%    
                
            }
            
            else
            {
                out.println("No Data Found");
                break;
            }
            }
            
            // Close all the connections 
            stm.close(); 
            %>
            
            
           <%  try
                {
                                 
                    Statement st = con.createStatement();
                    String query2 = "DELETE FROM work4";
                    
                    int res2 = st.executeUpdate(query2);
                    st.close(); 
                    
                
                }
                     
                catch (Exception e) 
                { 
                    e.printStackTrace();
                    out.println(e);
                }
             %>
            
            
            <h2> Remarks !!!! </h2>
            <form action="Metrics.jsp">
            <textarea name="comment" rows="7" cols="50" placeholder="Please comment about the student .... "></textarea> <br/><br/>
            <input class="button1" type="submit" value="Submit">
            </form>
            <%
                try { 
                    
                    
                    String s1 = request.getParameter("comment");
                    String s0 = "Software_Metrics";
                    
                    PreparedStatement st = con.prepareStatement("insert into metrics values(?, ? ,?)"); 
                    st.setString(1, a1);
                    st.setString(2, s0);
                    st.setString(3, s1);
                    st.executeUpdate();
                    st.close();

                }
                
                catch (Exception e) { 
                    e.printStackTrace();
                    System.out.println(e);
                } 
                %>
    
    </CENTER>
    </body>
</html>
