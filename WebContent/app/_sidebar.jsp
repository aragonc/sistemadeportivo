<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <!-- INICIO SIDEBAR IZQUIERDO -->
  <aside class="main-sidebar">
    <section class="sidebar">
      <!-- Sidebar user panel -->
      <div class="user-panel">
        <div class="pull-left image">
          <img src="${pageContext.request.contextPath}/images/avatar.jpg" class="img-circle" alt="User Image">
        </div>
        <div class="pull-left info">
          <p>Alexander Pierce</p>
          <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
        </div>
      </div>
      <ul class="sidebar-menu" data-widget="tree">
        <li class="header">MENÚ OPCIONES</li>
        <li class="active">
          <a href="${pageContext.request.contextPath}">
            <i class="fa fa-dashboard"></i> <span>Escritorio</span>
          </a>
        </li>
        <li>
          <a href="${pageContext.request.contextPath}/ServletDisciplina?tipo=listar">
            <i class="fa fa-futbol-o" aria-hidden="true"></i> <span>Disciplinas</span>
          </a>
        </li>
        <li>
          <a href="${pageContext.request.contextPath}/ServletCategoria?tipo=listar">
            <i class="fa fa-folder" aria-hidden="true"></i> <span>Categorias</span>
          </a>
        </li>
        <li>
          <a href="${pageContext.request.contextPath}/ServletModalidad?tipo=listar">
            <i class="fa fa-bookmark" aria-hidden="true"></i> <span>Modalidades</span>
          </a>
        </li>
        <li>
          <a href="${pageContext.request.contextPath}/ServletEvento?tipo=listar">
            <i class="fa fa-bell" aria-hidden="true"></i> <span>Eventos</span>
          </a>
        </li>
        <li>
          <a href="${pageContext.request.contextPath}/ServletPersona?tipo=listar">
            <i class="fa fa-user" aria-hidden="true"></i> <span>Personas</span>
          </a>
        </li>
        <li>
          <a href="${pageContext.request.contextPath}/ServletEquipo?tipo=listar">
            <i class="fa fa-users" aria-hidden="true"></i> <span>Equipos</span>
          </a>
        </li>
      </ul>
    </section>
  </aside>
 <!-- /.FIN DE SIDEBAR IZQUIERDO -->