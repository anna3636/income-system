<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/WEB-INF/views/layout/app.jsp">
<c:param name="content">

 <h2>ログイン画面</h2>
 <form method="POST" action="<c:url value='/login' />">
  <label for="name">ユーザー名</label>
  <input type="text" name="name" value="${name}" />

  <label for="password">パスワード</label>
  <input type="text" name="password" value="${password}" />

  <input type="hidden" name="_check" value="${_check }" />
  <button type="submit">ログインします</button>
 </form>
 <div>
<p><a href="<c:url value='/works/new' />">新規収入の登録</a></p>
 </div>

</c:param>
</c:import>