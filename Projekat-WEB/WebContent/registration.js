$(document).ready(function(){
    console.log('document ready');
    
	$('#forma_reg').submit(function(event){
        event.preventDefault();
    
        var username = $('input[name="username_reg"]').val();
        var password = $('input[name="password_reg"]').val();
        var rePassword = $('input[name="password_reg1"]').val();
        var ime = $('input[name="ime_reg"]').val();
        var prezime = $('input[name="prezime_reg"]').val();
        var gender = $('input[name="gender"]:checked').val();

        var validno = true;
        if(!username){
            $('#errReg').text('Username field is required');
            $('input[name="username_reg"]').focus();
            validno = false;
        }
        else if(!password){
            $('#errReg').text('Password field is required');
            $('input[name="password_reg"]').focus();
            validno = false;
        }
        else if(!rePassword){
            $('#errReg').text('Repeated Password field is required');
            $('input[name="password_reg1"]').focus();
            validno = false;
        }
        else if(password !== rePassword) {
            $('#errReg').text('Passwords must match!');
            validno = false;
        }
        else if(!ime){
            $('#errReg').text('First Name field is required');
            $('input[name="ime_reg"]').focus();
            validno = false;
        }
        else if(!prezime){
            $('#errReg').text('Last Name field is required');
            $('input[name="prezime_reg"]').focus();
            validno = false;
        }
        else if(!gender) {
            $('#errReg').text('Please check gender field');
            validno = false;
        }

        console.log(username+" "+password+" "+ime+" "+prezime+" "+gender);
        if(validno == true){
        $('#errReg').text('');
        var object = {
            "username" : username,
            "password" : password,
            "firstName" : ime,
            "lastName" : prezime,
            "gender" : gender
        }

        console.log(object);
            
        $.ajax({
            type: 'post',
            url: 'rest/registration',
            contentType: 'application/json',
            data: JSON.stringify(object),          
            success: function(response) {
                    alert("User "+ response +" is successfully created!");
            }
        });
    
        }
    
        event.preventDefault();    
    });
});