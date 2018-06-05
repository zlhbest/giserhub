$(document).ready(function(){
    var url = "http://39.106.181.120:8080/giserhub/Userlogin";
    jQuery.ajax({
        type:"post",
        url:url,
        async:true,
        data:{},
        contentType:"application/x-www-form-urlencoded",
        success: function(data,textStatus){

            console.log(data[11]=="0")
            if(data[11]=="0"){


            }
            else {
                $("#guests").hide();
                $("#user").show()
            }
        },
        error: function(xhr,status,errMsg){
            alert("操作失败!");
        }
    });
});

// $('#exampleModal').on('show.bs.modal', function (event) {
//     var button = $(event.relatedTarget) // Button that triggered the modal
//     var recipient = button.data('whatever') // Extract info from data-* attributes
//     // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
//     // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
//     var modal = $(this)
//     modal.find('.modal-title').text('New message to ' + recipient)
//     modal.find('.modal-body input').val(recipient)
// })