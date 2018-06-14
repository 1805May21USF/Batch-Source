// var jsonTest = '{'
//     + '"name" : "Bob Ross",'
//     + '"RID" : "1",'
//     + '"type" : "University Courses",'
//     + '"amount" : "$500",'
//     + '"status" : "Finished",'
//     + '"date" : "01-01-95"'
//     + '}';

// jsonTest = JSON.parse(jsonTest);

// var tableData = "<td>" + jsonTest.RID + "</td>" + "<td>" + jsonTest.type + "</td>"
//                 + "<td>" + jsonTest.amount + "</td>"
//                 + "<td>" + jsonTest.date + "</td>"
//                 + "<td>" + jsonTest.status + "</td>";
// console.log(tableData);

// var trElement = document.createElement("tr");
// trElement.innerHTML = tableData;
// var reimTable = document.getElementById("reim_table");
// while(tr)
// reimTable.appendChild(trElement.firstChild);

function readJSON() {
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if(xhr.readyState == 4 && xhr.status == 200) {
            var jsonObj = JSON.parse(xhr.responseURL);
            console.log(jsonObj);
            //document.getElementById("name").innerText = jsonObj.name;
        }
       // xhr.open("GET",'temp.json');
       //xhr.send();
    }
}

var xhr = new XMLHttpRequest();
xhr.onreadystatechange = function() {
    if(xhr.readyState == 4 && xhr.status == 200) {
        var jsonObj = JSON.parse(xhr.responseURL);
        console.log(jsonObj);
        //document.getElementById("name").innerText = jsonObj.name;
    }
   xhr.open("GET",'/dashboard');
   xhr.send();
}

window.onload = function() {

}