<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
<table >
   <!-- iterate over the collection using forEach loop -->
   <thead>
<tr>

<th>Prod Id</th>
<th>Prod Name</th>
<th>Prod Desc</th>
<th>Related Product</th>
<th>Product image Link</th>
<th>Update Product</th>
</tr>
</thead>
   <c:forEach var="list" items="${requestScope.productList}">
       <!-- create an html table row -->
       <tr>
       <!-- create cells of row -->
       <td>${list.prodId}</td>
       <td>${list.prodName}</td>
       <td>${list.prodDesc}</td>
       
       <td>${list.relProd}</td>
       
       <td>${list.prodImageLink}</td>
       <td><a href="/ATnTProject/updateProduct?key=${list.prodId}">Update Product</a></td>
       <!-- close row -->
       </tr>
       <!-- close the loop -->
   </c:forEach>
   <!-- close table -->
   </table>

</body>
</html>