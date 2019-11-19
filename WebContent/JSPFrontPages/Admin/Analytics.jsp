<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.google.gson.Gson"%>
<%@ page import="com.google.gson.JsonObject"%>
<%

String customer = session.getAttribute("customerList").toString();
customer = customer.substring(1,customer.length()-1);


Gson gsonObj = new Gson();
Map<Object,Object> map = null;
List<Map<Object,Object>> list = new ArrayList<Map<Object,Object>>();
String[] l = customer.split(",");
String y = "y";
String lab = "label";
for (int i=0; i < l.length; i++) {
	String[] j = l[i].split("=");
	map = new HashMap<Object,Object>(); 
	if(i == 0)
		map.put(lab, j[0].toLowerCase());
	else
		map.put(lab, j[0].toLowerCase().substring(1, j[0].length()));
	map.put(y, Integer.parseInt(j[1])); 
	list.add(map);
} 
String dataPoints = gsonObj.toJson(list);
%> 

 
<!DOCTYPE HTML>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
<jsp:include page="../../Partials/AdminMenu.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
window.onload = function() { 
 
var chart = new CanvasJS.Chart("chartContainer", {
	theme: "light2",
	title: {
		text: "Total No.Of Customers In Past 12 Months"
	},
	subtitles: [{
		text: "Customer Summary"
	}],
	axisY: {
		title: "Number of Customers",
	},
	data: [{
		type: "column",
		dataPoints: <%out.print(dataPoints);%>
	}]
});
chart.render();
 
}
</script>
</head>
<body>
<div>
<section id="chartContainer" style="height: 370px; width: 100%;"></section>
</div>
<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
</body>
</html> 