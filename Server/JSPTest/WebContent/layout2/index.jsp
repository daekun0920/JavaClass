<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file = "inc/asset.jsp" %>
<style>

</style>
<script>
	//$(document).ready(function() {
	//	
	//});
	
	// 줄임 표현
	$(function() {
		
	});
</script>
</head>
<body>
	<!-- index.jsp -->
	<div class = "container">
		
		<%
		//String title = "Home";
		%>
		
		<%-- <%@ include file = "inc/header.jsp" %> --%>
		<jsp:include page = "inc/header.jsp">
			<jsp:param value = "0" name = "mode" />
		</jsp:include>		
		<!-- jsp 액션태그로 할때는 이 페이지에서 선언한 지역 변수 사용 불가 -> 서로 따로 컴파일 하고 include 한 jsp 페이지를 잠깐 들렸다 가기 때문 -> iframe 과 같음(안과 밖 자원 서로 통용 불가) -->
		<!-- 가독성이 훨씬 높은 방식 -->
		
		<p class="lead">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Impedit quidem provident suscipit libero cumque aliquid repellat ipsa delectus sed aperiam laborum fugit pariatur atque ad sit voluptas accusamus error praesentium!</p>
		<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Non aspernatur et quas ut dolorem eligendi blanditiis facere eos libero quae mollitia maiores in nihil assumenda omnis ad ducimus est fuga reprehenderit iure officiis cumque dignissimos sint! Autem nesciunt quod est minus iusto et quam iste perspiciatis aspernatur doloribus quos facere. Quibusdam iure nisi temporibus fuga ab qui quia tempore odio. Qui est doloremque reiciendis placeat incidunt laborum facilis itaque rerum neque deleniti possimus in nulla amet recusandae voluptates nisi culpa iure doloribus commodi molestiae illo nihil inventore consequatur accusantium minima fugiat iste eius ipsam temporibus blanditiis! Officiis quibusdam autem voluptate!</p>
		<p>Quibusdam atque harum quae architecto ratione alias. Soluta nobis iure perspiciatis eaque odio aut iste fuga earum laudantium totam. Eligendi architecto cum rerum doloremque suscipit deleniti sed magni illum necessitatibus totam inventore ipsa deserunt quasi amet cumque nostrum libero nulla assumenda ratione doloribus delectus impedit quibusdam nesciunt aliquam enim sunt repellat tempora vitae minima. Voluptatibus alias suscipit numquam deserunt quidem voluptatum dolore consectetur quam velit placeat aut explicabo facilis. Labore deserunt laudantium consequatur quis ab accusamus nobis odio tempora inventore earum eius eligendi cumque quia quas repellendus sequi facilis mollitia impedit nostrum reprehenderit modi animi omnis ratione natus quam iste!</p>
		<p>Eum maxime possimus adipisci dolor officiis eaque cumque magni porro ipsum voluptatem nulla architecto aliquid labore. Rerum debitis nobis cumque iste corporis aspernatur distinctio voluptates mollitia nulla dolorem nostrum reiciendis doloremque error assumenda fugit? Ab voluptas et quibusdam iusto distinctio architecto est placeat eaque odio quia perspiciatis quisquam numquam voluptate modi soluta eos consectetur fugiat consequuntur inventore veritatis iste animi deserunt delectus non mollitia ex eligendi tempore nihil sit excepturi. Voluptatibus quod rem blanditiis eaque non odio quaerat quia possimus eum tempore officia omnis minima id voluptas fugit adipisci laudantium sed similique iste aliquid odit doloremque ex autem iusto quis!</p>
		
		
		<p class="lead">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Impedit quidem provident suscipit libero cumque aliquid repellat ipsa delectus sed aperiam laborum fugit pariatur atque ad sit voluptas accusamus error praesentium!</p>
		<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Non aspernatur et quas ut dolorem eligendi blanditiis facere eos libero quae mollitia maiores in nihil assumenda omnis ad ducimus est fuga reprehenderit iure officiis cumque dignissimos sint! Autem nesciunt quod est minus iusto et quam iste perspiciatis aspernatur doloribus quos facere. Quibusdam iure nisi temporibus fuga ab qui quia tempore odio. Qui est doloremque reiciendis placeat incidunt laborum facilis itaque rerum neque deleniti possimus in nulla amet recusandae voluptates nisi culpa iure doloribus commodi molestiae illo nihil inventore consequatur accusantium minima fugiat iste eius ipsam temporibus blanditiis! Officiis quibusdam autem voluptate!</p>
		<p>Quibusdam atque harum quae architecto ratione alias. Soluta nobis iure perspiciatis eaque odio aut iste fuga earum laudantium totam. Eligendi architecto cum rerum doloremque suscipit deleniti sed magni illum necessitatibus totam inventore ipsa deserunt quasi amet cumque nostrum libero nulla assumenda ratione doloribus delectus impedit quibusdam nesciunt aliquam enim sunt repellat tempora vitae minima. Voluptatibus alias suscipit numquam deserunt quidem voluptatum dolore consectetur quam velit placeat aut explicabo facilis. Labore deserunt laudantium consequatur quis ab accusamus nobis odio tempora inventore earum eius eligendi cumque quia quas repellendus sequi facilis mollitia impedit nostrum reprehenderit modi animi omnis ratione natus quam iste!</p>
		<p>Eum maxime possimus adipisci dolor officiis eaque cumque magni porro ipsum voluptatem nulla architecto aliquid labore. Rerum debitis nobis cumque iste corporis aspernatur distinctio voluptates mollitia nulla dolorem nostrum reiciendis doloremque error assumenda fugit? Ab voluptas et quibusdam iusto distinctio architecto est placeat eaque odio quia perspiciatis quisquam numquam voluptate modi soluta eos consectetur fugiat consequuntur inventore veritatis iste animi deserunt delectus non mollitia ex eligendi tempore nihil sit excepturi. Voluptatibus quod rem blanditiis eaque non odio quaerat quia possimus eum tempore officia omnis minima id voluptas fugit adipisci laudantium sed similique iste aliquid odit doloremque ex autem iusto quis!</p>
		
		
		
		<p class="lead">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Impedit quidem provident suscipit libero cumque aliquid repellat ipsa delectus sed aperiam laborum fugit pariatur atque ad sit voluptas accusamus error praesentium!</p>
		<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Non aspernatur et quas ut dolorem eligendi blanditiis facere eos libero quae mollitia maiores in nihil assumenda omnis ad ducimus est fuga reprehenderit iure officiis cumque dignissimos sint! Autem nesciunt quod est minus iusto et quam iste perspiciatis aspernatur doloribus quos facere. Quibusdam iure nisi temporibus fuga ab qui quia tempore odio. Qui est doloremque reiciendis placeat incidunt laborum facilis itaque rerum neque deleniti possimus in nulla amet recusandae voluptates nisi culpa iure doloribus commodi molestiae illo nihil inventore consequatur accusantium minima fugiat iste eius ipsam temporibus blanditiis! Officiis quibusdam autem voluptate!</p>
		<p>Quibusdam atque harum quae architecto ratione alias. Soluta nobis iure perspiciatis eaque odio aut iste fuga earum laudantium totam. Eligendi architecto cum rerum doloremque suscipit deleniti sed magni illum necessitatibus totam inventore ipsa deserunt quasi amet cumque nostrum libero nulla assumenda ratione doloribus delectus impedit quibusdam nesciunt aliquam enim sunt repellat tempora vitae minima. Voluptatibus alias suscipit numquam deserunt quidem voluptatum dolore consectetur quam velit placeat aut explicabo facilis. Labore deserunt laudantium consequatur quis ab accusamus nobis odio tempora inventore earum eius eligendi cumque quia quas repellendus sequi facilis mollitia impedit nostrum reprehenderit modi animi omnis ratione natus quam iste!</p>
		<p>Eum maxime possimus adipisci dolor officiis eaque cumque magni porro ipsum voluptatem nulla architecto aliquid labore. Rerum debitis nobis cumque iste corporis aspernatur distinctio voluptates mollitia nulla dolorem nostrum reiciendis doloremque error assumenda fugit? Ab voluptas et quibusdam iusto distinctio architecto est placeat eaque odio quia perspiciatis quisquam numquam voluptate modi soluta eos consectetur fugiat consequuntur inventore veritatis iste animi deserunt delectus non mollitia ex eligendi tempore nihil sit excepturi. Voluptatibus quod rem blanditiis eaque non odio quaerat quia possimus eum tempore officia omnis minima id voluptas fugit adipisci laudantium sed similique iste aliquid odit doloremque ex autem iusto quis!</p>
		
		
		
		<p class="lead">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Impedit quidem provident suscipit libero cumque aliquid repellat ipsa delectus sed aperiam laborum fugit pariatur atque ad sit voluptas accusamus error praesentium!</p>
		<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Non aspernatur et quas ut dolorem eligendi blanditiis facere eos libero quae mollitia maiores in nihil assumenda omnis ad ducimus est fuga reprehenderit iure officiis cumque dignissimos sint! Autem nesciunt quod est minus iusto et quam iste perspiciatis aspernatur doloribus quos facere. Quibusdam iure nisi temporibus fuga ab qui quia tempore odio. Qui est doloremque reiciendis placeat incidunt laborum facilis itaque rerum neque deleniti possimus in nulla amet recusandae voluptates nisi culpa iure doloribus commodi molestiae illo nihil inventore consequatur accusantium minima fugiat iste eius ipsam temporibus blanditiis! Officiis quibusdam autem voluptate!</p>
		<p>Quibusdam atque harum quae architecto ratione alias. Soluta nobis iure perspiciatis eaque odio aut iste fuga earum laudantium totam. Eligendi architecto cum rerum doloremque suscipit deleniti sed magni illum necessitatibus totam inventore ipsa deserunt quasi amet cumque nostrum libero nulla assumenda ratione doloribus delectus impedit quibusdam nesciunt aliquam enim sunt repellat tempora vitae minima. Voluptatibus alias suscipit numquam deserunt quidem voluptatum dolore consectetur quam velit placeat aut explicabo facilis. Labore deserunt laudantium consequatur quis ab accusamus nobis odio tempora inventore earum eius eligendi cumque quia quas repellendus sequi facilis mollitia impedit nostrum reprehenderit modi animi omnis ratione natus quam iste!</p>
		<p>Eum maxime possimus adipisci dolor officiis eaque cumque magni porro ipsum voluptatem nulla architecto aliquid labore. Rerum debitis nobis cumque iste corporis aspernatur distinctio voluptates mollitia nulla dolorem nostrum reiciendis doloremque error assumenda fugit? Ab voluptas et quibusdam iusto distinctio architecto est placeat eaque odio quia perspiciatis quisquam numquam voluptate modi soluta eos consectetur fugiat consequuntur inventore veritatis iste animi deserunt delectus non mollitia ex eligendi tempore nihil sit excepturi. Voluptatibus quod rem blanditiis eaque non odio quaerat quia possimus eum tempore officia omnis minima id voluptas fugit adipisci laudantium sed similique iste aliquid odit doloremque ex autem iusto quis!</p>
		
	
	</div>
	
</body>
</html>