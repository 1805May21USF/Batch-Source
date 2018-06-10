// alert("Roll Tide");
// var a = 10;
// var b,c,d,e,f,g,h,e;
// //Loosely Type - Dynamically Typed
// b="10";
// c=true;
// d={};
// e=null;
// //f=;
// g = (0/0);
// h=[];
// i=function(){};

// function incrementA(argument) {
// 	a+=1;
// 	return a;
// }
//Type Coercion
//== performs types coercion
//=== does not
// console.log("hi");
// console.log("5==5");
// console.log(5==5);
// console.log(5===5);
// console.log("weird");
// console.log(5=="5");
// console.log(5==="5");
// console.log(false==1);
// // console.log(false==0);
// console.log(false===0);
// console.log(false==-1000000);
// console.log(true==1000000);
// console.log(false=="false");
// console.log(false=="0");
// console.log(7+7+'7')
// //objects
// var person={name: "fred","age" : 87};
// person.gender="undefined";

// //constructor
// function Person (name, age) {
// 	this.name = name;
// 	this.age = age;
// }
// //how to use constructor
// var matt = new Person("matt",32);
// //Different constructor type thing
// function MakePerson(name, age){
// 	var p = {"name": name, "age":age};
// 	return p;
// }
// var arr = [10,20,30];
// arr[9] = 5;
// arr+=3;

//Closure
//Very similar to IIFE except it doesn't invoke immediately.
//Still used for some form of encapsulation.

//Example of param passing to IIFE
var wee = (function(hey) {
    return hey*5;
})(5);

//Hoisting - Useless and terrible practice
y=8; //Implicitly puts var before y
alert(y);
var y;