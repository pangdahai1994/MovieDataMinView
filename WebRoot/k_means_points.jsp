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
      <script src="js/highcharts-zh_CN.js"></script>
      <script src="js/highcharts.js"></script>
      <script src="js/highcharts-more.js"></script>
      <script src="js/exporting.js"></script>
      <!--[if lt IE 9]>
         <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
         <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
      <![endif]-->
<script>
$(function () {
    $('#kresultcontainer').highcharts({
        chart: {
            type: 'bubble',
            zoomType: 'xy'
        },
        title: {
            text: 'K=4时 聚类结果'
        },
        xAxis: {
        	max:0,
        	min:-200,
            gridLineWidth: 1
        },

        yAxis: {
        	max:80,
        	min:-100,
        	gridLineWidth: 1,

        },
        plotOptions: {
            bubble: {
                minSize: 150,
                maxSize: 340
            }
        },
        series: [{
            name:'聚类 1',
            // 每个气泡包含三个值，x，y，z；其中 x，y用于定位，z 用于计算气泡大小
            data: [[-135.4, -2.8,80]]
        }, {
            name:'聚类 2',
            data: [[-58.7, -48.4,60]]
        }, {
            name:'聚类 3',
            data: [[-54.4, 29.3,60]]
        },{
        	name:'聚类4',
            data: [[-24.4, -6.7,55]]
        }]
    });
});

</script>
</head>
<body>

<nav class="navbar navbar-default" role="navigation">
	<div class="container-fluid">
	<div class="navbar-header">
		<a class="navbar-brand" href="#">K-means</a>
	</div>
	<div>
		<ul class="nav navbar-nav">
			<li><a href="RankAction!movieRank">电影</a></li>
			<li><a href="RankAction!actorRank">演员</a></li>
			<li><a href="RankAction!directorRank">导演</a></li>
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
	
	<div class="jumbotron">
				<div id="kresultcontainer"   style="width: 1000px; height: 750px; margin: 0 auto">
				</div>
				</br>
				<p>
					 <a class="btn btn-primary btn-large" href="k_means.jsp">刷新</a>
				</p>
	</div>
</nav>

</body>
</html>