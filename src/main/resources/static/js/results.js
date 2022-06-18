$(function() {

$("#courseid").blur(
		function() {
			$("#courseid_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#courseid").after("<span id='courseid_msg' style='color: red'>实训不能为空</span>");
			}
	});

$("#usersid").blur(
		function() {
			$("#usersid_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#usersid").after("<span id='usersid_msg' style='color: red'>学生不能为空</span>");
			}
	});

$("#score").blur(
		function() {
			$("#score_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#score").after("<span id='score_msg' style='color: red'>成绩不能为空</span>");
			}
	});

$("#topic").blur(
		function() {
			$("#topic_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#topic").after("<span id='topic_msg' style='color: red'>评语不能为空</span>");
			}
	});

$("#memo").blur(
		function() {
			$("#memo_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#memo").after("<span id='memo_msg' style='color: red'>备注不能为空</span>");
			}
	});







$('#sub').click(function(){
var courseid = $("#courseid").val();
var usersid = $("#usersid").val();
var score = $("#score").val();
var topic = $("#topic").val();
var memo = $("#memo").val();
$("#courseid_msg").empty();
$("#usersid_msg").empty();
$("#score_msg").empty();
$("#topic_msg").empty();
$("#memo_msg").empty();
if (courseid == "" || courseid == null) {
	$("#courseid").after("<span id='courseid_msg' style='color: red'>实训不能为空</span>");
	return false;
}
if (usersid == "" || usersid == null) {
	$("#usersid").after("<span id='usersid_msg' style='color: red'>学生不能为空</span>");
	return false;
}
if (score == "" || score == null) {
	$("#score").after("<span id='score_msg' style='color: red'>成绩不能为空</span>");
	return false;
}
if (topic == "" || topic == null) {
	$("#topic").after("<span id='topic_msg' style='color: red'>评语不能为空</span>");
	return false;
}
if (memo == "" || memo == null) {
	$("#memo").after("<span id='memo_msg' style='color: red'>备注不能为空</span>");
	return false;
}
});
$('#res').click(function() {
$("#courseid_msg").empty();
$("#usersid_msg").empty();
$("#score_msg").empty();
$("#topic_msg").empty();
$("#memo_msg").empty();
});

});
