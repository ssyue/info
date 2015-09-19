

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body><form>
			<table>
			<tr><td>姓名</td>
						<td>${requestScope.entity.name}</td>
						</tr>
				<tr><td>电话号码:</td>
						<td>${requestScope.entity.phoneNum}</td>
						</tr>
				<tr><td>身份证号</td>
						<td>${requestScope.entity.IDNum}</td>
						</tr>
				<tr><td>预约时间</td>
						<td>${requestScope.entity.date}</td>
						</tr>
			</table>
			</form>
			
</body>
</html>