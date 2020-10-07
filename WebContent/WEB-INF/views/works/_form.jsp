<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${errors!=null}">
<div id="flush_error">
入力内容に問題があります。<br/>
 <c:forEach var="error" items="${errors}">
  ・<c:out value="${error}"/><br />
 </c:forEach>
</div>
</c:if>
<label for="name">氏名</label><br />
<input type="text" name="name" value="${work.name }" />
<br /><br />

<label for="password">パスワード</label><br />
<input type="password" name="password"/>
<br /><br />


<label for="admin_flag">権限</label><br />
<select name="admin_flag">
  <option value="0"<c:if test="${work.admin_flag == 0}"> selected</c:if>>ユーザー</option>
  <option value="1"<c:if test="${work.admin_flag == 1}"> selected</c:if>>管理者</option>
</select>
<br /><br />

<input type="hidden" name="_check" value="${_check}" />
<button type="submit">送信</button>
