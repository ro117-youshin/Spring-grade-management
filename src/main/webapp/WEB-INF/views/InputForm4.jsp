<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<title>성적 정보 수정</title>
	<style>
		table {
			width:700;
			text-align: center;
			margin-left: auto;
			margin-right: auto;
			font-family: 'Times New Roman', Times, serif;
			font-size: 30px;
			margin-top: 5%;
		}
	
		h1 {
			font-family: 'Times New Roman', Times, serif;
			font-size: 50px;
			text-align: center;
			margin-top: 20%;
		}
		
		input.button {
		  display: block;
		  position: absolute;
		  right: 500px;
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
		
		.btnBlueGreen {
			background: #00AE68;
		}
			
		.btnBlueGreen.btnPush {
			box-shadow: 0px 5px 0px 0px #007144;
		}
			
		.btnBlueGreen.btnPush:hover {
			box-shadow: 0px 0px 0px 0px #007144;
		}
	</style>
	<!-- 한글과 영어 이름만 가능하도록, 특수문자나 숫자, 띄어쓰기 입력 방지를 위한 함수 -->
	<script>    
		function characterCheck(obj){
			var reg = /[\{\}\[\]\/?.,;:|\-_+<>@\#$%&\'\"\\\()\=`~!^*123456789\s]/gi;
			if (reg.test(obj.value)){
				alert("특수문자나 숫자, 띄어쓰기는 입력하실수 없습니다.");
				obj.value = obj.value.substring(0,0);
			}
		}
		window.onload = function() {
		document.querySelector('form').addEventListener('submit', function(e){
			if(document.getElementById('kor').value == '' || 
				document.getElementById('eng').value == '' || 
				document.getElementById('mat').value == '' ){
				e.preventDefault()//이름 미입력을 방지
				alert('입력란을 모두 입력하세요')} 
		});
		}
	</script>
</head>
<body>
	<h1>성적 수정</h1>
	<form method = "post" action = "/ScoreItem/Update">
		<table cellspacing=1>
			<tr>
				<td width=550></td>
				<td width=100><input type = "submit" id = "submit" title="Button push blue/green" class="button btnPush btnBlueGreen" value = "수정"></td>
			</tr>
		</table>
		
		<table border = 1, black>
			<tr>
				<td width=150 bgcolor=lightgreen><p align=center>순번</p></td>
				<td width=550 align=center><input type=number id=id name=id value="${getItem.id}" readonly></td>
			</tr>
			<tr>
				<td width=150 bgcolor=lightgreen><p align=center>학생순번</p></td>
				<td width=550 align=center><input type=number id=listId name=listId value="${getItem.scoreList.id}" readonly></td>
			</tr>
			<tr>
				<td width=150 bgcolor=lightgreen><p align=center>시험명</p></td>
				<td width=550 align=center><input type = "text" id = "testname" onkeyup = "characterCheck(this)" name = "name" maxlength = "10" value="${getItem.name}"/></td>
			</tr>
			<tr>
				<td width=150 bgcolor=lightgreen><p align=center>국어점수</p></td>
				<td width=550 align=center><input type=number id=kor name=kor min=0 max=100 value="${getItem.kor}"></td>
			</tr>
			<tr>
				<td width=150 bgcolor=lightgreen><p align=center>영어점수</p></td>
				<td width=550 align=center><input type=number id=eng name=eng min=0 max=100 value="${getItem.eng}"></td>
			</tr>
			<tr>
				<td width=150 bgcolor=lightgreen><p align=center>수학점수</p></td>
				<td width=550 align=center><input type=number id=mat name=mat min=0 max=100 value="${getItem.mat}"></td>
			</tr>
		</table>
	</form>
</body>
</html>