<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String hong = "hong"; %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
 <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<style>
	body {
		padding:50px;
	}
	
	th {
		width:100px;
		vertical-align:middle;
		text-align:right;
	}
	
	td {
		width:400px;
	}
</style>
<script>
	//$(document).ready(function() {
	//	
	//});
	
	// 줄임 표현
	$(function() {
		   $( "#slider-range" ).slider({
	            range: true,
	            min: 0,
	            max: 500,
	            values: [ 75, 300 ],
	            slide: function( event, ui ) {
	              $( "#amount" ).val( "$" + ui.values[ 0 ] + " - $" + ui.values[ 1 ] );
	              $("#minprice").val(ui.values[0]);
	              $("#maxprice").val(ui.values[1]);
	            }
	          });
	          $( "#amount" ).val( "$" + $( "#slider-range" ).slider( "values", 0 ) +
	            " - $" + $( "#slider-range" ).slider( "values", 1 ) );
			
	});
</script>
</head>
<body>
	<!--  -->
	<h1>컨트롤 값 전송하기</h1>
	
	<!-- form태그는 특별한 경우가 아니면 무조건 post로 -->
	<form method = "post" action = "ex12_request_process.jsp">
	<table class = "table table-striped table-bordered">
		<tr>
			<th>텍스트 박스</th>
			<td><input type = "text" name = "txt1"></td>
		</tr>
		<tr>
			<th>암호 박스 : </th> <!-- 아스키 코드값만 입력 가능 -->
			<td><input type = "password" name = "pw1"></td>
		</tr>
		<tr>
			<th>멀티 박스 : </th>
			<td>
				<textarea cols = "40" rows = "6" name = "txt2"></textarea>
			</td>
		</tr>
		<tr>
			<th>체크 박스(싱글) : </th>
			<td>
				<input type = "checkbox" name = "cb1">
			</td>
		</tr>
		<tr>
			<th>체크 박스(싱글) : </th>
			<td>
				<input type = "checkbox" name = "cb2" value = "hong">
			</td>
		</tr>
		<tr>
			<th>체크 박스(멀티) : </th>
			<td>
				<input type = "checkbox" name = "hobbys" value = "1"> 운동
				<input type = "checkbox" name = "hobbys" value = "2"> 독서
				<input type = "checkbox" name = "hobbys" value = "3"> 잠
			</td>
		</tr>
		<tr>
			<th>라디오 버튼 : </th>
			<td>
				<h4>성별?</h4>
				<input type = "radio" name = "rbgender" value = "m" checked> 남자
				<input type = "radio" name = "rbgender" value = "f"> 여자
				<input type = "radio" name = "rbgender" value = "u"> 중성
			</td>
		</tr>
		   <tr>
            <th>셀렉트 박스</th>
            <td>
               <select name="sel1" id="">
                  <option >색상을 선택하세요</option>
                  <option value="white">힌색</option>
                  <option value="blue">파랑</option>
                  <option value="black">검정</option>
                  <option value="red">빨강</option>
               </select>
            </td>   
         </tr>
         <tr>
            <th>셀렉트 박스</th>
            <td>
               <select name="sel2" multiple="multiple" size="5">
                  <option value="white">힌색</option>
                  <option value="yellow">노랑</option>
                  <option value="blue">파랑</option>
                  <option value="black">검정</option>
                  <option value="red">빨강</option>
               </select>
            </td>   
         </tr>
         <tr>
            <th>히든 태그</th>
            <!--  
            보이지 않는 태그
            -> 사용자가 입력하는 값이 아니다.
            -> 개발자용 
            -> 눈에 안보이는 텍스트 박스
            -> 자바 스크립트 or 자바
            
            -->
            <td>
               <input type="hidden" name="id" value=<%= hong %> />
            </td>   
         </tr>
         <tr>
            <th>HTML5 </th>
            <td>
            <input type="date" name="birthday" />
            </td>   
         </tr>
         <tr>
            <th>자바스크립트 라이브러리</th>
            <td>
            	
               <div id="slider-range"></div>
               <p>
                 <label for="amount">Price range:</label>
                 <input type="text" id="amount" readonly style="border:0; color:#f6931f; font-weight:bold;">
               </p>
               <div id="amount"></div>
              
               <input type="hidden" name="minprice" id="minprice" />
               <input type="hidden" name="maxprice" id="maxprice"/>
            	
            	
            </td>   
            
         </tr>
      </table>
      <hr>
      	<input type="submit" value="데이터 전송하기" class="btn btn-default" />
		
	</form>

</body>
</html>