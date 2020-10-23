<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:if test="${errors !=null}">
 <div id="flush_error">
 入力内容に問題があります。<br/>
 <c:forEach var="error" items="${errors}">
  <c:out value="${error}" /><br />
 </c:forEach>
 </div>
</c:if>


<label for="work_name">バイト名</label>
<br />
<input type="text" name="work_name" value="${wage.work_name}" />
<br />
<br />

<label for="work_date">日付</label>
<br />
<input type="date" name="work_date"
    value="<fmt:formatDate value='${wage.work_date}' pattern='yyyy-MM-dd' />" />
<br />
<br />

<label for="income">収入</label>
<br />
<input type="number" name="income" value="${wage.income}" />
<br />
<br />

<label for="content">メモ</label>
<br />
<textarea name="content" rows="6" cols="50">${wage.content}</textarea>
<br />
<br />

<input type="hidden" name="_check" value="${_check}" />
<button type="submit">投稿</button>
