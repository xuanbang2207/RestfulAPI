$(document).ready(function () {
    getAllEmployer();
    

    $('#saveEmployer').show();
    $('#updateEmployer').hide();
    $('#idfield').hide();
    

    $('#saveEmployer').click(function (e) { 
        e.preventDefault();
       
        $.ajax({
            type: "POST",
            url: "/create",
            contentType: "application/json",
            data : JSON.stringify({
                name :   $('#name').val(),
                password :   $('#password').val(),
                email :   $('#email').val(),
                address :   $('#address').val()
            }),
            dataType: "JSON",
            success: function (response) {
                console.log(response);
                // alert('Thêm mới thành công')
              $('#employerForm')[0].reset()
               getAllEmployer();
            },
            error : function(err){ 
             alert('Error: ' + err.responseJSON.message )
                console.log(err.responseJSON.message);
            }
        });
    
    });
    
    $('#updateEmployer').click(function (e) { 
        e.preventDefault();
        var id = $('#id').val();
        $.ajax({
            type: "PUT",
            contentType: "application/json",
            dataType: "json",
            url: "/update/" + id,
            data : JSON.stringify({
                name :   $('#name').val(),
                password :   $('#password').val(),
                email :   $('#email').val(),
                address :   $('#address').val()
            }),
            success: function (response) {
                $('#employerForm')[0].reset();
                getAllEmployer();

                $('#saveEmployer').show();
                $('#updateEmployer').hide();
                $('#idfield').hide();
                $('#title').text('Add Employer Form');
            },
            
        });
       
        
        
    });

    $('#my-input').keyup(function (e) { 
        e.preventDefault();
     
        $.ajax({
            type: "GET",
            contentType: "application/json",
            dataType: "json",
            url: "/search",
            data: {
                keyword : $('#my-input').val()
            },
            success: function (response) {
                data = response
                $('.tr').remove();
                data.forEach(item => {
                   
                    $('#tableEmployer').append(`
                    <tr class="tr">
                        <td >`+ item.id +`</td>
                        <td>` + item.name +`</td>
                        <td>`+ item.email +`</td>
                        <td>`+ item.address +`</td>
                        <td><a  class="btn btn-outline-primary" onclick="editEmployer(` + item.id + `)" ><i class="fa fa-edit"></i></a></td>
                        <td><a  class="btn btn-outline-danger" onclick="deleteEmployer(` + item.id + `)"><i class="fa fa-recycle"></a></td>
                    </tr>
                    `);
                });
            }
        });
    });

});

var data = "";
function getAllEmployer() {
   
    $.ajax({
        type: "GET",
        url: "getAll",
        success: function (response) {
            data = response
            $('.tr').remove();
            data.forEach(item => {
               
                $('#tableEmployer').append(`
                <tr class="tr">
                    <td >`+ item.id +`</td>
                    <td>` + item.name +`</td>
                    <td>`+ item.email +`</td>
                    <td>`+ item.address +`</td>
                    <td><a  class="btn btn-outline-primary" onclick="editEmployer(` + item.id + `)" ><i class="fa fa-edit"></i></a></td>
                    <td><a  class="btn btn-outline-danger" onclick="deleteEmployer(` + item.id + `)"><i class="fa fa-recycle"></a></td>
                </tr>
                `);
            });
        }
       });
};

function editEmployer(id) {
    $.ajax({
        type: "GET",
        url: "/by/" + id,
        dataType: "json",
        success: function (response) {
            $('#id').val(response.id);
            $('#name').val(response.name);
            $('#password').val(response.password);
            $('#email').val(response.email);
            $('#address').val(response.address);

            $('#saveEmployer').hide();
            $('#updateEmployer').show();
            $('#idfield').show();
            $('#title').text('Edit Empolyer');
        },
        error : function(err){
            alert('Error: ' + err.responseJSON.message )
        }
    });
};

function deleteEmployer(id) {
    $.ajax({
        type: "DELETE",
        url: "/delete/" + id,
        success : function(response) {
            $('#idfield').hide();
            getAllEmployer()
            alert(response);
            
        },
        error : function(err){
            alert('Error: ' + err.responseJSON.message )
        }
    });
    
}

