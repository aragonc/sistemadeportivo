<%@page import="beans.LugarDTO"%>
<%@page import="java.util.List"%>
<%@page import="service.ComboService"%>

 <%@ include file="../_header.jsp" %>
 <%@ include file="../_sidebar.jsp" %>
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
                         	<div class="col-md-12">
                         		<div class="form-group">
		                           <label class="col-sm-2 control-label">Nombre lugar</label>
		                           <div class="col-sm-8">
		                             <input class="form-control" name="nombre" id="nombre" value="<%= obj.getNombre() %>">
		                           </div>
		                           <div class="col-sm-2">
		                           		<button type="button" class="btn btn-primary" id="search">
		                           		<i class="fa fa-search" aria-hidden="true"></i>
										Ubicar en el mapa
										</button>
		                           </div>
		                        </div>
                         		<div class="form-group">
		                           <label class="col-sm-2 control-label">Dirección</label>
		                           <div class="col-sm-8">
		                            	<input class="form-control" name="direccion" id="direccion" value="<%= obj.getDireccion() %>">
		                           </div>
		                           <div class="col-sm-2"></div>
	                         	</div>  

                         	</div>
                         	
                         </div>
                         
                         <div class="form-group">
	                           <label class="col-sm-2 control-label">Ubicación</label>
	                           <div class="col-sm-8">
	                             <div id="mapa" style="width: 100%; height: 400px;"></div>
	                           </div>
	                           <div class="col-sm-2"></div>
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
	                  
	                  var map;
	                  var latlng;
	                  var address;
	                  
	                  $(document).ready(function(){
						  // CREAMOS EL MAPA
	                	  map = new GMaps({
	                        div: '#mapa',
	                        zoom: 15,
	                        lat: ${latitud},
	                        lng: ${longitud},
	                        enableNewStyle: true
	                      });
	                	  
						  // UBICACION DEL MARKER
	                	  map.addMarker({
	                			  lat: ${latitud},
	                			  lng: ${longitud},
	                			  draggable: true
	                		});
	                	  //GEOLOCALIZACION
	                	  
	                	  /* GMaps.geolocate({
					        success: function(position){
					          map.setCenter(position.coords.latitude, position.coords.longitude);
					          map.setZoom(16);
					          map.addMarker({
              	                lat: position.coords.latitude,
              	                lng: position.coords.longitude,
              	                draggable: false,
              	              });
					        },
					        error: function(error){
					          alert('Geolocalización fallida: '+error.message);
					        },
					        not_supported: function(){
					          alert("Tu navegador no soporta la geolocazacion");
					        },
					        always: function(){
					          alert("Listo hemos ubicado tu posición...!");
					        }
					      });*/
	                	  
	                	  //BUSCAR LUGAR
	                	  $('#search').click(function(){
	                		  GMaps.geocode({
	                    		  address: $('#nombre').val().trim(),
	                    		  callback: function(results, status){
	                    			  if(status=='OK'){
	                    				  latlng = results[0].geometry.location;
	                    				  address = results[0].formatted_address;
	                    	              map.setCenter(latlng.lat(), latlng.lng());
	                    	              map.addMarker({
	                    	                lat: latlng.lat(),
	                    	                lng: latlng.lng(),
	                    	                draggable: false,
	                    	              });
	                    	              
	                    			  }
	                    			  document.getElementById('latitud').value = latlng.lat();
	                	              document.getElementById('longitud').value = latlng.lng();
	                	              document.getElementById('direccion').value = address;
	                    		  }
	                    	  });
	                	  });
		                     
	                    });
	                  
	                  
	                  
	                  </script>
	             </div>
			</div>
		</div>
    </section>
  </div>
 
 <%@ include file="../_footer.jsp" %>
 