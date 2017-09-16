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
					<form action="../ServletCategoria?tipo=registrar" class="form-horizontal" id="frmregistrar" method="post">
                         <div class="form-group">
                           <label class="col-sm-3 control-label">Nombre Categoria</label>
                           <div class="col-sm-9">
                             <input type="text"  id="txtnombre" name="txtnombre" class="form-control" placeholder="Escribe nombre de Categoria">
                           </div>
                         </div>
                         <div class="form-group">
                          <label class="col-sm-3 control-label">Genero</label>
                           <div class="col-sm-9">
                             	<label class="radio-inline">
								  <input type="radio" name="rbgenero" id="rb_genero1" value="M"> Masculino
								</label>
								<label class="radio-inline">
								  <input type="radio" name="rbgenero" id="rb_genero2" value="F"> Femenino
								</label>
								<label class="radio-inline">
								  <input type="radio" name="rbgenero" id="rb_genero3" value="A"> Mixto
								</label>
                           </div>
                         </div>
                         
                         <div class="form-group">
                           <label class="col-sm-3 control-label">Maximo Participante:</label>
                           <div class="col-sm-9">
                               <div class="checkbox">
                           <label>
                             <input type="checkbox" id="maxactive" value="1" >Habilitar Maximo de Participantes
                           </label>
                         </div>
                           </div>
                         </div>                                  
                         <div class="form-group">
                           <label class="col-sm-3 control-label"> </label>
                           <div class="col-sm-9">
                             <input type="text" id="maxpersonas" name="txtcantidad" class="form-control" value="0" disabled >
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
                             <a href="lista_categoria.jsp" class="btn btn-default"><i class="fa fa-arrow-left" aria-hidden="true"></i>
                               Atras
                             </a>
                             <button type="submit" class="btn btn-primary" >
                             <i class="glyphicon glyphicon-plus" aria-hidden="true"></i> Registrar Categoria</button>
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