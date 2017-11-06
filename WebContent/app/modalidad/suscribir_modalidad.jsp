<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib prefix="ct" uri="http://libreria.registro" %>	
<%@page import="beans.CategoriaDTO"%>
<%@page import="java.util.List"%>

<% String nombreEvento = (String)request.getAttribute("nomevento"); %>
<% String codigoEvento = (String)request.getAttribute("codevento"); %>

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
	              <h3 class="box-title">Asignar modalidad a evento al <span class="valor"><%= nombreEvento %></span></h3>
	        </div>
	        <div class="body">
	        	<div class="col-md-12">
	        		<!-- MENSAJE QUE APARECE CUANDO SE REGISTRA UN EVENTO -->
			       	<% if(codigoEvento!=null) { %>
		              	<div class="alert alert-success" role="alert">
		              		<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		              		Acabas de crear el evento a continuación procede a asignar las modalidesde de juego para el evento
		              	</div>
		              <% } %>
			       	<!-- FIN DEL MENSAJE -->
			        <div class="toolbar-actions">
			        	<div class="row">
			        		<div class="col-md-6">
					        	<a href="${pageContext.request.contextPath}/ServletEvento?tipo=listar">
					        		<img alt="Regresar a lista de eventos" title ="Regresar a lista de eventos" src="${pageContext.request.contextPath}/images/icons/32/back.png">
					        	</a>
			        		</div>
			        		<div class="col-md-6">
			        			<div class="pull-right">
	            					<form class="form-inline">
									  <div class="form-group">
									    <div class="input-group">
									      <input type="text" name="txtdni" class="form-control" id="txtdni" size="25" placeholder="Buscar modalidad">
									    </div>
									  </div>
									  <button type="submit" class="btn btn-success"><i class="fa fa-search" aria-hidden="true"></i>
									   Buscar</button>
									</form>
	            				</div>
			        		</div>
			        	</div>
			       	</div>
			       	
			       	<form action="${pageContext.request.contextPath}/ServletEvento?tipo=suscribirModalidad" method="post" id="formlista">
			        <div class="box-body table-responsive no-padding">
			        	<input type="hidden" name="codevento" value="<%= codigoEvento %>">
				        <display:table class="table table-bordered table-hover"  name="data" requestURI="../ServletModalidad?tipo=listar"	id="lista">
			                <display:column title="Item" sortable="false" media="html" >
							    	<input type="checkbox" name="modalidad[]" value="${lista.codigo}">
             		 		</display:column>
             		 		<display:column title="Modalidad" style="width:20%;">
             		 			<p>
             		 			${lista.disciplina.nombre} - ${lista.categoria.nombre}
             		 			${lista.genero == 'V' ? '<span class="badge mod_varones"> Varones </span>' : lista.genero == 'M' ? '<span class="badge mod_mujeres"> Mujeres </span>' : '<span class="badge mod_mixto"> Mixto </span>'}
             		 			</p>
             		 		</display:column>
			                <display:column title="Descripcion">
			                	${lista.descripcion == null ? Ninguna : lista.descripcion }
			                </display:column>
			                <display:column property="numJugadores" title="Cantidad Jugadores"/>
			                <display:column property="numVarones" title="N° Varones"/>
			                <display:column property="numMujeres" title="N° Mujeres"/>
				        </display:table>
			         </div>
			         <div class="btn-toolbar">
			         	<div class="btn-group">
			         		<a href="#" class="btn btn-default" onclick="javascript: setCheckbox(true, 'lista'); return false;">Seleccionar todos</a>
			         		<a href="#" class="btn btn-default" onclick="javascript: setCheckbox(false, 'lista'); return false;">Anular selección</a>
			         	</div>
			         	<div class="btn-actions">
						  <button type="button" id="seleccion" class="btn btn-success">
						  	<i class="fa fa-plus" aria-hidden="true"></i>
						    Agregar modalidades 
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