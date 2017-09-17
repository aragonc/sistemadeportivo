<%@page import="beans.CategoriaDTO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <jsp:include page="_header.jsp" flush="true" />
 <jsp:include page="_sidebar.jsp" flush="true" />
 <% CategoriaDTO ca = (CategoriaDTO) request.getAttribute("registro"); %>
 <c:set var="genero" value="<%= ca.getGenero() %>"/>
 <c:set var="cantidad" value="<%= ca.getCantidad() %>"/>
 <c:set var="estado" value="<%= ca.getEstado() %>"/>
 <div class="content-wrapper">
    <section class="content-header">
      <h3>Actualizar categoria de disciplina</h3> 
    </section>
    <section class="content">
        <div class="box box-primary">
        	<div class="box-header with-border">
              <h3 class="box-title">Categoria de disciplina</h3>
            </div>
        	<div class="box-body">
            	<div class="col-md-9">
					<form action="${pageContext.request.contextPath}/ServletCategoria?tipo=actualizar" class="form-horizontal" id="frmregistrar" method="post">
                         <input type="hidden" name="codigo" value="<%= ca.getCodigo() %>">
                         <div class="form-group">
                           <label class="col-sm-3 control-label">Nombre Categoria</label>
                           <div class="col-sm-9">
                             <input type="text"  id="txtnombre" name="txtnombre" class="form-control" value="<%= ca.getNombre() %>">
                           </div>
                         </div>
                         <div class="form-group">
                          <label class="col-sm-3 control-label">Genero</label>
                           <div class="col-sm-9">
                           	                          
                             	<label class="radio-inline">
								  <input type="radio" name="rbgenero" id="rb_genero1" value="M" ${genero == 'M' ? 'checked' : ''}> Masculino
								</label>
								<label class="radio-inline">
								  <input type="radio" name="rbgenero" id="rb_genero2" value="F" ${genero == 'F' ? 'checked' : ''}> Femenino
								</label>
								<label class="radio-inline">
								  <input type="radio" name="rbgenero" id="rb_genero3" value="A" ${genero == 'A' ? 'checked' : ''}> Mixto
								</label>
                           </div>
                         </div>
                         
                         <div class="form-group">
                           <label class="col-sm-3 control-label">Maximo Participante:</label>
                           <div class="col-sm-9">
                               <div class="checkbox">
                           <label>
                             <input type="checkbox" id="maxactive" value="1" ${cantidad > 0 ? 'checked' : ''}>Habilitar Maximo de Participantes
                           </label>
                         </div>
                           </div>
                         </div>                                  
                         <div class="form-group">
                           <label class="col-sm-3 control-label"> </label>
                           <div class="col-sm-9">
                             <input type="text" id="maxpersonas" name="txtcantidad" class="form-control" value="${cantidad}" ${cantidad > 0 ? '' : 'disabled'} >
                           </div>
                         </div>                                 
                         <div class="form-group">
                           <label class="col-sm-3 control-label">Estado</label>
                           <div class="col-sm-9">
                             <select id="cboestado" name="cboestado" class="form-control">
                                   <option value="1" ${estado == 1 ? 'selected' : ''}>Activo</option>
                                   <option value="2" ${estado == 2 ? 'selected' : ''}>Inactivo</option>
                             </select>
                           </div>
                         </div>
                         <div class="form-group">
                           <div class="col-sm-offset-3 col-sm-9">
                             <a href="${pageContext.request.contextPath}/ServletCategoria?tipo=listar" class="btn btn-default"><i class="fa fa-arrow-left" aria-hidden="true"></i>
                               Atras
                             </a>
                             <button type="submit" class="btn btn-primary" >
                             <i class="glyphicon glyphicon-plus" aria-hidden="true"></i> Actualizar Categoria</button>
                           </div>
                         </div>
                       </form>
                 </div> 
                 <div class="col-md-3">
	                  
	             </div>
			</div>
		</div>
    </section>
  </div>
 
 <jsp:include page="_footer.jsp" flush="true" />