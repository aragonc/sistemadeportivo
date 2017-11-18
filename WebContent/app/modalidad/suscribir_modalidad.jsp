<%@page import="java.util.Collections"%>
<%@page import="java.util.LinkedHashSet"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.ArrayList"%>
<%@page import="beans.ModalidadDTO"%>
<%@page import="beans.EventoDTO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib prefix="ct" uri="http://libreria.registro" %>	
<%@page import="beans.CategoriaDTO"%>
<%@page import="java.util.List"%>

<%
	String title = null;

	EventoDTO evento = (EventoDTO)request.getAttribute("evento");
	
	List<ModalidadDTO> original = (List<ModalidadDTO>)request.getAttribute("data");
	List<ModalidadDTO> actual = evento.getModalidades();
	
	String action = (String)request.getAttribute("accion");
	if(action.equals("agregar")){
		title = "Agregar Modalidades ";
	} else {
		title = "Actualizar Modalidades ";
	}
	ArrayList<String> xactual = new ArrayList<String>();
	for(ModalidadDTO item : actual){
		xactual.add(item.getCodigo()+"");
	}
	//System.out.println(xactual);

%>
<c:set var="listamodalidad" value="<%= evento.getModalidades() %>"/>
<%@ include file="../_header.jsp" %>
<%@ include file="../_sidebar.jsp" %>
 
  <div class="content-wrapper">
    <section class="content-header">
      <h1>Evento</h1> 
    </section>
    <section class="content">
       <div class="box box-primary">
           <div class="box-body">
           	<div class="box-header with-border">
	              <h3 class="box-title"> <%= title %><span class="valor"><%= evento.getNombre() %></span></h3>
	        </div>
	        <div class="body">
	        	<div class="col-md-12">
	        		
			        <div class="toolbar-actions">
			        	<div class="row">
			        		<div class="col-md-6">
					        	<a href="${pageContext.request.contextPath}/ServletEvento?tipo=listar">
					        		<img alt="Regresar a lista de eventos" title ="Regresar a lista de eventos" src="${pageContext.request.contextPath}/images/icons/32/back.png">
					        	</a>
			        		</div>
			        		<div class="col-md-6">
			        			
			        		</div>
			        	</div>
			       	</div>
			       	
			       	<form action="${pageContext.request.contextPath}/ServletEvento?tipo=suscribirModalidad" method="post" id="formlista">
			       	<div class="box-body table-responsive no-padding">
			       	<input type="hidden" name="accion" value="<%= action %>">
			       	<input type="hidden" name="codevento" value="<%= evento.getCodigo() %>">
			       	<table class="table table-bordered table-hover">
			       		<tr>
			       			<th>Item</th>
			       			<th>Modalidad</th>
			       			<th>Descripcion</th>
			       			<th>Cant. Jugadores</th>
			       			<th>N° Varones</th>
			       			<th>N° Mujeres</th>
			       		</tr>
			       	
			       	<% for( ModalidadDTO item : original) { %>
			       		<tr>
			       			<td><input type="checkbox" name="modalidad[]" id="modalidad_<%=item.getCodigo() %>" value="<%= item.getCodigo() %>" ></td>
			       			<td>
			       				<p>
			       				
			       				<% 
			       				
			       				out.println(item.getDisciplina().getNombre() + " - " + item.getCategoria().getNombre());
									
			       				if(item.getGenero().equals("V")) { 
									
			       					out.println("<span class=\"badge mod_varones\"> Varones </span>");
									
			       				} else if (item.getGenero().equals("M")) { 
									
									out.println("<span class=\"badge mod_mujeres\"> Mujeres </span>");
									
								} else { 
									
										out.println("<span class=\"badge mod_mixto\"> Mixto </span>");
									
								} %>		       				
			       				</p>
			       			</td>
			       			<td>
			       				<% if(item.getDescripcion().equals("")){
			       					out.println("-");
			       				}else{
			       					out.println(item.getDescripcion());
			       				}%>
			       				
			       			</td>
			       			<td>
			       				<%= item.getNumJugadores() %>
			       			</td>
			       			<td><%= item.getNumVarones() %></td>
			       			<td><%= item.getNumMujeres() %></td>
			       		</tr>
			       	<% } %>
			       	</table>
			       	<script type="text/javascript">
			       	$(document).ready(function(){
			       		var actual = <%= xactual %>;
			       		if(actual.length >= 0 ){
				       		console.log(actual);
				       		for ( var i = 0, l = actual.length; i < l; i++ ) {
				    			$("#modalidad_"+actual[i]).prop('checked',true);
				        		//console.log(actual[ i ]);
				    		}
			       		}
			       	});
			       	</script>
			         </div>
			         <div class="btn-toolbar">
			         	<div class="btn-group">
			         		<a href="#" class="btn btn-default" onclick="javascript: setCheckbox(true, 'lista'); return false;">Seleccionar todos</a>
			         		<a href="#" class="btn btn-default" onclick="javascript: setCheckbox(false, 'lista'); return false;">Anular selección</a>
			         	</div>
			         	<div class="btn-actions">
						  <button type="button" id="seleccion" class="btn btn-success">
						  	<i class="fa fa-plus" aria-hidden="true"></i>
						    <%= title %>
						  </button>
						  <script type="text/javascript">
						  	document.getElementById("seleccion").onclick = function() {
							    document.getElementById("formlista").submit();
							}
						  </script>
						</div>
						
			         </div>
			         </form>
	     	 	</div>
           		 
	        </div>
	    </div>
	   </div>
    </section>
  </div>
 
 <%@ include file="../_footer.jsp" %>