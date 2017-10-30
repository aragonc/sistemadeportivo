<%@page import="beans.CategoriaDTO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../_header.jsp" %>
<%@ include file="../_sidebar.jsp" %>
 <% 
 CategoriaDTO ca = (CategoriaDTO) request.getAttribute("registro"); 
 String validar = (String) request.getAttribute("validaciones");
 %>
 <c:set var="estado" value="<%= ca.getEstado() %>"/>

 <div class="content-wrapper">
 	<section class="content-header">
      <h1>Categoria</h1> 
    </section>
    <section class="content">
        <div class="box box-primary">
        	<div class="box-header with-border">
              <h3 class="box-title">Actualizar categoria de juego</h3>
            </div>
        	<div class="box-body">
            	<div class="col-md-9">
					<form action="${pageContext.request.contextPath}/ServletCategoria?tipo=actualizar" class="form-horizontal" id="frmregistrar" method="post">
                         <input type="hidden" name="codigo" value="<%= ca.getCodigo() %>">
                         <div class="form-group">
                          <% if (validar != null) { %>
                                 <div class="alert alert-warning" role="alert">${requestScope.validaciones}</div>
                                 <% } %>
                           <label class="col-sm-2 control-label">Nombre Categoria</label>
                           <div class="col-sm-5">
                             <input type="text"  id="txt_nombre" name="txt_nombre" class="form-control" value="<%= ca.getNombre() %>">
                           </div>
                           <div class="col-sm-5"></div>
                         </div>                            
                                                  
                         <div class="form-group">
                           <label class="col-sm-2 control-label">Estado</label>
                           <div class="col-sm-5">
                             <select id="cboestado" name="cboestado" class="form-control">
                                   <option value="1" ${estado == 1 ? 'selected' : ''}>Activo</option>
                                   <option value="2" ${estado == 2 ? 'selected' : ''}>Inactivo</option>
                             </select>
                           </div>
                           <div class="col-sm-5"></div>
                         </div>
                         <div class="form-group">
                           <div class="col-sm-offset-2 col-sm-9">
                             <a href="${pageContext.request.contextPath}/ServletCategoria?tipo=listar" class="btn btn-default"><i class="fa fa-arrow-left" aria-hidden="true"></i>
                               Atras
                             </a>
                             <button type="submit" class="btn btn-success" >
                             <i class="fa fa-pencil" aria-hidden="true"></i> Actualizar Categoria</button>
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
 
<%@ include file="../_footer.jsp" %>