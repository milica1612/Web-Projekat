function listApartments(apartment) {
    let type = $('<td>'+ apartment.type +'</td>');
    let  rNumber = $('<td>'+ apartment.roomNumber +'</td>');
    let gNumber = $('<td>'+ apartment.numberOfGuests +'</td>');
 //   let address = $('<td>'+ apartment. ' ' ' + ' ' +'</td>');
    let price = $('<td>'+ apartment.price +'</td>');
    let res = $('<td>' + '<button id = "' + apartment.id + '" class="btnReservation" type="submit">RESERVE</button>' + '</td>');
    
    let tr = $('<tr></tr>');
    tr.append(type).append(rNumber).append(gNumber).append(price).append("").append(res);
    $('#apartments-list-table tbody').append(tr);
}  

$(document).ready(function(){

    $('#apartments').click(function() {
        clearWorkspace();

        $.ajax({
            type: "get",
            url: "rest/apartments/all",
            contentType: "application/json",
            success: function(apartments) {
                console.log(apartments);
                $('#apartments-list').show();
                $('#apartments-list-table').show();
                $('#apartments-list-table tbody').empty();
                	for(let apartment of apartments){
                		listApartments(apartment);
                	}
            }
        })
    });
});