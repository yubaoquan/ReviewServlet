function func1() {
	var sentence = document.getElementsByName("sentence")[0].value;
	//alert(sentence);
	var username = document.getElementById("username").innerHTML;
	var msg = "<p><strong>" + username + ":</strong>" + sentence + "</p>\n";
	sendMsg(msg);
}

function sendMsg(message) {
	var req = new XMLHttpRequest();
	message = encodeURI(message);
	message = encodeURI(message);
	req.open("POST", "../MessageDispatcher", false);
	req.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	req.onreadystatechange = function() {
		if ((req.status >= 200 && req.status < 300) || req.status == 304) {
			//alert(req.responseText);
			document.getElementById("content").innerHTML = req.responseText;
			document.getElementsByName("sentence")[0].value = "";
		} else {
			alert("Request was unsuccessful: " + req.status);
		}
	};
	//alert("message: " + message);
	req.send("sentence=" + message);
}

function refreshMsg() {
	var req = new XMLHttpRequest();
	req.open("GET", "../MessageDispatcher", false);
	req.setRequestHeader("Content-Type", "text/html;charset=UTF-8");
	req.onreadystatechange = function() {
		if ((req.status >= 200 && req.status < 300) || req.status == 304) {
			//alert(req.responseText);
			var messages = req.responseXML.getElementsByTagName("message");
			var msg2print = "";
			
			for (var i = 0; i < messages.length;i ++) {
				console.log(messages[i].childNodes[0].nodeValue);
				msg2print += messages[i].childNodes[0].nodeValue;
			}
			document.getElementById("content").innerHTML = msg2print;
			
			var usersOnline = req.responseXML.getElementsByTagName("user");
			var userOnline2print = "";
			for (var i = 0; i < usersOnline.length;i ++) {
				//console.log(usersOnline[i].childNodes[0].nodeValue);//
				userOnline2print += "<p>" + usersOnline[i].childNodes[0].nodeValue + "</p>";
			}
			document.getElementById("onlineUserDiv").innerHTML = userOnline2print;
			//console.log("onlineuser: " + userOnline2print);
		} else {
			alert("Request was unsuccessful: " + req.status);
		}
	};
	req.send("message=" + message);
	setTimeout('refreshMsg()',1000);
}