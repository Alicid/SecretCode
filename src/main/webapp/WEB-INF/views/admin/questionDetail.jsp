<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="Responsive sidebar template with sliding effect and dropdown menu based on bootstrap 3">
  
<title>Insert title here</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
        crossorigin="anonymous">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
  <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
  <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">
  
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
  left: 0px;
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

#sidebar{
	margin-top : 0%;
	position : absolute;
	z-index : 0;
}
	.title{
		border-color: #aaf0d1;
    	color: #666;
    	background: #ffffff;
    	font-size: inherit;
    	padding : 5px;
    	border-left : 5px solid #aaf0d1;
    	margin:10px;
	}
	.content{
		height : 500px;
		overflow : auto;
		margin:10px;
	}
	
	i{
		margin-left:15px;
	}
	
</style>
<c:import url="../common/commonUtil.jsp"/>
</head>
<body class="host_version">
<div>
<c:import url="../common/header.jsp"/>
</div>
<div class="pa
ge-wrapper chiller-theme toggled">
<c:import url="../member/myPageMenu.jsp"/>

<div class="all-title-box">
      <div class="container text-center">
         <h1 style="color:#02876C">시험 문제</h1>
      </div>
</div>

<div id="overviews" class="section wb">
        <div class="container">
            <div class="row"> 
					<br />
                <div class="col-lg-12 blog-post-single">
                    <div class="blog-item">
                    <div class="blog-desc">
						<div class="title display-5">
							<h1>${question.qTitle}</h1>
						</div>
						<div class="post-content">
							<div class="meta-info-blog">
								<span><i class="fa fa-calendar fa-lg">난이도 : </i>${question.qLevel}</span>
								<span><i class="fa fa-pencil fa-lg" aria-hidden="true">점수 : </i>${question.qScore}점</span>
								<span><i class="fa fa-eye fa-lg" aria-hidden="true">${question.qWriter}</i></span>
								 <input type="hidden" class="qNo" name="qNo" value="${question.qNo}"/>
							</div>
							<div class="blog-desc">
								<blockquote class="default content">
									${question.qContent} 
								</blockquote>
							</div>							
						</div>
					</div>
    
    <div class="blog-comments"></div>
		<h4 align="center">정답  / 오답</h4>
			<div id="comment-blog">
				<ul class="comment-list" align="center">
				
				<li class="comment" style="display:inline-block; width: 45%;">
					<div class="comment-container" style="margin-left: -22px;">
							<h5 class="comment-author"><a href="#">정답 부분</a></h5>
						
						<div class="comment-body">
							<p>정답 부분</p>
						</div>
					</div>
				</li>
					
				<li class="comment" style="display:inline-block; width: 45%;">
					<div class="comment-container" style="margin-left: -8px;">
							<h5 class="comment-author"><a href="#">오답 부분</a></h5>
						
						<div class="comment-body">
							<p>오답 부분</p>
						</div>
					</div>
				</li>
			</ul>
		</div>
	</div>
</div>
</div>
		<div align="center">
          <c:if test="${!empty member and (member.aNo eq 1 or member.aNo eq 2)}">
			 <c:url var="questionUpdate" value="qUpdateForm.qo">
			      <c:param name="qNo" value="${question.qNo}" />
			 </c:url>
			 <button class="btn btn-primary" id="btnli" onclick="location.href='#'">수정</button>
		  </c:if>
              <input type="button" id="btnli" class="btn btn-primary" value="목록"
                     onclick="location.href='${pageContext.request.contextPath}/question/questionList.qo'">
		</div>
	</div>
  </div>
				
       
   

    <c:import url="../common/footer.jsp" />
    
</body>
</html>