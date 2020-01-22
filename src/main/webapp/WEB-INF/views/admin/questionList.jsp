<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="Responsive sidebar template with sliding effect and dropdown menu based on bootstrap 3">

<title>시험문제 목록</title>

<link href="https://unpkg.com/tailwindcss@1.0.4/dist/tailwind.min.css" rel="stylesheet">
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
  html,
  body {
    height: 100%;
  }
  
  @media (min-width: 640px) {
    table {
      display: inline-table !important;
    }

    thead tr:not(:first-child) {
      display: none;
    }
   
  td:not(:last-child) {
    border-bottom: 0;
  }

  th:not(:last-child) {
    border-bottom: 2px solid rgba(0, 0, 0, .1);
  }
  .th-co{
  	color:white;
  }
  :root {
    --speed: 0.5s;
    --distance: 1.3rem;
    --distance-negative: -1.3rem;
   }
   .animate-bottom-top:hover .button-children {
    animation: translate-y-bottom-top var(--speed) forwards;
}

@keyframes translate-y-bottom-top {
    25% {
        transform: translateY(var(--distance));
        opacity: 0;
    }
    26% {
        transform: translateY(var(--distance-negative));
        opacity: 0;
    }
}
#searchsubmit{
   background : #aaf0d1 url(../images/search-icon.png) no-repeat center 14px !important;
}
.widget-search{
   width : 25% !important;
}

.t2{
    dispaly : none !important;
    }
    button{
    	background-color:#ECECED;
    }
       
</style>

<c:import url="../common/commonUtil.jsp" /> 

   <link rel="stylesheet" href="${pageContext.request.contextPath }/css/versions.css">
</head>
<body class="host_version h-screen overflow-hidden items-center justify-center" style="background: white; overflow-y: scroll;">
   <c:import url="../common/header.jsp"/>
   <div class="page-wrapper chiller-theme toggled">
<c:import url="../member/myPageMenu.jsp"/>

<div class="all-title-box">
      <div class="container text-center">
         <h1 class="container text-center" style="color:#02876C">시험 문제 관리</h1>
      </div>
</div>
 
    <body class="flex items-center justify-center"  style="overflow-y: scroll;" >
   <!--<c:import url="../member/myPageMenu.jsp"/>-->
   <div id='root'></div>
   <div class="container">
   <c:if test="${!empty member and member.aNo eq 1}">
      <div class="blog-button">
         <a class="hover-btn-new orange lead" href="${pageContext.request.contextPath}/question/qInsert.qo"><span><b>글쓰기</b><span></a>
      </div>
      </c:if>
      <br />
      <p class="lead"><strong>총 ${ listCount }건의 게시물이 있습니다.</strong></p>
      <table class="w-full flex flex-row flex-no-wrap sm:bg-white rounded-lg overflow-hidden sm:shadow-lg my-5" style="table-layout:fixed;">
         <thead class="text-white">
         <c:forEach var="q" items="${list }">
            <tr class="bg-teal-400 flex flex-col flex-no wrap sm:table-row rounded-l-lg sm:rounded-none mb-2 sm:mb-0 tablehead " >
               <th class="p-3 text-left t1 th-co">번호</th>
               <th class="p-3 text-left t3 th-co">단원명</th>
               <th class="p-3 text-left t4 text-center th-co">문제</th>
               <th class="p-3 text-left t5 text-center th-co" >출제자</th>
               <th class="p-3 text-left t6 th-co">난이도</th>
            </tr>
         </c:forEach>
         </thead>
         <tbody class="flex-1 sm:flex-none">
         
         <c:forEach var="q" items="${list }">
            <tr class="flex flex-col flex-no wrap sm:table-row mb-2 sm:mb-0 lead">
               <td class="border-grey-light border p-3">${q.qnum}</td>
               <td class="border-grey-light border p-3  truncate">${q.qTitle}</td>
               <td class="border-grey-light border p-3 text-left  truncate">${q.qContent}</td>
               <td class="border-grey-light border p-3  text-center  truncate">${q.qWriter}</td>
               <td class="border-grey-light border p-3 truncate">${q.qLevel}</td>
               <input type="hidden" name="qno" value="${q.qNo}"/>               
            </tr>
         </c:forEach>
         </tbody>
      </table>
         <div class="widget-search">
                  <div class="site-search-area">
                     <form method="get" id="site-searchform" action="#">
                        <div>
                        	<select>
        						<option value="단원명" disabled>시부럴 단원명 쳐나오라고</option>
        					 </select>
                        	<input class="input-text form-control" name="search-k" id="search-k" placeholder="Search keywords..." type="text">
                           <input id="searchsubmit" value="Search" type="submit">
                        </div>
                     </form>
                  </div>
         </div>
   </div>
   <br /><br /><br />
   <div class="pagingArea pagination d-flex justify-content-center" >
         <c:url var="questionList" value="/question/questionList.qo"/>
         
         <!-- 처음 페이지 버튼 -->
         <button class="page-link" onclick="location.href='${questionList}?currentPage=1'">
            &lt;&lt;
         </button>
         
         <!-- 이전 페이지 버튼 -->
         <c:if test="${ pi.currentPage le 1 }">
            <button class="page-link" disabled>&lt;</button>
         </c:if>
         <c:if test="${ pi.currentPage gt 1 }">
            <button class="page-link" onclick="location.href='${questionList}?currentPage=${pi.currentPage - 1}'">
               &lt;
            </button>
         </c:if>
         
         <!-- 상세 페이지 구현을 위한 반복문 -->
         <c:forEach var="p" begin="${pi.startPage }" end="${pi.endPage}">
            <c:if test="${p eq pi.currentPage}">
               <button class="page-link"  disabled>
               <b>${p}</b>
               </button>
            </c:if>
            <c:if test="${p ne pi.currentPage}">
               <button class="page-link"  onclick="location.href='${questionList}?currentPage=${p}'">${p}</button>
            </c:if>
         </c:forEach>
         
         
         <!-- 다음 페이지 버튼 -->
         <c:if test="${ pi.currentPage ge pi.maxPage}">
            <button class="page-link" disabled>&gt;</button>
         </c:if>
         <c:if test="${ pi.currentPage lt pi.maxPage}">
            <button class="page-link" onclick="location.href='${questionList}?currentPage=${pi.currentPage + 1}'">
               &gt;
            </button>
            
         </c:if>
         
         <!-- 마지막 페이지 버튼 -->
         <button class="page-link" onclick="location.href='${questionList}?currentPage=${pi.maxPage}'">
            &gt;&gt;
         </button>
         </div>
         </div>
   <br /><br /><br />
   
   <c:import url="../common/footer.jsp"/>
   <script>
   $(function(){
      $('td').parent().mouseenter(function(){
         //console.log("확인!");
         $(this).css('background','#ECECED');
      }).mouseleave(function(){
         $(this).css('background','white');
      }).click(function(){
          var qNo = $(this).find('input').val();
          location.href="${pageContext.request.contextPath}/question/questionDetail.qo?qNo="+qNo;
      });
   });
   
   $(function(){
	      $('button').mouseenter(function(){
	         //console.log("확인!");
	         $(this).css('background','#ECECED');
	      }).mouseleave(function(){
	         $(this).css('background','white');
	      })
	   });
   
   
   </script>
</body>


</body>
</html>