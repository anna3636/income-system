<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/WEB-INF/views/layout/app.jsp">
 <c:param name="content">
  <c:choose>
   <c:when test="${wage !=null }">
    <h2>収入管理編集ページ</h2>
    <form method="POST" action="<c:url value='/wages/update' />">
     <c:import url="_form.jsp" />
    </form>
   </c:when>
   <c:otherwise>
    <h2>お探しのデータは見つかりません。</h2>
   </c:otherwise>
  </c:choose>
  <p><a href="<c:url value='/wages/index' />">一覧に戻る</a></p>
 </c:param>
</c:import>