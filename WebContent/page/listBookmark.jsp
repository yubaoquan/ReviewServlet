<%@ page
	import="service.BookmarkService,bean.Bookmark,java.util.Iterator"
	language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		BookmarkService bookmarkService = (BookmarkService) getServletContext().getAttribute("bookmarkService");
		Iterator<Bookmark> bookmarkIterator = bookmarkService.getBookmarks().iterator();
	%>
	<table>
		<tr>
			<td style="background-color: rgb(51, 255, 255);">·ÖÀà</td>
		</tr>
		<%
			while (bookmarkIterator.hasNext()) {
				Bookmark bookmark = bookmarkIterator.next();
		%>
		<tr>
			<td><a href="http://<%=bookmark.getUrl()%>" target="_blank"><%=bookmark.getTitle()%></a></td>
			<td><%=bookmark.getCategory()%></td>
		</tr>

		<%
			}
		%>

	</table>
	<%@include file="/addBookmark.html"%>
</body>
</html>