<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<label for="targetAmount">目標金額を入力</label>
<br />
<input type="number" name="targetAmount" value="${goal.targetAmount}" />
<br />
<br />

<label for="purpose">目的を入力</label>
<br />
<input type="text" name="purpose" value="${goal.purpose}" />
<br />
<br />

<input type="hidden" name="_check" value="${_check}" />
<button type="submit">設定！</button>

