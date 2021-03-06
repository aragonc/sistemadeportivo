
 <%@ include file="../_header.jsp" %>
 <%@ include file="../_sidebar.jsp" %>
  <%	String validar = (String) request.getAttribute("validaciones"); %>
 <div class="content-wrapper">
    <section class="content-header">
      <h1>Categoria</h1> 
    </section>
    <section class="content">
        <div class="box box-primary">
        	<div class="box-header with-border">
              <h3 class="box-title">Agregar nueva categoria de juego</h3>
            </div>
        	<div class="box-body">
            	<div class="col-md-9">
					<form action="${pageContext.request.contextPath}/ServletCategoria?tipo=registrar" class="form-horizontal" id="frmregistrar" method="post">
                         <div class="form-group">
                          <% if (validar != null) { %>
                                 <div class="alert alert-warning" role="alert">${requestScope.validaciones}</div>
                                 <% } %>
                         <label class="col-sm-2 control-label">Nombre Categoria</label>
                           <div class="col-sm-5">
                             <input type="text"  id="txt_nombre" name="txt_nombre" class="form-control" placeholder="Escribe nombre de Categoria">
                           </div>
                           <div class="col-sm-5"></div>
                         </div>                                                                
                         <div class="form-group">
                           <label class="col-sm-2 control-label">Estado</label>
                           <div class="col-sm-5">
                             <select id="cboestado" name="cboestado" class="form-control">
                                   <option value="1">Activo</option>
                                   <option value="2">Inactivo</option>
                             </select>
                           </div>
                           <div class="col-sm-5"></div>
                         </div>
                         <div class="form-group">
                           <div class="col-sm-offset-2 col-sm-10">
                             <a href="${pageContext.request.contextPath}/ServletCategoria?tipo=listar" class="btn btn-default"><i class="fa fa-arrow-left" aria-hidden="true"></i>
                               Atras
                             </a>
                             <button type="submit" class="btn btn-success" >
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
 
 <%@ include file="../_footer.jsp" %>