<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	int itm_id = 0;
	try { itm_id = Integer.parseInt(request.getParameter("id")); }
	catch (NullPointerException | NumberFormatException e) {};
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="jquery-ui.css">
<script src="js/jquery-3.6.0.js"></script>
<script src="js/jquery-ui-1.13.1.js"></script>
<script>

$( document ).ready(function() {
	$.getJSON("api/item/detail/<%= itm_id %>", function(jsondata) {
		$( "#dataview" ).val(JSON.stringify(jsondata));
		console.log(jsondata);
		$( "#itm_n" ).val(jsondata.item_name);
		$( "#itm_v" ).val(jsondata.item_value);
		if (jsondata.status == true)
			$( "#itm_sts option[value='true']" ).attr('selected', true);
		else
			$( "#itm_sts option[value='false']" ).attr('selected', true);
	});
});

</script>
<title>Update item</title>
</head>
<body>
<h1>Update item <%= itm_id %></h1>

Name: <input type="text" id="itm_n" name="item_name"><br>
Value: <input type="text" id="itm_v" name="item_value"><br>
Status: <select id="itm_sts" name="status">
		<option value="false" >false</option>
		<option value="true" >true</option>
		</select> <br>
<button type="button" id="updt_btn">Update</button>
<script>
$( "#updt_btn" ).on("click", function(event) {
	var itm_n = $( "#itm_n" ).val();
	var itm_v = $( "#itm_v" ).val();
	var itm_sts = $( "#itm_sts option:selected" ).val(); 
	var json = { 'id': <%= itm_id %>,
			'item_name': itm_n, 'item_value': itm_v,
			'status': JSON.parse(itm_sts),
			'last_updated': null};
	console.log(json);
	$.ajax({
		type: 'PUT',
		url: "api/item/update",
		data: JSON.stringify(json), 
		dataType: "json",
		contentType: "application/json",
		success: function (data) {
			$( "#dataview" ).val("Updated: "+JSON.stringify(data));
		}
	}).fail(function(xhr, statusText, error) {
		$( "#dataview" ).val("Failed: "+xhr.status+" "+statusText);
		console.log(error);
		console.dir(xhr);
	})
});
</script>
<br>
<textarea id="dataview" cols="80" rows="3"></textarea>
</body>
</html>