package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;

public final class Linux_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

 String a1;
            
  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Linux class</title>\n");
      out.write("                <style>\n");
      out.write(".button1 {\n");
      out.write("                    background-color: #4CAF50; /* Green */\n");
      out.write("                    border: none;\n");
      out.write("                    color: white;\n");
      out.write("                    padding: 10px 32px;\n");
      out.write("                    text-align: center;\n");
      out.write("                    text-decoration: none;\n");
      out.write("                    display: inline-block;\n");
      out.write("                    font-size: 16px;\n");
      out.write("                    margin: 10px 0px 0px 20px;\n");
      out.write("                    border-radius: 6px;\n");
      out.write("                    }\n");
      out.write("                    .button1:hover{\n");
      out.write("                          background-color: yellow;\n");
      out.write("                            color:black;\n");
      out.write("                        \n");
      out.write("                    }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("    <center>\n");
      out.write("        <h2>LINUX</H2>\n");
      out.write("        <h2><u>Student log activity:</u></h2>\n");
      out.write("        \n");
      out.write("            \n");
      out.write("            \n");
      out.write("            \n");
      out.write("            \n");
      out.write("            ");
      out.write("\n");
      out.write("            <b> Student: </b> \n");
      out.write("            ");

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
                

            
      out.write("\n");
      out.write("            \n");
      out.write("            <br/><br/>\n");
      out.write("            <u><H2> Log Status: </H2></u><br/>\n");
      out.write("            \n");
      out.write("            ");

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
            String query2 = "SELECT action,time FROM windowevent2 where status2=0;";
            
            //SELECT * FROM windowevent1 ORDER BY action1,time LIMIT 20;
            //out.println(st.getString("name"));
            
            ResultSet rs2 = st2.executeQuery(query2);
            int i=0;
            
            for (i=0;i<15;i++)
            {
            if (rs2.next())
            {
                out.println(rs2.getString("action")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Time:"+rs2.getString("time"));
                
            
      out.write("<br/>");
    
                
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
            
      out.write("  \n");
      out.write("            \n");
      out.write("            ");

                try
                {
                                 
                    Statement st = con.createStatement();
                    String query1 = "delete from windowevent2";
                    int rs1 = st.executeUpdate(query1);
                    st.close(); 
                    
                
                }
                     
                catch (Exception e) 
                { 
                    e.printStackTrace();
                    out.println(e);
                }
                
            
      out.write("\n");
      out.write("                \n");
      out.write("\n");
      out.write("            ");

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
            
      out.write("\n");
      out.write("            \n");
      out.write("            \n");
      out.write("                        <h2> The work done by Student:</h2>\n");
      out.write("            ");

                

            Statement stm = con.createStatement();
            String query = "SELECT * FROM work3";

           
            ResultSet rs = stm.executeQuery(query);
            
            for (int i=0;i<15;i++)
            {
            if (rs.next())
            {
                out.println(rs.getString("textarea")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Time:"+rs.getString("date&time"));
                
            
      out.write("<br/>");
    
                
            }
            
            else
            {
                out.println("No Data Found");
                break;
            }
            }
            
            // Close all the connections 
            stm.close(); 
            
      out.write("\n");
      out.write("            \n");
      out.write("            \n");
      out.write("           ");
  try
                {
                                 
                    Statement st = con.createStatement();
                    String query2 = "DELETE FROM work3";
                    
                    int res2 = st.executeUpdate(query2);
                    st.close(); 
                    
                
                }
                     
                catch (Exception e) 
                { 
                    e.printStackTrace();
                    out.println(e);
                }
             
      out.write("\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            \n");
      out.write("            <h2> Remarks !!!! </h2>\n");
      out.write("            <form action=\"Linux.jsp\">\n");
      out.write("            <textarea name=\"comment\" rows=\"7\" cols=\"50\" placeholder=\"Please comment about the student .... \"></textarea> <br/><br/>\n");
      out.write("            <input class=\"button1\" type=\"submit\" value=\"Submit\">\n");
      out.write("            </form>\n");
      out.write("            ");

                try { 
                    
                    
                    String s1 = request.getParameter("comment");
                    String s0 = "Linux";
                    
                    PreparedStatement st = con.prepareStatement("insert into linux values(?, ? ,?)"); 
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
                
      out.write("\n");
      out.write("    \n");
      out.write("    \n");
      out.write("    </CENTER>\n");
      out.write("            \n");
      out.write("            \n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
