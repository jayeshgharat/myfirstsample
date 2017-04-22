package mypack;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.SQLException;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationServlet
 */
//@WebServlet("/RegistrationServlet")   //use xml instead of annotation
public class RegistrationServlet extends HttpServlet {
	static Connection con;
	static PreparedStatement pst;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		//write here
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String fullname=request.getParameter("fullname");
		String gender=request.getParameter("gender");
		String email=request.getParameter("email");
		long phoneno=Long.parseLong(request.getParameter("phoneno"));
		String batch=request.getParameter("batch");
		
		try{
			String str="insert into registration values(?,?,?,?,?,?,?)";
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jack413","root","root");
			pst=con.prepareStatement(str);
			pst.setString(1, username);
			pst.setString(2, password);
			pst.setString(3, fullname);
			pst.setString(4, gender);
			pst.setString(5, email);
			pst.setLong(6, phoneno);
			pst.setString(7, batch);
			pst.executeUpdate();

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		//till here
		
		
	}

}
