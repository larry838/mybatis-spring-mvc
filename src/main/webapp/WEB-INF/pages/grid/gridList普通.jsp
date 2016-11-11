<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head>
	<title>DLShouWen Grid - 示例</title>
	<meta name="Keywords" content="DLShouWen Grid"/>
	<meta name="Description" content=""/>
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" />
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="format-detection" content="telephone=no">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
	<!-- favicon -->
	<link rel="icon" href="resources/images/favicon.ico" type="image/x-icon" />
	<!-- jQuery -->
	<script type="text/javascript" src="resources/jquery/jquery-2.2.3.min.js"></script>
	<!-- bootstrap -->
	<script type="text/javascript" src="resources/bootstrap/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="resources/bootstrap/css/bootstrap.min.css" />
	<!--[if lt IE 9]> 
	    <script src="resources/bootstrap/plugins/ie/html5shiv.js"></script> 
	    <script src="resources/bootstrap/plugins/ie/respond.js"></script> 
	<![endif]-->
	<!--[if lt IE 8]> 
	    <script src="resources/bootstrap/plugins/ie/json2.js"></script> 
	<![endif]-->
	<!-- font-awesome -->
	<link rel="stylesheet" type="text/css" href="resources/fontAwesome/css/font-awesome.min.css" media="all" />
	<!-- DLShouWen Grid -->
	<script type="text/javascript" src="resources/dlshouwen/js/dlshouwen.grid.js"></script>
	<script type="text/javascript" src="resources/dlshouwen/i18n/zh-cn.js"></script>
	<link rel="stylesheet" type="text/css" href="resources/dlshouwen/css/dlshouwen.grid.css" />
	<!-- datePicker -->
	<script type="text/javascript" src="resources/datePicker/WdatePicker.js" defer="defer"></script>
	<link rel="stylesheet" type="text/css" href="resources/datePicker/skin/WdatePicker.css" />
	<link rel="stylesheet" type="text/css" href="resources/datePicker/skin/default/datepicker.css" />
	
	<!-- toTop -->
	<script type="text/javascript" src="resources/toTop/jquery.toTop.js"></script>
	<link rel="stylesheet" type="text/css" href="resources/toTop/jquery.toTop.css" />

	<!-- syntaxHighLighter -->
	<script type="text/javascript" src="resources/syntaxHighLighter/scripts/shCore.js"></script>
	<script type="text/javascript" src="resources/syntaxHighLighter/scripts/shBrushBash.js"></script>
	<script type="text/javascript" src="resources/syntaxHighLighter/scripts/shBrushXml.js"></script>
	<script type="text/javascript" src="resources/syntaxHighLighter/scripts/shBrushJScript.js"></script>
	<link rel="stylesheet" type="text/css" href="resources/syntaxHighLighter/styles/shCore.css" />
	<link rel="stylesheet" type="text/css" href="resources/syntaxHighLighter/styles/shThemeDefault.css" />
	
<script type="text/javascript">
	//映射内容
	var sex = {1:'男', 2:'女'};
	var degree = {1:'小学', 2:'初中', 3:'高中', 4:'中专', 5:'大学', 6:'硕士', 7:'博士', 8:'其他'};
	//模拟数据（薪水在6000-12000之间，日期在1980-01-01 00::00:00到2014-10-01 00:00:00之间）
	var datas = new Array();
	for(var i=0; i<186; i++){
		var user = new Object();
		user.user_id = 'user_'+i;
		user.user_code = 'user_'+i;
		user.user_name = '模拟用户'+(Math.floor(Math.random()*1000)+10000)+'号';
		user.sex = (Math.floor(Math.random()*2)+1);
		user.salary = (Math.floor(Math.random()*6000)+6000);
		user.degree = (Math.floor(Math.random()*8)+1);
		user.time = new Date(Math.floor(Math.random()*1096588800000)+315504000000);
		user.time_stamp_s = Math.floor((Math.floor(Math.random()*1096588800000)+315504000000)/1000);
		user.time_stamp_ms = Math.floor(Math.random()*1096588800000)+315504000000;
		user.string_date = $.fn.dlshouwen.grid.tools.dateFormat(new Date(Math.floor(Math.random()*1096588800000)+315504000000), 'yyyy-MM-dd');
		user.string_time = $.fn.dlshouwen.grid.tools.dateFormat(new Date(Math.floor(Math.random()*1096588800000)+315504000000), 'yyyy-MM-dd hh:mm:ss');
		datas.push(user);
	}
	</script>	
</head>
<body>
	<header class="navbar navbar-inverse navbar-absolute-top" role="banner">
		<div class="container">
		</div>
	</header>
	<div class="container">
		<div class="col-md-9">
			<div class="layout main-container">
				<div id="2.1.2" class="sub-title">响应式表格</div>
				<script type="text/javascript">
				var gridColumns_2_1_2 = [
			 		{id:'user_code', title:'用户编号', type:'string', columnClass:'text-center'},
			 		{id:'user_name', title:'用户名称', type:'string', columnClass:'text-center'},
			 		{id:'sex', title:'性别', type:'string', codeTable:sex, columnClass:'text-center', hideType:'xs'},
			 		{id:'salary', title:'薪水', type:'number', format:'#,###.00', columnClass:'text-center', hideType:'xs'},
			 		{id:'degree', title:'学历', type:'string', codeTable:degree, columnClass:'text-center', hideType:'sm|xs'},
			 		{id:'time', title:'日期对象', type:'date', format:'yyyy-MM-dd hh:mm:ss', columnClass:'text-center', hideType:'md|sm|xs'},
			 		{id:'time_stamp_s', title:'秒级时间戳', type:'date', format:'yyyy-MM-dd hh:mm:ss', otype:'time_stamp_s', columnClass:'text-center', hideType:'lg|md|sm|xs'},
			 		{id:'time_stamp_ms', title:'毫秒级时间戳', type:'date', format:'yyyy-MM-dd hh:mm:ss S', otype:'time_stamp_ms', columnClass:'text-center', hideType:'lg|md|sm|xs'},
			 		{id:'string_date', title:'日期格式字符串', type:'date', format:'yyyy-MM-dd', otype:'string', oformat:'yyyy-MM-dd', columnClass:'text-center', hideType:'lg|md|sm|xs'},
			 		{id:'string_time', title:'时间格式字符串', type:'date', format:'yyyy-MM-dd hh:mm:ss', otype:'string', oformat:'yyyy-MM-dd hh:mm:ss', columnClass:'text-center', hideType:'lg|md|sm|xs'}
			 	];
			 	var gridOption_2_1_2 = {
			 		lang : 'zh-cn',
			 		ajaxLoad : false,
			 		exportFileName : '用户列表',
			 		datas : datas,
			 		columns : gridColumns_2_1_2,
			 		gridContainer : 'gridContainer_2_1_2',
					toolbarContainer : 'gridToolBarContainer_2_1_2',
					tools : '',
					pageSize : 10,
					pageSizeLimit : [10, 20, 50]
			 	};
			 	var grid_2_1_2 = $.fn.dlshouwen.grid.init(gridOption_2_1_2);
			 	$(function(){
			 		grid_2_1_2.load();
			 	});
				</script>
				<div id="gridContainer_2_1_2" class="dlshouwen-grid-container"></div>
				<div id="gridToolBarContainer_2_1_2" class="dlshouwen-grid-toolbar-container"></div>
			</div>
		</div>
	</div>
	<div class="footer">
		<div class="container copyright">
			<a href="#">wsh软件公司</a>旗下产品
			&nbsp;&nbsp;
			wshsoft.com
			&nbsp;&nbsp;
			<a href="javascript:;">辽ICP备14014868号</a>
			&nbsp;&nbsp;
		</div>
	</div>	
	<div id="back-to-top" class="back-to-top" title="回到顶部"><i class="fa fa-arrow-circle-up"></i></div>
</body>	