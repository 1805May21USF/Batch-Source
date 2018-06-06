//alert("Roll Tide");
var a = 10;
var b,c,d,e,f,g,h,e;

b = "10";
c = true;
d = {};
e = null;
//f = ;
g = (0/0);
h = [];
var i = function(){};

function incrementA(){
	a+=1;
	return a;
}
//Type Coercion
//== does it.
//=== dont.

//console.log("hi");
//console.log("5==5");
//console.log(5==5);
//console.log(5===5);
//console.log("weird");
//console.log(5=="5");
//console.log(5==="5");
//console.log(false==1);
//console.log(false==0);
//console.log(false===0);
//console.log(false ==-10000000);
//console.log(true === 1000000);
//console.log(false=="0");
//console.log('7'+7+7);

var person={"name":"fred",
"age": 87};
person.gender = "undefined";

function Person(name,age){
this.name = name;
this.age = age;
}
var matt = new Person("matt",32);

function MakePerson(name,age){
	var p = {"name":name,
		"age":age};
	return p;
}

var arr = [10,20,30];
arr[9]=5;


