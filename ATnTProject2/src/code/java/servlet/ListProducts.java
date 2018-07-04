package code.java.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.wink.json4j.JSONObject;

/**
 * Servlet implementation class ListProducts
 */
@WebServlet("/ListProducts")
public class ListProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListProducts() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		LinkedHashMap map = (LinkedHashMap)request.getServletContext().getAttribute("productList");
		if(map !=null)
		{
			List l = new ArrayList();
			 Set set = map.entrySet();
		      
		      // Get an iterator
		      Iterator i = set.iterator();
		      while(i.hasNext()) {
		          Map.Entry me = (Map.Entry)i.next();
		          System.out.print(me.getKey() + ": ");
		          System.out.println(me.getValue());
		          l.add((JSONObject)me.getValue());
		          
		       }
		      request.setAttribute("productList", l);
		}
		RequestDispatcher requestDispatcher = request
                .getRequestDispatcher("/pages/listProduct.jsp");
        requestDispatcher.forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
