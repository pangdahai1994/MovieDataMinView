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
      <script src="js/exporting.js"></script>
      <!--[if lt IE 9]>
         <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
         <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
      <![endif]-->
<script>
$(function () {
	var adsChart;
	adsChart =new Highcharts.Chart({ 
        chart: { 
            renderTo: 'kresultcontainer', //图表放置的容器，DIV 
            defaultSeriesType: 'spline', //图表类型line(折线图), 
            zoomType: 'x'   //x轴方向可以缩放 
        }, 
        credits: { 
            enabled: false   //右下角不显示LOGO 
        }, 
        title: {
            text: 'K值-总距离变化趋势图'
        },
        subtitle: {
            text: '不同k值下点到聚类中心的距离之和'
        },
        xAxis: {
        	title: {
                text: 'K值'
            },
        },
        yAxis: {
            title: {
                text: '总距离'
            }
        },
        plotOptions: {
            line: {
                dataLabels: {
                    enabled: true          // 开启数据标签
                },
                enableMouseTracking: false // 关闭鼠标跟踪，对应的提示框、点击事件会失效
            }
        },
        series: [{
            name: '总距离',
            data: []
        }]
    });
    url="KresultAction!update";
    $.post(url, function(response) {
      response=$.parseJSON(response);
      distanceList = response.distanceList;
      kList = response.kList;
      adsChart.series[0].setData(distanceList);
      adsChart.xAxis[0].setCategories(kList);
    }, "json");
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
				<div id="kresultcontainer"   style="min-width: 400px; height: 500px; margin: 0 auto">
				</div>
				</br>
				<p>
					 <a class="btn btn-primary btn-large" href="k_means.jsp">刷新</a>
				</p>
	</div>
</nav>

</body>
</html>