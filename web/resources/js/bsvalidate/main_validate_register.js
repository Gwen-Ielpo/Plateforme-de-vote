$(function(){

    var form = $('#registerUser');
    // Custom Messages
    form.bsValidate({
        fields:{
            pseudo: {
                required: {
                    helpText: "Veuillez entrer un pseudonyme. Il sera visible par tous les utilisateurs.",
                    alert: "Un pseudonyme est obligatoire pour l'inscription."
                }
            },
            email: {
                required: {
                    helpText: "Veuillez indiquer une adresse mail valide.",
                    alert: "Une adresse mail est obligatoire pour l'inscription."
                },
                email: {
                    helpText: "L'adresse mail entrée n'est pas valide.",
                    alert: "Veuillez indiquer une adresse mail valide."
                }
            },
            pwd: {
                required: {
                    helpText: "Veuillez entrer un mot de passe valide d'au moins 8 caractères",
                    alert: "Un mot de passe est obligatoire pour l'inscription."
                }
            },
            pwdConfirm: {
                required: {
                    helpText: "Confirmez votre mot de passe. ",
                    alert: "La confirmation du mot de passe est obligatoire pour l'inscription.",
                    dependency: {
                        isNotBlank: 'pwd'
                    }
                },
                match: {
                    field: "pwd",
                    helpText: "Les deux champs ne concordent pas.",
                    alert: "Veuillez reconfirmez votre mot de passe."
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
