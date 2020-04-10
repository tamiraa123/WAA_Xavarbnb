 var contextRoot = "/" + window.location.pathname.split( '/' )[1];
function makeAjaxCall(id){
	console.log("@@@hihihi"+id);
	console.log(contextRoot + '/users/id?id='+id);
	$.ajax({

		type: 'GET',
		url: contextRoot + '/users/id',
		data:{id:id},
		
		success: function(user) {
			console.log(user.person.personImage)
			$('#formInput').html("");

			$("#formInput").append("<H3 align='center'>" + user.person.firstName + "'s Information <H3>"); 
			$("#formInput").append("<img align='center' src='data:image/jpeg;base64," + user.person.personImage + "'/>");
			$('#formInput').append("<H4 align='center'>First Name:  " +  user.person.firstName + "</h4>"  );
			$('#formInput').append("<H4 align='center'>Last Name:  " +  user.person.lastName + "</h4>"  );
			$('#formInput').append("<H4 align='center'>Email:  " +  user.email + "</h4>"  );
			$('#formInput').append("<H4 align='center'>Date of birth:  " +  user.person.dob.year +"-"+ user.person.dob.monthValue+"-"+user.person.dob.dayOfMonth +"</h4>"  );
			$('#formInput').append("<H4 align='center'>Username:  " +  user.userCredentials.username + "</h4>"  );
			$('#formInput').append('<h4 align="center"> <a href="#" onclick="toggle_visibility(\'formInput\');resetForm(\'formInput\');"><b>EXIT</b> </a> </h4>');
			make_visible('formInput');
			make_hidden('errors');
		},

		error: function(errorObject){	
			console.log("amjiltgui")
			if (errorObject.responseJSON.errorType == "ValidationError") {
	 			$('#formInput').html("");
	 			$('#errors').html("");
	 			$("#errors").append( '<H3 align="center"> Error(s)!! <H3>');                
	  			    var errorList = errorObject.responseJSON.errors;
	 	 	        $.each(errorList,  function(i,error) {			   
	 		    		$("#errors").append( error.message + '<br>');
			    	});
	 	 	        $("#errors").append( '</p>');
	 	 	        $('#errors').show();
	 	 	      $("#errors").append('<h4 align="center"> <a href="#" onclick="toggle_visibility(\'errors\');resetForm(\'errors\');"><b>EXIT</b> </a> </h4>');
	 				
	 	 	      make_hidden('formInput');
			}
			else {
				alert(errorObject.responseJSON.errors(0));   // "non" Validation Error
			}
		}
	
	});
}

function amenitySubmit(){
       var dataToSend = JSON.stringify(serializeObject($('#amenityForm')));
     $.ajax({       
        type: 'POST',
        url: contextRoot + '/property/addAmenity',
        dataType: "json",           // Accept header
        data: dataToSend,
        contentType: 'application/json',   // Sends - Content-type
        success: function(amenity){
            $('#errors').html("");
            $("#result").append( '<H3 align="center"> OKAY!! <H3>');                
            $('#result').show();
            console.log(dataToSend.propertyId);
            $("#tbl_amenities").append(`<tr><td>${amenity.name}</td><td>${amenity.description}</td></tr>`);
        },
  
        error: function(errorObject ){  
//          error: function(jqXHR,  textStatus,  HTTPStatus ){  
// jqXHR = jQuery XMLHttpRequest superset of  XMLHttpRequest
//  EXAMPLE values:     error: function(jQuery XMLHttpRequest,  "error",  "Bad Request" ){  
//  see http://api.jquery.com/jquery.ajax/
             
            if (errorObject.responseJSON.errorType == "ValidationError") {
                $('#success').html("");
                $('#errors').html("");
                $("#errors").append( '<H3 align="center"> Error(s)!! <H3>');                
                    $("#result").append( '<p>');
         
                    var errorList = errorObject.responseJSON.errors;
                    $.each(errorList,  function(i,error) {             
                        $("#errors").append( error.message + '<br>');
                    });
                    $("#errors").append( '</p>');
                    $('#result').show();
            }
            else {
                alert(errorObject.responseJSON.errors(0));   // "non" Validation Error
            }
        }
    });
}
  
resetForm = function(id) {
    var element = document.getElementById(id);
    $(element)[0].reset();
    }     
 
make_hidden = function(id) {
    var e = document.getElementById(id);
        e.style.display = 'none';
        }      
 
make_visible = function(id) {
    var e = document.getElementById(id);
    e.style.display = 'block';
 }     
 
// Translate form to array
// Then put in JSON format
 function serializeObject (form)
{
    var jsonObject = {};
    var array = form.serializeArray();
    $.each(array, function() {
            jsonObject[this.name] = this.value;
    });
    return jsonObject;
};

