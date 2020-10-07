<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/WEB-INF/views/layout/app.jsp">
 <c:param name="content">
  <c:choose>
   <c:when test="${work !=null }">
    <h2>id : ${work.id}　の詳細　編集ページ</h2>
    <p>パスワードは変更する場合のみ入力してください。</p>
    <p>ユーザー名はすでに存在するものでは登録できません。</p>
    <form method="POST" action="<c:url value='/works/update' />">
     <c:import url="_form.jsp" />
    </form>

    <p><a href="#" onclick="confirmDestroy();">このユーザーを削除する</a></p>
    <form method="POST" action="<c:url value='/works/destroy' />">
     <input type="hidden" name="_check" value="${_check }" />
    </form>
    <script>
    function confirmDestroy(){
        if(confirm("本当に消してしまいますが…")){
            document.forms[1].submit();

        }
    }
    </script>
   </c:when>
   <c:otherwise>
   <h2>お探しのデータは見つかりませんでした。</h2>
   </c:otherwise>
  </c:choose>
  <p><a href="<c:url value='/works/index' />">一覧へ</a></p>
 </c:param>
</c:import>