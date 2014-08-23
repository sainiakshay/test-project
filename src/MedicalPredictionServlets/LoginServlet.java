package MedicalPredictionServlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.MedicalPredictionDAO;

import TransferObjects.UserTO;

import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String pwd = request.getParameter("password");
		
		UserTO user = new UserTO();
		user.setEmail(email);
		user.setPassword(pwd);
		
		MedicalPredictionDAO dao = new MedicalPredictionDAO();
		boolean isSuccess = dao.insertLoginDetails(user);
		
		/*Connection conn = DatabaseConn.getConnection();
		Statement stmt = null;
		String userName = null;
		
		System.out.println(email);
		System.out.println(pwd);
		try {
			stmt = (Statement) conn.createStatement();
			String sql;
			sql = "SELECT email from login where email='" + email
					+ "' and password = '" + pwd + "';";
			ResultSet rs = (ResultSet) stmt.executeQuery(sql);

			while (rs.next()) {
				userName = rs.getString("user_name");
				System.out.println("userN::" + userName);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (userName != "" && userName != null) {
			request.setAttribute("userName", userName);
			request.getRequestDispatcher("/main.jsp")
					.forward(request, response);
		} else {
			request.setAttribute("errorMsg", "Invalid Credential.");
			request.getRequestDispatcher("/login.jsp")
					.forward(request, response);
		}*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String pwd = request.getParameter("password");
		
		UserTO user = new UserTO();
		user.setEmail(email);
		user.setPassword(pwd);
		
		MedicalPredictionDAO dao = new MedicalPredictionDAO();
		
		String userName = dao.checkUserLogin(user);
		
		if (userName != "" && userName != null) {
			request.setAttribute("userName", userName);
			request.getRequestDispatcher("/main.jsp")
					.forward(request, response);
		} else {
			request.setAttribute("errorMsg", "Invalid Credential.");
			request.getRequestDispatcher("/login.jsp")
					.forward(request, response);
		}
	}

}
