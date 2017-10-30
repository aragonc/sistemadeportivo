<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<% 
String xSession = (String) session.getAttribute("inicio");

//CONTROLA SESSION
if ( ( xSession == null || xSession.equalsIgnoreCase("") ) ) {
	response.sendRedirect(request.getContextPath());
} else {
	List<ModuloDTO> modulos = (List<ModuloDTO>)session.getAttribute("menus"); 
%>
<%@page import="java.util.List" %>
 <%@ include file="_header.jsp"  %>
 <%@ include file="_sidebar.jsp" %>
   <div class="content-wrapper">
    <section class="content-header">
      <h1>
        Escritorio
      </h1>
    </section>
    <section class="content">
    	<div class="box box-primary">
    		<div class="box-header with-border">
	              <h3 class="box-title">Gestión de la plataforma</h3>
	        </div>
        	<div class="box-body">
            	
            	<% for (ModuloDTO item : modulos) { %>
            	
            	<div class="col-md-2 col-xs-6">
					<div id="tool_<%= item.getCodigo() %>" class="app-tools">
						<div class="icon">
							<a href="${pageContext.request.contextPath}/<%= item.getUrl() %>">
								<img class="touch" src="${pageContext.request.contextPath}/images/icons/tools/<%= item.getIconbing() %>">
							</a>
						</div>
						<div class="name">
							<a href="${pageContext.request.contextPath}/<%= item.getUrl() %>"><%= item.getNombre() %></a>
						</div>
					</div>
            	</div>
            	<% } %>
            	
           	</div>
       	</div>
    </section>
    </div>
  <%@ include file="_footer.jsp" %>
  <% } %>
  