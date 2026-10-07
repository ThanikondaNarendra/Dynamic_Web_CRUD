package crudOperations;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsertServlet
 */
@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
				ServletContext context=request.getServletContext();
				//String driver=;"driver"
				String url=context.getInitParameter("url");
				String user=context.getInitParameter("user");
				String password=context.getInitParameter("password");
					try {
						Class.forName(context.getInitParameter("driver"));
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		
		try(
				
				Connection con=DriverManager.getConnection(url,user,password);
				PreparedStatement ps=con.prepareStatement("insert into products values(?,?,?)");	
			)
		{	
			response.setContentType("text/html");
			int pid=Integer.parseInt(request.getParameter("pid"));
			String pname=request.getParameter("pname");
			double price=Double.parseDouble(request.getParameter("price"));
			ps.setInt(1,pid);
			ps.setString(2, pname);
			ps.setDouble(3,price);
			ps.executeUpdate();
			PrintWriter pw=response.getWriter();
			pw.println("row Inserted");
			pw.println("<a href='Index.html'>back</a>");
		}
		catch(Exception e) {
			//s.printStackTrace();
			e.printStackTrace();
		}
		
	}

}
