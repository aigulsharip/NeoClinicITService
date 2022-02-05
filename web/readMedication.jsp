<%@ page import="com.aigulsharip.java_ee.lecture5.db.Medication" %>
<%@ page import="com.aigulsharip.java_ee.lecture5.db.MedicationForm" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Aigul
  Date: 26.01.2022
  Time: 18:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Medication Details</title>
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
                Medication medication = (Medication) request.getAttribute("medication");
                if (medication != null) {
                    if (currentUser != null && currentUser.getUserRole() == UserRoles.ROLE_ADMIN ) {


            %>
            <form action="/readMedication" method="post">

                <input name = "id" type = "hidden" value="<%=medication.getId()%>">
                <div class="row mt-2">
                    <div class="col-12">
                        <label>Name: </label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <input type="text" class="form-control" required placeholder="Insert Name" name="name" value="<%=medication.getName()%>">
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col-12">
                        <label>Dosage: </label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <input type="text" class="form-control" required placeholder="Insert Dosage" name="dosage" value="<%=medication.getDosage()%>">
                    </div>
                </div>

                <div class="row mt-3">
                    <div class="col-12">
                        <label>Form: </label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <select class="form-select" name="form">

                            <%
                                ArrayList<MedicationForm> medicationForms = (ArrayList<MedicationForm>) request.getAttribute("medicationForms");
                                if (medicationForms != null) {
                                    for (MedicationForm med : medicationForms ) {

                            %>
                            <option value = "<%=med.getId()%>">
                                <%=med.getFormName()%>
                            </option>


                            <%
                                    }
                                }

                            %>


                        </select>

                    </div>
                </div>

                <div class="row mt-3">
                    <div class="col-12">
                        <label>Price: </label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <input type="text" class="form-control" required placeholder="Insert Price" name="price" value="<%=medication.getPrice()%>">
                    </div>
                </div>


                <div class="row mt-3">
                    <div class="col-12">
                        <label>Quantity: </label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <input type="text" class="form-control" required placeholder="Insert quantity" name="quantity" value="<%=medication.getQuantity()%>">
                    </div>
                </div>

                <div class="modal-footer">
                    <a href = "/medications" class="btn btn-secondary" > Close</a>
                    <button type="submit" class="btn btn-primary">Update Medication</button>
                    <button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#deleteMedication">Delete Medication</button>
                </div>
                <!-- Modal -->
                <div class="modal fade" id="deleteMedication" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <form method="post" action="/deleteMedication">
                                <input name="id" type="hidden" value="<%=medication.getId()%>">

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
                        <label>Name: </label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <input type="text" class="form-control" readonly value="<%=medication.getName()%>">
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col-12">
                        <label>Dosage: </label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <input type="text" class="form-control" readonly value="<%=medication.getDosage()%>">
                    </div>
                </div>

                <div class="row mt-3">
                    <div class="col-12">
                        <label>Form: </label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <input type="text" class="form-control"  readonly value="<%=medication.getMedicationForm().getFormName()%>">
                    </div>
                </div>

                <div class="row mt-3">
                    <div class="col-12">
                        <label>Price: </label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <input type="text" class="form-control" readonly value="<%=medication.getPrice()%>">
                    </div>
                </div>


                <div class="row mt-3">
                    <div class="col-12">
                        <label>Quantity: </label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <input type="text" class="form-control" readonly value="<%=medication.getQuantity()%>">
                    </div>
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
