<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">

        <c:choose>
            <c:when test="${wage !=null}">
                <h2>バイト収入詳細ページ</h2>

                <table id=show_list>
                    <tbody>
                        <tr>
                            <th>バイト名</th>
                            <td><c:out value="${wage.workName}" /></td>
                        </tr>
                        <tr>
                            <th>日付</th>
                            <td><fmt:formatDate value="${wage.workDate}"
                                    pattern="yyyy-MM-dd" /></td>
                        </tr>
                        <tr>
                            <th>収入</th>
                            <td><c:out value="${wage.income}" /></td>
                        </tr>
                        <tr>
                            <th>メモ</th>
                            <td><pre>
                                    <c:out value="${wage.content}" />
                                </pre></td>
                        </tr>
                    </tbody>
                </table>

                <c:if test="${sessionScope.loginWork.id==wage.work.id }">
                    <p>
                        <a href="<c:url value="/wages/edit?id=${wage.id}"/>">この収入管理を編集する</a>
                    </p>
                </c:if>
            </c:when>
            <c:otherwise>
                <h2>お探しのデータはみつかりません</h2>
            </c:otherwise>
        </c:choose>
        <p>
            <a href="<c:url value="/wages/index" />">収入一覧に戻る</a>
        </p>
    </c:param>
</c:import>
