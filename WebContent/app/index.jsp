<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
 <jsp:include page="_header.jsp" flush="true" />
 <jsp:include page="_sidebar.jsp" flush="true" />
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
            	
            	<div class="col-md-2 col-xs-6">
					<div class="app-tools">
						<div class="icon">
							<a href="${pageContext.request.contextPath}/ServletDisciplina?tipo=listar">
								<img class="touch" src="${pageContext.request.contextPath}/images/icons/64/021-football.png">
							</a>
						</div>
						<div class="name">
							<a href="${pageContext.request.contextPath}/ServletDisciplina?tipo=listar">Disciplinas</a>
						</div>
					</div>
            	</div>
            	
            	<div class="col-md-2 col-xs-6">
					<div class="app-tools">
						<div class="icon">
							<a href="${pageContext.request.contextPath}/ServletCategoria?tipo=listar">
								<img class="touch" src="${pageContext.request.contextPath}/images/icons/64/014-ball.png">
							</a>
						</div>
						<div class="name">
							<a href="${pageContext.request.contextPath}/ServletCategoria?tipo=listar">Categorias</a>
						</div>
					</div>
            	</div>
            	
            	<div class="col-md-2 col-xs-6">
					<div class="app-tools">
						<div class="icon">
							<a href="${pageContext.request.contextPath}/ServletModalidad?tipo=listar">
								<img class="touch" src="${pageContext.request.contextPath}/images/icons/64/035-strategy.png">
							</a>
						</div>
						<div class="name">
							<a href="${pageContext.request.contextPath}/ServletCategoria?tipo=listar">Modalidades</a>
						</div>
					</div>
            	</div>
            	<div class="col-md-2 col-xs-6">
					<div class="app-tools">
						<div class="icon">
							<a href="${pageContext.request.contextPath}/ServletEvento?tipo=listar">
								<img class="touch" src="${pageContext.request.contextPath}/images/icons/64/001-games.png">
							</a>
						</div>
						<div class="name">
							<a href="${pageContext.request.contextPath}/ServletEvento?tipo=listar">Mis Eventos</a>
						</div>
					</div>
            	</div>
            	<div class="col-md-2 col-xs-6">
					<div class="app-tools">
						<div class="icon">
							<a href="${pageContext.request.contextPath}/ServletPersona?tipo=listar">
								<img class="touch" src="${pageContext.request.contextPath}/images/icons/64/004-exercise-1.png">
							</a>
						</div>
						<div class="name">
							<a href="${pageContext.request.contextPath}/ServletPersona?tipo=listar">Personas</a>
						</div>
					</div>
            	</div>
            	
            	<div class="col-md-2 col-xs-6">
					<div class="app-tools">
						<div class="icon">
							<a href="${pageContext.request.contextPath}/ServletEquipo?tipo=listar">
								<img class="touch" src="${pageContext.request.contextPath}/images/icons/64/007-game-2.png">
							</a>
						</div>
						<div class="name">
							<a href="${pageContext.request.contextPath}/ServletEquipo?tipo=listar">Mis Equipos</a>
						</div>
					</div>
            	</div>
            	
            	
           	</div>
       	</div>
    </section>
    </div>
  <jsp:include page="_footer.jsp" flush="true" />