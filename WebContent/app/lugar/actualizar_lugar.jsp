<%@page import="beans.LugarDTO"%>
<%@page import="java.util.List"%>
<%@page import="service.ComboService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <jsp:include page="../_header.jsp" flush="true" />
 <jsp:include page="../_sidebar.jsp" flush="true" />
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%  
   String error = (String)request.getAttribute("errorMessage");
   LugarDTO obj = (LugarDTO) request.getAttribute("registro");
%>
<c:set var="latitud" value="<%= obj.getLatitud() %>"/>
<c:set var="longitud" value="<%= obj.getLongitud() %>"/>
 <div class="content-wrapper">
    <section class="content-header">
      <h1>Lugar</h1> 
    </section>
    <section class="content">
        <div class="box box-primary">
        	<div class="box-header with-border">
              <h3 class="box-title">Actualizar lugar de juego</h3>
            </div>
        	<div class="box-body">
        	
            	<div class="col-md-9">
            	
            		            	
					<form action="${pageContext.request.contextPath}/ServletLugar?tipo=actualizar" class="form-horizontal" id="frmregistrar" method="post">
                         <input type="hidden" name="codigo" value="<%= obj.getCodigo() %>">
                         <div class="row">
                         	<div class="col-md-6">
                         		<div class="form-group">
		                           <label class="col-sm-4 control-label">Nombre lugar</label>
		                           <div class="col-sm-8">
		                             <input class="form-control" name="nombre" id="nombre" value="<%= obj.getNombre() %>">
		                           </div>
		                         </div>
                         	</div>
                         	<div class="col-md-6">
                         		<div class="form-group">
		                           <label class="col-sm-4 control-label">Dirección</label>
		                           <div class="col-sm-8">
		                            	<input class="form-control" name="direccion" id="direccion" value="<%= obj.getDireccion() %>">
		                           </div>
		                         </div>  
                         	</div>
                         	
                         </div>
                         
                         <div class="form-group">
	                           <label class="col-sm-2 control-label">Ubicación</label>
	                           <div class="col-sm-10">
	                             <div id="mapa" style="width: 750px; height: 400px;"></div>
	                           </div>
		                 </div>
                         
                         <input type="hidden" name="latitud" id="latitud">    
                         <input type="hidden" name="longitud" id="longitud">                                    
                         
                         <div class="form-group">
                           <div class="col-sm-offset-2 col-sm-10">
                             <a href="${pageContext.request.contextPath}/ServletLugar?tipo=listar" class="btn btn-default"><i class="fa fa-arrow-left" aria-hidden="true"></i>
                               Atras
                             </a>
                             <button type="submit" class="btn btn-success" >
                             <i class="fa fa-plus" aria-hidden="true"></i> Actualizar Lugar</button>
                           </div>
                         </div>
                       </form>
                 </div> 
                 <div class="col-md-3">
	                  <script type="text/javascript">
	                  $( document ).ready(function() {
	                		
	                		var map;
	                		var lat;
	                		var lng;
	                		
	                		map = new GMaps({
	                	        div: '#mapa',
	                	        lat: ${latitud},
	                	        lng: ${longitud},
	                	        enableNewStyle: true
	                	      });
	                		
	                		
	                		map.addMarker({
	                			  lat: ${latitud},
	                			  lng: ${longitud},
	                			  draggable: true,
	                			  dragend: function(event) {
	                	              lat = event.latLng.lat();
	                	              lng = event.latLng.lng();
	                	              console.log(lat);
	                	              console.log(lng);
	                	              document.getElementById('latitud').value = lat;
	                	              document.getElementById('longitud').value = lng;

	                	          }
	                			  
	                			});
	                  	});
	                  </script>
	             </div>
			</div>
		</div>
    </section>
  </div>
 
 <jsp:include page="../_footer.jsp" flush="true" />
 