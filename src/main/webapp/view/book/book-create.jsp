<%--
  Created by IntelliJ IDEA.
  User: binh
  Date: 11/9/2024
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<form action="<%=request.getContextPath()%>/book/insert" method="post" enctype="multipart/form-data">
    <div class="form-group">
        <label for="isbn">Isbn code:</label>
        <input type="text" id="isbn" name="isbn" class="form-control"><br>
    </div>

    <div class="form-group">
        <label for="title">Title:</label>
        <input type="text" id="title" name="title" class="form-control"><br>
    </div>

    <div class="form-group">
        <label for="publisher">Publisher</label><br>
        <input type="text" id="publisher" name="publisher" class="form-control"><br>
    </div>

    <div class="form-group">
        <label for="price">Price:</label>
        <input type="text" id="price" name="price" class="form-control"><br>
    </div>

    <div class="form-group">
        <label for="description">Description:</label>
        <textarea id="description" name="description" class="form-control"></textarea><br>
    </div>

    <div class="form-group">
        <label for="publishDate">Publish date:</label>
        <input type="date" id="publishDate" name="publishDate" class="form-control"><br>
    </div>

    <div class="form-group">
        <label for="cvimage">Upload cover image</label><br>
        <input type="file" id="cvimage" name="cvimage" class="form-control"><br>
    </div>

    <div class="form-group">
        <label for="quantity">Quantity</label><br>
        <input type="text" id="quantity" name="quantity" class="form-control"></input><br>
    </div>

    <input type="submit" value="Insert">

</form>