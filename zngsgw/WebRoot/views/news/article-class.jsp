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
<title>分类管理</title>
</head>
<body>
<nav class="breadcrumb"><i class="iconfont">&#xf012b;</i> 首页 <span class="c-gray en">&gt;</span> 资讯管理 <span class="c-gray en">&gt;</span> 分类管理 <a class="btn btn-success radius r mr-20" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="icon-refresh"></i></a></nav>
<div class="pd-20 text-c">
  <form class="Huiform" action="/" method="post">
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
    <input class="input-text" style="width:250px" type="text" value="" placeholder="输入分类" id="article-class-val"><button type="button" class="btn btn-success" id="" name="" onClick="article_class_add(this);"><i class="icon-plus"></i> 添加</button>
  </form>
  <div class="article-class-list cl mt-20">
    <table class="table table-border table-bordered table-hover table-bg">
      <thead>
        <tr class="text-c">
          <th width="25"><input type="checkbox" name="" value=""></th>
          <th width="80">ID</th>
          <th width="80">排序</th>
          <th>分类名称</th>
          <th width="70">操作</th>
        </tr>
      </thead>
      <tbody>
        <tr class="text-c">
          <td><input type="checkbox" name="" value=""></td>
          <td>1</td>
          <td>1</td>
          <td class="text-l">一级分类</td>
          <td class="f-14"><a title="编辑" href="javascript:;" onclick="article_class_edit('1','620','160','分类编辑','article-class-edit.jsp')" style="text-decoration:none"><i class="icon-edit"></i></a> <a title="删除" href="javascript:;" onclick="article_class_del(this,'1')" class="ml-5" style="text-decoration:none"><i class="icon-trash"></i></a></td>
        </tr>
        <tr class="text-c">
          <td><input type="checkbox" name="" value=""></td>
          <td>2</td>
          <td>2</td>
          <td class="text-l">&nbsp;&nbsp;├&nbsp;二级分类</td>
          <td class="f-14"><a title="编辑" href="javascript:;" onclick="article_class_edit('2','620','160','分类编辑','article-class-edit.jsp')" style="text-decoration:none"><i class="icon-edit"></i></a> <a title="删除" href="javascript:;" onclick="article_class_del(this,'2')" class="ml-5" style="text-decoration:none"><i class="icon-trash"></i></a></td>
        </tr>
        <tr class="text-c">
          <td><input type="checkbox" name="" value=""></td>
          <td>3</td>
          <td>3</td>
          <td class="text-l">&nbsp;&nbsp;├&nbsp;二级分类</td>
          <td class="f-14"><a title="编辑" href="javascript:;" onclick="article_class_edit('3','620','160','分类编辑','article-class-edit.jsp')" style="text-decoration:none"><i class="icon-edit"></i></a> <a title="删除" href="javascript:;" onclick="article_class_del(this,'3')" class="ml-5" style="text-decoration:none"><i class="icon-trash"></i></a></td>
        </tr>
      </tbody>
    </table>
  </div>
</div>
<script type="text/javascript" src="<%=basePath%>static/lib/jquery.min.js"></script> 
<script type="text/javascript" src="<%=basePath%>static/lib/Validform_v5.3.2.js"></script> 
<script type="text/javascript" src="<%=basePath%>static/lib/layer1.8/layer.min.js"></script> 
<script type="text/javascript" src="<%=basePath%>static/lib/laypage/laypage.js"></script> 
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