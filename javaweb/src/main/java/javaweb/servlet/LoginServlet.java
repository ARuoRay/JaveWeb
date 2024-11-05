package javaweb.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import javaweb.model.dto.UserCert;
import javaweb.service.CertService;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private CertService certService=new CertService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		
		//驗證帳密
		UserCert userCert=null;
		
		try {
			userCert=certService.getCert(username, password);
		} catch (Exception e) {
			req.setAttribute("message", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/view/error.jsp").forward(req, resp);
			return;
		}
				
		HttpSession session=req.getSession();
		session.setAttribute("userCert", userCert);
		session.setAttribute("locale", req.getLocale());
		
		req.setAttribute("message", "登入成功");
		req.getRequestDispatcher("/WEB-INF/view/result.jsp").forward(req, resp);
	}
	
	
	
	
}
