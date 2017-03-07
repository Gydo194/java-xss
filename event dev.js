var postdata = "default_postback";

function ack() {
    var ackReq = new XMLHttpRequest();
    ackReq.open("GET", "/ack.php",false);
    ackReq.send();
    
}




function getEventFileStatus() {
    console.log("getEventFileStatus() run");
    var eventreq = new XMLHttpRequest();
    eventreq.open("GET","/event.txt",false);
    eventreq.send();
    eventreq.onreadystatechange = function() {
        console.log(this.readyState);
        if(this.readyState == 4)
        {
            console.log("Running code because the file is found");
            //var script = document.createElement("script");
           // script.src = "/event.txt";
           // script.type = "application/javascript";
           // document.head.appendChild( script );
           // ack();
        }
        else
        {
            console.log("Eventfile not found, not executing hook code");
        }
    }
}

function postback(postdata) {
	var posturl = "/post.php?postback=" + postdata;
	console.log(posturl);
	var xmlHTTP = new XMLHttpRequest();
	xmlHTTP.open("GET", posturl, false);
	xmlHTTP.send();
};



setInterval(function(){getEventFileStatus()}, 500);
