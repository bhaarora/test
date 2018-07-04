package code.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.wink.json4j.JSONException;
import org.apache.wink.json4j.JSONObject;

/**
 * Servlet implementation class AddProduct
 */
@WebServlet("/AddProduct")
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 static final Logger LOGGER = Logger.getLogger(AddProduct.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LOGGER.info(request.getParameter("prodId"));
		LOGGER.info(request.getParameter("prodId"));
		if(request.getParameter("prodId") .equals("x"))
		{
		throw  new IOException();
		}
		HashMap map = (HashMap)request.getServletContext().getAttribute("productList");
		String key = request.getParameter("prodId");
		 JSONObject jsonObj = new JSONObject();
		 try {
			jsonObj.put("prodId", request.getParameter("prodId"));
			jsonObj.put("prodName", request.getParameter("prodName"));
			jsonObj.put("prodDesc", request.getParameter("prodDesc"));
			jsonObj.put("relProd", request.getParameter("relProd"));
			jsonObj.put("prodImageLink", request.getParameter("prodImageLink"));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 map.put(key, jsonObj);
		 HashMap map2 = (HashMap)request.getServletContext().getAttribute("productList");
		 LOGGER.info(map2.get(key));
		 response.setContentType("text/html"); 
		 PrintWriter out = response.getWriter();
		 out.write(jsonObj.toString());
		 
		 
		
	}

}
