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
 * Servlet implementation class DrawBarGraphServlet
 */
@WebServlet("/DrawBarGraphServlet")
public class DrawBarGraphServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DrawBarGraphServlet() {
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
		
		String[] ageGroup = {"1","1-4","5-9","10-14","15-19","20-24","25-29","30-34","35-39","40-44","45-49","50-54","55-59","60-64","65-69","70-74","75-79","80-84","85+"};                    
		for(int i=0;i<ageGroup.length;i++){
			//returnCategories = new CategoriesTO();
			categoriesTO.setAge(ageGroup[i]);
			CategoriesTO returnCategories = null;
			returnCategories = comm.predictAgeGroup(categoriesTO);
			categoriesArray.add(new CategoriesTO(returnCategories));
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
