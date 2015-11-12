<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<body>
<h2>Add Match Score</h2>

<form action="add" method="post">
    <table>
        <tr>
            <td>Home Team:</td>
            <td><select name="hometeam">
<c:forEach var="team" items="${teams}">
            <option value="${team.id}">${team.name}</option>
</c:forEach>
            </select></td>
        </tr>
        <tr>
            <td>Home Score:</td>
            <td><input type="text" name="homescore" /></td>
        </tr>
        <tr>
            <td>Away Team:</td>
            <td><select name="awayteam">
                <c:forEach var="team" items="${teams}">
                    <option value="${team.id}">${team.name}</option>
                </c:forEach>
            </select></td>
        </tr>
        <tr>
            <td>Away Score:</td>
            <td><input type="text" name="awayscore" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <button type="submit">Add!</button>
            </td>
        </tr>
    </table>
</form>

</body>
</html>
