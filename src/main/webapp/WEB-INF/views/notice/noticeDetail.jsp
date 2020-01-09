<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>공지사항 상세 게시글</title>
    
    <c:import url="../common/commonUtil.jsp" />
    
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
   
    <style>
        #btnup{
            background: #02876C;
            border:#02876C;
        }
        #btnde{
            background: #02876C;
            border:#02876C;
        }
        #btnli{
            background: #02876C;
            border:#02876C;
        }
        
    </style>

</head>
<body class="host_version">

<c:import url="../common/header.jsp" />

    <c:url var="noticeDetail" value="noticeDetail.no">
               <c:param name="noticeDetail" value="${notice.nNo }" />
</c:url>

<br><br>
    <div class="row">
        <div class="col-xs-2 col-md-2"></div>
        <div class="col-xs-8 col-md-8">
            <h1 class="text-center" style="color: #02876C;">게시글 보기</h1>
            <hr>
            <p>&nbsp;</p>
            <div class="table table-responsive" style="overflow-x:hidden;">
                <table class="table">
                    <tr>
                        <th class="success" style="background: #02876C; color: snow;" >글번호</th>
                        <td>${notice.nNo}</td>
                        <th class="success" style="background: #02876C; color: snow;">조회수</th>
                        <td>${notice.nCount}</td>
                    </tr>


                    <tr>
                        <th class="success" style="background: #02876C; color: snow;">작성자</th>
                        <td>관리자</td>
                        <th class="success" style="background: #02876C; color: snow;">작성일</th>
                        <td>${notice.nEnrolldate}</td>
                    </tr>

                    <tr>
                        <th class="success" style="background: #02876C; color: snow;">제목</th>
                        <td colspan="3">${notice.nTitle}</td>
                    </tr>

                    <tr>
                        <th class="success" style="background: #02876C; color: snow;">글 내용</th>
                        <td colspan="3">${notice.nContent}</td>
                    </tr>

                    <tr align="center">
                        <td colspan="5" class="text-center">
                        <c:if test="${!empty member and member.uNo eq notice.uNo}">
			            <c:url var="noticeUpdate" value="nUpdateForm.no">
			               <c:param name="nNo" value="${notice.nNo}" />
			            </c:url>
			            <button class="btn btn-primary" id="btnli" onclick="location.href='${noticeUpdate}'">수정</button>
			         	</c:if>
                            <input type="button" id="btnli" class="btn btn-primary" value="목록"
                                onclick="location.href='${pageContext.request.contextPath}/notice/noticeList.no'">
                        </td>
                    </tr>
            </table>
            </div>

        </div>
    </div>
    
    <c:import url="../common/footer.jsp" />
    
</body>
</html>