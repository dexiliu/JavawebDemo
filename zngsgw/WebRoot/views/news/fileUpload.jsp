<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	
    <base href="<%=basePath%>">
    
    <title>add user</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script type="text/javascript" src="<%=basePath%>js/jquery-1.7.2.js"></script>
	<script type="text/javascript">
		j=1;
		$(document).ready(function(){
			$("#btn_add2").click(function(){  
	            $("#newUpload2").innerHTML+='<div id="div_'+j+'"><input  name="file_'+j+'" type="file"  /><input type="button" value="删除"  onclick="del_2('+j+')"/></div>';  
	              j = j + 1;  
	        });  
		});
		function del_2(o){  
	         $("#newUpload2").removeChild(document.getElementById("div_"+o));  
	    }
	</script>
	
	<style type="text/css">
    .input {
        width: 80px;
        height: 20px;
        line-height: 20px;
        background: #0088ff;
        text-align: center;
        display: inline-block;
        overflow: hidden;
        position: relative;
        text-decoration: none;
        top: 5px;
    }
     
    .input:hover {
        background: #ff8800;
    }
     
    .file {
        opacity: 0;
        filter: alpha(opacity =     0);
        font-size: 50px;
        position: absolute;
        top: 0;
        right: 0;
    }
     
    a:link {
        text-decoration: none;
    }
    a:visited {
        text-decoration: none;
    }
    a:hover {
        color: #999999;
        text-decoration: underline;
    }
</style>
  </head>
  <body>
    <form action="news.do?upload" method="post" enctype="multipart/form-data">
    	<input type="file" name="file"/>
    	<input type="submit" name="submit" value="upload">
    </form>
    <br/>
    <hr/>
    <form action="news.do?getData" method="post">
    	<input type="submit" value="button">
    </form>
<!--     <form name="userForm2" action="news.do?upload2" method="post" enctype="multipart/form-data">
    	<div id="newUpload2">
    		<input type="file" name="file">
    		<input type="file" name="file1">
    	</div>
    	<input type="button" id="btn_add2" value="增加一行">
    	<input type="submit" value="upload">
    </form>
    
    <form action="news.do?upload2"
        enctype="multipart/form-data" method="post">
        <div>
            <input type="text" readonly="readonly" /> <a
                href="javascript:void(0);" class="input"> 浏览 <input type="file"
                class="file" name="filename1"> </a>
        </div>
        <div>
            <input type="text" readonly="readonly" /> <a
                href="javascript:void(0);" class="input"> 浏览 <input type="file"
                class="file" name="filename2"> </a>
        </div>
        <div>
            <input type="text" readonly="readonly" /> <a
                href="javascript:void(0);" class="input"> 浏览 <input type="file"
                class="file" name="filename3"> </a>
        </div>
        <input type="submit" value="上传">
    </form>
    <br />
    &nbsp;&nbsp;<a href="news.do?download">下载文件</a> -->
    
    <script type="text/javascript">
        var nodes = document.getElementsByTagName("input");
        for ( var i = 0; i < nodes.length; i++) {
            if("file" == nodes[i].type){
                nodes[i].onchange = function(){
                    var textObj = this.parentNode.parentNode.getElementsByTagName("input")[0];
                    var textvalue = this.value;
                    textvalue = textvalue.substring(textvalue.lastIndexOf("\\")+1, textvalue.length);
                    textObj.value = textvalue;
                };
            }
        }
    </script>
  </body>
</html>
