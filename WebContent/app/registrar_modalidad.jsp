<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <jsp:include page="_header.jsp" flush="true" />
 <jsp:include page="_sidebar.jsp" flush="true" />
 
 <div class="content-wrapper">
    <section class="content-header">
      <h3>Modalidad</h3> 
    </section>
    <section class="content">
        <div class="box box-primary">
        	<div class="box-header with-border">
              <h3 class="box-title">Agregar modalidad de juego</h3>
            </div>
        	<div class="box-body">
            	<div class="col-md-9">
					<form action="${pageContext.request.contextPath}/ServletModalidad?tipo=registrar" class="form-horizontal" id="frmregistrar" method="post">
                         
                         <div class="row">
                         	<div class="col-md-6">
                         		<div class="form-group">
		                           <label class="col-sm-4 control-label">Disciplina</label>
		                           <div class="col-sm-8">
		                             <select id="cbodisciplina" name="cbodisciplina" class="form-control">
		                                   <option value="1">Activo</option>
		                                   <option value="2">Inactivo</option>
		                             </select>
		                           </div>
		                         </div>
                         	</div>
                         	<div class="col-md-6">
                         		<div class="form-group">
		                           <label class="col-sm-4 control-label">Categoria</label>
		                           <div class="col-sm-8">
		                             <select id="cbocategoria" name="cbocategoria" class="form-control">
		                                   <option value="1">Activo</option>
		                                   <option value="2">Inactivo</option>
		                             </select>
		                           </div>
		                         </div>  
                         	</div>
                         </div>
                         
                         <div class="form-group">
	                           <label class="col-sm-2 control-label">Descripcion</label>
	                           <div class="col-sm-10">
	                             <textarea id=txthtml name="descripcion" rows="5" class="form-control"></textarea>
	                           </div>
		                 </div>
                                                                                      
                         
                         <div class="form-group">
                           <div class="col-sm-offset-2 col-sm-10">
                             <a href="${pageContext.request.contextPath}/ServletCategoria?tipo=listar" class="btn btn-default"><i class="fa fa-arrow-left" aria-hidden="true"></i>
                               Atras
                             </a>
                             <button type="submit" class="btn btn-primary" >
                             <i class="fa fa-plus" aria-hidden="true"></i> Registrar Modalidad</button>
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