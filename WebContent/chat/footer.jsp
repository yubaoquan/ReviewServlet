<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="footer">
<form name="message" action="say">
<h2 id="username">${user.username}</h2><!-- <br> -->
<textarea name="sentence"></textarea>
<input type="button" value="送出" onclick="return func1()" style="vertical-align:middle;">
</form>
</div>