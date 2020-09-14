function addNewUser(user) {
    let username = $('<td>'+ user.username +'</td>');
    let firstName = $('<td>'+ user.firstName +'</td>');
    let lastName = $('<td>'+ user.lastName +'</td>');
    let gender = $('<td>'+ user.gender +'</td>');
    let role = $('<td>'+ user.role +'</td>');

    let tr = $('<tr></tr>');
    tr.append(username).append(firstName).append(lastName).append(gender).append(role);
    $('#user-list-table tbody').append(tr);
}

$(document).ready(function(){

    // CLOSE MODAL
    $('.modal-header span').click(function() {
        $('#mod_pretraga').hide();
        $('#mod_amenities').hide();
    });

    $('#users_li').click(function() {
        clearWorkspace();

        $.ajax({
            type: "get",
            url: "rest/users",
            contentType: "application/json",
            success: function(users) {
                console.log(users);
                $('#user-list').show();
                $('#user-list-table tbody').empty();
                for(let user of users){
                    addNewUser(user);
                }
            }
        })
    });

    $('#search-user').on('input', function() {
        onSearchChange();
    });

    $( "#user-list-gender" ).change(function() {
        onSearchChange();
    });

    $( "#user-list-role" ).change(function() {
        onSearchChange();
    });

    $('#search_li').click(function() {
        $('#mod_pretraga').show();
    })

})

function onSearchChange() {
    let username = $('#search-user').val();
    let gender = $( "select#user-list-gender" ).val();
    let role = $( "select#user-list-role" ).val();

    if(username === "") {
        username = "empty_string";
    } 

    $.ajax({
        type: "get",
        url: "rest/users/search/"+username+"/"+gender+"/"+role,
        contentType: "application/json",
        success: function(users) {
            $('#user-list-table tbody').empty();
            for(let user of users){
                addNewUser(user);
            }
        }
    });
}