function waitThreeSecs(){
    var ms = 5000 + new Date().getTime();
    while(new Date() < ms){}
    console.log('funcao de dely acabou');
}
function clickHandler(){
    console.log('evento de click');
}

//add um listenes pra click
document.addEventListener('click', clickHandler);

waitThreeSecs();
console.log(' fim de execucao do escopo glibal');
