//TODO
var getNewAlertInterval = 10000;
var getNewMessageInterval = 10000;

var alertTimeout = setInterval(getNewAlert, getNewAlertInterval);
var messageTimeout = setInterval(getNewMessage, getNewMessageInterval);


document.addEventListener("DOMContentLoaded", function() {
	getNewAlert();
	getNewMessage();
	$.ajax({
		type: "POST",
		url: "/user/post",
		headers: {
			"X-CSRF-TOKEN": $("input[name='_csrf']").val()
		},
		error: function(e) {
			if (e.status == 403) {
				location.reload();
			}
		}
	});
});

function getNewAlert() {
	$.ajax({
		type: "GET",
		url: "/user/status/new-alert",
		headers: {
			"X-CSRF-TOKEN": $("input[name='_csrf']").val()
		},
		success: function(bool) {
			if (bool) {
				$("#nav-alerts").addClass("new");
				//				clearTimeout(alertTimeout);
			}
		},
		error: function(e) {
			console.log(e);
			clearTimeout(alertTimeout);
			if (e.status == 403) {
				location.reload();
			}
		}
	});
}

function getNewMessage() {
	$.ajax({
		type: "GET",
		url: "/user/status/new-message",
		headers: {
			"X-CSRF-TOKEN": $("input[name='_csrf']").val()
		},
		success: function(bool) {
			if (bool) {
				$("#nav-chats").addClass("new");
				//				clearTimeout(messageTimeout);
			}
		},
		error: function(e) {
			console.log(e);
			clearTimeout(messageTimeout);
		}
	});
}
