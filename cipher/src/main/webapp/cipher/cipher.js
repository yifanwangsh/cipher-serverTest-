var Abase = "A".charCodeAt(0);

function encycrptChar(charA, charB) {
  let num1 = charA.charCodeAt(0) - Abase;
  let num2 = charB.charCodeAt(0) - Abase;
  return (num1 + num2)%26;
}

function encycrpt(message) {
  let mChar = message.split("");
  let encycrpted = new Array(0);
  let ci = 0;
  mChar.forEach(function(c) {
    if (c === " ") {
      encycrpted.push(c);
      return;
    }
    let num = encycrptChar(c.toUpperCase(), key[ci]);
    let push = String.fromCharCode(num + Abase);
    encycrpted.push(push)
    ci++;
    if (key[ci] == undefined) ci=0;
  })
  return encycrpted.join("");
}
