/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


//var imageinput=document.getElementById("input-icon");
//var previewImage=document.getElementById("preview-img");
//
//imageinput.addEventListener("change", function(event){
//  if(event.target.files.length==0){
//      return;
//      }  
//    var tempUrl=URL.createObjectURL(event.target.files[0]);
//    previewImage.setAttribute("src",tempUrl);
//});


function showImage(event) {

    var imageinput = document.getElementById("input-icon");
    var previewImage = document.getElementById("preview-img");

    var tempUrl = URL.createObjectURL(event.target.files[0]);
    if (tempUrl.length == 0) {
        previewImage.setAttribute("src", "https://as1.ftcdn.net/v2/jpg/03/46/83/96/1000_F_346839683_6nAPzbhpSkIpb8pmAwufkC7c5eD7wYws.jpg");

        return;
    }else{
    previewImage.setAttribute("src", tempUrl);
    }
}