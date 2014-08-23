package MedicalPredictionServlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import RPackage.CommandLineCall;
import TransferObjects.CategoriesTO;

import com.google.gson.Gson;

/**
 * Servlet implementation class MainPageServlet
 */
@WebServlet("/MainPageServlet")
public class MainPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public MainPageServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<CategoriesTO> categoriesArray = new ArrayList<CategoriesTO>();
		//CategoriesTO returnCategories = null;
		String categories = request.getParameter("categories");
		Gson gson = new Gson();
		CategoriesTO categoriesTO = gson.fromJson(categories, CategoriesTO.class);

		CommandLineCall comm = new CommandLineCall();
		//categoriesTO = comm.produceResult(categoriesTO);
		String[] regions = {"West","South","Midwest","Northeast"};
		for(int i=0;i<regions.length;i++){
			//returnCategories = new CategoriesTO();
			categoriesTO.setRegion(regions[i]);
			CategoriesTO returnCategories = null;
			returnCategories = comm.predictRegionYear(categoriesTO);
			categoriesArray.add(new CategoriesTO(returnCategories));
		}
		String categoriesJson = gson.toJson(categoriesArray);
		response.getWriter().write(categoriesJson);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
