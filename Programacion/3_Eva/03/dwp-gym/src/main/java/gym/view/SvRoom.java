package gym.view;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;
import java.io.IOException;
import java.util.ArrayList;


@WebServlet("/SvRoom")
public class SvRoom extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SvRoom() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		List<String> rooms = new ArrayList<String>();
		rooms.add("Entrada");
		
		request.setAttribute("rooms", rooms);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("room/list.html");
		requestDispatcher.forward(request, response);
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
