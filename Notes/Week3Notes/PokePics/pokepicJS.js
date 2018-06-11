function loadPokemon(pokemon){
    document.getElementById("name").innerHTML=pokemon.name;
    document.getElementById("sprites").innerHTML=pokemon.sprites.front_default;

    function getPokemon(){
        console.log("in getPokemon");
        var pokemonId= document.getElementById("pokeId").value;
        //Step 1
        var xhr =  new XMLHttpRequest();
        //Step 2 function to handle onreadystatechange of response
        xhr.onreadystatechange=function (){
            console.log("roll tide");
            if(xhr.readyState ==4 && xhr.status ==200){
                console.log(xhr.responseText);
                var pokemon= JSON.parse(xhr.responseText);
                loadPokemon(pokemon);
                xhr.open("GET", "https://pokeapi.co/api/v2/pokemon/" + pokemonId,true);
                xhr.send();
            }
        }
    }
    
    window.onload =  function (){
        console.log("in onLoad");
        document.getElementById("pokemonSubmit").addEventListener("click", getPokemon, false);
    }
 }