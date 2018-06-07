// //alert("Roll Tide");
// var a = 10;
// var b,c,d,e,f,g,h,e;
// //loosely type
// b = "10";
// c = true;
// d = {};
// e = null;
// //f= ;
// g = (0/0);
// h = [ ];
// i = function() {};  

// function incrementA() {
//     a+=1;
//     return a;
// }
// // Type Coercion
// // == performs type coercion
// // === does not
// console.log("Hi"); //basically sysout
// console.log("5==5"); //true
// console.log(5==5); //true
// console.log(5===5); //true
// console.log(5=="5"); //true
// // console.log("weird"); 
// console.log(5==="5"); //false
// console.log(false==1); //false
// console.log(false==0); //true
// console.log(false === 0); //false
// console.log(true==1000000); //false
// console.log(7+7+'7'); //147
// console.log('7'+7+7); //777 all variables after string is variable

// //Objects
// var person = {name: "fred", age :87}
// person.gender="undefined";


// //Constructor
// function Person (name,age) {
//     this.name = name;
//     this.age = age;
// }
// //How to use constructor
// var matt = new Person("Matt",32);

// //Different construtor type thing
// function MakePerson (name,age) {
//     var p = {"name":name,"age":age};
//     return p;
// }

// //Arrays
// var arr=[10,20,30];
// arr[9]=5;



var name = 
(function () {
    var name = "";
    var fname = "Sunny";
    var lname = "Prasavath";
    function init() {
        addFirstName();
        addLastName();
    }

    function addFirstName() {
        name += fname + " "
    }

    function addLastName() {
        name +=  "Prasavath";
    }
    init();
    return name;
}());

var x = 10;
y = 8;
alert(x);
alert(y);
y = 5;

