<%@page import="beans.DisciplinaDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <jsp:include page="_header.jsp" flush="true" />
 <jsp:include page="_sidebar.jsp" flush="true" />
 <% DisciplinaDTO di = (DisciplinaDTO) request.getAttribute("registro"); %>
  <c:set var="estado" value="<%= di.getEstado() %>"/>
 <div class="content-wrapper">   
    <section class="content">
              <div class="box box-primary">
              <div class="box-header with-border">
	              <h3 class="box-title">Actualizar disciplina de juego</h3>
	        	</div>
                  <div class="box-body">
                          <div class="col-md-9">

                                <form action="${pageContext.request.contextPath}/ServletDisciplina?tipo=actualizar" class="form-horizontal" id="frmdisciplina" method="post">
                                <input type="hidden" name="txt_codigo" value="<%= di.getCodigo() %>">
                                  <div class="form-group">
                                    <label for="txtdisciplina" class="col-sm-2 control-label">Nombre de Disciplina</label>
                                    <div class="col-sm-5">
                                      <input type="text" class="form-control" name="txt_nombre" id="txtdisciplina" placeholder="Escribe nombre de disciplina" value="<%= di.getNombre()%>">
                                    </div>
                                    <div class="col-sm-5"></div>
                                  </div>

                                  <div class="form-group">
                                    <label class="col-sm-2 control-label">Estado</label>
                                    <div class="col-sm-5">
                                      <select id="cboestado" name="cbo_estado" class="form-control">
                                            <option value="1" ${estado == 1 ? 'selected' : ''}>Activo</option>
                                   			<option value="2" ${estado == 2 ? 'selected' : ''}>Inactivo</option>
                                          </select>
                                    </div>
                                    <div class="col-sm-5"></div>
                                  </div>
                                  <div class="form-group">
                                    <div class="col-sm-offset-2 col-sm-10">
                                      <a href="${pageContext.request.contextPath}/ServletDisciplina?tipo=listar" class="btn btn-default"><i class="fa fa-arrow-left" aria-hidden="true"></i>
                              	 		Atras
                             			</a>	
                                      <button type="submit" class="btn btn-success">
                                      <i class="fa fa-pencil" aria-hidden="true"></i> Actualizar Disciplina</button>
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
  <!-- /.content-wrapper -->
 
 <jsp:include page="_footer.jsp" flush="true" />