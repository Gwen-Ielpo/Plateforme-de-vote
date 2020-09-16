$(function(){

    var form = $('#connect');
    // Custom Messages
    form.bsValidate({
        fields:{
            ids: {
                required: {
                    helpText: "Veuillez entrer votre pseudonyme ou votre adresse e-mail.",
                    alert: "Un identifiant doit être indiqué."
                }
            },

            pwd: {
                required: {
                    helpText: "Veuillez entrer votre mot de passe.",
                    alert: "Un mot de passe doit être indiqué."
                }
            }
        },
        before: function(){
            form.find('.alert').remove();
        },
        success: function(e){
        }
    });
});
