<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE>

<html>

<head>
<title>Student Registration Form</title>
</head>

<body>

	<form:form action="processForm" modelAttribute="student">
	
	First name: <form:input path="firstName" />

		<br>
		<br>
	
	Last name: <form:input path="lastName" />

		<br>
		<br>
		
	Country: <form:select path="country">
				<form:options items="${theCountryOptions}" />
			 </form:select>

		<br>
		<br>
		
	Favorite Language: <form:radiobuttons path="favoriteLanguage" items="${student.favoriteLanguageOptions}" />

		<br>
		<br>

	Operating System: 
	
		Linux <form:checkbox path="operatingSystem" value="Linux"/>
		MS Windows <form:checkbox path="operatingSystem" value="MS Windows"/>
		Mac OS <form:checkbox path="operatingSystem" value="Mac OS"/>
		
		<br>
		<br>

		<input type="submit" value="Submit">
		
		<br>
		<br>
		

	</form:form>

</body>

</html>