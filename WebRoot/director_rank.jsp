<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
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


<style type="text/css">
    #table1 {border: 3px solid white}
</style>
<script type="text/javascript">
function num(i) {
	var n = i.toFixed(1);
	alert(n);
	return n;
}
</script>

</head>
<body>

<nav class="navbar navbar-default" role="navigation">
	<div class="container-fluid">
	<div class="navbar-header">
		<a class="navbar-brand" href="#">数据展示</a>
	</div>
	<div>
		<ul class="nav navbar-nav">
			<li><a href="RankAction!movieRank">电影</a></li>
			<li><a href="RankAction!actorRank">演员</a></li>
			<li class="active"><a href="RankAction!directorRank">导演</a></li>
			<li class="dropdown">
				<a href="#" class="dropdown-toggle" data-toggle="dropdown">
					数据展示
					<b class="caret"></b>
				</a>
				<ul class="dropdown-menu">
					<li><a href="k_means.jsp">K值曲线</a></li>
					<li><a href="#">观众聚类</a></li>
					<li><a href="#">用户分组</a></li>
					<li class="divider"></li>
					<li><a href="#">3D图</a></li>
					<li class="divider"></li>
					<li><a href="#">其他图</a></li>
				</ul>
			</li>
		</ul>
	</div>
	</div>
	
</nav>
<div class="container-fluid">
<div class="col-xs-4">
	<div class="jumbotron">
	    <table class="table table-striped" id="table1">
	        <p class="text-center">导演热度榜</p>
	        <thead>
	            <tr>
	                <th>导演名</th>
	                <th>导演热度</th>
	            </tr>
	        </thead>
	        <tbody>
	            <s:iterator value="topredudirectors" id="column">
				    <tr>
    			    	<td><s:property value="dname"/></td>
     			    	<td><s:property value="totalscore"/></td>
     			    </tr>
     		    </s:iterator>
	        </tbody>
		</table>
	</div>
</div>
<div class="col-xs-4">
	<div class="jumbotron">
	    <table class="table table-striped" id="table1">
	        <p class="text-center">导演人气榜</p>
	        <thead>
	            <tr>
	                <th>导演名</th>
	                <th>导演人气</th>
	            </tr>
	        </thead>
	        <tbody>
	            <s:iterator value="topwatcherdirectors" id="column">
				    <tr>
    			    	<td><s:property value="dname"/></td>
     			    	<td><s:property value="fans"/></td>
     			    </tr>
     		    </s:iterator>
	        </tbody>
		</table>
	</div>
</div>
<div class="col-xs-4">
	<div class="jumbotron">
	    <table class="table table-striped" id="table1">
	        <p class="text-center">导演评分榜</p>
	        <thead>
	            <tr>
	                <th>导演名</th>
	                <th>导演评分</th>
	            </tr>
	        </thead>
	        <tbody>
	            <s:iterator value="topscoredirectors" id="column">
				    <tr>
    			    	<td><s:property value="dname"/></td>
     			    	<td><s:property value="averagescore"/></td>
     			    </tr>
     		    </s:iterator>
	        </tbody>
		</table>
	</div>
</div>
</div>
</body>
</html>