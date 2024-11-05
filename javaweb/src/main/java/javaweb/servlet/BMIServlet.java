package javaweb.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*
 * 網址 http://localhost:8080/javaweb/bmi?h=170&w=110
 * */

@WebServlet("/bmi")
public class BMIServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//取得?後的參數
		String h = req.getParameter("h");
		String w = req.getParameter("w");
		
		//檢查參數
		if(h==null || w==null) {
			req.setAttribute("message","叫你輸出身高體重,你在幹嘛?");
			req.getRequestDispatcher("/WEB-INF/view/error.jsp").forward(req, resp);
			return;
			
		}
		//計算
		double height=Double.parseDouble(h);
		double weight=Double.parseDouble(w);
		double bmi= weight/Math.pow(height/100, 2);
		
		//資料船屋去
		req.setAttribute("height", height);
		req.setAttribute("weight", weight);
		req.setAttribute("bmi", bmi);
		
		//傳出
		req.getRequestDispatcher("/WEB-INF/view/bmi.jsp").forward(req, resp);
	}
	

}
