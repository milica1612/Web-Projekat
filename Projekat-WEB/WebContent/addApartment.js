function putInTable(amenitie) {
    let name = $('<td>'+ amenitie.name +'</td>');
    let checkboxx = $('<td>' + '<input type="checkbox" id="check" value="' + amenitie.name + '"' + '</td>');
    let tr = $('<tr></tr>');
    tr.append(name).append(checkboxx);
    $('#amenities-list-table-modal tbody').append(tr);

}

$(document).ready(function() {

    $('#add_amenties_ap').click(function() {
    	$('#mod_amenities').show();
            $.ajax({
                type: "get",
                url: "rest/amenities/all",
                contentType: "application/json",
                success: function(amenities) {
                    console.log(amenities);
                    $('#amenities-list-table-modal tbody').empty();
                    for(let amenitie of amenities){
                    	putInTable(amenitie);
                    }
                    let tr = '<tr><td colspan = "2"><input type="submit" id="btn_add_amenities_to_apartment" text-align: center;" value=" Submit "></td></tr>';
                    $('#amenities-list-table-modal tbody').append(tr);
                }
            
            })
       
    });
    
    

    
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