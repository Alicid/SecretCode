<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Responsive sidebar template with sliding effect and dropdown menu based on bootstrap 3">
    <title>My Page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
        crossorigin="anonymous">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
 
 <script src="${pageContext.request.contextPath }/js/Chart.bundle.js" integrity="sha256-8zyeSXm+yTvzUN1VgAOinFgaVFEFTyYzWShOy9w7WoQ=" crossorigin="anonymous"></script>
    <script src="${pageContext.request.contextPath }/js/Chart.bundle.min.js"  integrity="sha256-TQq84xX6vkwR0Qs1qH5ADkP+MvH0W+9E7TdHJsoIQiM=" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/Chart.css" integrity="sha256-IvM9nJf/b5l2RoebiFno92E5ONttVyaEEsdemDC6iQA=" crossorigin="anonymous" />
    <script src="${pageContext.request.contextPath }/js/Chart.js"  integrity="sha256-nZaxPHA2uAaquixjSDX19TmIlbRNCOrf5HO1oHl5p70=" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/Chart.min.css" integrity="sha256-aa0xaJgmK/X74WM224KMQeNQC2xYKwlAt08oZqjeF0E=" crossorigin="anonymous" />
    <script src="${pageContext.request.contextPath }/js/Chart.min.js"integrity="sha256-R4pqcOYV8lt7snxMQO/HSbVCFRPMdrhAFMH+vr9giYI=" crossorigin="anonymous"></script>
   <style>
    @keyframes swing {
  0% {transform: rotate(0deg);}
  10% {transform: rotate(10deg);}
  30% {transform: rotate(0deg);}
  40% {transform: rotate(-10deg);}
  50% {transform: rotate(0deg);}
  60% {transform: rotate(5deg);}
  70% {transform: rotate(0deg);}
  80% {transform: rotate(-5deg);}
  100% {transform: rotate(0deg);}
}

@keyframes sonar {
  0% {
    transform: scale(0.9);
    opacity: 1;
  }
  100% {
    transform: scale(2);
    opacity: 0;
  }
}
body {
  font-size: 0.9rem;
}
.page-wrapper .sidebar-wrapper,
.sidebar-wrapper .sidebar-brand > a,
.sidebar-wrapper .sidebar-dropdown > a:after,
.sidebar-wrapper .sidebar-menu .sidebar-dropdown .sidebar-submenu li a:before,
.sidebar-wrapper ul li a i,
.page-wrapper .page-content,
.sidebar-wrapper .sidebar-search input.search-menu,
.sidebar-wrapper .sidebar-search .input-group-text,
.sidebar-wrapper .sidebar-menu ul li a,
#show-sidebar,
#close-sidebar {
  -webkit-transition: all 0.3s ease;
  -moz-transition: all 0.3s ease;
  -ms-transition: all 0.3s ease;
  -o-transition: all 0.3s ease;
  transition: all 0.3s ease;
}

.page-wrapper {
  height: 100vh;
}
.page-wrapper .theme {
  width: 40px;
  height: 40px;
  display: inline-block;
  border-radius: 4px;
  margin: 2px;
}
.page-wrapper .theme.chiller-theme {
  background: #1e2229;
}
.page-wrapper.toggled .sidebar-wrapper {
  left: 0px;
}
@media screen and (min-width: 768px) {
  .page-wrapper.toggled .page-content {
    padding-left: 300px;
  }
}
#show-sidebar {
  position: fixed;
  left: 0;
  top: 10px;
  border-radius: 0 4px 4px 0px;
  width: 35px;
  transition-delay: 0.3s;
}
.page-wrapper.toggled #show-sidebar {
  left: -40px;
}
.sidebar-wrapper {
  width: 260px;
  height: 10%;
  max-height: 100%;
  position: fixed;
  top: 1;
  left: -300px;
  z-index: 999;
}
.sidebar-wrapper ul {
  list-style-type: none;
  padding: 0;
  margin: 0;
}
.sidebar-wrapper a {
  text-decoration: none;
}
.sidebar-wrapper .sidebar-brand {
  padding: 20px 30px;
  display: flex;
  align-items: center;
}
.sidebar-wrapper .sidebar-brand > a {
  text-transform: uppercase;
  font-weight: bold;
  flex-grow: 1;
}
.sidebar-wrapper .sidebar-brand #close-sidebar {
  cursor: pointer;
  font-size: 20px;
}
.sidebar-wrapper .sidebar-header {
  padding: 20px;
  overflow: hidden;
}
.sidebar-wrapper .sidebar-header .user-pic {
  float: left;
  width: 60px;
  padding: 2px;
  border-radius: 12px;
  margin-right: 15px;
  overflow: hidden;
}
.sidebar-wrapper .sidebar-header .user-pic img {
  object-fit: cover;
  height: 100%;
  width: 100%;
}
.sidebar-wrapper .sidebar-header .user-info {
  float: left;
}
.sidebar-wrapper .sidebar-header .user-info > span {
  display: block;
}
.sidebar-wrapper .sidebar-header .user-info .user-role {
  font-size: 12px;
}
.sidebar-wrapper .sidebar-header .user-info .user-status {
  font-size: 11px;
  margin-top: 4px;
}
.sidebar-wrapper .sidebar-header .user-info .user-status i {
  font-size: 8px;
  margin-right: 4px;
  color: #5cb85c;
}
.sidebar-wrapper .sidebar-search > div {
  padding: 10px 20px;
}
.sidebar-wrapper .sidebar-menu {
  padding-bottom: 10px;
}
.sidebar-wrapper .sidebar-menu .header-menu span {
  font-weight: bold;
  font-size: 14px;
  padding: 15px 20px 5px 20px;
  display: inline-block;
}
.sidebar-wrapper .sidebar-menu ul li a {
  display: inline-block;
  width: 100%;
  text-decoration: none;
  position: relative;
  padding: 8px 30px 8px 20px;
}
.sidebar-wrapper .sidebar-menu ul li a i {
  margin-right: 10px;
  font-size: 12px;
  width: 30px;
  height: 30px;
  line-height: 30px;
  text-align: center;
  border-radius: 4px;
}
.sidebar-wrapper .sidebar-menu ul li a:hover > i::before {
  display: inline-block;
  animation: swing ease-in-out 0.5s 1 alternate;
}
.sidebar-wrapper .sidebar-menu .sidebar-dropdown > a:after {
  font-family: "Font Awesome 5 Free";
  font-weight: 900;
  content: "\f105";
  font-style: normal;
  display: inline-block;
  font-style: normal;
  font-variant: normal;
  text-rendering: auto;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  background: 0 0;
  position: absolute;
  right: 15px;
  top: 14px;
}
.sidebar-wrapper .sidebar-menu .sidebar-dropdown .sidebar-submenu ul {
  padding: 5px 0;
}
.sidebar-wrapper .sidebar-menu .sidebar-dropdown .sidebar-submenu li {
  padding-left: 25px;
  font-size: 13px;
}
.sidebar-wrapper .sidebar-menu .sidebar-dropdown .sidebar-submenu li a:before {
  content: "\f111";
  font-family: "Font Awesome 5 Free";
  font-weight: 400;
  font-style: normal;
  display: inline-block;
  text-align: center;
  text-decoration: none;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  margin-right: 10px;
  font-size: 8px;
}
.sidebar-wrapper .sidebar-menu ul li a span.label,
.sidebar-wrapper .sidebar-menu ul li a span.badge {
  float: right;
  margin-top: 8px;
  margin-left: 5px;
}
.sidebar-wrapper .sidebar-menu .sidebar-dropdown .sidebar-submenu li a .badge,
.sidebar-wrapper .sidebar-menu .sidebar-dropdown .sidebar-submenu li a .label {
  float: right;
  margin-top: 0px;
}
.sidebar-wrapper .sidebar-menu .sidebar-submenu {
  display: none;
}
.sidebar-wrapper .sidebar-menu .sidebar-dropdown.active > a:after {
  transform: rotate(90deg);
  right: 17px;
}
.page-wrapper .page-content {
  display: inline-block;
  width: 100%;
  padding-left: 0px;
  padding-top: 20px;
}
.page-wrapper .page-content > div {
  padding: 20px 40px;
}
.page-wrapper .page-content {
  overflow-x: hidden;
}
.chiller-theme .sidebar-wrapper {
    background: white;
}
.chiller-theme .sidebar-wrapper .sidebar-header,
.chiller-theme .sidebar-wrapper .sidebar-search,
.chiller-theme .sidebar-wrapper .sidebar-menu {
    border-top: 4px solid #02876C;
}
.chiller-theme .sidebar-wrapper .sidebar-search input.search-menu,
.chiller-theme .sidebar-wrapper .sidebar-search .input-group-text {
    border-color: transparent;
    box-shadow: none;
}
.chiller-theme .sidebar-wrapper .sidebar-brand>a{color : rgb(0, 119, 73); font-size: 25px;}
.chiller-theme .sidebar-wrapper .sidebar-search .input-group-text,
.chiller-theme .sidebar-wrapper .sidebar-search input.search-menu,
.chiller-theme .sidebar-wrapper .sidebar-menu ul li a,
.chiller-theme .sidebar-footer>a {
    color: #02876C;
}
.chiller-theme .sidebar-wrapper .sidebar-header .user-info{
    color: rgb(9, 102, 102)
}
.chiller-theme .sidebar-wrapper .sidebar-menu ul li:hover>a,
.chiller-theme .sidebar-wrapper .sidebar-menu .sidebar-dropdown.active>a,
.chiller-theme .sidebar-wrapper .sidebar-brand>a:hover,
.chiller-theme .sidebar-footer>a:hover i {
    color: #b8bfce;
}
.chiller-theme .sidebar-wrapper ul li:hover a i,
.chiller-theme .sidebar-wrapper .sidebar-dropdown .sidebar-submenu li a:hover:before,
.chiller-theme .sidebar-wrapper .sidebar-search input.search-menu:focus+span,
.chiller-theme .sidebar-wrapper .sidebar-menu .sidebar-dropdown.active a i {
    color: #b8bfce;
    text-shadow:0px 0px 10px rgba(22, 199, 255, 0.5);
}
.chiller-theme .sidebar-wrapper .sidebar-menu ul li a i,
.chiller-theme .sidebar-wrapper .sidebar-menu .sidebar-dropdown div,
.chiller-theme .sidebar-wrapper .sidebar-search input.search-menu,
.chiller-theme .sidebar-wrapper .sidebar-search .input-group-text {
    background: #aaf0d1;
}
.chiller-theme .sidebar-wrapper .sidebar-menu .header-menu span {
    color: #6c7b88;
}
.field-label-responsive {
    padding-top: .5rem;
    text-align: right;
}
.btn{
  background: transparent;
  position: relative;
  overflow: hidden;
  transition: all .5s;
}
.btn:before,
.btn:after{
  content: '';
  position: absolute;
  left: 0;
  top: 0;
  right: 0;
  bottom: 0;
  height: 100%;
  z-index: -1;
  transition: all .5s;
}
.btn-dark:before{
  background: #aaf0d1;
}
.btn-dark:after{
  background: #02876C;
}
.btn-dark:hover{
  background: #02876C;
}
.slidebottomleft:after{
  transform: translate3D(100%,100%,0);
}
.slidebottomleft:hover:after{
	transform: translate3D(0,0,0);
  transition: all .5s;
}
#sidebar{
	margin-top : 0%;
	position : absolute;
	z-index : 0;
}
.btn{
  background: transparent;
  position: relative;
  overflow: hidden;
  transition: all .5s;
}
.btn:before,
.btn:after{
  content: '';
  position: absolute;
  left: 0;
  top: 0;
  right: 0;
  bottom: 0;
  height: 100%;
  z-index: -1;
  transition: all .5s;
}
.btn-dark:before{
  background: #aaf0d1;
}
.btn-dark:after{
  background: #02876C;
}
.btn-dark:hover{
  background: #02876C;
}
.slidebottomleft:after{
  transform: translate3D(100%,100%,0);
}
.slidebottomleft:hover:after{
	transform: translate3D(0,0,0);
  transition: all .5s;
}
#sidebar{
	margin-top : 0%;
	position : absolute;
	z-index : 0;
}
</style>
<c:import url="../common/commonUtil.jsp"/>
</head>

<body>
<c:import url="../common/header.jsp" />
<div class="page-wrapper chiller-theme toggled">
	<c:import url="myPageMenu.jsp" />
 <main class="page-content">
 
    <div class="container-fluid">
      <h2>My Page</h2>
      <hr>
      &nbsp;&nbsp;&nbsp;&nbsp;
      <span class="custom-dropdown big">
		    <select name="category" id="ccc"> 
		    			<option value="0">-----카테고리-----</option>
		    	<c:forEach var="cate" items="${category}" varStatus="status"> 
		        		<option name="category2" value="${cate.CNUM}" >${cate.NAME} </option>
		       </c:forEach>  
		    </select>
	  </span>
		 <canvas id="myChart" class="chartjs-render-monitor" width="300" height="150"></canvas>
       </div>
       </main>
       </div> 
       
<c:import url="../common/footer.jsp" />

<script>

var	myChart;
$('#ccc').change(function(){
	var category = $('#ccc').val();
	$.ajax({
		url:'${pageContext.request.contextPath}/tResult/selectMyStaticsList.re',
		type: 'get',
		data : {category : category},
		dataType : 'json',
		success: function(data){
			console.log(data);
			
			if(myChart != null){
				myChart.destroy();
			}
			
			var ctx = document.getElementById('myChart').getContext('2d');
			myChart = new Chart(ctx, {
			    type: 'bar',
			    data: {
			        labels: ['응용SW기초기술활용', '프로그래밍 언어 활용', 'SQL 활용', '화면 구현', 'UI 테스트', '애플리케이션 테스트 수행', '애플리케이션 배포'],
			        datasets: [{
			            label: "정답율",
			            data: data,
			            backgroundColor: [
			                'rgba(255, 99, 132, 0.5)',
			                'rgba(54, 162, 235, 0.5)',
			                'rgba(255, 99, 132, 0.5)',
			                'rgba(54, 162, 235, 0.5)',
			                'rgba(255, 99, 132, 0.5)',
			                'rgba(54, 162, 235, 0.5)',
			                'rgba(255, 99, 132, 0.5)',
			            ],
			            borderColor: [
			                'rgba(255, 99, 132, 1)',
			                'rgba(54, 162, 235, 1)',
			                'rgba(255, 99, 132, 1)',
			                'rgba(54, 162, 235, 1)',
			                'rgba(255, 99, 132, 1)',
			                'rgba(54, 162, 235, 1)',
			                'rgba(255, 99, 132, 1)',
			            ],
			            borderWidth: 3
			        }]
			    },
			    options: {
			        scales: {
			            yAxes: [{
			                ticks: {
			                    beginAtZero: true
			                }
			            }]
			        }
			    }
				})
		}, error : function(data){
		}
})
})
;

	</script>

</body>
</html>