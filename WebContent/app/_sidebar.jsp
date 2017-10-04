<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <!-- INICIO SIDEBAR IZQUIERDO -->
  <aside class="main-sidebar">
    <section class="sidebar">
      <!-- Sidebar user panel -->
      <div class="user-panel">
        <div class="pull-left image">
          <img src="../images/avatar.jpg" class="img-circle" alt="User Image">
        </div>
        <div class="pull-left info">
          <p>Alexander Pierce</p>
          <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
        </div>
      </div>
      <ul class="sidebar-menu" data-widget="tree">
        <li class="header">MENÚ OPCIONES</li>
        <li class="treeview">
          <a href="#">
            <i class="fa fa-dashboard"></i> <span>Dashboard</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="${pageContext.request.contextPath}/app/"><i class="fa fa-circle-o"></i> Escritorio</a></li>
          </ul>
        </li>
        <li class="treeview active">
          <a href="#">
            <i class="fa fa-edit"></i> <span>Modulo Registro</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="${pageContext.request.contextPath}/app/registrar_categoria.jsp"><i class="fa fa-circle-o"></i> Registrar Categoria</a></li>
            <li><a href="${pageContext.request.contextPath}/app/registrar_disciplina.jsp"><i class="fa fa-circle-o"></i> Registrar Disciplina</a></li>
            <li><a href="${pageContext.request.contextPath}/app/registrar_persona.jsp"><i class="fa fa-circle-o"></i> Registrar Persona</a></li>
            <li><a href="${pageContext.request.contextPath}/app/registrar_equipo.jsp"><i class="fa fa-circle-o"></i> Registrar Equipo</a></li>
            <li><a href=""><i class="fa fa-circle-o"></i> Registrar Evento</a></li>
          </ul>
        </li>
      </ul>
    </section>
  </aside>
 <!-- /.FIN DE SIDEBAR IZQUIERDO -->