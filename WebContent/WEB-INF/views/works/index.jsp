<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="../layout/app.jsp">
    <c:param name="content">
        <c:if test="${flush !=null}">
            <div id="flush_success">
                <c:out value="${flush}"></c:out>
            </div>
        </c:if>
        <h2>ユーザー 一覧</h2>
        <table id="menber_list">
            <tbody>
                <tr>
                    <th>ユーザー名</th>
                    <th>操作</th>
                </tr>
                <c:forEach var="work" items="${works}" varStatus="status">
                    <tr class="row${status.count % 2}">
                        <td><c:out value="${work.name}" /></td>
                        <td><c:choose>
                                <c:when test="${work.delete_flag == 1}">
                                            (削除されました)
                                </c:when>
                                <c:otherwise>
                                    <a href="<c:url value='/works/show?id=${work.id}'/>">詳細へ</a>
                                </c:otherwise>
                            </c:choose></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <div id="pagination">
            (全${all_number}件)<br />
            <c:forEach var="i" begin="1" end="${((all_number-1)/15)+1 }" step="1">
                <c:choose>
                    <c:when test="${i==page}">
                        <c:out value="${i}" />&nbsp;
       </c:when>
                    <c:otherwise>
                        <a href="<c:url value='/works/index?page=${i}'/>"><c:out
                                value="${i}" /></a>&nbsp;
       </c:otherwise>
                </c:choose>
            </c:forEach>
        </div>
        <p>
            <a href="<c:url value='/works/new' />">新規ユーザーの登録</a>
        </p>

    </c:param>

</c:import>
