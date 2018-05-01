var Abase = "A".charCodeAt(0);

function decycrptChar(charA, charB) {
  let num1 = charA.charCodeAt(0) - Abase;
  let num2 = charB.charCodeAt(0) - Abase;
  if (num1 - num2 >= 0) {
    return String.fromCharCode(num1-num2+Abase);
  }
  else return String.fromCharCode(num1-num2+26+Abase);
}

function decycrpt(ciphered) {
  let cChar = ciphered.split("");
  let decycrpted = new Array(0);
  let ci = 0;
  cChar.forEach(function(c) {
    if (c ===" ") {
      decycrpted.push(c);
      return;
    }
    let push = decycrptChar(c, key[ci]);
    decycrpted.push(push);
    ci++;
    if (key[ci] == undefined) ci=0;
  })
  return decycrpted.join("")
}
