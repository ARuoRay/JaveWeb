package javaweb.servlet;

import java.io.IOException;
import java.util.Random;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*
 * 模式:Model1
 * Servlet 負責邏輯
 * JSP 資料呈現
 * 
 * */

@WebServlet("/lottery")
public class LotteryServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//電腦選號 四星彩
				Random random=new Random();
				int n1=random.nextInt(10);
				int n2=random.nextInt(10);
				int n3=random.nextInt(10);
				int n4=random.nextInt(10);
				
				
				//印出(用resp) 直接寫http的程式碼給網站
				req.setAttribute("n1", n1);
				req.setAttribute("n2", n2);
				req.setAttribute("n3", n3);
				req.setAttribute("n4", n4);
				
				//重倒到指定
				req.getRequestDispatcher("/WEB-INF/view/lottery.jsp").forward(req, resp);
				

}
}
