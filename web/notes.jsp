<%@ page import="java.util.ArrayList" %>
<%@ page import="com.aigulsharip.java_ee.lecture5.db.Note" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> Doctors' Notes</title>
    <link rel = "stylesheet" type = "text/css" href = "bootstrap/css/bootstrap.min.css">
</head>
<body>
<div class = "container-fluid">
    <div class = "row">
        <div class="col-12">
            <%@include file="navbar.jsp"%>
        </div>
    </div>

    <div class = "container-fluid">
        <div class = "row">
            <div class = "col mx-auto">
                <%
                    ArrayList <Note> notes = (ArrayList<Note>) request.getAttribute("notes");
                    if (notes != null) {
                        for (Note note: notes) {
                %>

                <div class = "mt-4 border-bottom">
                    <a href = "/readNote?id=<%=note.getId()%> " style = "text-decoration: none; color: black">
                        <h3> Patient name: <%=note.getPatientName()%></h3>
                    </a>
                    <p>Type of visit: <%=note.getNoteType()%></p>
                    <p><%=note.getContent()%></p>
                    <p> Posted by <strong><%=note.getDoctor().getFullName()%></strong> at <strong> <%=note.getVisitTime()%></strong></p>
                    <p><%=note.getLikes()%> likes </p>
                </div>
                <%
                        }
                    }
                %>

            </div>
        </div>
    </div>
</div>




</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

</html>
