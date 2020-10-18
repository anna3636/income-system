<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">

        <h2>収入情報一覧</h2>

        <div>(合計 ${income_count} 円)</div>

        <table id="wage_list">
            <tbody>
                <tr>
                    <th class="date_list">日時</th>
                    <th class="income_list">給料</th>
                </tr>
                <c:forEach var="wage" items="${wages}" varStatus="status">
                    <tr class="row${status.count % 2 }">
                        <td><fmt:formatDate value="${wage.work_date}"
                                pattern="yyyy-MM-dd" /></td>
                        <td><c:out value="${wage.income}" /></td>
                        <td><a href="<c:url value='/wages/show?id=${wage.id}' />">詳細へ</a></td>
                    </tr>
                </c:forEach>

            </tbody>
        </table>

        <p>
            <a href="<c:url value='/wages/new' />">新規収入の登録</a>
        </p>
    </c:param>
</c:import>