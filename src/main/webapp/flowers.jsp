<!DOCTYPE html>
<html>
<head>
    <title>List of Flowers</title>
</head>
<body>
    <h1>Flowers in the Shop</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Description</th>
            <th>Price</th>
        </tr>
        <c:forEach var="flower" items="${flowers}">
            <tr>
                <td>${flower.id}</td>
                <td>${flower.name}</td>
                <td>${flower.description}</td>
                <td>${flower.price}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>