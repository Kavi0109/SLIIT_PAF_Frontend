$(document).ready(function()
{
	 $("#alertSuccess").hide();
 	 $("#alertError").hide();
});

// SAVE ============================================
$(document).on("click", "#btnSave", function(event)
{
	// Clear alerts---------------------
	$("#alertSuccess").text("");
 	$("#alertSuccess").hide();
 	$("#alertError").text("");
 	$("#alertError").hide();

	// Form validation-------------------
	var status = validateItemForm();
	if (status != true)
	{
		 $("#alertError").text(status);
 		 $("#alertError").show();
 		 return;
 	}
 	
	// If valid-------------------------
 	var type = ($("#hidItemIDSave").val() == "") ? "POST" : "PUT";

	$.ajax(
 	{
 		url : "UserAPI",
 		type : type,
 		data : $("#formItem").serialize(),
 		dataType : "text",
 		complete : function(response, status)
 		{
 			onItemSaveComplete(response.responseText, status);
 		}
 	}); 
 });

function onItemSaveComplete(response, status)
	{
		if (status == "success")
		{
			 var resultSet = JSON.parse(response);
 			 if (resultSet.status.trim() == "success")
			 {
 				$("#alertSuccess").text("Successfully saved.");
 				$("#alertSuccess").show();
 				$("#divItemsGrid").html(resultSet.data);
 			 } 
 			 else if (resultSet.status.trim() == "error")
			 {
 				$("#alertError").text(resultSet.data);
 				$("#alertError").show();
 			 }
 		} 
 		else if (status == "error")
 		{
 			$("#alertError").text("Error while saving.");
 			$("#alertError").show();
 		} 
 		else
 		{
 			$("#alertError").text("Unknown error while saving..");
 			$("#alertError").show();
 		}
		$("#hidItemIDSave").val("");
 		$("#formItem")[0].reset();
}

	// UPDATE==========================================
	$(document).on("click", ".btnUpdate", function(event)
	{
		 $("#hidItemIDSave").val($(this).data("id"));
		 $("#name").val($(this).closest("tr").find('td:eq(0)').text());
		 $("#email").val($(this).closest("tr").find('td:eq(1)').text());
		 $("#pass").val($(this).closest("tr").find('td:eq(2)').text());
 		 $("#mobile").val($(this).closest("tr").find('td:eq(3)').text());
 		$("#type").val($(this).closest("tr").find('td:eq(4)').text());
	});
	
	
	
	$(document).on("click", ".btnRemove", function(event)
	{
 		$.ajax(
 		{
 			url : "UserAPI",
 			type : "DELETE",
 			data : "id=" + $(this).data("id"),
 			dataType : "text",
 			complete : function(response, status)
 			{
 				onItemDeleteComplete(response.responseText, status);
 			}
 		});
	});


	function onItemDeleteComplete(response, status)
	{
		if (status == "success")
 		{
 			var resultSet = JSON.parse(response);
 			if (resultSet.status.trim() == "success")
 			{
 				$("#alertSuccess").text("Successfully deleted.");
 				$("#alertSuccess").show();
 				$("#divItemsGrid").html(resultSet.data);
 			} 
 			else if (resultSet.status.trim() == "error")
 			{
 				$("#alertError").text(resultSet.data);
 				$("#alertError").show();
 			}
 		} 
 		else if (status == "error")
 		{
 				$("#alertError").text("Error while deleting.");
 				$("#alertError").show();
 		} 
 		else
 		{
 				$("#alertError").text("Unknown error while deleting..");
 				$("#alertError").show();
 		}
}
	

	// CLIENT-MODEL================================================================
	function validateItemForm()
	{
		// Name
		if ($("#name").val().trim() == "")
		{
 			return "Insert Full Name.";
 		}

		// Email
		if ($("#email").val().trim() == "")
 		{
 			return "Insert Email Address.";
 		}

		// Password
		if ($("#pass").val().trim() == "")
 		{
 			return "Insert Password.";
 		}
		
		// Mobile
		if ($("#mobile").val().trim() == "")
 		{
 			return "Insert Mobile Number.";
 		}
		
		// Type
		if ($("#type").val().trim() == "")
 		{
 			return "Insert User Type.";
 		}
		

		return true;
	}