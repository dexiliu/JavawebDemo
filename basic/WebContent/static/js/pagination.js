function submitWithoutNumber() {
	$("#qp_number").val(1);
	document.form1.submit();
}

function onPrev() {
	var number = $("#qp_number").val();
	$("#qp_number").val(number - 1);
	document.form1.submit();
}
function goPage(number) {
	$("#qp_number").val(number);
	document.form1.submit();
}
function onNext() {
	var number = $("#qp_number").val();
	$("#qp_number").val(Number(number) + 1);
	document.form1.submit();
}

