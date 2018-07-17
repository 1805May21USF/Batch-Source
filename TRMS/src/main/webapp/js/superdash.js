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
    xhr3.open("GET","SuperDislayDBServlet",true);
    xhr3.send();
    xhr3.onreadystatechange =  function() {
        if(xhr3.readyState == 4 && xhr3.status == 200) {
            var jrem = JSON.parse(xhr3.responseText);
            console.log(jrem);
            var fill = "<tr class=\"reim_row\">"
            +"<th class=\"reim_header\">NAME</th>"
            + "<th class=\"reim_header\">RID</th>"
            // + "<th class=\"reim_header\">GRADE</th>"
            + "<th class=\"reim_header\">AMOUNT</th>"
            + "<th class=\"reim_header\">DATE</th>"
            + "<th class=\"reim_header\">APPROVE/DENY</th></tr>";
            for(var i = 0; i < jrem.length; i++) {
                var tname = "<tr class=\"reim_row\"><td class=\"reim_td\">" + jrem[i].name + "</td>";
                var tid = "<td class=\"reim_td\">" + jrem[i].rid + "</td>";
                //var tgrade = "<td class=\"reim_td\">" + jrem[i].grade + "</td>";
                var tamount = "<td class=\"reim_td\">" + jrem[i].amount + "</td>";
                var tstartdate = "<td class=\"reim_td\">" + jrem[i].date + "</td>";
                var buttons = "<td class=\"reim_btns\"><button id=\"approveBtn" +jrem[i].rid+"\">Approve</button> "
                 + "<button id=\"denyBtn" +i+"\">Deny</button></td></tr>"
                fill += tname+tid+tamount+tstartdate+buttons;
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
    