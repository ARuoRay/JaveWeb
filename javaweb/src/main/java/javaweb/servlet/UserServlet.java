package javaweb.servlet;

import java.io.IOException;
import java.security.PrivateKey;
import java.util.List;

import com.mysql.cj.Session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import javaweb.model.dto.UserCert;
import javaweb.model.dto.UserDto;
import javaweb.repository.UserDao;
import javaweb.service.UserService;

/**

MVC + 自訂框架
 
 request   +-------------+          +-------------+          +---------+
---------> | UserServlet | -------> | UserService | -------> | UserDao | ------->    MySQL
           | (Controller)| <------- |             | <------- |         | <------- (web.users)
 			+-------------+  UserDto +-------------+   User   +---------+
 			       |          (Dto)                  (Entity)
 			       |
 			       v
 			+-------------+
<--------- |   user.jsp  |
 response	|    (View)   |
 			+-------------+                 

查詢全部: GET  /user
查詢單筆: GET  /user/get?username=admin
新增單筆: POST /user/add
修改單筆: POST /user/update?userId=1
刪除單筆: GET  /user/delete?userId=1 

* */

@WebServlet(urlPatterns = {"/user/*","/users"})
public class UserServlet extends HttpServlet {

	private UserService userService=new UserService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String pathInfo=req.getPathInfo();
			
			if(pathInfo==null) {
				List<UserDto>userDtos=userService.findAll();
				req.setAttribute("userDtos", userDtos);
				req.getRequestDispatcher("/WEB-INF/view/user.jsp").forward(req, resp);
				return;
			}else if (pathInfo.equals("/delete")) {
				String userId=req.getParameter("userId");
				userService.deleateUser(userId);
				// 刪除完畢之後, 重新執行指定頁面
				resp.sendRedirect("/javaweb/user");
				return;
			}else if (pathInfo.equals("/get")) {
				String username=req.getParameter("username");
				UserDto userDto=userService.getUser(username);
				// 將必要資料加入到 request 屬性中以便交由 jsp 進行分析與呈現
				req.setAttribute("userDto", userDto);
				// 內重導到 user_update.jsp
				req.getRequestDispatcher("/WEB-INF/view/user_update.jsp").forward(req, resp);
				return;
			}else if(pathInfo.equals("/update/password")) {
				req.getRequestDispatcher("/WEB-INF/view/update_password.jsp").forward(req, resp);
				return;
			}
				
			}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String pathInfo=req.getPathInfo();
		
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		String email=req.getParameter("email");
		String role=req.getParameter("role");
		String active=req.getParameter("active");
		String userId=req.getParameter("userId");
		String oldPassword=req.getParameter("oldPassword");
		String newPassword=req.getParameter("newPassword");
		
		switch(pathInfo) {
		case"/add":
			userService.appendUser(username , password, email, role);
			break;
		case"/update":
			userService.updateUser(userId, active, role);
			break;
		case"/update/password":	
			HttpSession session=req.getSession();
			try {
				UserCert userCert=(UserCert)session.getAttribute("userCert");
				userService.updatePassword(userCert.getUserId(),userCert.getUsername(),oldPassword,newPassword);
				req.setAttribute("message", "密碼更新成功");
				req.getRequestDispatcher("/WEB-INF/view/result.jsp").forward(req, resp);
				
			} catch (Exception e) {
				req.setAttribute("message", e.getMessage());
				req.getRequestDispatcher("/WEB-INF/view/result.jsp").forward(req, resp);
			}
			return;
		}
		resp.sendRedirect("/javaweb/user");
	}


}
