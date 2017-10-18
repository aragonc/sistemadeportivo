<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
 <jsp:include page="../_header.jsp" flush="true" />
 <jsp:include page="../_sidebar.jsp" flush="true" />
 
 <div class="content-wrapper">
 <section class="content-header">
      <h1>Disciplina</h1> 
    </section>
    <section class="content">
              <div class="box box-primary">
              	<div class="box-header with-border">
	              <h3 class="box-title">Agregar disciplina de juego</h3>
	        	</div>
                  <div class="box-body">
                          <div class="col-md-9">
                                <form action="../ServletDisciplina?tipo=registrar" class="form-horizontal" id="frmdisciplina" method="post">
                                  <div class="form-group">
                                    <label for="txtdisciplina" class="col-sm-2 control-label">Nombre de Disciplina</label>
                                    <div class="col-sm-5">
                                      <input type="text" class="form-control" name="txt_nombre" id="txtdisciplina" placeholder="Escribe nombre de disciplina">
                                    </div>
                                    <div class="col-md-5"></div>
                                  </div>

                                  <div class="form-group">
                                    <label class="col-sm-2 control-label">Estado</label>
                                    <div class="col-sm-5">
                                      <select id="cboestado" name="cbo_estado" class="form-control">
                                            <option value="1">Activo</option>
                                            <option value="2">Inactivo</option>
                                          </select>
                                    </div>
                                    <div class="col-md-5"></div>
                                  </div>
                                  <div class="form-group">
                                    <div class="col-sm-offset-2 col-sm-10">
                                      <a href="${pageContext.request.contextPath}/ServletDisciplina?tipo=listar" class="btn btn-default"><i class="fa fa-arrow-left" aria-hidden="true"></i>
                                        Atras
                                      </a>
                                      <button type="submit" class="btn btn-success">
                                      <i class="fa fa-plus" aria-hidden="true"></i> Registrar Disciplina</button>
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