<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<body>
<h2>Add Team</h2>

<form action="add" method="post">
    <table>
        <tr>
            <td>Name:</td>
            <td><input type="text" name="name" /></td>
        </tr>
        <tr>
            <td>Age:</td>
            <td><input type="text" name="age" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <button type="submit">Add!</button>
            </td>
        </tr>
    </table>
</form>

<c:if test="${not empty teams}">
    <table border="1">
        <caption>All Teams</caption>
        <tr>
            <td>ID</td>
            <td>Name</td>
            <td>Age</td>
        </tr>
        <c:forEach var="team" items="${teams}">
            <tr>
                <td>${team.id}</td>
                <td>${team.name}</td>
                <td>${team.age}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<c:if test="${not empty oldTeams}">
    <table border="1">
        <caption>Old Teams</caption>
        <tr>
            <td>ID</td>
            <td>Name</td>
            <td>Age</td>
        </tr>
        <c:forEach var="team" items="${oldTeams}">
            <tr>
                <td>${team.id}</td>
                <td>${team.name}</td>
                <td>${team.age}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
