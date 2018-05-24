<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/inc/asset.jsp"></jsp:include>
<style>
 	#page_title { /*h2*/
	    color: #1f1f1f;
	    font-weight: bold;
	    font-size: 30px;
	    padding: 17px 0px 25px 0px;
	    text-align: center;
	    text-transform: uppercase;
    } 

	#contents{border: 1px black solid; text-align: center; width : 974px; margin: 0 auto; /*가운데 정렬*/} /*컨텐츠를 담고있는 상자*/
	
 	ul{ list-style:none; padding:0px;} /*컨텐츠 담고있는 ul*/
	ul .content{ /*컨텐츠 하나하나*/
		background-color: white; 
		list-style:none; 
		float:left; 
		padding:0; 
		margin:0; 
		width:447px; 
		margin: 0 0 30px 26px;
	}
	
	.add { /*연예인 이름+ 좋아요*/
	    padding: 10px 25px 10px 25px;
	    background: #fff;
	    border-bottom: 1px solid #e2e2e2;
    }
	
/* 	.wrap {
	    width: 974px;
	    margin: 0 auto; /*가운데 정렬*/
	}
	 */
	div {
	    display: block;
	}
	.wrap:after {
	    content: '';
	    display: block;
	    clear: both;
	}
	
 	.singerimg {
		padding: 0px;
		margin: 0px;
	} 
	
	.goodimg{
		width:30px; 
		text-align: right;
		
	}

</style>
<script>

var sel_file;


$(function() {

	
	//모달에있는 그림 미리보기
	$("#input_img").on("change", handleImgFileSelect);
	
});


//하트 눌렀을때 , 접근 권한 주기!(로그인한 사용자만 가능하게!)
function editlike(star_profile_seq , mycount){

	var heart = event.srcElement;
	
	var filename = [];
	filename["on"] ="like.png"; //on
	filename["off"] = "non_like.png";//off

	//alert(star_profile_seq);//내가 선택한 가수 프로필 게시판 번호!
	//alert(mycount);
	
	//하트 눌렀을때 , 상태 on , off
	//if(mycount == 1){ //하트가 ♥ -> ♡ 로 하기!
	$.ajax({
			
			type: "GET",
			url: "/enter/promotion/artist/singer_good.do",
			data: "stat="+mycount+"&star_profile_seq="+star_profile_seq, //좋아요 상태 (on -> off) 취소,연예인 목록 번호(star_profile_seq) 주고
			dataType: "json",
			success: function(result) { //하트 갯수 받기!!
				//alert(result.result);
				if(result.result == 1) {
					if(result.state == 0){
						$(heart).attr("src","/enter/images/artist/"+filename["off"]);
						$(heart).next().text(result.likeCount);
					} else {
						$(heart).attr("src","/enter/images/artist/"+filename["on"]);
						//$("#btnbad").attr("src","/enter/images/artist/"+filename["on"]);//count
						$(heart).next().text(result.likeCount);
					}
				} else{
					alert("좋아요 실패");
				}
				
			}
			
		});  
	
	
}

//좋아요 이미지확장자명만 빼기
function getFileName(path){
    var index = path.lastIndexOf("/");
    if (index > -1) {
       return path.substr(index+1);
    } else {
       return null;
    }
 }

//이미지 미리보기
function handleImgFileSelect(e) {
    var files = e.target.files;
    var filesArr = Array.prototype.slice.call(files);

    filesArr.forEach(function(f) {
        if(!f.type.match("image.*")) {
            alert("확장자는 이미지 확장자만 가능합니다.");
            return;
        }

        sel_file = f;

        var reader = new FileReader();
        reader.onload = function(e) {
            $("#addimg").attr("src", e.target.result);
        }
        reader.readAsDataURL(f);
    });
}


//모달 닫기!
function closeModal(){
	//동영상 없애기
	$("#preview").html("");
	//창 닫기
	$("#myModal").modal("hide");
}

//모달을 띄울때 , ajax를 가지고 db 목록 가져오기!
function addsinger(){ //가수 이름 + seq  받아오기!
	
	$.ajax({
		
		type: "GET",
		url: "/enter/promotion/artist/index_singer_data.do",
		data: "arttype=가수", //주고
		dataType: "json",
		success: function(result) { //받고(다음 페이지의 레코드들..)
			/* alert(result.length);	 */

			$(result).each(function(index,item){ //item-> 레코드 한줄!! (=DTO) (= JSON객체 1개 )
				var row;
				row += "<option value='"+item.artist_seq+"'>" + item.name + "</option>";
				$("#selecttbl #artist_seq").append(row);
			});
		}
		
	});
	
}


</script>
</head>
<body>
	<!--  -->
	<jsp:include page="/inc/header_main.jsp"></jsp:include>
	
	<div id="container" >
		<h2 id="page_title">SINGER</h2>
		
		<div id="contents" class="wrap">
			<ul class="singer_list">
			
			<c:forEach items="${list}" var="dto">
				<li class="content">
					<div class="pic">
							<!-- 글 제목!! + 이미지면 이미지 보이기!! -->	
							<a href="/enter/promotion/artist/introduce.do?star_profile_seq=${dto.star_profile_seq}">${dto.subject}</a>
					</div>
					<div class="add">
						<div class="add_tit" style="float:left;font-size:15px; padding-top: 13px;" id="add_tit">${dto.starname}</div>
						
						
						<!-- 좋아요 -->
						<div id ="good" style=" float:right; ">
								
								<c:if test="${dto.mycount == 0}">
								<img src="/enter/images/artist/non_like.png" id ="btnbad" class="goodimg" onclick="editlike(${dto.star_profile_seq},${dto.mycount});"/>
								</c:if>
								
								<c:if test="${dto.mycount == 1}">
								<img src="/enter/images/artist/like.png" id ="btngood" class="goodimg" onclick="editlike(${dto.star_profile_seq},${dto.mycount});"/>
								</c:if>
								
								
								<div id="labelbad" style="font-size:3px;padding-top: 2px;">${dto.likeCount}</div>
						</div>
						<div style="clear: both;"></div>
					</div>
				</li>
				
			</c:forEach>

			</ul>	
		</div><!-- end #contents -->
		
<!-- 		<div id="btns">
			<input type="button" value="글쓰기" class="btn btn-primary" onclick="location.href='/mvc/board/add.do';">
		</div> -->
		
		<!-- Button trigger modal -->
		<button type="button" class="btn btn-default" data-toggle="modal" data-target="#myModal" onclick="addsinger();">글쓰기
		</button>
		<span id ="movieKey"></span><!-- 선택하고 닫았는지 선택 안했는지 알려주는것!! -->
	
	</div><!-- end #container -->

	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">ADD Singer</h4>
	      </div>
	     
	      <form method="post" action="/enter/promotion/artist/singer_addok.do" enctype="multipart/form-data"><!-- enctype="multipart/form-data" : 첨부파일! -->
	      
	      <div class="modal-body">
	        <table class="table table-striped" id="selecttbl">
	        	<tr>
	        		<th>Singer</th>
	        		<td>
					   <select name="artist_seq" id="artist_seq">
					      <option value="0">선택하세요.</option>
					   </select>
					</td>
				</tr>
				<tr>
	        		<th>사진 파일</th>
	        		<td class="form-inline">
	        			<input type="file" name="attach" style="width:350px;" id="input_img" class="form-control">
	        		</td>
	        	</tr>
	        	<tr>
	        		<th>미리보기</th>
	        		<td>
		        		<div>
					        <div class="img_wrap">
					            <img id="addimg" style="width:447px; height: 190px;"/>
					        </div>
					    </div>
				    </td>
	        	</tr>
	        </table>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" onclick="closeModal();">닫기</button>
	        <!-- <button type="button" class="btn btn-primary" onclick="addsinger();">추가하기</button> -->
	        <input type="submit" value="글쓰기" class="btn btn-primary">
	      </div>

	      
	      </form>
	    </div>
	  </div>
	</div>


<iframe name="_action_frame_home" width="0" height="0" frameborder="0" scrolling="no"></iframe>

<jsp:include page="/inc/footer.jsp"></jsp:include>

</body>
</html>