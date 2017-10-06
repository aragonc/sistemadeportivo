<%@page import="beans.ModalidadDTO"%>
<%@page import="beans.ComboDTO"%>
<%@page import="java.util.List"%>
<%@page import="service.ComboService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <jsp:include page="_header.jsp" flush="true" />
 <jsp:include page="_sidebar.jsp" flush="true" />
 <%  
 	ModalidadDTO obj = (ModalidadDTO)request.getAttribute("registro");
	ComboService listas = new ComboService();  
	List<ComboDTO> listaCategoria = listas.listarComboSql("SELECT idcategoria, nombres FROM campeonato.categoria where estado = 1;");
	List<ComboDTO> listaDisciplina = listas.listarComboSql("SELECT iddisciplina, nombre FROM campeonato.disciplina where estado = 1;");
%>
 <div class="content-wrapper">
    <section class="content-header">
      <h1>Modalidad</h1> 
    </section>
    <section class="content">
        <div class="box box-primary">
        	<div class="box-header with-border">
              <h3 class="box-title">Actualizar modalidad de juego</h3>
            </div>
        	<div class="box-body">
            	<div class="col-md-9">
					<form action="${pageContext.request.contextPath}/ServletModalidad?tipo=actualizar" class="form-horizontal" id="frmregistrar" method="post">
                         <input type="hidden" name="codigo" value="<%= obj.getCodigo() %>">
                         <div class="row">
                         	<div class="col-md-6">
                         		<div class="form-group">
		                           <label class="col-sm-4 control-label">Disciplina</label>
		                           <div class="col-sm-8">
		                             <select id="cbodisciplina" name="cbodisciplina" class="form-control">
		                                   <option value="">-- Seleccione --</option>
						                    	<%
							                    	for (ComboDTO item : listaDisciplina ){
							                    		
							                    		if(item.getField().equals(obj.getDisciplina().getCodigo()+"")){
							                    			out.println("<option value="+ item.getField() +" selected>" + item.getValor()+"</option>");
							                    		} else {
							                    			out.println("<option value="+ item.getField() +" >" + item.getValor()+"</option>");
							                    		}
							                    	}
							                    
							                   	%>
		                             </select>
		                           </div>
		                         </div>
                         	</div>
                         	<div class="col-md-6">
                         		<div class="form-group">
		                           <label class="col-sm-4 control-label">Categoria</label>
		                           <div class="col-sm-8">
		                             <select id="cbocategoria" name="cbocategoria" class="form-control">
		                                   <option value="">-- Seleccione --</option>
						                    	<%
							                    	for (ComboDTO item : listaCategoria ){
							                    		if(item.getField().equals(obj.getCategoria().getCodigo()+"")){
							                    			out.println("<option value="+ item.getField() +" selected>" + item.getValor()+"</option>");
							                    		} else {
							                    			out.println("<option value="+ item.getField() +" >" + item.getValor()+"</option>");
							                    		}
							                    	}
							                    
							                   	%>
		                             </select>
		                           </div>
		                         </div>  
                         	</div>
                         </div>
                         
                         <div class="form-group">
	                           <label class="col-sm-2 control-label">Descripción</label>
	                           <div class="col-sm-10">
	                             <textarea id=txthtml name="descripcion" rows="5" class="form-control">
	                             	<%= obj.getDescripcion() %>
	                             </textarea>
	                           </div>
		                 </div>
                                                                                      
                         
                         <div class="form-group">
                           <div class="col-sm-offset-2 col-sm-10">
                             <a href="${pageContext.request.contextPath}/ServletModalidad?tipo=listar" class="btn btn-default"><i class="fa fa-arrow-left" aria-hidden="true"></i>
                               Atras
                             </a>
                             <button type="submit" class="btn btn-primary" >
                             <i class="fa fa-plus" aria-hidden="true"></i> Actualizar Modalidad</button>
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