package MedicalPredictionServlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.MedicalPredictionDAO;
import TransferObjects.UserTO;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/register.jsp")
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("welcome to registration");
		String email = request.getParameter("email");
		String pwd = request.getParameter("password");
		
		UserTO user = new UserTO();
		user.setEmail(email);
		user.setPassword(pwd);
		
		MedicalPredictionDAO dao = new MedicalPredictionDAO();
		boolean isRegistration = dao.insertLoginDetails(user);
		
		if (isRegistration) {
			request.setAttribute("message", "Registration successful!!");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		} else {
			request.setAttribute("errorMsg", "Registration unsuccessful!!");
			request.getRequestDispatcher("/register.jsp")
					.forward(request, response);
		}
		Mail mail = new Mail(email, "Registration","Hi,\nThanks for registering with Smart Healthcare."
				+ "Your username is " +email+"\n\n Please click here to login & use Smart Healthcare\n www.smarthealthcare.com/login \n"
				+"\nRegards,\n"+"SmartHealthcare Team");
}
}


