<%@page import="beans.ModuloDTO"%>
<%@page import="java.util.List"%>
<%@page import="beans.UsuarioDTO"%>

  <!-- INICIO SIDEBAR IZQUIERDO -->
  <%
  	UsuarioDTO usuario = null;
  	String nombre = null;
  	String avatar = null;
  	String validarSession = (String) session.getAttribute("inicio");
	
	//CONTROLA SESSION
	if ( ( validarSession == null || validarSession.equalsIgnoreCase("") ) ) {
		System.out.println("Sesión caducada");
		//procesar = false;
		response.sendRedirect(request.getContextPath());
    } else {
    	usuario = (UsuarioDTO)session.getAttribute("user");
    	nombre = usuario.getPersona().getApaterno() + " " +usuario.getPersona().getAmaterno();
  		List<ModuloDTO> menus = usuario.getModulo();
  %>
  <aside class="main-sidebar">
    <section class="sidebar">
      <!-- Sidebar user panel -->
      <div class="user-panel">
        <div class="pull-left image">
          <%
          	if(usuario.getPersona().getAvatar().equals("avatar.jpg") || usuario.getPersona().getAvatar().equals("") ){
          %>
          	<img src="${pageContext.request.contextPath}/images/<%= usuario.getPersona().getAvatar() %>" class="img-circle" alt="<%= nombre %>">
          <% } else { %>
          	<img src="${pageContext.request.contextPath}/uploads/<%= usuario.getPersona().getAvatar() %>" class="img-circle" alt="<%= nombre %>">
          <% } %>
        </div>
        <div class="pull-left info">
          <p><%= nombre %></p>
          <a href="#"><i class="fa fa-circle text-success"></i> <%= usuario.getPerfil().getNombre() %></a>
        </div>
      </div>
      <ul class="sidebar-menu" data-widget="tree">
        <li class="header">MENÚ OPCIONES</li>
        <li class="active">
          <a href="${pageContext.request.contextPath}/ServletUsuario?tipo=panel">
            <i class="fa fa-dashboard"></i> <span>Escritorio</span>
          </a>
        </li>
        
        <% for (ModuloDTO item : menus) { %>
	        <li>
	          <a href="${pageContext.request.contextPath}/<%= item.getUrl() %>">
	            <i class="fa <%= item.getIconsmall() %>" aria-hidden="true"></i> <span><%= item.getNombre() %></span>
	          </a>
	        </li>
        <% } %>
        
        
      </ul>
    </section>
  </aside>
  <% } %>
 <!-- /.FIN DE SIDEBAR IZQUIERDO -->