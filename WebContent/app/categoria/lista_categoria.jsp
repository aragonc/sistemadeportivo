<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib prefix="ct" uri="http://libreria.registro" %>	
<%@page import="beans.CategoriaDTO"%>
<%@page import="java.util.List"%>

 <%@ include file="../_header.jsp"  %>
 <%@ include file="../_sidebar.jsp" %>
 
  <div class="content-wrapper">
  <section class="content-header">
      <h1>Categoria</h1> 
    </section>
    <section class="content">
       <div class="box box-primary">
           <div class="box-body">
           	<div class="box-header with-border">
	              <h3 class="box-title">Listado de categorias</h3>
	        </div>
	        <div class="body">
	        	<div class="col-md-9">
			        <div class="toolbar-actions">
			        	<a href="${pageContext.request.contextPath}/ServletUsuario?tipo=panel">
			        		<img alt="Regresar al escritorio" title ="Regresar al escritorio" src="${pageContext.request.contextPath}/images/icons/32/home.png">
			        	</a>
				        <a href="${pageContext.request.contextPath}/app/categoria/registrar_categoria.jsp">
				        	<img alt="Crear nueva categoria" title="Crear nueva categoria" src="${pageContext.request.contextPath}/images/icons/32/new_folder.png">
				        </a>
			       	</div>
			       	<form class="form-horizontal" action="ServletCategoria?tipo=eliminar" method="post" id="formlista">
			        <div class="table-responsive">
				        <display:table class="table table-bordered table-hover"  name="data" requestURI="../ServletCategoria?tipo=listar"	id="lista">
			                <display:setProperty name="basic.msg.empty_list">
	               		 					<div class="alert alert-warning" role="alert">No se existen categorias registradas</div>
	               		 				</display:setProperty>
			                <display:column title="Item" sortable="false" media="html" >
								<input type="checkbox" name="cod[]" value="${lista.codigo}">
             		 		</display:column>
			                <display:column property="nombre" title="Nombre" />
			                <display:column  title="Estado" sortable="false" >
			                	${lista.estado == 1 ? '<span class="label label-success"> Activo </span>' : '<span class="label label-danger"> Inactivo </span>'}
			                </display:column>
			                
			                <display:column  title="Acciones" sortable="false">
			               	<div class="text-center">
			               		<div class="btn-group btn-group-sm" role="group" aria-label="...">
			                    <a href="ServletCategoria?tipo=buscar&cod=${lista.codigo}" class="btn btn-default" title="Editar"><i class="fa fa-pencil" aria-hidden="true"></i></a>
			                    <a onclick="javascript:if(!confirm('Por favor, confirme su elecci�n')) return false;" href="ServletCategoria?tipo=eliminar&cod[]=${lista.codigo}" class="btn btn-default" title="Eliminar"><i class="fa fa-trash-o" aria-hidden="true"></i></a>
			                  </div>
			               	</div>    
				            </display:column>
				        </display:table>
			         </div>
			         <div class="btn-toolbar">
				         	<div class="btn-group">
				         		<a href="#" class="btn btn-default" onclick="javascript: setCheckbox(true, 'lista'); return false;">Seleccionar todos</a>
				         		<a href="#" class="btn btn-default" onclick="javascript: setCheckbox(false, 'lista'); return false;">Anular selecci�n</a>
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
									  		if(confirm('Por favor, confirme su elecci�n')){
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
           		<div class="col-md-3">
                 
                </div>  
	        </div>
	    </div>
	   </div>
    </section>
  </div>
 
 <%@ include file="../_footer.jsp" %>