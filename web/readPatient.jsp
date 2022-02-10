<%@ page import="java.util.ArrayList" %>
<%@ page import="com.aigulsharip.java_ee.lecture5.db.*" %><%--
  Created by IntelliJ IDEA.
  User: Aigul
  Date: 26.01.2022
  Time: 18:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Patient Details</title>
    <link rel = "stylesheet" type = "text/css" href = "bootstrap/css/bootstrap.min.css">

</head>
<body>
<div class = "container-fluid">
    <div class = "row">
        <div class="col-12">
            <%@include file="navbar.jsp"%>
        </div>
    </div>
</div>


<div class = "container-fluid">
    <div class = "row">
        <div class="col-12">
            <%
                Patient patient = (Patient) request.getAttribute("patient");
                if (patient != null) {
                    if (currentUser != null && currentUser.getUserRole() == UserRoles.ROLE_ADMIN ) {


            %>
            <form action="/readPatient" method="post">

                <input name = "id" type = "hidden" value="<%=patient.getId()%>">
                <div class="row mt-2">
                    <div class="col-12">
                        <label>Full Name: </label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <input type="text" class="form-control" name="full_name" value="<%=patient.getFullName()%>">
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col-12">
                        <label>Birth Date: </label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <input type="text" class="form-control" name = "birthdate" value="<%=patient.getBirthDate()%>">
                    </div>
                </div>



                <div class="row mt-3">
                    <div class="col-12">
                        <label>Gender: </label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <input type="text" class="form-control"  name="gender" value="<%=patient.getGender()%>">
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col-12">
                        <label>Email: </label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <input type="text" class="form-control" name="email" value="<%=patient.getEmail()%>">
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col-12">
                        <label>City: </label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <input type="text" class="form-control" name="city" value="<%=patient.getCity()%>">
                    </div>
                </div>

                <div class="row mt-3">
                    <div class="col-12">
                        <label> Patient's Medication List: </label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <% ArrayList<Medication> patientMedsList = (ArrayList<Medication>) request.getAttribute("patientMedsList");
                            if (patientMedsList != null) {
                                for (Medication med : patientMedsList) {

                        %>
                        <div class = ""><p><%=med.getName()%></p></div>

                        <%
                                }
                            }
                        %>

                        </di>
                </div>



                <div class="modal-footer">
                    <a href = "/patients" class="btn btn-secondary" > Close</a>
                    <button type="submit" class="btn btn-primary">Update Patient</button>
                    <button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#deletePatient">Delete Patient</button>
                </div>
                <!-- Modal -->
                <div class="modal fade" id="deletePatient" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <form method="post" action="/deletePatient">
                                <input name="id" type="hidden" value="<%=patient.getId()%>">

                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">Delete</h5>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                    Are you sure?
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">No</button>
                                    <button type="submit" class="btn btn-primary">Yes</button>
                                </div>

                            </form>

                        </div>
                    </div>
                </div>


            </form>
            <%
            }else {

            %>
            <div>

                <div class="row mt-2">
                    <div class="col-12">
                        <label>Full Name: </label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <input type="text" class="form-control" readonly name="full_name" value="<%=patient.getFullName()%>">
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col-12">
                        <label>Birth Date: </label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <input type="date" class="form-control" readonly name = "birthdate" value="<%=patient.getBirthDate()%>">
                    </div>
                </div>



                <div class="row mt-3">
                    <div class="col-12">
                        <label>Gender: </label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <input type="text" class="form-control"  readonly name="gender" value="<%=patient.getGender()%>">
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col-12">
                        <label>Email: </label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <input type="text" class="form-control" readonly name="email" value="<%=patient.getEmail()%>">
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col-12">
                        <label>City: </label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <input type="text" class="form-control" readonly name="dosage" value="<%=patient.getCity()%>">
                    </div>
                </div>

                <%
                }
                    }

            %>
        </div>
    </div>
</div>


</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>


</html>
