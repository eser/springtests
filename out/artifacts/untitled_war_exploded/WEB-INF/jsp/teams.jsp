<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<body>
<h2>Add Team</h2>

<form action="add" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <table>
        <tr>
            <td>Name:</td>
            <td><input type="text" name="name" /></td>
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
        <caption>List of Teams</caption>
        <tr>
            <td>Name</td>
        </tr>
        <c:forEach var="team" items="${teams}">
            <tr>
                <td>${team.name}</td>
            </tr>
        </c:forEach>
    </table>
    <table id="result-table">
        <thead>
            <tr>
                <th>Home</th>
                <th>Away</th>
                <th>Score</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="team" items="${teams}">
            <tr>
                <td>${team.hometeam}</td>
                <td>${team.awayteam}</td>
                <td>${team.homescore} - ${team.awayscore}</td>
            </tr>
            </c:forEach>
        </tbody>                        
    </table>    
</c:if>

</body>
</html>
