
<%@page import="beans.EquipoDTO"%>
<%@page import="beans.PersonaDTO"%>
<%@page import="java.util.List"%>

 <%@ include file="../_header.jsp" %>
 <%@ include file="../_sidebar.jsp" %>
<% 
	EquipoDTO obj = (EquipoDTO)request.getAttribute("equipo"); 
%>
  <div class="content-wrapper">
    <section class="content-header">
      <h1>Equipo</h1> 
    </section>
    <section class="content">
    	<div class="box box-primary">
    		<div class="box-header with-border">
              <h3 class="box-title">Detalle: <%= obj.getNombre() %> </h3>
            </div>
        	<div class="box-body">
            	<div class="col-md-12">
						<section class="detalle">
						<div class="panel panel-info">
							<div class="panel-heading">
								<div class="pull-right btn-panel">
									<a href="ServletEquipo?tipo=buscar&cod=<%= obj.getCodigo() %>" class="btn btn-primary btn-sm">
										<i class="fa fa-pencil" aria-hidden="true"></i>
										Modificar equipo
									</a>
								</div>
								<h3 class="panel-title">Información del equipo</h3>
								
							</div>
							<div class="panel-body">
								<div class="table-responsive">
									<table class="table tabler-hover">
										<tr>
											<th class="th-detalle">Código</th>
											<th class="th-detalle">Nombre del equipo</th>
											<th class="th-detalle">Descripción</th>
											<th class="th-detalle">Delegado</th>
											<th class="th-detalle">Email</th>
											<th class="th-detalle">Télefono</th>
										</tr>
										<tr>
											<td><%= obj.getCodigo() %></td>
											<td><%= obj.getNombre()%></td>
											<td><%= obj.getDescripcion() %></td>
											<td><% out.print(obj.getDelegado().getNombre()+", "+obj.getDelegado().getApaterno()+" "+obj.getDelegado().getAmaterno()) ; %></td>
											<td><%= obj.getDelegado().getEmail() %></td>
											<td><%= obj.getDelegado().getFono()%></td>
										</tr>
									</table>
								</div>
								
								<div class="table-responsive">
									<table class="table tabler-hover">
										<tr>
											<th class="th-detalle">Color</th>
											<th class="th-detalle">Modalidad</th>
											<th class="th-detalle">Estado</th>
										</tr>
										<tr>
											<td><%= obj.getColor() %></td>
											<td>
											<% 
											out.print(obj.getModalidad().getDisciplina().getNombre()+" "); 
											out.print(obj.getModalidad().getCategoria().getNombre()+" - ") ;
											if(obj.getModalidad().getGenero()==1){
												out.print("Varones");
											}else if(obj.getModalidad().getGenero()==2){
												out.print("Mujeres");
											} else {
												out.print("Mixto");
											} %>
											</td>
											<td><%  if(obj.getEstado()==1){
												out.print("Activo");
											} else {
												out.print("Inactivo");
											} %></td>
										</tr>
									</table>
								</div>
							</div>
						</div>
	                    
	                    <div class="panel panel-info">
							<div class="panel-heading">
								<div class="pull-right btn-panel">
									<a href="#" class="btn btn-primary btn-sm">
										<i class="fa fa-plus" aria-hidden="true"></i>
										Agregar jugadores
									</a>
								</div>
								<h3 class="panel-title">Lista de Jugadores</h3>
							</div>
							<div class="panel-body">
									<div class="table-responsive">
									<table class="table tabler-hover">
										<tr>
											<th class="th-detalle">Código</th>
											<th class="th-detalle">Apellidos y nombres</th>
											<th class="th-detalle">Sexo</th>
										</tr>

											<% for (PersonaDTO item : obj.getJugadores() ){  %>
							                    <tr>
							                    	<td> <%= item.getCodigo() %> </td>	
							                    	<td> <%= item.getApaterno() + " " + item.getAmaterno() + ", "+ item.getNombre() %> </td>
							                    	<td> <% 
							                    	if(item.getSexo()==1){
							                    		out.print("Masculino");
							                    	}else{
							                    		out.print("Femenino");
							                    	} 
							                    	%> </td>
							                    </tr>
							               <% } %>
							               
									</table>
								</div>
							</div>
						</div>
                        </section>
                        <div class="box-footer">
							<a href="${pageContext.request.contextPath}/ServletEquipo?tipo=listar" class="btn btn-default"><i class="fa fa-arrow-left" aria-hidden="true"></i> Volver a lista </a>
		              	</div>

                  </div>
                  
        	</div>
        </div>              
    </section>
 </div>	
 <%@ include file="../_footer.jsp" %>
