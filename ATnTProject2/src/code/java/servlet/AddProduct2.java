package code.java.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;
import org.apache.wink.json4j.JSONException;
import org.apache.wink.json4j.JSONObject;


/**
 * Servlet implementation class AddProduct
 */
@WebServlet("/AddProduct")
public class AddProduct extends HttpServlet {
	private boolean isMultipart;
	   private String filePath;
	   private int maxFileSize = 2755469;
	   private int maxMemSize = 2755490;
	   private File file ;

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
		final String dir =  getServletContext().getRealPath("");
        System.out.println("current dir = " + dir);
        String contextPath = request.getContextPath();
        System.out.println(contextPath);
        String fileName ="";
		//start of the docupload
//		jsonObj.put("prodId", request.getParameter("prodId"));
//		jsonObj.put("prodName", request.getParameter("prodName"));
//		jsonObj.put("prodDesc", request.getParameter("prodDesc"));
//		jsonObj.put("relProd", request.getParameter("relProd"));
//		jsonObj.put("prodImageLink", request.getParameter("prodImageLink"));
		String prodId="";
		String prodName="";
		String prodDesc="";
		String relProd="";
		String prodImageLink="";
		
		 isMultipart = ServletFileUpload.isMultipartContent(request);
	      response.setContentType("text/html");
	     
	  
	      DiskFileItemFactory factory = new DiskFileItemFactory();
	   
	      // maximum size that will be stored in memory
	      factory.setSizeThreshold(maxMemSize);
	   
	      // Location to save data that is larger than maxMemSize.
	      factory.setRepository(new File(dir));

	      // Create a new file upload handler
	      ServletFileUpload upload = new ServletFileUpload(factory);
	   
	      // maximum file size to be uploaded.
	      upload.setSizeMax( maxFileSize );

	      try { 
	         // Parse the request to get file items.
	         List fileItems = upload.parseRequest(request);
		
	         // Process the uploaded file items
	         Iterator i = fileItems.iterator();

	       
	   
	         while ( i.hasNext () ) {
	            FileItem fi = (FileItem)i.next();
	            if ( !fi.isFormField () ) {
	               // Get the uploaded file parameters
	               String fieldName = fi.getFieldName();
	              fileName = fi.getName();
	               String contentType = fi.getContentType();
	               boolean isInMemory = fi.isInMemory();
	               long sizeInBytes = fi.getSize();
	            
	               // Write the file
	               if( fileName.lastIndexOf("\\") >= 0 ) {
	                  file = new File( dir + "\\"+prodId+"_"+fileName.substring( fileName.lastIndexOf("\\"))) ;
	               } else {
	                  file = new File( dir +"\\"+prodId+"_"+ fileName.substring(fileName.lastIndexOf("\\")+1)) ;
	               }
	               fileName = fileName.substring(fileName.lastIndexOf("\\")+1);
	               fi.write( file ) ;
	               System.out.println(file.getAbsolutePath());
	              
	            }
	            else
	            { 
	            	  if ("prodId".equals(fi.getFieldName()))
	                 {
	            		  prodId = fi.getString();
	                }
	            	  if ("prodName".equals(fi.getFieldName()))
		                 {
	            		  prodName = fi.getString();
		                }
	            	  if ("prodDesc".equals(fi.getFieldName()))
		                 {
	            		  prodDesc = fi.getString();
		                }
	            	  if ("prodImageLink".equals(fi.getFieldName()))
		                 {
	            		  prodImageLink = fi.getString();
		                }
	            	  if ("relProd".equals(fi.getFieldName()))
		                 {
	            		  relProd = fi.getString();
		                }
	        		
	        		
	        		
	            	
	            }
	         }
	         
	         } catch(Exception ex) {
	            System.out.println(ex);
	         }
		//end of the doc upload
//		if(request.getParameter("prodId") .equals("x"))
//		{
//		throw  new IOException();
//		}
		HashMap map = (HashMap)request.getServletContext().getAttribute("productList");
		String key = prodId;
		 JSONObject jsonObj = new JSONObject();
		 try {
			jsonObj.put("prodId",prodId);
			jsonObj.put("prodName",prodName);
			jsonObj.put("prodDesc", prodDesc);
			jsonObj.put("relProd", relProd);
			jsonObj.put("prodImageLink",prodImageLink);
			jsonObj.put("imageUrl", contextPath+"\\"+prodId+"_"+fileName);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 map.put(key, jsonObj);
		 HashMap map2 = (HashMap)request.getServletContext().getAttribute("productList");
		 LOGGER.info(map2.get(key));
		
		 PrintWriter out = response.getWriter();
		 out.write(jsonObj.toString());
		 
		 
		
	}

}
