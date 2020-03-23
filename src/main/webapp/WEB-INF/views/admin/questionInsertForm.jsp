<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>문제풀이 게시글 작성</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link rel="stylesheet" href="../../resources/css/test.css">
    <c:import url="../common/commonUtil.jsp" /> 
    
   <style>
        
    .red{
    color:red;
    }

    #btnSubmit {
        background: #02876C;
        border:#02876C;
    }
    #btnSubmit:hover,
    #btnSubmit:active,
    #btnSubmit:focus {
            background: #02876C;
            border:#02876C;
        }
    </style>
    </style>
</head>
<body>
  <c:import url="../common/header.jsp"/>
    <p>&nbsp;</p>
    <h1 class="text-center" style="color: #02876C">문제 작성</h1>
<p>&nbsp;</p>
<div class="container">
    <div>        
        <br style="clear:both">
            <div class="form-group col-md-12 ">
                <select>
                    <option value="1">응용 SW 기초기술 활용</option>
                    <option value="2">프로그래밍 언어 활용</option>
                    <option value="3">SQL 활용</option>
                    <option value="4">화면 구현</option>
                    <option value="5">UI 테스트</option>
                    <option value="6">애플리케이션 테스트 수행</option>
                    <option value="7">애플리케이션 배포</option>
                </select>
                <select>
                    <option value="11">상</option>
                    <option value="12">중</option>
                    <option value="13">하</option>
                </select>                                
                <form action="${pageContext.request.contextPath }/qInsert.qo">
                <input type="text" id="title" name="title" class="form-control input-sm" placeholder="제목"> <br>
                <textarea class="form-control input-sm " type="textarea" id="message" name="content" placeholder="내용을 입력하세요" maxlength="3000" rows="7"></textarea>
                    <span class="help-block"><p id="characterLeft" class="help-block "style="color:snow">You have reached the limit</p></span>                    
            	
            </div>
        <br style="clear:both">
        <div class="form-group col-md-12">
        <button class="form-control input-sm btn btn-success disabled" id="btnSubmit" name="btnSubmit" type="submit" style="height:35px"> 글쓰기</button>    
    	</d
    	iv>
    	</form>
</div>
</div>
<c:import url="../common/footer.jsp"/>
<script>
    $(document).ready(function(){ 
    $('#characterLeft').text('3000 자 이내로 입력해주세요');
    $('#message').keyup(function () {
        var max = 3000;
        var len = $(this).val().length;
        if (len >= max) {
            $('#characterLeft').text('You have reached the limit');
            $('#characterLeft').addClass('red');
            $('#btnSubmit').addClass('disabled');            
        } 
        else {
            var ch = max - len;
            $('#characterLeft').text(ch + ' characters left');
            $('#btnSubmit').removeClass('disabled');
            $('#characterLeft').removeClass('red');            
        }
    });    
});
</script>

</body>
</html>