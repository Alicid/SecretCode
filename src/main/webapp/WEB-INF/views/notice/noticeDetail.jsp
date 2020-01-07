<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>공지사항 상세 게시글</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/test.css">
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
<body>
    <c:url var="boardUpdate" value="nUpView.no">
               <c:param name="n_no" value="${notice.n_no }" />
</c:url>
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
                        <c:url var="boardUpdate" value="nUpView.no">
                           <c:param name="nNo" value="${notice.nNo }" />
                     </c:url>
                            <input type="button" id="btnup" class="btn btn-warning" value="수정"
                                onclick="location.href='${boardUpdate}'">
                           
                        <c:url var="boardDelete" value="delete.no">
                           <c:param name="nNo" value="${notice.nNo }" />
                     </c:url>
                            <input type="button" id="btnde" class="btn btn-danger" value="삭제"
                                onclick="deleteBtn();">
                            
                            <input type="button" id="btnli" class="btn btn-primary" value="목록"
                                onclick="location.href='${pageContext.request.contextPath}/selectList.no'">
                        </td>
                    </tr>

            </table>
            </div>

        </div>
    </div>
</body>
</html>