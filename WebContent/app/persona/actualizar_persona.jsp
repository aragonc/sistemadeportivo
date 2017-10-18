
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="beans.PersonaDTO"%>
<%@page import="service.ComboService"%>
<%@page import="dao.MySqlComboDAO"%>
<%@page import="interfaces.ComboDAO"%>
<%@page import="beans.ComboDTO"%>
<%@page import="java.util.List"%>
 
<%  
	PersonaDTO pe = (PersonaDTO) request.getAttribute("registro");
	ComboService listaDocumento = new ComboService();  
	List<ComboDTO> listaDoc = listaDocumento.listarCombo("documento");
	List<ComboDTO> listaSexo = listaDocumento.listarCombo("sexo");
%>
<c:set var="estado" value="<%= pe.getEstado() %>"/>

 <jsp:include page="../_header.jsp" flush="true" />
  <jsp:include page="../_sidebar.jsp" flush="true" />
  <!-- INICIO DE CABECERA INFO PAGE  -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        Actualizar Persona
      </h1>
      
    </section>
	<!-- /.FIN DE CABECERA INFO PAGE -->
	
    <!-- SECCION DE CONTENIDO -->
    <section class="content">
    
    <div class="box box-primary">
    	<div class="row">
    	<div class="col-md-9">
    		<div class="box-header with-border">
  				<h3 class="box-title">Actualizar persona</h3>
  			</div>
	  		<form class="form-horizontal" action="${pageContext.request.contextPath}/ServletPersona?tipo=actualizar" method="post">
	  			<input type="hidden" name="codigo" value="<%= pe.getCodigo() %>">
	  			<div class="box-body">
		  			<div class="form-group">
					    <label for="txtnombre" class="col-sm-2 control-label">Nombres:</label>
					    <div class="col-sm-10">
					      <input type="text" class="form-control"  id="txtnombre" name="txtnombre" value="<%= pe.getNombre() %>" placeholder="Escribir el nombre">
					    </div>
					</div>
					<div class="form-group">
					    <label for="txtapaterno" class="col-sm-2 control-label">Apellido Paterno:</label>
					    <div class="col-sm-10">
					      <input type="text" class="form-control" value="<%= pe.getApaterno() %>" id="txtapaterno" name="txtapaterno" placeholder="Escribir el apellido paterno">
					    </div>
					</div>
					<div class="form-group">
					    <label for="txtamaterno" class="col-sm-2 control-label">Apellido Materno:</label>
					    <div class="col-sm-10">
					      <input type="text" class="form-control" id="txtamaterno" value="<%= pe.getAmaterno() %>" name="txtamaterno" placeholder="Escribir el apellido materno">
					    </div>
					</div>
					<div class="form-group">
					    <label for="cmbsexo" class="col-sm-2 control-label">Sexo:</label>
					    <div class="col-sm-10">
					      <select class="form-control" id="cmbsexo" name="cmbsexo">
		                    <option value="0">-- Seleccione --</option>
		                    	<%
			                    	for (ComboDTO item : listaSexo ){
			                    		if(item.getField().equals(pe.getSexo())){
			                    			out.println("<option value="+ item.getField() +" selected>" + item.getValor()+"</option>");
			                    		} else {
			                    			out.println("<option value="+ item.getField() +" >" + item.getValor()+"</option>");
			                    		}
			                    	}
			                    
			                   	%>
		                  </select>
					    </div>
					</div>
					<div class="form-group">
					    <label for="cbotipodocumento" class="col-sm-2 control-label">Documento de identidad:</label>
					    <div class="col-sm-10">
					    	 <select class="form-control" id="cbotipodocumento" name="cbotipodocumento">
			                    <option value="0">-- Seleccione --</option>
			                    <%
			                    	for (ComboDTO item : listaDoc ){
			                    		if(item.getField().equals(pe.getTipodocumento()+"")){
			                    			out.println("<option value="+ item.getField() +" selected>" + item.getValor()+"</option>");
			                    		} else {
			                    			out.println("<option value="+ item.getField() +" >" + item.getValor()+"</option>");
			                    		}
			                    	}
			                   	%>
		                  	</select>
					      	<input type="text" class="form-control" id="txtnumdocumento" value="<%= pe.getNumdocumento() %>" name="txtnumdocumento" placeholder="Escribir el número de documento">
					    </div>
					</div>
					<div class="form-group">
					    <label for="txtfechanacimiento" class="col-sm-2 control-label">Fecha Nacimiento:</label>
					    <div class="col-sm-10">
					      <div class="input-group date">
			                  <div class="input-group-addon">
			                    <i class="fa fa-calendar"></i>
			                  </div>
			                  <input type="text" value="<%= pe.getFnacimiento() %>" class="form-control midatepicker pull-right" id="txtfechanacimiento" data-date-format="yyyy-mm-dd" name="txtfechanacimiento">
			                </div>
					    </div>
					</div>
					<div class="form-group">
					    <label for="txtemail" class="col-sm-2 control-label">Email:</label>
					    <div class="col-sm-10">
					      <div class="input-group">
				                <span class="input-group-addon"><i class="fa fa-envelope"></i></span>
				                <input type="email" class="form-control" value="<%= pe.getEmail() %>" name="txtemail" id="txtemail" placeholder="Escribir el correo electronico">
				          </div>
					    </div>
					</div>
					<div class="form-group">
					    <label for="txtfono" class="col-sm-2 control-label">Teléfono:</label>
					    <div class="col-sm-10">
					      <input type="text" class="form-control" id="txtfono" value="<%= pe.getFono() %>" name="txtfono" placeholder="Escribir el número de teléfono">
					    </div>
					</div>
					<div class="form-group">
					    <label for="cmbestado" class="col-sm-2 control-label">Estado:</label>
					    <div class="col-sm-10">
					      <select class="form-control" name="cmbestado">
		                    <option value="1" ${estado == 1 ? 'selected' : ''}>Activo</option>
		                    <option value="2" ${estado == 2 ? 'selected' : ''}>Inactivo</option>
		                  </select>
					    </div>
					</div>
				</div>
				<div class="box-footer">
					<a href="${pageContext.request.contextPath}/ServletPersona?tipo=listar" class="btn btn-default"><i class="fa fa-arrow-left" aria-hidden="true"></i> Volver a lista </a>
                	<button type="submit" class="btn btn-primary"><i class="glyphicon glyphicon-plus" aria-hidden="true"></i> Actualizar persona</button>
              	</div>
	  		</form>
    	</div>
    	<div class="col-md-3">
    	
    	</div>
  		</div>
	</div>
      
    </section>
    <!-- /.FIN DE CABECERA INFO PAGE-->
  </div>
  <!-- /.FIN DE SECCION DE CONTENIDO -->
  <jsp:include page="../_footer.jsp" flush="true" />
