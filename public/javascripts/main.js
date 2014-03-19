$(document).ready(function(){
	adjust();
	$("#msg-view").animate({scrollTop:99999}, 0);
	$("#post-form").focus();

	$(window).resize(function(){
		adjust();
	})
	function adjust(){
		var h = $(window).height();
		var h1= $('#post-view').height();
		$("#msg-view").height(h - h1);
	}
});