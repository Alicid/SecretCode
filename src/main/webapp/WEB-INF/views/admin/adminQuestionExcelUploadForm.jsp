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
 <c:import url="../common/commonUtil.jsp" /> 
 <script src="${pageContext.request.contextPath }/js/jquery.form.js"></script>

 
</head>
<body>
<c:import url="../common/header.jsp"/>

<form name="excelUpForm" id="excelUpForm" enctype="multipart/form-data" method="POST" action="${pageContext.request.contextPath }/excelDown.do">
    <input type="file" id="excelFile" name="excleFile" value="엑셀 업로드" />
    <button type="submit" id="excelUp" >등록</button>
</form>

 <c:import url="../common/footer.jsp"/>
 
 <script>
 
 $("#excelUpForm").change(function(){
     var form = $("#excelUpForm")[0];

     var data = new FormData(form);
     $.ajax({
        enctype:"multipart/form-data",
        method:"POST",
        url: '${pageContext.request.contextPath}/excelUp.do',
        processData: false,   
        contentType: false,
        cache: false,
        data: data,
        success: function(result){  
            alert("업로드 성공!!");
        }
     });
 });


 </script>
 
</body>
</html>