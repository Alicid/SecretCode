<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>카테고리 선택 화면</title>
<style>
.big {
  font-size: 1.2em;
}

.small {
  font-size: .7em;
}

.square {
  width: .7em;
  height: .7em;
  margin: .5em;
  display: inline-block;
}

/* Custom dropdown */
.custom-dropdown {
  position: relative;
  display: inline-block;
  vertical-align: middle;
  margin: 10px; /* demo only */
}

.custom-dropdown select {
  background-color: #1abc9c;
  color: #fff;
  font-size: inherit;
  padding: .5em;
  padding-right: 2.5em;	
  border: 0;
  margin: 0;
  border-radius: 3px;
  text-indent: 0.01px;
  text-overflow: '';
  -webkit-appearance: button; /* hide default arrow in chrome OSX */
}

.custom-dropdown::before,
.custom-dropdown::after {
  content: "";
  position: absolute;
  pointer-events: none;
}

.custom-dropdown::after { /*  Custom dropdown arrow */
  content: "\25BC";
  height: 1em;
  font-size: .625em;
  line-height: 1;
  right: 1.2em;
  top: 50%;
  margin-top: -.5em;
}

.custom-dropdown::before { /*  Custom dropdown arrow cover */
  width: 2em;
  right: 0;
  top: 0;
  bottom: 0;
  border-radius: 0 3px 3px 0;
}

.custom-dropdown select[disabled] {
  color: rgba(0,0,0,.3);
}

.custom-dropdown select[disabled]::after {
  color: rgba(0,0,0,.1);
}

.custom-dropdown::before {
  background-color: rgba(0,0,0,.15);
}

.custom-dropdown::after {
  color: rgba(0,0,0,.4);
}
</style>
 <c:import url="../common/commonUtil.jsp"/>
</head>
<body class="host_version">

<div>
<c:import url="../common/header.jsp" />
<br /><br /><br /><br /><br /><br /><br /><br /><br />
<div style="text-align: center;">
	학습할 문제의 카테고리를 선택해주세요.
</div>
<form action="${pageContext.request.contextPath}/question/questionSelectList.do" method="GET" style="text-align: center;" onsubmit="return comfirm();">
<span class="custom-dropdown big">
    <select name="category" id="ccc"> 
    			<option value="0">-----카테고리-----</option>
    	<c:forEach var="cate" items="${category}" varStatus="status"> 
        		<option name="category2" value="${cate.CNUM}">${cate.NAME} </option>
       </c:forEach>  
    </select>
</span>
<c:if test="${empty member}">
<input type="hidden" id="member"  value="0"/>
</c:if>
<c:if test="${!empty member}">
<input type="hidden" id="member"  value="${member.nickName}"/>
</c:if>

<br />
<div>
문제풀이 모드
</div>
<span class="custom-dropdown big">
	<select name="mode">
		<option value="문제풀이 모드">문제풀이 모드</option>
		<option value="타임어택">타임어택</option>
		<c:if test="${member.aNo eq 1}"><option value="하드코어">하드코어 모드</option></c:if>
	</select>
</span>
	<br />
<div>
단원 선택
</div>
<span class="custom-dropdown big">
	<select name="unit" id="unit">
		<option value="0">-----단원 선택-----</option>
		
	</select>
</span>
	<br />
	<button type="submit" class="btn btn-info">선택완료</button>
</form>	
</div>
<br /><br /><br /><br /><br /><br /><br />
<c:import url="../common/footer.jsp" />
<script>

$('#ccc').change(function(){
	var category = $('#ccc').val();
	console.log(category);
			$.ajax({
				   url  : "${pageContext.request.contextPath}/question/selectUnit.do",
				   type: 'POST',
				   data : {category:category},
				   dataType: "json",
				   success : function(data){
					   console.log('아작스 성공!');
					   console.log(data);
					   var $unit = $('#unit');
					   $unit.empty();
					   $unit.append('<option value="0">-----전체 선택-----</option>');
					   //console.log($unit);
					   //console.log(data.unit);
					   //console.log(data.unit[0]);
					   //console.log(data.unit[0].QU_NO);
					   //console.log(data.unit.length);
					   for(var i =0;i<data.unit.length;i++){
						   $unit.append('<option value="'+data.unit[i].QU_NO+'">'+data.unit[i].QU_NAME+'</option>'); 
					   }
					  
					   
				   },error : function(jqxhr, textStatus, errorThrown){
				      	     console.log("ajax 처리 실패");
				    	     //에러로그
				    	     console.log(jqxhr);
				    	     console.log(textStatus);
				    	     console.log(errorThrown);
			   }
		});//ajax 끝
});
function comfirm(){
	var $category = $("#ccc");
	var $unit=$('#unit');
	var $member=$('#member');
	//var member = ${member.nickName};
	console.log($member.val());
	if($category.val()==0){
		alert("카테고리를 선택해주세요.");
		$category.focus();
		return false;
	}
	if($member.val()==0){
		alert('로그인을 하셔야 이용가능합니다.');
		return false;
	}
	
	
	return true;
}
</script>

</body>
</html>