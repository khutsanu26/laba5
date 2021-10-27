package laba4;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="MainForm", urlPatterns="/MainForm")
public class MainForm extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestCalc Calc = RequestCalc.fromRequestParameters(request);
		Calc.setAsRequestAttributes(request);
		 
		request.getRequestDispatcher("/").forward(request, response);
		
	}
	
	private static class RequestCalc {
		private final String first_calc;
		private final String second_calc;
						
		private RequestCalc (String first, String second) {
			this.first_calc = first;
			this.second_calc = second;
			}
		
		public static RequestCalc fromRequestParameters(HttpServletRequest request) {
			return new RequestCalc(
			request.getParameter("first"),
			request.getParameter("second"));
			}
				
		public void setAsRequestAttributes(HttpServletRequest request) {
			request.setAttribute("first", first_calc);
			request.setAttribute("second", second_calc);
		}
		
	}

}