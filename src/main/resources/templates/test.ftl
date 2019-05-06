<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>测试</title>
</head>
<body>

		<table border="1px">
			<tr>
				<td>userId</td>
				<td>info</td>
				<td>infocomeId</td>
				<td>infocomeName</td>
                <td>postId</td>
                <td>postTitle</td>
            </tr>
			<#if unreads??>
			<#list unreads as unread>
			<tr>
                <td>${unread.userId}</td>
                <td>${unread.info}</td>
                <td>${unread.infocomeId}</td>
                <td>${unread.infocomeName}</td>
                <td>${unread.postId}</td>
                <td>${unread.postTitle}</td>
			</tr>
			</#list>
		</table>
		<#else>
		</#if>
</body>

</html>