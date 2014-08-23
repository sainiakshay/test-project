package MedicalPredictionServlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import RPackage.CommandLineCall;
import TransferObjects.SpecificationsTO;

import com.google.gson.Gson;

/**
 * Servlet implementation class DrawGaugeChartServlet
 */
@WebServlet("/DrawGaugeChartServlet")
public class DrawGaugeChartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DrawGaugeChartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String specifications = request.getParameter("specifications");
		Gson gson = new Gson();
		SpecificationsTO specificationsTO = gson.fromJson(specifications, SpecificationsTO.class);

		CommandLineCall comm = new CommandLineCall();
		double severity = comm.produceCancerSeverity(specificationsTO);
		
		String specificationsJson = gson.toJson(severity);
		response.getWriter().write(specificationsJson);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
