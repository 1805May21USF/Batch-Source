//YAY JAVASCRIPT YAY AJAX
var poke = [];
var count = 0;
function loadPokemon(){
	console.log();
	if(poke[0].height > poke[1].height) {
		document.getElementById("name").innerHTML = poke[0].name+" "+poke[0].height+" is taller than "+poke[1].name;
	}
	else{
		document.getElementById("name").innerHTML=poke[1].name+" "+poke[1].height+" is taller than "+poke[0].name;
	}
};

function firstStep(){
	var pokemonId1 = document.getElementById("pokeId1").value;
	var pokemonId2 = document.getElementById("pokeId2").value;
	var poke1 = getPokemon(pokemonId1);
	var poke2 = getPokemon(pokemonId2);
	//loadPokemon(poke1,poke2);
}

function getPokemon(pokemonId){
	console.log("in getPokemon");
	var pokemonId1 = pokemonId;
	//Step 1: 
	var xhr1 = new XMLHttpRequest();
	//Step 2 function to handle onreadystatechange of response
	xhr1.onreadystatechange=function(){
		console.log("Roll Tide1");
		//Need both conditionals!
		if(xhr1.readyState == 4 && xhr1.status == 200){
			console.log(xhr1.responseText);
			poke.push(JSON.parse(xhr1.responseText));
			count++;
			if(count == 2){
				loadPokemon();
			}
		}
	}
	// xhr2.onreadystatechange=function(){
	// 	console.log("Roll Tide2");
	// 	//Need both conditionals!
	// 	if(xhr2.readyState == 4 && xhr2.status == 200){
	// 		console.log(xhr2.responseText);
	// 		var pokemon = JSON.parse(xhr2.responseText);
	// 		loadPokemon(pokemon);
	// 	}
	// }

	//Step 3 open the request/connection
	xhr1.open("GET", "https://pokeapi.co/api/v2/pokemon/"+pokemonId1,true);
	//Step 4 - Send request
	xhr1.send();
}

window.onload = function (){
	console.log("in onLoad");
	//false means Bubbling~
	document.getElementById("pokemonSubmit").addEventListener("click", firstStep, false);
}