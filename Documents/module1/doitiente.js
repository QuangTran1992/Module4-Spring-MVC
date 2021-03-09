function Amount() {
  let Amount = document.getElementById("Amount").value;

  let VND;

  VND = parseInt(Amount) / 23000;

  document.getElementById("result").innerHTML = "USD la " + VND;
}
