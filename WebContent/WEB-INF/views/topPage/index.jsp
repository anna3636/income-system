<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/app.jsp">
  <c:param name="content">

    <h2>バイト収入管理トップページ</h2>

  <div id="select_button">
   <c:if test="${sessionScope.login_work !=null}">
    <div><a href="<c:url value='/wages/index?id=${wage.work.id}' />">収入管理</a></div>

    //ここは後で情報を追加していく
     <div><a href="<c:url value='/information/index' />">バイト収入情報</a></div>
    <div><a href="<c:url value='/goal/index' />">目標設定</a></div>
    </c:if>
   </div>


  </c:param>
</c:import>