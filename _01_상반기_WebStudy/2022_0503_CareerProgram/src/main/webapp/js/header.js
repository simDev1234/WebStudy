/*
 Header 영역 
 */

/* 햄버거 버튼이 눌렸는지 여부 */
var bMenuOn = false;
var menuIcon = document.getElementById("hamberger");

$(document).ready(function(){
   /* 메뉴 숨김 */
   $("#menu").hide();
});

/* showMenu() 호출 시, 메뉴 보임/숨김 */
function showMenu(){
   if (bMenuOn == false){
       $('.navi_menu').css("visibility","hidden");
       $('#insertRecruitTable .w3-button').css("visibility","hidden");
	   $("#menu").show();
	   $("#hamberger > img").attr("src","image/close.png");
   }else{
       $('.navi_menu').css("visibility","visible");
       $('#insertRecruitTable .w3-button').css("visibility","visible");
	   $("#menu").hide();
	   $("#hamberger > img").attr("src","image/menu.png");
   }
   
   bMenuOn = !bMenuOn;
}