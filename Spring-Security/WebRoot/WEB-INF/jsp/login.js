var pagination = function() {
	return {
		login:function(){
			var user=$("#j_username").val();
			var pass=$("#j_password").val();
			if(user==""){
				alert("please input the username");
				$("user").focus();
				return false;
			}
			if(pass==""){
				alert("please input the password");
				$("pass").focus();
				return false;
			}
			
			$.ajax( {
				type : "POST",
				url : "j_spring_security_check",
				data : "j_username=" + user + "&j_password=" + pass,

				success : function() {
					location.href ='jsp/commonpage.jsp';
			      }
			});
		}
	}
}();