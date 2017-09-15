<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

 <jsp:include page="_header.jsp" flush="true" />
 <jsp:include page="_sidebar.jsp" flush="true" />
 
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h3>Lista de disciplinas</h3> 
    </section>

    <!-- Main content -->
    <section class="content">
       <div class="box box-primary">
           <div class="box-body">
	        <div class="col-md-9">
	        <div class="toolbar-actions">
		        <a class="btn btn-primary">
		        	<i class="glyphicon glyphicon-plus" aria-hidden="true"></i> Registrar disciplina
		       	</a>
	       	</div>
	        <div class="box-body table-responsive no-padding">
		        <table class="table table-hover">
		              <tr>
		                <th>Codigo</th>
		                <th>Nombre</th>
		                <th>Estado</th>
		                <th width="100">Acciones</th>
		              </tr>
		              <tr>
		                <td>0001</td>
		                <td>Futbol</td>
		                <td><span class="label label-primary">Activo</span></td>
		                <td>
		                  <div class="btn-group btn-group-sm" role="group" aria-label="...">
		                    <a href="#" class="btn btn-default" title="Editar Deuda"><i class="fa fa-pencil" aria-hidden="true"></i></a>
		                    <a href="#" class="btn btn-default" title="Eliminar deuda"><i class="fa fa-trash-o" aria-hidden="true"></i></a>
		                  </div>
		                </td>
		              </tr>
		        </table>
	         </div>
	     	 </div>
           		<div class="col-md-3">
                 
                 </div>  
	        </div>
	    </div> 
    </section>
  </div>
 
 <jsp:include page="_footer.jsp" flush="true" />