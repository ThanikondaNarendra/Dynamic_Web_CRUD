package crudOperations;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RetriveServlet
 */
@WebServlet("/RetriveServlet")
public class RetriveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RetriveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
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
				PreparedStatement ps=con.prepareStatement("select * from products");
				ResultSet rs=ps.executeQuery();
			)
		{	
			response.setContentType("text/html");
			PrintWriter pw=response.getWriter();
			while(rs.next()) {
				pw.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getDouble(3));
			}
			pw.println("rows retrived");
			pw.println("<a href='Index.html'>back</a>");
		}
		catch(Exception e) {
			//s.printStackTrace();
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
