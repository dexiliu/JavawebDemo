// select or cancel all checkboxes
function selectAll(selectall, ids) {
	var selectall = document.getElementById(selectall);
	var checkboxes = document.getElementsByName(ids);

    for(var i = 0; i < checkboxes.length; i++){
       if(selectall.checked){
    	   checkboxes[i].checked = true;
       }else{
    	   checkboxes[i].checked = false;
       }
    }
}