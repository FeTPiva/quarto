
var Tony = {
    firstname: 'tony',
    lastname: 'alicea',
    address:{
        street:'11 main st.',
        city: 'new york',
        state:'ny'
    }
    idade: function(){return 10;}
};

function greet(person){
    console.log('hi' + person.firstname);
}

greet(Tony);