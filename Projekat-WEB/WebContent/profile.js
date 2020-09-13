$(document).ready(function() {

    $('#profile_li').click(function() {
        clearWorkspace();
        $.ajax({
            type: "get",
            url: "rest/users/active",
            contentType: "application/json",
            success: function(user) {
                console.log(user);
                $('#user-profile').show();
                $('#user-profile-table-username').val(user.username);
                $('#user-profile-table-password').val(user.password);
                $('#user-profile-table-firstName').val(user.firstName);
                $('#user-profile-table-lastName').val(user.lastName);
                if(user.gender === "MALE") {
                    $("#profileMale").prop("checked", true);
                } else {
                    $("#profileFemale").prop("checked", true);
                }
            }
        })
    });

    $('#user-profile-table-send').click(function() {
        let username = $('#user-profile-table-username').val();
        let password = $('#user-profile-table-password').val();
        let firstName = $('#user-profile-table-firstName').val();
        let lastName = $('#user-profile-table-lastName').val();
        let maleRadio = $('#profileMale').is(':checked');
        let gender = 'MALE';
        if(!maleRadio) {
            gender = 'FEMALE';
        }

        // validacija...
        let editObj = {
            "username" : username,
            "password" : password,
            "firstName" : firstName,
            "lastName" : lastName,
            "gender" : gender
        }
        console.log(editObj);

        $.ajax({
            type: "put",
            url: "rest/users/"+username,
            data: JSON.stringify(editObj),
            contentType: "application/json",
            success: function(user) {
                console.log(user);
                alert('Uspesna izmena profila.');
            }
        })
    })

})