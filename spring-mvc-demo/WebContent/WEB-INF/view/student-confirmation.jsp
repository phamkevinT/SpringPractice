<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE>
 
<html>

<head>
<title>Student Confirmation</title>
</head>


<body>

	The Student is confirmed: ${student.firstName} ${student.lastName}
	<br><br>
	Country: ${student.country}
	<br><br>
	Favorite Programming Language: ${student.favoriteLanguage}
	<br><br>
	Operating System: 
	
	<ul>
		<c:forEach var="temp" items="${student.operatingSystem}">
			<li> ${temp} </li>
		</c:forEach>
	</ul>
	
	<br><br>

</body>




</html>