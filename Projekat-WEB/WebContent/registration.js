$(document).ready(function(){
	$('#regForma').submit(function(event){	
		let password1 = $('input[name=pass1]').val();
		let password2 = $('input[name=pass2]').val();
		if (password1 != password2){
			event.preventDefault();
			alert("Lozinke se ne poklapaju!");
		}
	});
});