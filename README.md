# java-xss

An XSS franework written in Java, JavaScript and PHP.

It allows you to take over control over a "hooked" browser by issuing JavaScript commands.

the idea is to put a <script src= to the "event.js" file in the HTML source of a page, then visit it and issue a JS command in the XSS shell. use the postback() function to get the contents of the postdata variable. it is written to the postback.txt file. the XSS shell also dumps the postback database on every command.