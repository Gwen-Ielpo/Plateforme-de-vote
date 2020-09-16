
    $(document).ready(function() {
    var wrapper         = $(".dynamicInput"); //Fields wrapper
    var add_button      = $(".btn-add-field"); //Add button ID
    var counter = 3 ;
    var x = 2; //initial text box count
    $(add_button).click(function(e){ //on add input button click
        e.preventDefault();
            x++; //text box increment
            var newChoice = "<div id='choice_" + (counter) +"' class='form-group'><label for='choice"+counter+"'>Choix supplémentaire</label><div class='input-group'><input type='text' class='form-control' placeholder='Votre nouveau Choix' name='choice"+counter+"'id='choice"+counter+"'><div class='input-group-btn'><button type='button' class='btn btn-default remove_field'> <i class='glyphicon glyphicon-minus'></i></button></div></div></div>" ;
            $(wrapper).append(newChoice); //add input box
            counter++;
    });

    $(wrapper).on("click",".remove_field", function(e){ //user click on remove text
        e.preventDefault();
        $(this).parent('div').parent('div').parent('div').remove();
        x--;
    })
});

/*
<- A GENERER !  UN NAME ET UN ID ! ->
                    <div id="choice2" class="form-group">
                        <label for="Choice2"> Choix 2</label>
                        <div class="input-group">                                                                                                                                              +
                            <input type="text" class="form-control" placeholder="Votre nouveau choix" name="Choice2" id="Choice2">
                            <div class="input-group-btn">
                                <button type="button" class="btn btn-default remove_field"> <i class="glyphicon glyphicon-minus"></i></button>
                            </div>
                        </div>
                    </div>
 */