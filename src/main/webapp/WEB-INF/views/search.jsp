 <%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix="c" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>RentalCar Search</title>
</head>
<body>
<%@ include file="header.jsp" %>
<c:if test="${cars != null}">
  <table  class="table">
      <thead><tr><th colspan="6">Results for location ${param.pickUp}  and Max Daily rate <fmt:formatNumber type="currency" value="${param.price}"/></th></tr></thead>
	  <thead>
	    <tr>
	      <th>ID</th>
	      <th>Location</th>
	      <th>Category</th>
	      <th>Make</th>
	      <th>Model</th>
	      <th><font color='green'>Your Price</font></th>
	    </tr>
	  </thead>
	  <tbody>

       <c:forEach items="${cars}" var="car">
	    <tr>
	      <!-- We use both getProperty and c:out here to illustrate -->
	      <!-- their use                                            -->
	      <td><c:out value="${car.id}"/></td>
	      <td><c:out value="${car.location}"/></td>
		  <td><c:out value="${car.category}"/></td>
	      <td><c:out value="${car.make}"/></td>
	      <td><c:out value="${car.model}"/></td>
	      <td><b><font color='green'><fmt:formatNumber type="currency" value="${car.dailyRate}"/></font></b></td>
	    </tr>
       </c:forEach>
      </tbody>
	</table>
 </c:if>
 
</body>
</html>