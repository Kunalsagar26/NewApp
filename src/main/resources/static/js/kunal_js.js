
$("#submitId").click(function()
{
	alert('this is submit function '+ email+"   "+pass);

	
	$.ajax({
   url: "url", 
   type: "POST",
   contentType: "application/json; charset=utf-8",
   data: { email: email, pass:pass },
   success: function (result) {
       // when call is sucessfull
    },
    error: function (err) {
    // check the err for error details
    }
 }); // ajax call closing



});



function ll(){
	
	
	alert('this is clicked');
	
   $.ajax({
   url: "/kpath/validateUser", 
   type: "POST",
   dataType: "json",
   contentType: "application/json; charset=utf-8",
   data: { email: "EMAIL", pass:"ss" },
   success: function (result) {
       // when call is sucessfull
    },
    error: function (err) {
    // check the err for error details
    }
 }); // ajax call closing



	
}






function login(){
	
	
	$.ajax('/kpath/validateUser',
			{
	    type: 'POST',  // http method
	    data: { 
	    	userid: "kunal",
	    	password:"pass",
	    	},  // data to submit
	    success: function (data, status, xhr) {
	       alert('SUCCESS');
	    },
	    error: function (jqXhr, textStatus, errorMessage) {
	    	alert('FAILED');
	    }
	});
}






