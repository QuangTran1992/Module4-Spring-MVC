function square(number) {
  var result = number * number;
  return result;
}
// var squareOf2 = square(2);
// document.write("square 2 is " + squareOf2 + "<br/>");

// var squareOf5 = square(5);
// document.write("square 5 is " + squareOf5);
function calculate() {
  var input = document.getElementById("input").value;
  var result = input * input;
  document.getElementById("result").innerHTML = result;
}
