﻿<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
<![endif]--><title>角色编辑</title>
</head>
<body>
<div class="pd-20">
  <form class="Huiform" id="form-role-add" action="" method="post">
    <table class="table table-border table-bordered table-bg">
      <tbody>
        <tr>
          <th class="text-r" width="80">角色名称：</th>
          <td><input name="oldpassword" type="text" class="input-text" id="" value="超级管理员" datatype="*1-20" nullmsg="角色名称不能为空！"> 
          </td>
        </tr>
        <tr>
          <th class="text-r va-t">权限：</th>
          <td>
            <table class="table table-border table-bordered table-bg">
              <tbody>
                <tr>
                  <th width="70">用户管理（会员）</th>
                  <td class="permission-list">
               
                    <div class="cl">
                    <label class="item"><input name="" type="checkbox" value=""> 添加</label>
                    <label class="item"><input name="" type="checkbox" value=""> 删除</label>
                    <label class="item"><input name="" type="checkbox" value=""> 编辑</label>
                    <label class="item"><input name="" type="checkbox" value=""> 排序</label>
                    </div>
         
                    <div class="cl">
                    <label class="item"><input name="" type="checkbox" value=""> 查看</label></div>
                  </td>
                </tr>
                <tr>
                  <th>资讯管理</th>
                  <td class="permission-list">
                    <div class="cl">
                      <b class="item">分类：</b>
                      <label class="item"><input name="" type="checkbox" value=""> 添加</label>
                      <label class="item"><input name="" type="checkbox" value=""> 删除</label>
                      <label class="item"><input name="" type="checkbox" value=""> 编辑</label>
                      <label class="item"><input name="" type="checkbox" value=""> 查看</label>
                    </div>
                    <div class="cl">
                      <b class="item">资讯：</b>
                      <label class="item"><input name="" type="checkbox" value=""> 添加</label>
                      <label class="item"><input name="" type="checkbox" value=""> 删除</label>
                      <label class="item"><input name="" type="checkbox" value=""> 编辑</label>
                      <label class="item"><input name="" type="checkbox" value=""> 查看</label>
                    </div>
                    <div class="cl"><label class="item c-orange"><input name="" type="checkbox" value=""> 只能操作自己发布的</label></div>
                  </td>
                </tr>
                <tr>
                  <th>图片库</th>
                  <td class="permission-list">
                    <div class="cl">
                      <b class="item">分类：</b>
                      <label class="item"><input name="" type="checkbox" value=""> 添加</label>
                      <label class="item"><input name="" type="checkbox" value=""> 删除</label>
                      <label class="item"><input name="" type="checkbox" value=""> 编辑</label>
                      <label class="item"><input name="" type="checkbox" value=""> 查看</label>
                    </div>
                    <div class="cl">
                      <b class="item">图片：</b>
                      <label class="item"><input name="" type="checkbox" value=""> 添加</label>
                      <label class="item"><input name="" type="checkbox" value=""> 删除</label>
                      <label class="item"><input name="" type="checkbox" value=""> 编辑</label>
                      <label class="item"><input name="" type="checkbox" value=""> 查看</label>
                    </div>
                    <div class="cl"><label class="item c-orange"><input name="" type="checkbox" value=""> 只能操作自己发布的</label></div>
                  </td>
                </tr>
                <tr>
                  <th>产品库</th>
                  <td class="permission-list">
                    <div class="cl">
                      <b class="item">分类：</b>
                      <label class="item"><input name="" type="checkbox" value=""> 添加</label>
                      <label class="item"><input name="" type="checkbox" value=""> 删除</label>
                      <label class="item"><input name="" type="checkbox" value=""> 编辑</label>
                      <label class="item"><input name="" type="checkbox" value=""> 查看</label>
                    </div>
                    <div class="cl">
                      <b class="item">产品：</b>
                      <label class="item"><input name="" type="checkbox" value=""> 添加</label>
                      <label class="item"><input name="" type="checkbox" value=""> 删除</label>
                      <label class="item"><input name="" type="checkbox" value=""> 编辑</label>
                      <label class="item"><input name="" type="checkbox" value=""> 查看</label>
                    </div>
                    <div class="cl"><label class="item c-orange"><input name="" type="checkbox" value=""> 只能操作自己发布的</label></div>
                  </td>
                </tr>
                <tr>
                  <th>页面管理</th>
                  <td class="permission-list">
                    <label class="item"><input name="" type="checkbox" value=""> 添加</label>
                    <label class="item"><input name="" type="checkbox" value=""> 删除</label>
                    <label class="item"><input name="" type="checkbox" value=""> 编辑</label>
                    <label class="item"><input name="" type="checkbox" value=""> 查看</label>
                  </td>
                </tr>
                <tr>
                  <th>管理员管理</th>
                  <td class="permission-list">
                    <label class="item"><input name="" type="checkbox" value=""> 管理员添加</label>
                    <label class="item"><input name="" type="checkbox" value=""> 管理员删除</label>
                    <label class="item"><input name="" type="checkbox" value=""> 权限编辑</label>
                    <label class="item"><input name="" type="checkbox" value=""> 角色编辑</label>
                  </td>
                </tr>
                <tr>
                  <th>系统管理</th>
                  <td class="permission-list">
                    <label class="item"><input name="" type="checkbox" value=""> 基本设置</label>
                    <label class="item"><input name="" type="checkbox" value=""> 栏目设置</label>
                    <label class="item"><input name="" type="checkbox" value=""> 数据字典</label>
                    <label class="item"><input name="" type="checkbox" value=""> 系统日志</label>
                  </td>
                </tr>
                <tr>
                  <th>统计管理</th>
                  <td class="permission-list">
                    <label class="item"><input name="" type="checkbox" value=""> 产看</label>
                  </td>
                </tr>
              </tbody>
            </table>
          </td>
        </tr>
        <tr>
          <th class="text-r va-t">描述：</th>
          <td><textarea name="newpassword" class="textarea" id="newpassword" placeholder="描述下角色所具有的权限"></textarea> 
          </td>
        </tr>
        
        <tr>
          <th></th>
          <td>
            <button type="submit" class="btn btn-success radius" id="admin-role-save" name="admin-role-save"><i class="icon-ok"></i> 确定</button>
          </td>
        </tr>
      </tbody>
    </table>
  </form>
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