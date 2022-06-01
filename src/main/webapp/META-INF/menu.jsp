<%
//scriptles
    String op = request.getParameter("opcion");
%>
<!-- -->             
  <ul class="nav nav-pills">
  <li class="nav-item">
    <a class="nav-link <%= (op.equals("participantes"))?"active":""%>" 
       aria-current="page" href="Controller_participantes">Participantes</a>
  </li>
  <li class="nav-item">
    <a class="nav-link <%=(op.equals("seminarios"))?"active":""%>" 
       aria-current="page" href="Controller_seminarios">Seminarios</a>
  </li>

  <li class="nav-item">
    <a class="nav-link disabled">Disabled</a>
  </li>
</ul>
  