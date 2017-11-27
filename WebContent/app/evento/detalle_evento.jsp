
<%@page import="beans.ModalidadDTO"%>
<%@page import="beans.EventoDTO"%>
<%@page import="java.util.List"%>
 <%@ include file="../_header.jsp" %>
 <%@ include file="../_sidebar.jsp" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% 
	EventoDTO obj = (EventoDTO)request.getAttribute("registro"); 
%>
  <c:set var="latitud" value="<%= obj.getLugar().getLatitud() %>"/>
  <c:set var="longitud" value="<%= obj.getLugar().getLongitud() %>"/>
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
            	<div class="col-md-12">
						<section class="detalle">
						<div class="panel panel-info">
							<div class="panel-heading">
								<div class="pull-right btn-panel">
									<a href="ServletEvento?tipo=buscar&cod=<%= obj.getCodigo() %>" class="btn btn-primary btn-sm">
										<i class="fa fa-pencil" aria-hidden="true"></i>
										Actualizar Evento
									</a>
								</div>
								<h3 class="panel-title">Información del evento</h3>
								
							</div>
							<div class="panel-body">
								<div class="row">
									<div class="col-md-9">
										<div class="table-responsive">
											<table class="table tabler-hover">
												<tr>
													<th class="th-detalle">Código</th>
													<th class="th-detalle">Titulo del evento</th>
													<th class="th-detalle" style="width: 300px">Descripción</th>
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
													<th class="th-detalle">Lugar del evento</th>
													<th class="th-detalle">Costo S/.</th>
													<th class="th-detalle">Gratuito</th>
													<th class="th-detalle">Estado</th>
													<th class="th-detalle">Fecha registro</th>
												</tr>
												<tr>
													<td>
														<strong><%= obj.getLugar().getNombre() %></strong><br>
														<%= obj.getLugar().getDireccion() %>
													</td>
													<td><%= obj.getPrecio() %></td>
													<td><%= obj.getModo() %></td>
													<td>
														<% if(obj.getEstado() == 1 ){
															out.println("Activo");
														} else {
															out.println("Inactivo");
														}
														%>
													</td>
													<td><%= obj.getFechaInicio() %></td>
												</tr>
											</table>
										</div>
									</div>
									<div class="col-md-3">
										<div id="mapa" style="width: 300px; height: 250px;"></div>
										<script type="text/javascript">
						                  $( document ).ready(function() {
						                		
						                		var map;
						                		var lat;
						                		var lng;
						                		
						                		map = new GMaps({
						                	        div: '#mapa',
						                	        lat: ${latitud} ,
						                	        lng: ${longitud},
						                	        enableNewStyle: true
						                	      });
						                		
						                		
						                		map.addMarker({
						                			  lat: ${latitud},
						                			  lng: ${longitud},
						                			  draggable: false
						                			});
						                  	});
						                  </script>
									</div>
								</div>
								
								
								
							</div>
						</div>
	                    
	                    <div class="panel panel-info">
							<div class="panel-heading">
								<div class="pull-right btn-panel">
									<a href="ServletEvento?tipo=listaModalidad&action=update&cod=<%= obj.getCodigo() %>" class="btn btn-primary btn-sm">
										<i class="fa fa-pencil"></i>
										Actualizar Modalidades
									</a>
								</div>
								<h3 class="panel-title">Modalidades de Juego</h3>
							</div>
							<div class="panel-body">
									<div class="table-responsive">
									<table class="table tabler-hover">
										<tr>
											<th class="th-detalle">Código</th>
											<th class="th-detalle">Modalidad</th>
											<th class="th-detalle">Descripción</th>
											<th class="th-detalle">Genero</th>
											<th class="th-detalle">N° Jugadores</th>
										</tr>

											<% for (ModalidadDTO item : obj.getModalidades() ){  %>
							                    <tr>
							                    	<td> <%= item.getCodigo() %> </td>	
							                    	<td> <%= item.getDisciplina().getNombre() %> <%= item.getCategoria().getNombre() %> </td>
							                    	<td> <%= item.getDescripcion()  %></td>	
							                    	<td>  
							                    		<% if(item.getGenero()==1){ %>
							                    			<p>Varones</p>
							                    		<% } else if(item.getGenero()==2){ %>
							                    			<p>Mujeres</p>
							                    		<% } else { %>
							                    			<p>Mixto</p>
							                    		<% } %>
							                    	</td>
							                    	<td>
							                    		
							                    		<strong>V</strong> (<%= item.getNumVarones() %>)  <strong>M</strong> (<%= item.getNumMujeres() %>)
							                    		= <%= item.getNumJugadores() %>
							                    	</td>
							                    	
							                    </tr>
							               <% } %>
							               
									</table>
								</div>
							</div>
						</div>
                        </section>
                        <div class="box-footer">
							<a href="${pageContext.request.contextPath}/ServletEvento?tipo=listar" class="btn btn-default"><i class="fa fa-arrow-left" aria-hidden="true"></i> Volver a lista </a>
		              	</div>

                  </div>
                  
        	</div>
        </div>              
    </section>
 </div>	
 <%@ include file="../_footer.jsp" %>
