<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.google.gson.Gson"%>
<%@ page import="com.google.gson.JsonObject"%>
<%

String retailer = session.getAttribute("retailerList").toString();
retailer = retailer.substring(1,retailer.length()-1);

Gson gsonObj = new Gson();
Map<Object,Object> map = null;
List<Map<Object,Object>> list = new ArrayList<Map<Object,Object>>();
String[] l = retailer.split(",");
String y = "y";
String lab = "label";
Integer sum = 0;

for (int i=0; i < l.length; i++) {
	String[] j = l[i].split("=");
	sum += Integer.parseInt(j[1]);
}

System.out.println(sum);

for (int i=0; i < l.length; i++) {
	String[] j = l[i].split("=");
	map = new HashMap<Object,Object>(); 
	if(i == 0)
		map.put(lab, j[0].toLowerCase());
	else
		map.put(lab, j[0].toLowerCase().substring(1, j[0].length()));
	map.put(y, Math.round(Double.parseDouble(j[1])/sum*100)); 
	list.add(map);
} 
String dataPoints = gsonObj.toJson(list);
System.out.println(dataPoints);
%> 

 
<!DOCTYPE HTML>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
<jsp:include page="../../Partials/AdminMenu.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
<script type="text/javascript">
window.onload = function() { 
 
var chart = new CanvasJS.Chart("chartContainer", {
	theme: "light2",
	title: {
		text: "Retailer : Max customer"
	},
	data: [{
		type: "pie",
		showInLegend: true,
		legendText: "{label}",
		toolTipContent: "{label}:{y}%",
		indexLabel: "{label} {y}%",
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

</body>
</html> 