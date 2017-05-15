<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>RentalCar Search</title>
<link href="/rentals/resources/css/bootstrap.css" rel="stylesheet" />
<link href="/rentals/resources/css/bootstrap-theme.css" rel="stylesheet" />


</head>
<body>

	<form:form commandName="car" class="panel panel-primary"
		action="${pageContext.request.contextPath}/rental/location"
		method="POST">
		<form:errors path="*" element="div" style="color:red" />
		<div class="panel-heading">
			<div class="panel-title">RentalCar Availability</div>
		</div>
		<table class="table">
			<tr>
				<td><IMG src="/rentals/resources/images/car.jpg" width="200"
					height="120" /></td>
				<td>
					<div class="input-group">
						<span>PickUp Location</span>
						<form:select path="pickUp" items="${offices}" class="form-control" />
						<form:errors path="pickUp" style="color:red" />
					</div>
					<div class="input-group">
						<span>Max Daily Cost</span>
						<form:input path="price" class="form-control" />
					</div>
					<div>
						<input class="btn btn-primary" type="submit" value="Search" />
					</div>


				</td>
				<td><IMG src="/rentals/resources/images/mini.jpg" width="200"
					height="120" /></td>
			</tr>

		</table>
	</form:form>

</body>
</html>