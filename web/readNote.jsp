<%@ page import="java.util.ArrayList" %>
<%@ page import="com.aigulsharip.java_ee.lecture5.db.Note" %>
<%@ page import="com.aigulsharip.java_ee.lecture5.db.Comment" %>
<%--
  Created by IntelliJ IDEA.
  User: Aigul
  Date: 18.01.2022
  Time: 21:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
                                     <html>
<head>
       <title>Note</title>
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
            <div class = "col-12 mx-auto">
                <%
                     Note note = (Note) request.getAttribute("note");
                    if (note != null) {

                %>

                <div class = "mt-4 border-bottom">
                    <h2> <%=note.getPatientName()%></h2>
                    <p><%=note.getNoteType()%></p>
                    <p><%=note.getContent()%></p>

                    <p>Posted by <strong><%=note.getDoctor().getFullName()%></strong> at <strong> <%=note.getVisitTime()%></strong></p>
                </div>
                <h3>Comments: </h3>

                <div class="row mt-2">
                    <div class = "col-12">
                        <%
                            if (currentUser != null) {


                        %>
                            <div>
                                <form action = "/addComment" method="post">
                                    <input type ="hidden" name = "note_id" value="<%=note.getId()%>">
                                    <textarea class = "form-control" name = "comment" placeholder="Leave a comment"></textarea>
                                    <button class = "btn btn-success btn-sm mt-3">Add Comment</button>
                                </form>
                            </div>

                        <%
                            }
                        %>

                        <div class="list-group">
                            <%
                                ArrayList<Comment> comments = (ArrayList<Comment>) request.getAttribute("comments");
                                if(comments!=null){
                                    for(Comment c : comments){
                            %>
                            <span class="list-group-item list-group-item-action">
                                    <div class="d-flex w-100 justify-content-between">
                                        <h5 class="mb-1"><%=c.getAuthor().getFullName()%></h5>
                                        <small class="text-muted"><%=c.getPostDate()%></small>
                                    </div>
                                    <p class="mb-1"><%=c.getCommment()%></p>
                                </span>
                            <%
                                    }
                                }
                            %>
                        </div>





                    </div>



                </div>



                <%

                    }
                %>

            </div>
        </div>
    </div>
</div>




</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

</html>
