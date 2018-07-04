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

/**
 * Servlet implementation class DeleteProduct
 */
@WebServlet("/DeleteProduct")
public class DeleteProduct extends HttpServlet {
	static final Logger LOGGER = Logger.getLogger(DeleteProduct.class);
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteProduct() {
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
		String[] key = request.getParameterValues("record");
		String responseCode ="";
		if(key == null)
		{
			responseCode ="Please select at least 1 product to be deleted ";
		}
		else 
			if(key.length == 3)
			{
				throw new IOException();
			}
		HashMap map = (HashMap)request.getServletContext().getAttribute("productList");
		if(map !=null && key !=null && key.length > 0)
		{     responseCode ="Successfully Deleted for the product ids ";
			for(int i =0; i < key.length; i++)
			{
				map.remove(key[i]);
				responseCode +=" : "+key[i];
			}
			HashMap map2 = (HashMap)request.getServletContext().getAttribute("productList");
			 LOGGER.info(map2.get(key));
			 
		}
		response.setContentType("text/html"); 
		 PrintWriter out = response.getWriter();
		 out.write(responseCode);
		
	}

}
