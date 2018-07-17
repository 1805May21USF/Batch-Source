

window.onload = function () {
console.log("window onload");
var xhr2 = new XMLHttpRequest;
xhr2.open("GET","DBUserServlet",true);
xhr2.send();
xhr2.onreadystatechange = function() {
    if(xhr2.readyState == 4 && xhr2.status == 200) {
        var j = JSON.parse(xhr2.responseText);
        console.log(j);
        
        var name = j.firstName + " " + j.lastName + "!";
        console.log(name);
        document.getElementById("name").innerText = name;
        document.title = "Welcome, " + name;
        
              
    }
}

var xhr3 = new XMLHttpRequest;
xhr3.open("GET","DBDisplayServlet",true);
xhr3.send();
xhr3.onreadystatechange =  function() {
    if(xhr3.readyState == 4 && xhr3.status == 200) {
        var jrem = JSON.parse(xhr3.responseText);
        console.log(jrem);
        var fill = "<tr class=\"reim_row\"><th class=\"reim_header\">ID</th><th class=\"reim_header\">TYPE</th>"
        + "<th class=\"reim_header\">AMOUNT</th><th class=\"reim_header\">SUBMITTED</th><th class=\"reim_header\">STATUS</th></tr>";
        for(var i = 0; i < jrem.length; i++) {
            var tid = "<tr class=\"reim_row\"><td class=\"reim_td\">" + jrem[i].rid + "</td>";
            var ttype = "<td class=\"reim_td\">" + jrem[i].type + "</td>";
            var tamt = "<td class=\"reim_td\">" + jrem[i].amount + "</td>";
            var tsubmit = "<td class=\"reim_td\">" + jrem[i].startdate + "</td>";
            var tstatus = "<td class=\"reim_td\">" + jrem[i].status + "</td></tr>"
            fill += tid+ttype+tamt+tsubmit+tstatus;
        }
        remtable = document.getElementById("reim_table").innerHTML;
        //console.log(remtable);
        //console.log(fill);
        document.getElementById("reim_table").innerHTML = fill;
        //console.log("Finished");
        //console.log(jrem);
    }
}
}
