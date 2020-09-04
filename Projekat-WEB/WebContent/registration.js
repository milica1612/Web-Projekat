$(document).ready(function(){
	$('#regForma').submit(function(event){	
		let password1 = $('input[name=pass1]').val();
		let password2 = $('input[name=pass2]').val();
		if (password1 != password2){
			event.preventDefault();
			alert("Lozinke se ne poklapaju!");
		}
		
		let username = $('input[name="username"]').val();
		let name = $('input[name="name"]').val();
		let lastName = $('input[name="lastName"]').val();
		let gender = $('input[name="gender"]').val();
		
		$.post({
			url: '/registration',
			data: JSON.stringify({username:username, password:password1, firstName:name,
								  lastName:lastName, gender:gender}), 
			contentType: 'application/json',
			success: function(user){
				alert("Uspješna registracija!");
			},
			error: function(message){
				alert("Došlo je do greške prilikom registracije!");
			}
		});
		
	});
});