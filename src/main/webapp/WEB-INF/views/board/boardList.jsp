<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://unpkg.com/tailwindcss@1.0.4/dist/tailwind.min.css" rel="stylesheet">
  <c:import url="../common/commonUtil.jsp" /> 
  
  <style>
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
    
    
  }
	
  td:not(:last-child) {
    border-bottom: 0;
  }

  th:not(:last-child) {
    border-bottom: 2px solid rgba(0, 0, 0, .1);
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
</style>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/versions.css">
</head>
<body class="host_version h-screen overflow-hidden items-center justify-center" style="background: #edf2f7;overflow-y: auto;">
	<c:import url="../common/header.jsp"/>
	
	<div class="all-title-box" style="background-image:url('${pageContext.request.contextPath }/images/blog_single.jpg');">
      <div class="container text-center">
         <h1>자유 게시판<span class="m_1">Love your neighbor as yourself.</span></h1>
      </div>
    </div>
    
	<br>	<br>
    <body class="flex items-center justify-center" style="background: #edf2f7;overflow-y: auto;">
   <div id='root'></div>
	<div class="container">
		<div class="blog-button">
		<c:if test="${!empty member}">
			<a class="hover-btn-new orange" href="${pageContext.request.contextPath}/board/boardInsertView.do"><span>글 작성<span></a>
		</c:if>
			
		</div>
		
  	
		<table class="w-full flex flex-row flex-no-wrap sm:bg-white rounded-lg overflow-hidden sm:shadow-lg my-5">
			<thead class="text-white">
			<c:forEach var="board" items="${list }">
				<tr class="bg-teal-400 flex flex-col flex-no wrap sm:table-row rounded-l-lg sm:rounded-none mb-2 sm:mb-0 tablehead">
					<th class="w-24 p-3 text-center t1">번호</th>
					<th class="w-24 p-3 text-center t2">글유형</th>
					<th class="p-3 text-center t3" >제목</th>
					<th class="w-24 p-3 text-center t4">작성자</th>
					<th class="w-24 p-3 text-center t5">작성일</th>
					<th class="w-24 p-3 text-center t6">조회수</th>
				
				</tr>
			</c:forEach>
			</thead>
			<tbody class="flex-1 sm:flex-none">
			
			<c:forEach var="board" items="${list }">
				<tr class="flex flex-col flex-no wrap sm:table-row mb-2 sm:mb-0" style="cursor:default">
					<td class="border-grey-light border  p-3 text-center">${board.bnum }</td>
					<td class="border-grey-light border  p-3 truncate text-center">${board.bCategory }</td>
					<td class="border-grey-light border  p-3 truncate" style="padding-left: 50px;">${board.bTitle }&nbsp;<c:if test="${board.cCount ne 0}"><b>(${board.cCount})</b></c:if></td>
					<td class="border-grey-light border  p-3 truncate">${board.writer }</td>
					<td class="border-grey-light border  p-3 truncate">${board.bDate }</td>
					<td class="border-grey-light border  p-3 truncate">${board.bCount }</td>
					 <input type="hidden" class="bno" name="bno" value="${board.bno }"/>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		
	</div>
	<br /><br /><br />
	<div class="pagingArea pagination d-flex justify-content-center" align="center">
			<c:url var="selectList" value="/board/boardSelectList.do"/>
			
			<!-- 처음 페이지 버튼 -->
			<button class="page-link" onclick="location.href='${selectList}?currentPage=1'">
				&lt;&lt;
			</button>
			
			<!-- 이전 페이지 버튼 -->
			<c:if test="${ pi.currentPage le 1 }">
				<button class="page-link" disabled>&lt;</button>
			</c:if>
			<c:if test="${ pi.currentPage gt 1 }">
				<button class="page-link" onclick="location.href='${selectList}?currentPage=${pi.currentPage - 1}'">
					&lt;
				</button>
			</c:if>
			
			<!-- 상세 페이지 구현을 위한 반복문 -->
			<c:forEach var="p" begin="${pi.startPage }" end="${pi.endPage }">
				<c:if test="${p eq pi.currentPage }">
					<button class="page-link" disabled>
					<b>${p}</b>
					</button>
				</c:if>
				<c:if test="${p ne pi.currentPage }">
					<button class="page-link" onclick="location.href='${selectList }?currentPage=${p }'">${p}</button>
				</c:if>
			</c:forEach>
			
			
			<!-- 다음 페이지 버튼 -->
			<c:if test="${ pi.currentPage ge pi.maxPage }">
				<button class="page-link" disabled>&gt;</button>
			</c:if>
			<c:if test="${ pi.currentPage lt pi.maxPage }">
				<button class="page-link" onclick="location.href='${selectList}?currentPage=${pi.currentPage + 1}'">
					&gt;
				</button>
			</c:if>
			
			<!-- 마지막 페이지 버튼 -->
			<button class="page-link" onclick="location.href='${selectList}?currentPage=${pi.maxPage}'">
				&gt;&gt;
			</button>
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
		    var bno = $(this).find('.bno').val();
			 location.href="${pageContext.request.contextPath}/board/selectOne.do?bno=" + bno;
		});
	});
	</script>
</body>


</body>
</html>