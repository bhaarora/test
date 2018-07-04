package code.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.wink.json4j.JSONException;
import org.apache.wink.json4j.JSONObject;

/**
 * Servlet implementation class UpdateProduct
 */
@WebServlet("/UpdateProduct")
public class UpdateProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final Logger LOGGER = Logger.getLogger(UpdateProduct.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String key = request.getParameter("key");
		HashMap map = (HashMap)request.getServletContext().getAttribute("productList");
		if(request.getParameter("updateItem")!=null && request.getParameter("updateItem").equals("true"))
		{
			 JSONObject jsonObj = new JSONObject();
			 try {
				jsonObj.put("prodId", key);
				jsonObj.put("prodName", request.getParameter("prodName"));
				jsonObj.put("prodDesc", request.getParameter("prodDesc"));
				jsonObj.put("relProd", request.getParameter("relProd"));
				jsonObj.put("prodImageLink", request.getParameter("prodImageLink"));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 map.put(key, jsonObj);
			 response.setContentType("text/html"); 
			 PrintWriter out = response.getWriter();
			 out.write(jsonObj.toString());
		}
		else
		{
		request.setAttribute("updatedObject",(JSONObject)map.get(key));
		
		RequestDispatcher requestDispatcher = request
                .getRequestDispatcher("/pages/update.jsp");
        requestDispatcher.forward(request, response); 
		}
		 LOGGER.info(map);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String key = request.getParameter("key");
		HashMap map = (HashMap)request.getServletContext().getAttribute("productList");
		if(request.getParameter("updateItem")!=null && request.getParameter("updateItem").equals("true"))
		{
			 JSONObject jsonObj = new JSONObject();
			 try {
				jsonObj.put("prodId", key);
				jsonObj.put("prodName", request.getParameter("prodName"));
				jsonObj.put("prodDesc", request.getParameter("prodDesc"));
				jsonObj.put("relProd", request.getParameter("relProd"));
				jsonObj.put("prodImageLink", request.getParameter("prodImageLink"));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 map.put(key, jsonObj);
			 response.setContentType("text/html"); 
			 PrintWriter out = response.getWriter();
			 out.write(jsonObj.toString());
		}
		else
		{
		request.setAttribute("updatedObject",(JSONObject)map.get(key));
		
		RequestDispatcher requestDispatcher = request
                .getRequestDispatcher("/pages/update.jsp");
        requestDispatcher.forward(request, response); 
		}
		 LOGGER.info(map);
	}

}
