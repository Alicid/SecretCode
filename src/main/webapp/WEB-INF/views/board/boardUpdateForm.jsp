<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<style>
   .mb-3{
      display:inline-block;
   }

</style>

<c:import url="../common/commonUtil.jsp" />

<!-- include summernote css/js -->
    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.15/dist/summernote-lite.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.15/dist/summernote-lite.min.js"></script>
<title>게시글 작성</title>

</head>
<body class="host_version">
<c:import url="../common/header.jsp" />
<br />
<section>
<div class="mb-2" align="center">
<form id="updateForm" action="${ pageContext.request.contextPath }/board/bUpdate.do"  method="post"  >
		<div class="input-group mb-3" style="width:900px;">
			<br />
		<input type="hidden" name="uno"  value="${member.uNo}"/>
		<input type="hidden" name="bno"  value="${board.bno}"/>
  				<input type="text" class="form-control" aria-label="Text input with dropdown button" 
 				 name="bTitle" id="title" placeholder="제목을 입력하세요." value="${board.bTitle}">
 				  <div style="margin-top: 8px;margin-right: 23px;margin-left: 30px;">
 				 카테고리 선택 : 
 				 </div>
 				<select name="bCategory" class="dropdown-select" style="width: 132px;">
 					<option value="${board.bCategory}">${board.bCategory}</option>
      				<option value="잡담">잡담</option>
      				<option value="자랑">자랑</option>
      				<option value="팁">팁</option>
    			</select>
		</div>

		<div class="editorArea"  style="margin-top:20px;">
  				<textarea id="summernote" name="bContent">${board.bContent}</textarea>
		</div>
		
<br /><br />

<div align="center">
<button type="submit" class="btn btn-primary" onclick="deleteBtn();">삭제</button>&nbsp;&nbsp;&nbsp;
<button type="submit" class="btn btn-primary" onclick="updateBtn();">수정완료</button>
</div>
</form>
				
</div>
</section>
<br ><br ><br ><br ><br >


<c:import url="../common/footer.jsp" />

 <script>
$(document).ready(function(){
	
		$('#summernote').summernote({
		    placeholder: '내용을 입력하세요.',
		    tabsize: 2,
		    height: 500,
		    width: 900,
		    focus: true,
		    callbacks: {
		       onImageUpload: function(files, editor, welEditable) {
		             for (var i = files.length - 1; i >= 0; i--) {
		                sendFile(files[i], this);
		             }
		         }
		    }
		 });
		});
			
		  $('.dropdown-toggle').dropdown()
 
 function sendFile(file, el) {
    
 var form_data = new FormData();
  form_data.append('file', file);
  // console.log(form_data.file);

  
  $.ajax({
       data: form_data,
       type: "post",
       url: '/sc/update.tn',
    cache : false,
    contentType : false,
       enctype: 'multipart/form-data',
    processData : false,
       success: function(url) {
          console.log('----------------------------');
          console.log(url);
          console.log('----------------------------');
          url.replace("\/","/");
         $(el).summernote('editor.insertImage', url);
       }, error: function(){
          console.log("실패실패");
       }
  });
}
 
  function updateBtn(){
      if($('#title').val() == ""){
         alert("제목을 입력하세요.");
         $('#title').focus();
      } else if($('#summernote').val() == ""){
         alert("내용을 입력해 주세요.");
         $('#summernote').focus();
      } else {
         $('#updateForm').submit();
      }
      event.preventDefault();   
      
   }
   
   function deleteBtn(){
      var answer = confirm("게시글을 삭제하시겠습니까?");
      
      if(answer == true){
    	  $('#updateForm').attr("action", "${pageContext.request.contextPath}/notice/nDelete.no");
        } 
   }
   
 
</script>

</body>
</html>