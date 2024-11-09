<%--
  Created by IntelliJ IDEA.
  User: binh
  Date: 11/9/2024
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/conmon/taglib.jsp"%>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>


<table class="table">
    <tr>
        <th>STT</th>
        <th>Mã isbn</th>
        <th>Tiêu đề</th>
        <th>Số lượng</th>
        <th>Chi tiết</th>
    </tr>
    <c:forEach items="${listbook}" var="book" varStatus="STT" >
        <tr class="odd gradeX">
            <td>${STT.index+1 }</td>
            <td>${book.isbn}</td>
            <td>${book.title}</td>
            <td>${book.quantity}</td>
            <td>
                <a href="<%=request.getContextPath()%>/book/detail?bookid=${book.id}">Detail</a>
            </td>
            <td>
                <a href="<%=request.getContextPath()%>/book/edit?bookid=${book.id}">Update</a>
            </td>
        </tr>
    </c:forEach>
</table>

<nav aria-label="Page navigation example">
    <ul class="pagination">
        <c:forEach items="${pageNumbers}" var="pageNumber">
            <li class="page-item">
                <a style="background: blue; color: white" href="<%=request.getContextPath()%>/books?pageNumber=${pageNumber}" class="page-link">
                        ${pageNumber}
                </a>
            </li>
        </c:forEach>
    </ul>
</nav>