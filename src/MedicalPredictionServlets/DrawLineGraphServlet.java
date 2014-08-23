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
 * Servlet implementation class DrawLineGraphServlet
 */
@WebServlet("/DrawLineGraphServlet")
public class DrawLineGraphServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DrawLineGraphServlet() {
        super();
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
		double year = categoriesTO.getYear();
		//categoriesTO = comm.produceResult(categoriesTO);
		Double[] yearsArray = new Double[5];
		for(int i=0;i<5;i++){
			yearsArray[i] = year+i;
		}
		String[] sex = {"Male","Female"};
		for(int j=0;j<yearsArray.length;j++){
			for(int i=0;i<sex.length;i++){
				//returnCategories = new CategoriesTO();
				categoriesTO.setSex(sex[i]);
				categoriesTO.setYear(yearsArray[j]);
				CategoriesTO returnCategories = null;
				returnCategories = comm.predictYearSex(categoriesTO);
				categoriesArray.add(new CategoriesTO(returnCategories));
			}
		}
		String categoriesJson = gson.toJson(categoriesArray);
		response.getWriter().write(categoriesJson);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
