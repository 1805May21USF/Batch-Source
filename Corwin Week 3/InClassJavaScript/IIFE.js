(function () {
    console.log("I execute immediatly");
})();

(()=>{
    console.log("I also execute immediatly");
})();

var variablerun = (function(){
    console.log("I dont get saved to a variable");
    return 10;
})();

(function (){
    var canttouchthis = 10;
})();


