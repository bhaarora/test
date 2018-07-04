 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Add Product </title>
<style type="text/css">
table{
width: 100%;
margin: 20px 0;
border-collapse: collapse;
}
table, th, td{
border: 1px solid #cdcdcd;
}
table th, table td{
padding: 5px;
text-align: left;
}
</style>
<script type="text/javascript" src="//code.jquery.com/jquery-1.8.3.js"></script>
<script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.10.0/jquery.validate.min.js"></script>
<script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.10.0/additional-methods.js"></script>
</head>
<body>
 <div id="server-results"></div> 
<form action="/ATnTProject/addProduct" method="post" id="my_form">
<input type="text" id="prodId" name="prodId" placeholder="product ID" required>
<input type="text" id="prodName"  name="prodName" placeholder="product Name" required>
<input type="text" id="prodDesc" name="prodDesc" placeholder="product Desc" required>
<input type="text" id="relProd" name="relProd" placeholder="related product">
<input type="text" id="prodImageLink" name="prodImageLink" placeholder="product image link">
<input type="submit" class="add-row" value="Add Product">
<!-- <div id="server-results">For server results</div> -->
</form>
<form action="/ATnTProject/deleteProduct" method="post" id="my_form_delete">
<table>
<thead>
<tr>
<th>Check for Deletion</th>
<th>Prod Id</th>
<th>Prod Name</th>
<th>Prod Desc</th>
<th>Related Product</th>
<th>Product image Link</th>
<th>Update Product</th>
</tr>
</thead>
<tbody>
<c:forEach var="list" items="${requestScope.productList}">
       <!-- create an html table row -->
       <tr id="row${list.prodId}">
       <!-- create cells of row -->
       <td><input type='checkbox' name='record' value ="${list.prodId}" ></td>
       <td>${list.prodId}</td>
       <td>${list.prodDesc}</td>
       <td>${list.prodName}</td>
       <td>${list.relProd}</td>
       
       <td>${list.prodImageLink}</td>
       <td><a href="/ATnTProject/updateProduct?key=${list.prodId}">Update Product</a></td>
       <!-- close row -->
       </tr>
       <!-- close the loop -->
   </c:forEach>
</tbody>
</table>
<input type="submit" class="delete-row" value="Delete Product" /input>
</form>
<br/><br/><br/>
<div ><a href='/ATnTProject/listProducts' target="_blank">List All Products</a></div> 
</body>

<script type="text/javascript">
$().ready(function(){

		
$("#my_form").submit(function(event){
    event.preventDefault(); //prevent default action
    var post_url = $(this).attr("action"); //get form action url
    var request_method = $(this).attr("method"); //get form GET/POST method
    var form_data = $(this).serialize(); //Encode form elements for submission
    
		
   $.ajax({
        url : post_url,
        
        type: request_method,
        data : form_data
    }).done(function(response){ //
      
		
        var obj = JSON.parse(response);
         $("#server-results").html("Product with Product Id "+obj.prodId+" added successfully" );
        var updateLink ="<td><a href='/ATnTProject/updateProduct?key="+obj.prodId+"'>Update Product</a> </td></tr>";
        var rowString = "<tr id='row"+obj.prodId+"'><td><input type='checkbox' name='record' value ='"+obj.prodId+"' ></td><td>" + obj.prodId + "</td><td>" + obj.prodName + "</td><td>" + obj.prodDesc +  "</td><td>"  + obj.relProd +  "</td><td>" + obj.prodImageLink + "</td>"+updateLink;
         $("#row"+obj.prodId).remove();
        $("table tbody").append(rowString);
        
    })  .fail(function() {
    alert( "Error while adding the product id "+ $("#prodId").val() );
  }); // end of ajax call
  
});

$("#my_form_delete").submit(function(event){
    event.preventDefault(); //prevent default action
    var post_url = $(this).attr("action"); //get form action url
    var request_method = $(this).attr("method"); //get form GET/POST method
    var form_data = $(this).serialize(); //Encode form elements for submission
   
    $.ajax({
        url : post_url,
        type: request_method,
        data : form_data
    }).done(function(response){ //
         $("#server-results").html(response);
//         var obj = JSON.parse(response);
//         var rowString = "<tr><td><input type='checkbox' name='record' value ='"+obj.prodId+"' ></td><td>" + obj.prodId + "</td><td>" + obj.prodName + "</td><td>" + obj.prodDesc +  "</td><td>"  + obj.relProd +  "</td><td>" + obj.prodImageLink + "</td></tr>";
//         $("table tbody").append(rowString);
			$("table tbody").find('input[name="record"]').each(function(){
if($(this).is(":checked")){
$(this).parents("tr").remove();
}
});
    }).fail(function(response){ //
        alert("Deletion Failure" );
    });
});
}); 

</script>
</html> 