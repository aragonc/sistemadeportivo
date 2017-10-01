<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <jsp:include page="_header.jsp" flush="true" />
 <jsp:include page="_sidebar.jsp" flush="true" />
 
 <div class="content-wrapper">
    <section class="content-header">
      <h3>Registrar categoria de disciplina</h3> 
    </section>
    <section class="content">
        <div class="box box-primary">
        	<div class="box-header with-border">
              <h3 class="box-title">Categoria de disciplina</h3>
            </div>
        	<div class="box-body">
            	<div class="col-md-9">
					<form action="${pageContext.request.contextPath}/ServletCategoria?tipo=registrar" class="form-horizontal" id="frmregistrar" method="post">
                         <div class="form-group">
                           <label class="col-sm-3 control-label">Nombre Categoria</label>
                           <div class="col-sm-9">
                             <input type="text"  id="txtnombre" name="txtnombre" class="form-control" placeholder="Escribe nombre de Categoria">
                           </div>
                         </div>                                                                
                         <div class="form-group">
                           <label class="col-sm-3 control-label">Estado</label>
                           <div class="col-sm-9">
                             <select id="cboestado" name="cboestado" class="form-control">
                                   <option value="1">Activo</option>
                                   <option value="2">Inactivo</option>
                             </select>
                           </div>
                         </div>
                         <div class="form-group">
                           <div class="col-sm-offset-3 col-sm-9">
                             <a href="${pageContext.request.contextPath}/ServletCategoria?tipo=listar" class="btn btn-default"><i class="fa fa-arrow-left" aria-hidden="true"></i>
                               Atras
                             </a>
                             <button type="submit" class="btn btn-primary" >
                             <i class="fa fa-plus" aria-hidden="true"></i> Registrar Categoria</button>
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