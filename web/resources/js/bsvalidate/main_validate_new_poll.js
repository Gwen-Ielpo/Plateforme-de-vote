$(function(){

    var form = $('#connect');
    // Custom Messages
    form.bsValidate({
        fields:{

        },
        before: function(){
            form.find('.alert').remove();
        },
        success: function(e){
        }
    });
});
