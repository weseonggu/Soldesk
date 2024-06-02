<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="css/ouputStyle.css">


</head>
<body>
	<table>
		<tr>
			<td align="center" colspan="2"><h3>결과</h3></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><img src="img/${guest.fname}"></td>
		</tr>
		<tr>
			<td align="center">이름</td>
			<td align="center">${guest.name}</td>
		</tr>
		<tr>
			<td align="center">키</td>
			<td align="center">${guest.h}</td>
		</tr>
		<tr>
			<td align="center">몸무게</td>
			<td align="center">${guest.w}</td>
		</tr>
		<tr>
			<td align="center">BMI</td>
			<td align="center">${guest.bmi}</td>
		</tr>
		<tr>
			<td colspan="2" align="center">${guest.result}</td>
		</tr>
	</table>
</body>
</html>