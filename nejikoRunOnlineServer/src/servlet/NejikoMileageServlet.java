package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.NejikoLogic;
import model.NejikoMileage;

/**
 * Servlet implementation class NejikoMileageServlet
 */
@WebServlet("/NejikoMileageServlet")
public class NejikoMileageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NejikoMileageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		NejikoLogic nejikoLogic = new NejikoLogic();

		String responseJSON = nejikoLogic.findMileage();

		System.out.println("doGet/レスポンスするJSON文字列 ..." + responseJSON);

		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");

		response.getWriter().print(responseJSON);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		String name = request.getParameter("name");

		int score = Integer.parseInt(request.getParameter("score"));

		System.out.println("doPost/Postされたパラメーター ...name" + name + "/score: " + score );

		NejikoMileage nm = new NejikoMileage(name,score);

		System.out.println("doPost/リクエストパラメータの値が入ったインスタンス:" + nm);

		NejikoLogic nejikoLogic = new NejikoLogic();

		if(nejikoLogic.registMileage(nm)){
			response.getWriter().print("SUCCESS");

		}else{
			response.getWriter().print("ERROR");
		}
	}

}
