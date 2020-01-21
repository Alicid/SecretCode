<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>시험문제 목록</title>
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
   <link rel="stylesheet" href="${pageContext.request.contextPath }/css/versions.css">
</head>
<body class="host_version h-screen overflow-hidden items-center justify-center" style="background: #edf2f7; overflow-y: scroll;">
   <c:import url="../common/header.jsp"/>

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
         <a class="hover-btn-new orange lead" href="${pageContext.request.contextPath}/question/qInsert.qo"><span><b>문제 작성</b><span></a>
         <a class="hover-btn-new orange lead" data-toggle="modal" data-target="#staticBackdrop"><span><b>Excel 문제파일 업로드</b><span></a>
          <a class="hover-btn-new orange lead" href="${pageContext.request.contextPath}/resources/excel/엑셀 업로드 샘플.xlsx"><span><b>문제 양식 받기</b><span></a>
      </div>
         </c:if>
         <div class="modal fade" id="staticBackdrop" data-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="staticBackdropLabel" aria-hidden="true">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="staticBackdropLabel">Excel 파일 업로드</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		       <form id="excelUploadForm" name="excelUploadForm" enctype="multipart/form-data" method="post" 
                                action= "${pageContext.request.contextPath}/excelUp.do">
			    <div class="contents">
			        <div>첨부파일은 xlsx확장자만 등록 가능하며, 본 페이지에서 제공되는 양식만 등록가능합니다.</div>
			 
			        <dl class="vm_name">
			                <dt class="down w90">첨부 파일</dt>
			                <dd><input id="excelFile" type="file" name="excelFile" /></dd>
			        </dl>        
			    </div>
		      <div class="modal-footer">
		        <button type="button" class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded-full" data-dismiss="modal">Close</button>
		        <button type="submit" id="addExcelImpoartBtn" class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded-full"  "><span>추가</span></button>
		      </div>
				</form> 
		      </div>
		    </div>
		  </div>
		</div>
		</div>
      
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