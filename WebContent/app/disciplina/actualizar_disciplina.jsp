<%@page import="beans.DisciplinaDTO"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ include file="../_header.jsp" %>
 <%@ include file="../_sidebar.jsp" %>
 <% 
 String validar = (String) request.getAttribute("validaciones");
 DisciplinaDTO di = (DisciplinaDTO) request.getAttribute("registro"); 
 
 %>

<c:set var="estado" value="<%= di.getEstado() %>"/>

 <div class="content-wrapper">
 	<section class="content-header">
      <h1>Disciplina</h1> 
    </section>
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
                                  <% if (validar != null) { %>
                                 <div class="alert alert-warning" role="alert">${requestScope.validaciones}</div>
                                 <% } %>
                                    <label for="txtdisciplina" class="col-sm-2 control-label">Nombre de Disciplina</label>
                                    <div class="col-sm-5">
                                      <input type="text" class="form-control" name="txt_nombre" id="txt_disciplina" placeholder="Escribe nombre de disciplina" value="<%= di.getNombre()%>">
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
 
 <jsp:include page="../_footer.jsp" flush="true" />