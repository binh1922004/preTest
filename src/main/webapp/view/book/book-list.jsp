<%--
  Created by IntelliJ IDEA.
  User: binh
  Date: 11/9/2024
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/conmon/taglib.jsp"%>

<table>
    <tr>
        <th>STT</th>
        <th>Mã isbn</th>
        <th>Tiêu đề</th>
        <th>Số lượng</th>
    </tr>
    <c:forEach items="${listbook}" var="book" varStatus="STT" >
        <tr class="odd gradeX">
            <td>${STT.index+1 }</td>
            <td>${book.isbn}</td>
            <td>${book.title}</td>
            <td>${book.quantity}</td>
        </tr>
    </c:forEach>
</table>