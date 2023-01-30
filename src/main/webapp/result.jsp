<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
body {
display : grid;
align-items : center;
padding: 5rem 8rem;
}
</style>
<body>
<a href="/">Go back</a>
<table id="contacts" border="1" 
       cellpadding="4"
       cellspacing="5"></table>
</body>
<script type="text/javascript">
const obj = ${result};
const contactDiv = document.querySelector("#contacts");
if(obj.length === 0) {
	contactDiv.innerHTML = "<h1>No Contacts Found</h1>";
}
for(let c of obj) {
	const tr = document.createElement("tr");
	for(let key in c) {
	const td = document.createElement("td");
	const h2 = document.createElement("h2");
	h2.innerText = c[key];
	td.appendChild(h2);
		tr.appendChild(td);
	}
	contactDiv.appendChild(tr);
}
</script>
</html>