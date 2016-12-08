var postback = "";
function main() {


var script = document.createElement("script");
script.src = "/event.txt";
script.type = "application/javascript";
document.head.appendChild( script );
if(postback != null) {
	httprequest(postback);
};
};

function httprequest(value) {
	var xmlHTTP = new XMLHttpRequest();
	xmlHTTP.open("POST", "/post.php", false);
	xmlHTTP.send(value);
	return 0;
};



setInterval(function(){main()}, 8000)
