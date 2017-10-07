
<%@page import="beans.ModalidadDTO"%>
<%@page import="beans.EventoDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <jsp:include page="../_header.jsp" flush="true" />
 <jsp:include page="../_sidebar.jsp" flush="true" />
<% 
	EventoDTO obj = (EventoDTO)request.getAttribute("registro"); 
%>
  <div class="content-wrapper">
    <section class="content-header">
      <h1>Eventos</h1> 
    </section>
    <section class="content">
    	<div class="box box-primary">
    		<div class="box-header with-border">
              <h3 class="box-title">Detalle: <%= obj.getNombre() %> </h3>
            </div>
        	<div class="box-body">
            	<div class="col-md-9">
					
						<div class="panel panel-primary">
							<div class="panel-heading">
								<h3 class="panel-title">Información del evento</h3>
							</div>
							<div class="panel-body">
								<div class="table-responsive">
									<table class="table tabler-hover">
										<tr>
											<th class="th-detalle">Código</th>
											<th class="th-detalle">Titulo del evento</th>
											<th class="th-detalle">Descripción</th>
											<th class="th-detalle">Fecha Inicio</th>
											<th class="th-detalle">Fecha Fin</th>
										</tr>
										<tr>
											<td><%= obj.getCodigo() %></td>
											<td><%= obj.getNombre()%></td>
											<td><%= obj.getDescripcion() %></td>
											<td><%= obj.getFechaInicio() %></td>
											<td><%= obj.getFechaFin() %></td>
										</tr>
									</table>
								</div>
								
								<div class="table-responsive">
									<table class="table tabler-hover">
										<tr>
											<th class="th-detalle" >Costo S/.</th>
											<th class="th-detalle">Gratuito</th>
											<th class="th-detalle">Estado</th>
											<th class="th-detalle">Fecha Registro</th>
										</tr>
										<tr>
											<td><%= obj.getPrecio() %></td>
											<td><%= obj.getGratuito() %></td>
											<td><%= obj.getEstado() %></td>
											<td><%= obj.getFechaInicio() %></td>
										</tr>
									</table>
								</div>
							</div>
						</div>
	                    
	                    <div class="panel panel-primary">
							<div class="panel-heading">
								<h3 class="panel-title">Modalidades de Juego</h3>
							</div>
							<div class="panel-body">
									<div class="table-responsive">
									<table class="table tabler-hover">
										<tr>
											<th class="th-detalle" >Código</th>
											<th class="th-detalle">Disciplina</th>
											<th class="th-detalle">Cateogoria</th>
											<th class="th-detalle">Acciones</th>
										</tr>

											<% for (ModalidadDTO item : obj.getModalidades() ){  %>
							                    <tr>
							                    	<td> <%= item.getCodigo() %> </td>	
							                    	<td> <%= item.getDisciplina().getNombre() %> </td>
							                    	<td> <%= item.getCategoria().getNombre() %> </td>
							                    	<td> 
							                    		<a class="btn btn-default">Quitar</a>
							                    	</td>	
							                    </tr>
							               <% } %>
							               
									</table>
								</div>
							</div>
						</div>
                        
                        <div class="box-footer">
							<a href="${pageContext.request.contextPath}/ServletEvento?tipo=listar" class="btn btn-default"><i class="fa fa-arrow-left" aria-hidden="true"></i> Volver a lista </a>
		              	</div>

                  </div>
                  <div class="col-md-3">
                  
                  </div> 
        	</div>
        </div>              
    </section>
 </div>	
 <jsp:include page="../_footer.jsp" flush="true" />
