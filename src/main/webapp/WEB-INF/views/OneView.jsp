<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 정보</title>
<style>
#field {
	width: 65%;
	font-size: 20px;
	margin-left: auto;
	margin-right: auto;
	margin-top: 5%;
	background-color: white;
	font-family: 'Times New Roman', Times, serif;
}

h1, p {
	text-align: center;
}

a {
	text-decoration: none;
}

a.button {
  display: block;
  position: absolute;
  right: 330px;
  float: left;
  width: 120px;
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
  	transition: all 0.2s;
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
	<h1>${get_list.name} 학생의 점수</h1>
	<p><a href="/ScoreItem/Insert?id=${get_list.id}" title="Button push blue/green" class="button btnPush btnBlueGreen">시험 점수 추가</a></p>
	<table id=field border=1>
		<tr bgcolor=lightgreen>
			<td width=50><p>시험명</p></td>
			<td width=50><p>국어</p></td>
			<td width=50><p>영어</p></td>
			<td width=50><p>수학</p></td>
			<td width=50><p>총점</p></td>
			<td width=50><p>평균</p></td>
			<td width=50><p>수정</p></td>
			<td width=50><p>삭제</p></td>
		</tr>
		<c:forEach var="scoreItem" items="${scoreList}" varStatus="status">
			<tr>
				<td width=50><p>${scoreItem.name}</p></td>
				<td width=50><p>${scoreItem.kor}</p></td>
				<td width=50><p>${scoreItem.eng}</p></td>
				<td width=50><p>${scoreItem.mat}</p></td>
				<td width=50><p><fmt:formatNumber value="${scoreItem.mat + scoreItem.kor + scoreItem.eng}" pattern="#,###" /></p></td>
				<td width=50><p><fmt:formatNumber value="${(scoreItem.mat + scoreItem.kor + scoreItem.eng) / 3}" pattern="##.##" /></p></td>
				<td width=50><p><a href="/ScoreItem/Update?id=${scoreItem.id}" title="UpdateButton push orange" class="UpdateButton btnPush btnOrange">수정</a>
				</p></td>
				<td width=50><p><a href="/ScoreItem/Delete?id=${scoreItem.id}" title="DeleteButton push purple" class="DeleteButton btnPush btnPurple">삭제</a>
				</p></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>