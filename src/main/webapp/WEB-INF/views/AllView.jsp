<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 전체 조회</title>
<style>

#addButton{
	position: absolute;	
	left: 18%;
}

#field {
	width: 55%;
	font-size: 20px;
	margin-top: 5%;
	margin-left: auto;
	margin-right: auto;
	background-color: white;
	font-family: 'Times New Roman', Times, serif;
}

#list {
	margin-left: auto;
	margin-right: auto;
	font-family: 'Times New Roman', Times, serif;
	font-size: 20px;
}

h1, p {
	text-align: center;
}
.aTag {
	display: block;
}
a {
	text-decoration: none;
}

a.button {
	margin-left: 100%;
  	display: block;
  	right: 340px;
  	float: left;
  	width: 100px;
  	padding: 0;
  	margin: 10px 20px 10px 0;
  	font-weight: 600;
  	text-align: center;
  	line-height: 50px;
  	color: #FFF;
  	border-radius: 5px;
  	transition: all 0.2s ;
}

a.UpdateButton, a.DeleteButton {
	display: block;
	width: 80px;
  	padding: 0;
  	margin: 0px auto;
  	font-weight: 600;
  	text-align: center;
  	line-height: 50px;
  	color: #FFF;
  	border-radius: 5px;
  	transition: all 0.2s ;
}

.btnBlueGreen {
  background: #00AE68;
}

.btnBlueGreen.btnPush {
  box-shadow: 0px 5px 0px 0px #007144;
}

.btnBlueGreen.btnPush:hover {
  box-shadow: 0px 0px 0px 0px #007144;
}

.btnOrange {
  background: #FFAA40;
}

.btnOrange.btnPush {
  box-shadow: 0px 5px 0px 0px #A66615;
}

.btnOrange.btnPush:hover {
  box-shadow: 0px 0px 0px 0px #A66615;
}

.btnPurple {
  background: #A74982;
}

.btnPurple.btnPush {
  box-shadow: 0px 5px 0px 0px #6D184B;
}

.btnPurple.btnPush:hover {
  box-shadow: 0px 0px 0px 0px #6D184B;
}
</style>
</head>
<body>
	<h1><a href="/">전체 성적 조회</a></h1>
	<div id=addButton>
		<a href="/ScoreList/InputForm1" title="Button push blue/green" class="button btnPush btnBlueGreen">학생 추가</a>
	</div>
		<table id=field border=1>
			<tr bgcolor=lightgreen>
				<td width=50><p>이름</p></td>
				<td width=50><p>학번</p></td>
				<td width=30><p>수정</p></td>
				<td width=30><p>삭제</p></td>
			</tr>
			<c:forEach var="scoreList" items="${scoreList}" varStatus="status">
				<tr>
					<td width=50><p><a href="/ScoreList/OneView?id=${scoreList.id}">${scoreList.name}</a></p></td>
					<td width=50><p>${scoreList.studentid}</p></td>		
					<td width=30>
						<div class="aTag">
							<a href="/ScoreList/Update?id=${scoreList.id}" title="UpdateButton push orange" class="UpdateButton btnPush btnOrange">수정</a>
						</div>
					</td>
					<td width=30>
						<div class="aTag" >
							<a href="/ScoreList/Delete?id=${scoreList.id}" title="DeleteButton push purple" class="DeleteButton btnPush btnPurple">삭제</a>
						</div>
					</td>
				</tr>
			</c:forEach>
		</table>
	 <table id=list>
		<tr>
			<td width=50><p><a href="/ScoreList/AllView?page=${p.ppPage-1}&size=${p.pageSize}">&lt;&lt;</a></p></td>
			<td width=50><p><a href="/ScoreList/AllView?page=${p.pPage-1}&size=${p.pageSize}">&lt;</a></p></td>
			<c:forEach var="i" begin="${p.sPage}" end="${p.ePage}">
				<td width=50><p><a href="/ScoreList/AllView?page=${i-1}&size=${p.pageSize}">${i}</a></p></td>
			</c:forEach>
			<td width=50><p><a href="/ScoreList/AllView?page=${p.nPage-1}&size=${p.pageSize}">&gt;</a></p></td>
			<td width=50><p><a href="/ScoreList/AllView?page=${p.nnPage-1}&size=${p.pageSize}">&gt;&gt;</a></p></td>			
		</tr>
	</table>
</body>
</html>