package laba4;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="Calc", urlPatterns="/JavaCalc") //���������� �������� � URL
public class Calc extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestCalc Calc = RequestCalc.fromRequestParameters(request);
		Calc.setAsRequestAttributesAndCalculate(request);
		 
		request.getRequestDispatcher("/Results.jsp").forward(request, response);
		
	}
	
	private static class RequestCalc {
		private final String first_calc;
		private final String second_calc;
		private double result;
		private double result_in_mm;
						
		private RequestCalc (String first, String second) {
			this.first_calc = first;
			this.second_calc = second;
			}
		
		public static RequestCalc fromRequestParameters(HttpServletRequest request) {
			return new RequestCalc(
			request.getParameter("first"),
			request.getParameter("second"));
			}
				
		public void setAsRequestAttributesAndCalculate(HttpServletRequest request) {
			request.setAttribute("first_result", first_calc);
			request.setAttribute("second_result", second_calc);
			double first_try;
			double second_try;
			try { 
			first_try=Double.parseDouble(first_calc);
			second_try=Double.parseDouble(second_calc);
			}
			catch (NumberFormatException e) {
				first_try=0;
				second_try=0;	
			}
			
			result=2 * Math.PI * first_try * first_try * second_try / 3;
			String formattedResult = String.format("%.2f",result);
			result_in_mm = result * 1000000;
			String formattedResultInMm = String.format("%.2f",result_in_mm);
			request.setAttribute("first", first_calc);
			request.setAttribute("second", second_calc);
			request.setAttribute("formattedResult", formattedResult);
			request.setAttribute("formattedResultInMm", formattedResultInMm);
		}
		
	}
	
	
}