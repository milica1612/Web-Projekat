function listAmenitie(amenitie) {
    let name = $('<td>'+ amenitie.name +'</td>');
    let edit = $('<td>' + '<button class="btnSelect" type="submit" >EDIT</button>' + '</td>');
    let ddelete = $('<td>' + '<button class="btnSelect" type="submit" >DELETE</button>' + '</td>');
    
    let tr = $('<tr></tr>');
    tr.append(name).append(edit).append(ddelete);
    $('#amenities-list-table tbody').append(tr);

}  

$(document).ready(function(){

        $('#add_new_amenitie_li').click(function() {
            clearWorkspace();

            $.ajax({
                type: "get",
                url: "rest/amenities/all",
                contentType: "application/json",
                success: function(amenities) {
                    console.log(amenities);
                    $('#amenities-list').show();
                    $('#amenities-list-table').show();
                    $('#amenities-list-table tbody').empty();
                    $('#div_dodavanje_sadrzaja').show();
                    	for(let amenitie of amenities){
                    		listAmenitie(amenitie);
                    	}
                }
            })
        });
        
        $('#btn_add_amenitie_submit').click(function(){
                event.preventDefault();
                var name = $('input[name="add_amentie"]').val();
          
                var object = {
                      "name" : name
                   }
                console.log(name);
          
                $.ajax({
                   type: 'post',
                   url: 'rest/amenities',
                   contentType: 'application/json',
                   data: JSON.stringify(object),         
                   success: function(response) {
                	
                	   clearWorkspace();

                       $.ajax({
                           type: "get",
                           url: "rest/amenities/all",
                           contentType: "application/json",
                           success: function(amenities) {
                               console.log(amenities);
                               $('#amenities-list').show();
                               $('#amenities-list-table').show();
                               $('#amenities-list-table tbody').empty();
                               $('#div_dodavanje_sadrzaja').show();
                               	for(let amenitie of amenities){
                               		listAmenitie(amenitie);
                               	}
                           }
                       })
                       
                      console.log(response);
                      alert("Successfully added amenitie!");
                   }
                });
       });            
});
