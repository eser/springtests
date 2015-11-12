<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Midterm</title>
        <style>
            #container{
                font-family: arial;
                width:400px;
                font-size:16px;
            }
            table{
                width:400px;
                margin-bottom: 20px;
            }
            td{
                padding:6px;
            }
            input , select{
                font-size:16px;
            }           
            input[type="number"]{
                width:50px;
            }
            #result-table{
                margin:0px;
                padding:0px;
                border-collapse:collapse;
                border-spacing:0;
                text-align: center;
            }
            
            #result-table th{
                padding:10px 6px;
            }
            #result-table td , #result-table th{
                border:1px solid #414141;
            }
            #result-table tr:nth-child(even) , #result-table th {
               background-color: #ccc;
            }
            #submit_btn{
                padding:20px;
                font-size:18px;
            }
        </style>
    </head>
    <body>
        <div id="container">
            <form action="add" method="post">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <table id="form-table">
                    <tr>
                        <td>Home Team</td>
                        <td>
                            <select name="hometeam" id="hometeam">
                                <option>Arsenallll</option>
                                <option>2</option>
                                <option>3</option>
                            </select>
                            <select name="hometeam">
                            <c:forEach var="team" items="${teams}">
                                <option value="${team.id}">${team.name}</option>
                            </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Home Team Score</td>
                        <td>
                            <input type="number" id="homescore" name="homescore" value="0" placeholder="Score" />
                        </td>
                    </tr>
                    <tr>
                        <td>Away Team</td>
                        <td>
                            <select name="awayteam" id="awayteam">
                            <c:forEach var="team" items="${teams}">
                                <option value="${team.id}">${team.name}</option>
                            </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Away Team Score</td>
                        <td>
                            <input type="number" id="awayscore" name="awayscore" value="0" placeholder="Score" />
                        </td>
                    </tr>               
                    <tr>
                        <td></td>
                        <td><button type="submit" id="submit_btn">Submit</button></td>
                    </tr>                               
                </table>
            </form>
        </div>
    </body>
</html>