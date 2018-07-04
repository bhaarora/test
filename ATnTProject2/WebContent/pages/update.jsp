<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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

</head>
<body>
<form action="/ATnTProject/updateProduct" method="post" id="my_form">
<label for="prodId">${requestScope.updatedObject.prodId}</label>
<input type="hidden" id="key" name="key" placeholder="product ID" value="${requestScope.updatedObject.prodId}" required>
<input type="text" id="prodName"  name="prodName" placeholder="product Name" value="${requestScope.updatedObject.prodName}" required>
<input type="text" id="prodDesc" name="prodDesc" placeholder="product Desc" value="${requestScope.updatedObject.prodDesc}" required>
<input type="text" id="relProd" name="relProd" placeholder="related product" value="${requestScope.updatedObject.relProd}">
<input type="text" id="prodImageLink" name="prodImageLink" placeholder="product image link" value="${requestScope.updatedObject.prodImageLink}">
<input type="hidden" id="updateItem" name="updateItem" value="true">
<input type="submit" class="add-row" value="Update Product">
<!-- <div id="server-results">For server results</div> -->
</form>

</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
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
//         $("#server-results").html(response);
        var obj = JSON.parse(response);
        
        $("#prodName").val(obj.prodName);
         $("#prodDesc").val(obj.prodDesc);
          $("#relProd").val(obj.relProd);
           $("#prodImageLink").val(obj.prodImageLink);
        
    });
});
</script>
</html>