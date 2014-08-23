package MedicalPredictionServlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import RPackage.CommandLineCall;
import TransferObjects.CategoriesTO;

import com.google.gson.Gson;

/**
 * Servlet implementation class DisplayAllCatsDeathsServlet
 */
@WebServlet("/DisplayAllCatsDeathsServlet")
public class DisplayAllCatsDeathsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayAllCatsDeathsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//CategoriesTO returnCategories = null;
		String categories = request.getParameter("categories");
		Gson gson = new Gson();
		CategoriesTO categoriesTO = gson.fromJson(categories, CategoriesTO.class);

		CommandLineCall comm = new CommandLineCall();
		double numberOfDeaths = comm.produceResult(categoriesTO);
		double finalNum = Math.abs(numberOfDeaths);
		
		String categoriesJson = gson.toJson(finalNum);
		response.getWriter().write(categoriesJson);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
