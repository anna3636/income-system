<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/app.jsp">
  <c:param name="content">

    <h2>バイト収入管理トップページ</h2>

  <div id="select_button">
   <c:if test="${sessionScope.login_work !=null}">
    <div class="box1"><a href="<c:url value='/wages/index?id=${wage.work.id}' />">収入管理</a></div>


     <div><a href="<c:url value='/information/index' />">バイト収入情報</a></div>
    <div><a href="<c:url value='/goals/index?id=${goal.work.id }' />">目標設定</a></div>
    </c:if>
   </div>

  <div id="all_income">
   <h2>合計収入</h2>
   <div>(${income_count}　円)</div>
   </div>

   <div id="max_goal">
    <h2>一番高い目標まで</h2>
    <c:if test="${max_goal > income_count }" >
      <div>${max_goal - income_count} 円</div>
    </c:if>
    <c:if test="${max_goal <= income_count}">
      <div>目標達成おめでとう！！</div>
    </c:if>
   </div>


  </c:param>
</c:import>