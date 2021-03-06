<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="../layout/app.jsp">
    <c:param name="content">

        <h2>バイト収入管理トップページ</h2>

        <div id="select_button">
            <c:if test="${sessionScope.loginWork !=null}">
                <div id="button1">
                    <a href="<c:url value='/wages/index?id=${wage.work.id}' />">収入管理</a>
                </div>

                <div id="button2">
                 <c:if test="${sessionScope.loginWork.adminFlag == 1 }">
                    <a href="<c:url value='/works/index' />">ユーザー管理者用ページ</a>
                 </c:if>
                </div>

                <div id="button3">
                    <a href="<c:url value='/goals/index?id=${goal.work.id }' />">目標設定画面へ</a>
                </div>
            </c:if>
        </div>


        <div id="all_income">
            <h2>合計収入</h2>
            <div>${incomeCount}円</div>
        </div>



        <div id="maxGoal">
            <h2>一番高い目標まで</h2>
            <c:if test="${maxGoal > incomeCount }">
                <div>${maxGoal - incomeCount}円</div>
            </c:if>
            <c:if test="${maxGoal <= incomeCount}">
                <div>目標達成おめでとう！！</div>
            </c:if>
        </div>





    </c:param>
</c:import>