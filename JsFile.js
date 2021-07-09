$(function () {
  // ON SELECTING ROW
  $(".gfgselect").click(function () {
//FINDING ELEMENTS OF ROWS AND STORING THEM IN VARIABLES
    var a =$(this).parents("tr").find(".gfgusername").text();
    var c =$(this).parents("tr").find(".gfgpp").text();
    var d =$(this).parents("tr").find(".gfgscores").text();
    var p = "";
    // CREATING DATA TO SHOW ON MODEL
    p +="<p id='a' name='GFGusername' >Account No: "+ a + " </p>";
    p +="<p id='c' name='GFGpp'>Name: "+ c + "</p>";
    p +="<p id='d' name='GFGscores' >Current Balance: "+ d + " </p>";
    //CLEARING THE PREFILLED DATA
    $("#divGFG").empty();
    //WRITING THE DATA ON MODEL
    $("#divGFG").append(p);
  });

});
function myFunction1() {
  var r = confirm("Are you sure you want to cancel the trasaction?\n"+"Press Ok to confirm");
  if (r == true) {
document.getElementById("form1").action;
return true;
} else {
return false;
  }
}
function myFunction2() {
  var r = confirm("Are you sure you want to cancel the trasaction?\n"+"Press Ok to confirm");
  if (r == true) {
document.getElementById("form2").action;
return true;
} else {
return false;
  }
}
function myFunction3() {
  var r = confirm("Are you sure you want to cancel the trasaction?\n"+"Press Ok to confirm");
  if (r == true) {
window.location.href="./HomePage.html";
return true;
} else {
return false;
  }
}
 function show()
  {
    var c=document.getElementById("c");
    var d=c.innerHTML;
    const arr=d.split(" ")
    localStorage.setItem("name",arr[1]+ " "+arr[2]);
    location.href="./Transfer.html";
}
function show2(d)
{
  document.getElementById("fname").value=localStorage.getItem("name");
}
