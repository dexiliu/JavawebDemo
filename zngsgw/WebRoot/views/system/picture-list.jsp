﻿<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><html>
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
<title>图片列表</title>
</head>
<body>
<nav class="breadcrumb"><i class="iconfont">&#xf012b;</i> 首页 <span class="c-gray en">&gt;</span> 图片库 <span class="c-gray en">&gt;</span> 图片列表 <a class="btn btn-success radius r mr-20" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="icon-refresh"></i></a></nav>
<div class="pd-20">
  <div class="text-c"> 日期范围：
    <input type="text" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'logmax\')||\'%y-%M-%d\'}'})" id="logmin" class="input-text Wdate" style="width:120px;">
    -
    <input type="text" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'logmin\')}',maxDate:'%y-%M-%d'})" id="logmax" class="input-text Wdate" style="width:120px;">
    <input type="text" name="" id="" placeholder=" 图片名称" style="width:250px" class="input-text">
    <button name="" id="" class="btn btn-success" type="submit"><i class="icon-search"></i> 搜图片</button>
  </div>
  <div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"><a href="javascript:;" onclick="datadel()" class="btn btn-danger radius"><i class="icon-trash"></i> 批量删除</a> <a class="btn btn-primary radius" onclick="picture_add('','','添加图片','picture-add.jsp')" href="javascript:;"><i class="icon-plus"></i> 添加图片</a></span> <span class="r">共有数据：<strong>54</strong> 条</span> </div>
  <table class="table table-border table-bordered table-bg table-hover table-sort">
    <thead>
      <tr class="text-c">
        <th width="40"><input name="" type="checkbox" value=""></th>
        <th width="80">ID</th>
        <th width="100">分类</th>
        <th width="150">封面</th>
        <th>图片名称</th>
        <th width="150">Tags</th>
        <th width="150">更新时间</th>
        <th width="60">发布状态</th>
        <th width="70">操作</th>
      </tr>
    </thead>
    <tbody>
      <tr class="text-c">
        <td><input name="" type="checkbox" value=""></td>
        <td>001</td>
        <td>分类名称</td>
        <td><a href="picture-show.html"><img class="picture-thumb" src="pic/200x150.jpg"></a></td>
        <td class="text-l"><a class="maincolor" href="picture-show.html">现代简约 白色 餐厅</a></td>
        <td class="text-c">标签</td>
        <td>2014-6-11 11:11:42</td>
        <td class="picture-status"><span class="label label-success">已发布</span></td>
        <td class="f-14 picture-manage"><a style="text-decoration:none" onClick="picture_xiajia(this,'10001')" href="javascript:;" title="下架"><i class="icon-hand-down"></i></a> <a style="text-decoration:none" class="ml-5" onClick="picture_edit('10001','','','图库编辑','picture-edit.jsp')" href="javascript:;" title="编辑"><i class="icon-edit"></i></a> <a style="text-decoration:none" class="ml-5" onClick="picture_del(this,'10001')" href="javascript:;" title="删除"><i class="icon-trash"></i></a></td>
      </tr>
    </tbody>
  </table>
  <div id="pageNav" class="pageNav"></div>
</div>
<script type="text/javascript" src="<%=basePath%>static/lib/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>static/lib/layer1.8/layer.min.js"></script>
<script type="text/javascript" src="<%=basePath%>static/lib/laypage/laypage.js"></script> 
<script type="text/javascript" src="<%=basePath%>static/lib/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="<%=basePath%>static/lib/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="<%=basePath%>static/js/H-ui.js"></script>
<script type="text/javascript" src="<%=basePath%>static/js/H-ui.admin.js"></script> 
<script type="text/javascript" src="<%=basePath%>static/js/H-ui.admin.doc.js"></script>
<script type="text/javascript">

$('.table-sort').dataTable({
	"lengthMenu":false,//显示数量选择 
	"bFilter": false,//过滤功能
	"bPaginate": false,//翻页信息
	"bInfo": false,//数量信息
	"aaSorting": [[ 1, "desc" ]],//默认第几个排序
	"bStateSave": true,//状态保存
	"aoColumnDefs": [
	  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
	  {"orderable":false,"aTargets":[0,8]}// 制定列不参与排序
	]
});
</script> 
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