$(document).ready(function() {

    $('#add_amenties_ap').click(function() {
        $('#mod_amenities').show();
    })

    
    $('#btn_add_apartment_submit').click(function(){
    /*	$('#login_li').hide();
        $('#logout_li').show();*/
        console.log('submit');
        event.preventDefault();
        var numberOfRooms = $('input[name="number_rooms"]').val();
        var numberOfGuests = $('input[name="number_guests"]').val();
        var cost = $('input[name="cost_per_night"]').val();
  
      /*  if(!username){
           $('#errLogin').text('Please fill Username field');
           event.preventDefault();
           return;
        }
        else if(!password) {
          $('#errLogin').text('Please fill Password field');
          event.preventDefault();
          return;
        }
        else{*/
           var object = {
              "roomNumber" : numberOfRooms,
              "numberOfGuests" : numberOfGuests,
              "price" : cost
           }
        //}
  
        $.ajax({
           type: 'post',
           url: 'rest/apartments',
           contentType: 'application/json',
           data: JSON.stringify(object),         
           success: function(response) {
              console.log(response);
              activeUser = response;
              alert("Successfully added apartment!");
           }
        });
     });
});