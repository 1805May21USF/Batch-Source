//alert("Hello World");
var a = 10;
var b, c, d, e, f, g, f;
//Testing variables
b = "10";
c=true;
d = {}; // An object
f = 40;
g = (0/0); //NaN
h = []; //Empty array
// A function
i = function(){
    return alert("hiii");
};

function incrementA() {
    a += 1;
    return a
}

//Type Coecrion -  the conversion of one type of object
// to a new object of a different type with similar content. 

//console.log("Hello!!!");

// console.log(7+7+'7'); //147
// console.log('7'+7+7); //777

// //Objects
// var person={name: "fred", "age": 87} // A person object
// person.gender= "undefined"; // You can add an variable to a person object later


// //Constructor
// function Person (name,age) {
//     this.name = name;
//     this.age = age;
// }
// //Different constructor
// var matt = new Person("matt", 32);

// function makePerson(name,age){ 
//     var p = {"name":name, "age":age};
//     return p;
// }


// //Arrays
// var arr=[10,20,30];
// arr[9] = 5;


//---------IIFE--------------------
// Create an anonymous function expression that gets invoked immediately,
// and assign its *return value* to a variable. This approach "cuts out the
// middleman" of the named `makeWhatever` function reference.
// 
// As explained in the above "important note," even though parens are not
// required around this function expression, they should still be used as a
// matter of convention to help clarify that the variable is being set to
// the function's *result* and not the function itself.

// var counter = (function(){
//     var i = 0;
  
//     return {
//       get: function(){
//         return i;
//       },
//       set: function( val ){
//         i = val;
//       },
//       increment: function() {
//         return ++i;
//       }
//     };
//   }());
  
//   // `counter` is an object with properties, which in this case happen to be
//   // methods.
  
//   counter.get(); // 0
//   counter.set( 3 );
//   counter.increment(); // 4
//   counter.increment(); // 5
  
//   counter.i; // undefined (`i` is not a property of the returned object)
//   i; // ReferenceError: i is not defined (it only exists inside the closure)


//-----------HOISTING-------------------
// y = 9;

// alert(y);

// y = 4;

sayIt = "Roll Tide";
console.log(sayIt);
var sayIt;