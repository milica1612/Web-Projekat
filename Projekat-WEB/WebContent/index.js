function clearWorkspace(){
    $('#div_prijava').hide();
    $('#dugme_reg').hide();
    $('#div_registracija').hide();
    $('#user-profile').hide();
    $('#user-list').hide();
 //   $('#logout_li').hide();
 //   $('login_li').show();
 //   $('users_li').show();
}

activeUser = null;

$(document).ready(function(){
	$('login_li').show();
	$('users_li').show();
	$('#logout_li').hide();
	console.log('document index ready');
    
    $('#btn_reg').click(function(){
        clearWorkspace();
        $('#div_registracija').show();
        $('#login_li').show();
    });

    $('#login_li').click(function() {
        clearWorkspace();
        $('#div_prijava').show();
        $('#dugme_reg').show();
    });
    

    $('#btn_login_submit').click(function(){
    	$('#login_li').hide();
        $('#logout_li').show();
        console.log('submit');
        event.preventDefault();
        var username = $('input[name="username"]').val();
        var password = $('input[name="password"]').val();
  
        if(!username){
           $('#errLogin').text('Please fill Username field');
           event.preventDefault();
           return;
        }
        else if(!password) {
          $('#errLogin').text('Please fill Password field');
          event.preventDefault();
          return;
        }
        else{
           var object = {
              "username" : username,
              "password" : password
           }
        }
  
        $.ajax({
           type: 'post',
           url: 'rest/login',
           contentType: 'application/json',
           data: JSON.stringify(object),         
           success: function(response) {
              console.log(response);
              activeUser = response;
              showFuncByRole(response.role);
              alert("Successfully login!");
           }
        });
     });
    
    $('#logout_li').click(function(){
 	   clearWorkspace();
        $('#div_prijava').show();
        $('#dugme_reg').show();
        $('#login_li').show();
        $('#logout_li').hide();
        $.ajax({
     	   type: 'get',
     	   url: 'rest/logout',
     	   contentType: 'application/json',
     	   success: function(response) {
     		   console.log(response);
                activeUser = null;
                alert("Successfully logout!");
     	   }
        });
    });

});


function showFuncByRole(userRole){
    clearWorkspace();
    if(userRole === "ADMIN") {
        $('#search_li').hide();
    } else if(userRole === "HOST") {
        $('#users_li').hide();
        $('#search_li').hide();
    } else {
        $('#users_li').hide();
        $('#search_li').hide();
    }
}