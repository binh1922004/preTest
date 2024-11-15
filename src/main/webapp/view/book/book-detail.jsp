<%--
  Created by IntelliJ IDEA.
  User: binh
  Date: 11/9/2024
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/conmon/taglib.jsp"%>

<div>
    <div style="display: flex">
        <%--    for cover image--%>
        <div>
            <c:if test="${book.coverimage.substring(0,5) == 'https'}">
                <c:url value="${book.coverimage}" var="imgUrl"></c:url>
            </c:if>
            <c:if test="${cate.images.substring(0,5) != 'https'}">
                <c:url value="/image?fname=${book.coverimage}" var="imgUrl"></c:url>
            </c:if>
            <img height="150" width="200" src="${imgUrl}" alt=""/>
        </div>

        <%--    for content--%>
        <div>
            <p>Tiêu đề: ${book.title} </p>
            <p>Mã isbn: ${book.isbn}</p>
            <p>Publisher: ${book.publisher}</p>
            <p>Publisher date: ${book.publishdate}</p>
            <p>Quantity: ${book.quantity}</p>
        </div>
    </div>
    <div>
        <a href="<%=request.getContextPath()%>/book/edit?bookid=${book.id}">Edit</a>
    </div>
</div>