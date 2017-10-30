<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib prefix="ct" uri="http://libreria.registro" %>	
<%@page import="beans.CategoriaDTO"%>
<%@page import="java.util.List"%>

 <%@ include file="../_header.jsp" %>
 <%@ include file="../_sidebar.jsp" %>
 
  <div class="content-wrapper">
    <section class="content-header">
      <h1>Modalidad</h1> 
    </section>
    <section class="content">
       <div class="box box-primary">
           <div class="box-body">
           	<div class="box-header with-border">
	              <h3 class="box-title">Listado de modalidades</h3>
	        </div>
	        <div class="body">
	        	<div class="col-md-12">
			        <div class="toolbar-actions">
			        	<div class="row">
			        		<div class="col-md-6">
					        	<a href="${pageContext.request.contextPath}/ServletUsuario?tipo=panel">
					        		<img alt="Regresar al escritorio" title ="Regresar al escritorio" src="${pageContext.request.contextPath}/images/icons/32/home.png">
					        	</a>
						        <a href="${pageContext.request.contextPath}/app/modalidad/registrar_modalidad.jsp">
						        	<img alt="Crear nueva categoria" title="Crear nueva modalidad" src="${pageContext.request.contextPath}/images/icons/32/new_folder.png">
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
			       	
			       	<form class="form-horizontal" action="ServletModalidad?tipo=eliminar" method="post" id="formlista">
			        <div class="box-body table-responsive no-padding">
				        <display:table class="table table-bordered table-hover"  name="data" requestURI="../ServletModalidad?tipo=listar"	id="lista">
			               <display:setProperty name="basic.msg.empty_list">
	               		 					<div class="alert alert-warning" role="alert">No se existe modalidades registradas</div>
	               		 				</display:setProperty>
			                <display:column title="Item" sortable="false" media="html" >
							    	<input type="checkbox" name="cod[]" value="${lista.codigo}">
             		 		</display:column>
             		 		<display:column property="disciplina.nombre" title="Disciplina" />
			                <display:column property="categoria.nombre" title="Categoria" />
			                <display:column property="descripcion" title="Descripcion" />
			                <display:column property="numJugadores" title="N° Jugadores" />
			                <display:column title="Género">
			                	${lista.genero == 'V' ? '<span> Varones </span>' : lista.genero == 'M' ? '<span> Mujeres </span>' : '<span> Mixto </span>'}
			                
			                </display:column>
			                <display:column property="numVarones" title="N° Varones" />
			                <display:column property="numMujeres" title="N° Mujeres" />
			                <display:column  title="Acciones" sortable="false">
				               	<div class="text-center">
				               		<div class="btn-group btn-group-sm" role="group" aria-label="...">
				                    	<a href="ServletModalidad?tipo=buscar&cod=${lista.codigo}" class="btn btn-default" title="Editar"><i class="fa fa-pencil" aria-hidden="true"></i></a>
				                    	<a onclick="javascript:if(!confirm('Por favor, confirme su elección')) return false;" href="ServletModalidad?tipo=eliminar&cod[]=${lista.codigo}" class="btn btn-default" title="Eliminar"><i class="fa fa-trash-o" aria-hidden="true"></i></a>
				                  	</div>
				               	</div>
				            </display:column>
				        </display:table>
			         </div>
			         
			         <div class="btn-toolbar">
			         	<div class="btn-group">
			         		<a href="#" class="btn btn-default" onclick="javascript: setCheckbox(true, 'lista'); return false;">Seleccionar todos</a>
			         		<a href="#" class="btn btn-default" onclick="javascript: setCheckbox(false, 'lista'); return false;">Anular selección</a>
			         	</div>
			         	<div class="btn-group">
						  <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						    Acciones <span class="caret"></span>
						  </button>
						  <ul class="dropdown-menu">
						    <li><a href="#" id="seleccion">Eliminar de la plataforma</a></li>
						  </ul>
						  <script type="text/javascript">
								  	document.getElementById("seleccion").onclick = function() {
								  		if(confirm('Por favor, confirme su elección')){
								  			document.getElementById("formlista").submit();
								  		} else {
								  			false;
								  		}  
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