<%--
  Created by IntelliJ IDEA.
  User: binh
  Date: 11/9/2024
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/conmon/taglib.jsp"%>

<p>Tiêu đề: ${book.title} </p>
<p>Mã isbn: ${book.isbn}</p>
<p>Publisher: ${book.publisher}</p>
<p>Publisher date: ${book.publishdate}</p>
<p>Quantity: ${book.quantity}</p>