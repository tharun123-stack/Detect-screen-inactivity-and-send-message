import java.io.IOException; 
import java.io.PrintWriter; 
import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.Statement; 
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException; 
import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 



@WebServlet("/InsertData") 

public class fLogin extends HttpServlet {

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter out = response.getWriter();
        try { 
            
            response.setContentType("text/html;charset=UTF-8");
            
           
            String s1 = request.getParameter("user1");
            String s2 = request.getParameter("pass1");
            
            
            Connection con = signin.initializeDatabase(); 
            Statement st = con.createStatement();
            
            
            String query = "SELECT * FROM facultydetails WHERE user = '" +s1+"' && passwd = '" +s2+ "'";
           
            ResultSet rs = st.executeQuery(query);
                 
            switch(s1)  
            {
                case "181066":
                {
                        if (rs.next())
                        {         
                            String location = "Facultyportal.html";
                            response.sendRedirect(location);
                        }
                        else
                        {
                            out.println("<html><body><b>Invalid login!!!   not found"+ "</b></body></html>"); 
                        }
                        st.close(); 
                        con.close(); 
                }
                
                case "181067":
                {
                        if (rs.next())
                        {         
                            String location = "Facultyportal2.html";
                            response.sendRedirect(location);
                        }
                        else
                        {
                            out.println("<html><body><b>Invalid login!!!   not found"+ "</b></body></html>"); 
                        }
                        st.close(); 
                        con.close(); 
                }
                case "181044":
                {
                        if (rs.next())
                        {         
                            String location = "Facultyportal3.html";
                            response.sendRedirect(location);
                        }
                        else
                        {
                            out.println("<html><body><b>Invalid login!!!   not found"+ "</b></body></html>"); 
                        }
                        st.close(); 
                        con.close(); 
                }
                case "181060":
                {
                        if (rs.next())
                        {         
                            String location = "Facultyportal4.html";
                            response.sendRedirect(location);
                        }
                        else
                        {
                            out.println("<html><body><b>Invalid login!!!   not found"+ "</b></body></html>"); 
                        }
                        st.close(); 
                        con.close(); 
                }
                case "181080":
                {
                        if (rs.next())
                        {         
                            String location = "Facultyportal5.html";
                            response.sendRedirect(location);
                        }
                        else
                        {
                            out.println("<html><body><b>Invalid login!!!   not found"+ "</b></body></html>"); 
                        }
                        st.close(); 
                        con.close(); 
                }
                default :
                {
                    out.println("<html><body><b>Invalid login!!!   not found"+ "</b></body></html>"); 
                }
            }
        } 
       
        catch (Exception e) { 
            e.printStackTrace();
            out.println(e);
        
    }



}


}


