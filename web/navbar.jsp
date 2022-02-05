<%@ page import="com.aigulsharip.java_ee.lecture5.db.User" %>
<%@ page import="com.aigulsharip.java_ee.lecture5.db.UserRoles" %>
<%
    String siteTitle = "NeoClinic Medications";
    User currentUser = (User) session.getAttribute("current_user");
%>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="#"><%=siteTitle%></a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <%
                    if (currentUser != null) {
                %>

                <li class="nav-item">
                    <a class="nav-link " aria-current="page" href="/profile"><%=currentUser.getFullName()%></a>
                </li>

                <%
                    if (currentUser.getUserRole() == UserRoles.ROLE_ADMIN) {
                %>

                <li class="nav-item">
                    <a class="nav-link " aria-current="page" href="/medications">Medications</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link " aria-current="page" href="/addMedication">Add Medication</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link " aria-current="page" href="/addNote">Add Note</a>
                </li>


                <%
                    }
                %>

                <li class="nav-item">
                    <a class="nav-link " aria-current="page" href="/signout">Sign Out</a>
                </li>


                <%

                    } else {
                %>

                <li class="nav-item">
                    <a class="nav-link " aria-current="page" href="/">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link " aria-current="page" href="/medications">Medications</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link " aria-current="page" href="/notes">Notes</a>
                </li>



                <li class="nav-item">
                    <a class="nav-link " aria-current="page" href="/signin">Sign In</a>
                </li>

                <%

                    }
                %>







            </ul>
        </div>
    </div>
</nav>
