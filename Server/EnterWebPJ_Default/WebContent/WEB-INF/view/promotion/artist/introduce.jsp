<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../js/jquery-1.12.4.js"></script>
<script src="../js/bootstrap.js"></script>
		<jsp:include page="/inc/asset.jsp"></jsp:include>
<style>
	#page_title{
		padding: 25px 0; 
		font-weight: bold; 
		text-align: center; 
		width: 100%; 
		height: 108;
	}
	#content {
		margin: 0 auto; 
		width: 920px; 
		padding:45px 0; 
		border-top: 3px solid black; 
		background-color: white;
	}
	
	#menu {
		background-color: white; 
		width: 150px; 
		transform:translate(885px,-330px);
	}

	#mini_cont{margin-left: 50px;}
	
	#actor_pic{margin-top:20px; }
	
	.title_txt{font-size: 12px; color: #949494;}
	
	.submenu li {
		font-size: 13px; 
		list-style: none; 
		margin-bottom: 13px; 
		color: #949494; 
	}

	a{text-decoration: none; color: #949494;}
	
	a:link{text-decoration: none; }
	
	a:hover {text-decoration: none; color:cornflowerblue;}
	
	#filmography {
		margin:-120px auto;  
		width: 920px; 
		background-color: white; 
		padding: 10px 0px; 
		hight: 400px;
	}
	
	#filmography:after {
		content:" "; 
		display:block; 
		clear:both;
	}
	
	#filmography > ul ul li { 
		padding: 10px 0; 
		font-size: 12px; 
		border-bottom: 1px solid #e2e2e2; 
		list-style: none;
	}

	.section{width: 1000px;}
	
	#drama, #movie{ 
		float: left;  
		width: 32%;
		margin: 30px auto;
	}
	
	#adminBtnBox{ 
	
		display:none; 
		margin: 30px 10px;
		padding: 10px;	
	}
		
	h4{ margin: 30px 0px 0px 50px; float: left; width: 25%;}
	h5{ border-top: 3px solid black; padding-top: 20px;}
	ul{list-style: none; }
	
	



</style>
<script>
/* 	$(function() {
		// pageAuth 에 컨트롤러단에서 넘어온 권한을 넣어줌
	    var pageAuth = 4; 
		
		// 4이상 권한만 보이고 나머지는 숨김
	    if ( pageAuth >= 4 ) $("#adminBtnBox").css( "display", "block" );
	    else $("#adminBtnBox").css( "display", "none" );
	    
	 }); */
	 
var sel_file;
	 
$(function(){
	
	 //모달 그림 미리보기
	 $("#input_img").on("change", handleImgFileSelect);
	
	 $.ajax ({
			type:"GET",
			url:"/enter/promotion/loadpic.do",
			data:"profseq=2", 
			dataType:"json",
			success: function(result) {
				
				$("#profilepic").attr("src", "../files/" + result["filename"]);      
				
			},
			error: function(a, b, c) {
				console.log(a,b,c);
				
			}
				
		
	});
	
	 
	 
});	

function handleImgFileSelect(e){
	var files = e.target.files;
	var filesArr = Array.prototype.slice.call(files);
	
	filesArr.forEach(function(f){
		if(!f.type.match("image.*")){
			alert("확장자는 이미지 확장자만  가능합니다.");
			return;
		}
		
		sel_file = f;
		
		var reader = new FileReader();
		reader.onload = function(e){
			$("#addimg").attr("src", e.target.result);
		}
		reader.readAsDataURL(f);
	});
	
	
}




</script>
</head>
<body>
	<!--  -->
	<jsp:include page="/inc/header_main.jsp"></jsp:include>
	
	<div id="container">
		<h2 id="page_title">ACTOR</h2>
		<div id="content" class="wrap">
			<div id="mini_cont">
				<div id="artist_box">
					<h3 class="mini_title">SEO KANG JOON</h3>
					<div class="title_txt">서강준 / 1993. 10.12</div>
				<div id="introduce">
					<div id="actor_pic" class="section">
						<img src="" alt="사진" id = "profilepic" style = "width:60%;height:40%;">
					</div>
				</div>
			</div>
			</div>
		</div>
		<div id="menu">
         <ul class="submenu">
            <li><a href="/enter/promotion/artist/index_singer.do">MAIN</a></li>
            <li><a href="/enter/promotion/artist/introduce.do?star_profile_seq=${star_profile_seq}">INTRODUCE</a></li>
            <li><a href="/enter/promotion/artist/schedule.do?star_profile_seq=${star_profile_seq}">SCHEDULE</a></li>
            <li><a href="/enter/promotion/artist/notice.do?star_profile_seq=${star_profile_seq}">NOTICE</a></li>
            <li><a href="/enter/promotion/artist/photo.do?star_profile_seq=${star_profile_seq}">PHOTO</a></li>
            <li><a href="/enter/promotion/artist/video.do?star_profile_seq=${star_profile_seq}">VIDEO</a></li>
            <li><a href="/enter/promotion/artist/news.do?star_profile_seq=${star_profile_seq}">NEWS</a></li>
            <li><a href="/enter/promotion/artist/fromstar.do?star_profile_seq=${dto.star_profile_seq}">From Star</a></li>
         </ul>
         
         
      <!-- Button trigger modal -->
      <div id="adminBtns">   
      <button type="button" class="btn btn-default btn-sm" data-toggle="modal" data-target="#myModal" onclick="addsinger();">등록</button>
      <button type="button" class="btn btn-default btn-sm" data-toggle="modal" data-target="#myModal" onclick="addsinger();">수정</button>
      <button type="button" class="btn btn-default btn-sm" data-toggle="modal" data-target="#myModal" onclick="addsinger();">삭제</button>
      <span id ="movieKey"></span><!-- 선택하고 닫았는지 선택 안했는지 알려주는것!! -->
		
     
      
         
      </div>
		
		</div>	
		<div id="filmography" class="sub_cont">
			<h4> Works&Achievements </h4>
			
				<ul>
					<li class="left_box">
						<div class="section" id="drama">
							<ul>
								<h5>DRAMA</h5>
								<li>2010 SBS 괜찮아, 아빠 딸 / 황연두 역 </li>
								<li>2011 MBC 넌 내게 반했어 / 여준희 역 </li>
							</ul>
						</div>
					</li>
					<li class="right_box">
						<div class="section" id="movie">
							<ul>
								<h5>MOVIE</h5>
								<li>2010 SBS 괜찮아, 아빠 딸 / 황연두 역 </li>
								<li>2011 MBC 넌 내게 반했어 / 여준희 역 </li>
								<li>2011 MBC 넌 내게 반했어 / 여준희 역 </li>
								<li>2010 SBS 괜찮아, 아빠 딸 / 황연두 역 </li>
								<li>2011 MBC 넌 내게 반했어 / 여준희 역 </li>
								<li>2011 MBC 넌 내게 반했어 / 여준희 역 </li>
								<li>2010 SBS 괜찮아, 아빠 딸 / 황연두 역 </li>
								<li>2011 MBC 넌 내게 반했어 / 여준희 역 </li>
								<li>2011 MBC 넌 내게 반했어 / 여준희 역 </li>
								
							</ul>
						</div>
					</li>
				</ul>
		</div>
		
		
		</div>   
      <!-- Modal -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title" id="myModalLabel">ADD Artist Photo</h4>
		      </div>
		     
		      <form method="post" action="/enter/promotion/artistadd.do" enctype="multipart/form-data"><!-- enctype="multipart/form-data" : 첨부파일! -->
		      <input type = "hidden" value = "2" id = "star_profile_seq" name = "star_profile_seq">
		      <div class="modal-body">
		        <table class="table table-striped" id="selecttbl">

					<tr>
		        		<th>사진 파일</th>
		        		<td class="form-inline">
		        			<input type="file" name="attach" style="width:360px;" id="input_img" class="form-control">
		        		</td>
		        	</tr>
		        	<tr>
		        		<th>미리보기</th>
		        		<td>
			        		<div>
						        <div class="img_wrap">
						            <img id="addimg" style="width:360px; height: 215px;"/>
						        </div>
						    </div>
					    </td>
		        	</tr>
		        </table>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-default" onclick="closeModal();">닫기</button>
		        <input type="submit" value="등록" class="btn btn-primary">
		      </div>
	
		      
		      </form>
		    </div>   
		
		
		</div>
	</div>
	
	
		
<iframe name="_action_frame_home" width="0" height="0" frameborder="0" scrolling="no"></iframe>	
<jsp:include page="/inc/footer.jsp"></jsp:include>
</body>
</html>