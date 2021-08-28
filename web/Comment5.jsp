<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <center><h2><u>Soft Skills:</u></h2><br/>
                <table border="1" cellpadding="15" cellspacing="0">
                    <tr>
                        <th> Name: </th>
                        <th> Class: </th>
                        <th> Comments: </th>
                    </tr>
                    
                    <%@page import="java.sql.DriverManager"%>
                    <%@page import="java.sql.ResultSet"%>
                    <%@page import="java.sql.Statement"%>
                    <%@page import="java.sql.Connection"%>
                    <%@page import="java.sql.PreparedStatement"%>
                    <%! String a1;
                                    %>
                    
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
                       
                            Statement st = con.createStatement();
                            String query = "SELECT name from studentdetails2 where status=0";
                            ResultSet rs = st.executeQuery(query);
                                   
                            if (rs.next())
                            {
                                a1 = rs.getString("name");
                            }
                            
                            String query2 = "SELECT * FROM softskills where name = '" + a1 + "' ";
                            ResultSet rs2 = st.executeQuery(query2);
                            int i=0;
                            for (i=0;i<15;i++)
                            {
                                %>
                                <tr>
                            <%        
                            if (rs2.next())
                            {
                                %>
                                <td>
                                    <% out.println(rs2.getString("name")+"."); %>
                                </td>
                                <td>
                                    <% out.println(rs2.getString("class")+"."); %>
                                </td>
                                <td>
                                    <% out.println(rs2.getString("comment")+"."); %>
                                </td>
                                <%
                            }
                            %>
                                </tr>
                                <%
                            }
                            
                            }
                            catch (ClassNotFoundException e) 
                            {
                                e.printStackTrace();
                            }
                            %>
                </table>
            
            
        
        
        
        
        
    </body>
</html>
