package javaweb.servlet;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*
 * 功能:分數計算與統計
 * 網址:/score?score=100&score=85&score=45
 * 引出總分 最高 最低
 * */

@WebServlet("/score")
public class Score extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[]scores=req.getParameterValues("score");
		int[] scoreInt = Arrays.stream(scores).mapToInt(Integer::parseInt).toArray();
		
		
		int total = IntStream.of(scoreInt).sum();
		int high = IntStream.of(scoreInt).max().orElse(0);
		int low = IntStream.of(scoreInt).min().orElse(0);
		
		resp.getWriter().println("scores:"+Arrays.toString(scores));
		resp.getWriter().println("total:"+total);
		resp.getWriter().println("high:"+high);
		resp.getWriter().println("low:"+low);
		
		
	}
	

}
