<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>バイト収入管理</title>
<link rel="stylesheet" href="<c:url value='/css/reset.css'/>">
<link rel="stylesheet" href="<c:url value='/css/style.css'/>">

</head>
<body>



    <header>
        <h1 class="headline">
            <a href="<c:url value='/' />">バイト収入管理</a>
        </h1>
        &nbsp;&nbsp;&nbsp;

        <c:if test="${sessionScope.loginWork !=null }">
            <div id="work_name">
                <c:out value="${sessionScope.loginWork.name}" />
                &nbsp;さん&nbsp;&nbsp;&nbsp; <a href="<c:url value='/logout'/>">ログアウト</a>
            </div>
        </c:if>
    </header>




    <div id="content">${param.content}</div>
    <div id="footer">by Anna.</div>




</body>
</html>