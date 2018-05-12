
function showWarningMessage(span) {
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
	let url = urlBuilder("rest", "updateKey", keyInput);
	sendReq("POST", url, true).then(function() {
		console.log("key updated");
	}).catch(function(e) {
		showWarningMessage($("#js-empty-key"));
	})
})

$("#js-cipher-message-button").click(function() {
	let cipherMessage = $("#js-cipher-message").val();
	let url = urlBuilder("rest", "encycrpt", cipherMessage);
	sendReq("GET", url, true).then(function(ret) {
		vmCipher.$data.ciphered = ret;
	});
});

$("#js-decipher-message-button").click(function() {
	let decipherMessage = $("#js-decipher-message").val();
	let url = urlBuilder("rest", "decycrpt", decipherMessage);
	sendReq("GET", url, true).then(function(ret) {
		vmDecipher.$data.deciphered = ret;
	});
})