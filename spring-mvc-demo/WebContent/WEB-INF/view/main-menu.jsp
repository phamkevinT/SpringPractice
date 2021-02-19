<!DOCTYPE html>
<html>



<!-- Example of linking CSS and JS resources

<head>
<link rel="stylesheet" type="text/css"    
href="${pageContext.request.contextPath}/resources/css/my-test.css">
<script src="${pageContext.request.contextPath}/resources/js/simple-test.js"></script>
</head>

-->


<body>

	<img
		src="${pageContext.request.contextPath}/resources/images/spring-logo.png"
		alt="spring-logo-image" />


	<h2>Spring MVC Demo - Home Page</h2>
	<hr>
	
	<br>
	<br>

	<a href="hello/showForm">Hello World Form</a>

	<br>
	<br>

	<a href="student/showForm">Student Form</a>
	
	<br>
	<br>

	<a href="customer/showForm">Customer Form</a>



</body>


</html>