<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="/WEB-INF/views/layout/app.jsp">
<c:param name="content">
<h2>目標　金額</h2>
 <table id="goal_list">
  <tbody>
   <tr>
    <th class="target_amount">目標金額</th>
    <th class="purpose">目的</th>
    <th class="created_date">登録日時</th>
    <th class="updated_date">更新日時</th>
   </tr>

   <c:forEach var="goal" items="${goals}" varStatus="status">
    <tr class="row${status.count %2 }">
     <td class="target_amount"><c:out value="${goal.targetAmount}" /></td>
     <td class="purpose"><c:out value="${goal.purpose}" /></td>
     <td class="created_date"><fmt:formatDate value="${goal.created_at }"/></td>
     <td class="updated_at"><fmt:formatDate value="${goal.updated_at }"/></td>
    </tr>

   </c:forEach>

  </tbody>
 </table>
   <p><a href="<c:url value='/goals/new' />">新規の登録</a></p>
</c:param>
</c:import>