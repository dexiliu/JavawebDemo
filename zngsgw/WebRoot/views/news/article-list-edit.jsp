<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="<%=basePath%>static/lib/html5.js"></script>
<script type="text/javascript" src="<%=basePath%>static/lib/respond.min.js"></script>
<script type="text/javascript" src="<%=basePath%>static/lib/PIE_IE678.js"></script>
<![endif]-->
<link href="<%=basePath%>static/css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>static/css/H-ui.admin.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>static/css/style.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>static/lib/font-awesome/font-awesome.min.css" rel="stylesheet" type="text/css" />
<!--[if IE 7]>
<link href="<%=basePath%>static/lib/font-awesome/font-awesome-ie7.min.css" rel="stylesheet" type="text/css" />
<![endif]-->
<link href="<%=basePath%>static/lib/iconfont/iconfont.css" rel="stylesheet" type="text/css" />
<!--[if IE 6]>
<script type="text/javascript" src="<%=basePath%>static/lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>分类编辑</title>
</head>
<body>
<div class="pd-20">
  <form class="Huiform" action="/" method="post" id="form-article-class">
    上级栏目： <span class="select-box" style="width:150px">
    <select class="select" id="sel_Sub" name="sel_Sub" onchange="SetSubID(this);">
      <option value="0">顶级分类</option>
      <option value="100">分类一级</option>
      <option value="101">&nbsp;&nbsp;├ 分类二级</option>
      <option value="102">&nbsp;&nbsp;├ 分类二级</option>
      <option value="201">分类一级</option>
      <option value="101">&nbsp;&nbsp;├ 分类二级</option>
    </select>
    </span>
    <input type="hidden" id="hid_ccid" value="">
    排序：
    <input class="input-text text-c" style="width:50px" type="text" value="3" placeholder="排序" name="class-rank" id="class-rank">
    分类名：
    <input class="input-text" style="width:170px" type="text" value="二级分类" placeholder="输入分类" name="class-val" id="class-val">
    <div class="text-c mt-20">
      <button type="button" class="btn btn-success radius" id="" name="" onClick="class_save(this,'2');"><i class="icon-save"></i> 保存</button>
    </div>
  </form>
</div>
<script type="text/javascript" src="<%=basePath%>static/lib/jquery.min.js"></script> 
<script type="text/javascript" src="<%=basePath%>static/lib/Validform_v5.3.2.js"></script>
<script type="text/javascript" src="<%=basePath%>static/js/H-ui.js"></script> 
<script type="text/javascript" src="<%=basePath%>static/js/H-ui.admin.js"></script> 
<script type="text/javascript" src="<%=basePath%>static/js/H-ui.admin.doc.js"></script>
<script>
var _hmt = _hmt || [];
(function() {
  var hm = document.createElement("script");
  hm.src = "//hm.baidu.com/hm.js?080836300300be57b7f34f4b3e97d911";
  var s = document.getElementsByTagName("script")[0]; 
  s.parentNode.insertBefore(hm, s);
})();
var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://" : " http://");
document.write(unescape("%3Cscript src='" + _bdhmProtocol + "hm.baidu.com/h.js%3F080836300300be57b7f34f4b3e97d911' type='text/javascript'%3E%3C/script%3E"));
</script>
</body>
</html>