$.ajax({
   url: "url", 
   type: "POST",
   dataType: "json",
   contentType: "application/json; charset=utf-8",
   data: JSON.stringify({ name: 'value1', email: 'value2' }),
   success: function (result) {
       // when call is sucessfull
    },
    error: function (err) {
    // check the err for error details
    }
 }); // ajax call closing