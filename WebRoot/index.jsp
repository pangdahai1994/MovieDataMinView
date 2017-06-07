<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
   <head>
      <title>电影</title>
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <link href="css/bootstrap.min.css" rel="stylesheet">
      <link href="css/zfilm.css" rel="stylesheet">
      <script src="js/jquery.js"></script>
      <script src="js/bootstrap.min.js"></script>
      <!--[if lt IE 9]>
         <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
         <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
      <![endif]-->
   </head>
<body>

<nav class="navbar navbar-default" role="navigation">
	<div class="container-fluid">
	<div class="navbar-header">
		<a class="navbar-brand" href="#">数据展示</a>
	</div>
	<div>
		<ul class="nav navbar-nav">
			<li><a href="movies.jsp">电影</a></li>
			<li><a href="actors.jsp">演员</a></li>
			<li><a href="directors.jsp">导演</a></li>
			<li class="dropdown">
				<a href="#" class="dropdown-toggle" data-toggle="dropdown">
					数据展示
					<b class="caret"></b>
				</a>
				<ul class="dropdown-menu">
					<li><a href="#">K值曲线</a></li>
					<li><a href="#">观众聚类</a></li>
					<li><a href="#">用户分组</a></li>
					<li class="divider"></li>
					<li><a href="#">3D图</a></li>
					<li class="divider"></li>
					<li><a href="#">其他图</a></li>
				</ul>
			</li>
			<li class="dropdown">
				<a href="#" class="dropdown-toggle" data-toggle="dropdown">
					排行榜
					<b class="caret"></b>
				</a>
				<ul class="dropdown-menu">
					<li><a href="#">电影热度</a></li>
					<li><a href="#">观影人数</a></li>
					<li class="divider"></li>
					<li><a href="#">电影评分</a></li>
					<li><a href="#">导演评分</a></li>
					<li><a href="#">演员评分</a></li>
				</ul>
			</li>			
		</ul>
		<div class="search">
			<form class="navbar-form" action="movieAction!search" method="post">
            	<input type="text" class="form-control" placeholder="搜索电影">
            	<button type="button" class="btn">搜索</button>
			</form>
		</div>
	</div>
	</div>
</nav>

</body>
</html>