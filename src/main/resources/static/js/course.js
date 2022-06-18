$(function() {

$("#cno").blur(
		function() {
			$("#cno_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#cno").after("<span id='cno_msg' style='color: red'>课程号不能为空</span>");
			}
	});

$("#coursename").blur(
		function() {
			$("#coursename_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#coursename").after("<span id='coursename_msg' style='color: red'>课程名称不能为空</span>");
			}
	});

$("#cateid").blur(
		function() {
			$("#cateid_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#cateid").after("<span id='cateid_msg' style='color: red'>课程类型不能为空</span>");
			}
	});

$("#clazzid").blur(
		function() {
			$("#clazzid_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#clazzid").after("<span id='clazzid_msg' style='color: red'>班级不能为空</span>");
			}
	});

$("#teacherid").blur(
		function() {
			$("#teacherid_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#teacherid").after("<span id='teacherid_msg' style='color: red'>带队老师不能为空</span>");
			}
	});

$("#thestart").blur(
		function() {
			$("#thestart_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#thestart").after("<span id='thestart_msg' style='color: red'>开始日期不能为空</span>");
			}
	});

$("#theend").blur(
		function() {
			$("#theend_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#theend").after("<span id='theend_msg' style='color: red'>结束日期不能为空</span>");
			}
	});

$("#address").blur(
		function() {
			$("#address_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#address").after("<span id='address_msg' style='color: red'>实训地址不能为空</span>");
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
var cno = $("#cno").val();
var coursename = $("#coursename").val();
var cateid = $("#cateid").val();
var clazzid = $("#clazzid").val();
var teacherid = $("#teacherid").val();
var thestart = $("#thestart").val();
var theend = $("#theend").val();
var address = $("#address").val();
var memo = $("#memo").val();
$("#cno_msg").empty();
$("#coursename_msg").empty();
$("#cateid_msg").empty();
$("#clazzid_msg").empty();
$("#teacherid_msg").empty();
$("#thestart_msg").empty();
$("#theend_msg").empty();
$("#address_msg").empty();
$("#memo_msg").empty();
if (cno == "" || cno == null) {
	$("#cno").after("<span id='cno_msg' style='color: red'>课程号不能为空</span>");
	return false;
}
if (coursename == "" || coursename == null) {
	$("#coursename").after("<span id='coursename_msg' style='color: red'>课程名称不能为空</span>");
	return false;
}
if (cateid == "" || cateid == null) {
	$("#cateid").after("<span id='cateid_msg' style='color: red'>课程类型不能为空</span>");
	return false;
}
if (clazzid == "" || clazzid == null) {
	$("#clazzid").after("<span id='clazzid_msg' style='color: red'>班级不能为空</span>");
	return false;
}
if (teacherid == "" || teacherid == null) {
	$("#teacherid").after("<span id='teacherid_msg' style='color: red'>带队老师不能为空</span>");
	return false;
}
if (thestart == "" || thestart == null) {
	$("#thestart").after("<span id='thestart_msg' style='color: red'>开始日期不能为空</span>");
	return false;
}
if (theend == "" || theend == null) {
	$("#theend").after("<span id='theend_msg' style='color: red'>结束日期不能为空</span>");
	return false;
}
if (address == "" || address == null) {
	$("#address").after("<span id='address_msg' style='color: red'>实训地址不能为空</span>");
	return false;
}
if (memo == "" || memo == null) {
	$("#memo").after("<span id='memo_msg' style='color: red'>备注不能为空</span>");
	return false;
}
});
$('#res').click(function() {
$("#cno_msg").empty();
$("#coursename_msg").empty();
$("#cateid_msg").empty();
$("#clazzid_msg").empty();
$("#teacherid_msg").empty();
$("#thestart_msg").empty();
$("#theend_msg").empty();
$("#address_msg").empty();
$("#memo_msg").empty();
});

});
