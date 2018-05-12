
function showMessage(span) {
	span.fadeIn();
	let promise = new Promise(function(resolve, reject) {
		setTimeout(resolve, 2000);
	});
	promise.then(function() {
		span.fadeOut();
	})
}

$("#js-key-enter-button").click(function() {
	let keyInput = $("#js-key-enter").val();
	if (keyInput == "") keyInput = "!";
	
	let url = urlBuilder("rest", "updateKey", keyInput);
	sendReq("POST", url, true).then(function() {
		showMessage($("#js-key-updated"));
	}).catch(function(e) {
		showMessage($("#js-empty-key"));
	})
})

$("#js-cipher-message-button").click(function() {
	let cipherMessage = $("#js-cipher-message").val();
	let url = urlBuilder("rest", "encycrpt", cipherMessage);
	sendReq("GET", url, true).then(function(ret) {
		vmCipher.$data.ciphered = ret;
	}).catch(function(e) {
		showMessage($("#js-illegal-cipher-message"));
	})
});

$("#js-decipher-message-button").click(function() {
	let decipherMessage = $("#js-decipher-message").val();
	let url = urlBuilder("rest", "decycrpt", decipherMessage);
	sendReq("GET", url, true).then(function(ret) {
		vmDecipher.$data.deciphered = ret;
	});
})