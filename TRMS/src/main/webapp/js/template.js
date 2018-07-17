
var opner = document.getElementById('opener');
opner.addEventListener("click",openOrCloseSB);




function openOrCloseSB() {
    var move = document.getElementsByClassName('container');
    if(document.getElementById('sidebar').style.display == 'none') {
        document.getElementById('sidebar').style.display = 'block';
        move[0].style.marginLeft = '20%';
    
    } else {
        document.getElementById('sidebar').style.display = 'none';
        move[0].style.marginLeft = '0%';
    }
}