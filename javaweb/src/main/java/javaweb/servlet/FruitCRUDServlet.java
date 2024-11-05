package javaweb.servlet;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*
 * 新增水果:/fruit/create?name=apple or /fruit/create?name=banana etc...
 * 查詢水果:/fruit/read
 * 修改水果路徑:/fruit/update?name=apple&newName=pineApple
 * 路徑:/fruit/delete?name=banana
 * */

@WebServlet("/fruit/*")
public class FruitCRUDServlet extends HttpServlet{
	private List<String>fruits=new CopyOnWriteArrayList<>();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String newName=req.getParameter("newName");
		
		String pathInfo=req.getPathInfo();
		
		switch (pathInfo) {
			case "/create":
				fruits.add(name);
				resp.getWriter().print("Create fruit OK");
				resp.getWriter().println(fruits);
				break;
			case "/read":
				resp.getWriter().println(fruits);
	
				break;
			case "/update":
				Integer idx=fruits.indexOf(name);
				fruits.set(idx,newName);
				resp.getWriter().print("Update fruit OK");
				resp.getWriter().println(fruits);
	
				break;
			case "/deleate":
				fruits.remove(name);
				resp.getWriter().print("Deleate fruit OK");
				resp.getWriter().print(fruits);
	
				break;

		}
		
		
	}

	
}
