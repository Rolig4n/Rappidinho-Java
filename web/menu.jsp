<%-- 
    Document   : menu
    Created on : 06/05/2021, 18:28:41
    Author     : hiago
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<aside class="left-sidebar" data-sidebarbg="skin6">
    <!-- Sidebar scroll-->
    <div class="scroll-sidebar">
        <!-- Big Sidebar navigation-->
        <nav class="sidebar-nav d-none d-xl-block">
            <ul id="sidebarnav">
                <!-- Cadastros-->
                <li class="sidebar-item pt-2">
                    <a class="sidebar-link waves-effect waves-dark sidebar-link" href="cadastros.jsp"
                       aria-expanded="false">
                        <i class="fas fa-database" aria-hidden="true"></i>
                        <span class="hide-menu">Cadastros</span>
                    </a>
                <!-- User Profile-->
                <li class="sidebar-item pt-2">
                    <a class="sidebar-link waves-effect waves-dark sidebar-link" href="dashboard.jsp"
                       aria-expanded="false">
                        <i class="fas fa-chart-pie" aria-hidden="true"></i>
                        <span class="hide-menu">Painel de controle</span>
                    </a>
                </li>
                <li class="sidebar-item">
                    <a class="sidebar-link waves-effect waves-dark sidebar-link" href="perfil.jsp"
                       aria-expanded="false">
                        <i class="fa fa-user" aria-hidden="true"></i>
                        <span class="hide-menu">Perfil</span>
                    </a>
                </li>
                <!-- Menu customizado / Depende Tipo Usuario-->
                <li class="sidebar-item">
                    <a class="sidebar-link waves-effect waves-dark sidebar-link" href="entrega.jsp"
                       aria-expanded="false">
                        <i class="fas fa-boxes" aria-hidden="true"></i>
                        <span class="hide-menu">Minhas estregas</span>
                    </a>
                </li>
                <li class="sidebar-item">
                    <a class="sidebar-link waves-effect waves-dark sidebar-link" href="#"
                       aria-expanded="false">
                        <i class="fas fa-chart-bar" aria-hidden="true"></i>
                        <span class="hide-menu">Relatorio entregas</span>
                    </a>
                </li>
                <!-- Fim Menu customizado -->
                <li class="sidebar-item">
                    <a class="sidebar-link waves-effect waves-dark sidebar-link" href="#"
                       aria-expanded="false">
                        <i class="fas fa-share-alt" aria-hidden="true"></i>
                        <span class="hide-menu">Compartilhar</span>
                    </a>
                </li>
                <li class="sidebar-item">
                    <a class="sidebar-link waves-effect waves-dark sidebar-link" href="#"
                       aria-expanded="false">
                        <i class="fa fa-exclamation" aria-hidden="true"></i>
                        <span class="hide-menu">Relatar ERRO</span>
                    </a>
                </li>
                <li class="sidebar-item">
                    <a class="sidebar-link waves-effect waves-dark sidebar-link" href="#"
                       aria-expanded="false">
                        <i class="fa fa-power-off" aria-hidden="true"></i>
                        <span class="hide-menu">Sair</span>
                    </a>
                </li>
                <li class="text-center p-20 upgrade-btn">
                    <a href="#"
                       class="btn d-grid btn-danger text-white" target="_blank">
                        Baixe agora <i class="fab fa-android" aria-hidden="true"></i></a>
                </li>
            </ul>
        </nav>
        <!-- End Big Sidebar navigation -->
        
        <!-- Sidebar navigation-->
        <nav class="sidebar-nav d-xl-none">
            <ul id="sidebarnav">
                <!-- User Profile-->
                <li class="sidebar-item">
                    <a class="sidebar-link" href="dashboard.jsp">
                        <i class="fas fa-chart-pie"></i>
                    </a>
                </li>
                <li class="sidebar-item">
                    <a class="sidebar-link waves-effect waves-dark sidebar-link" href="perfil.jsp"
                       aria-expanded="false">
                        <i class="fa fa-user" aria-hidden="true"></i>
                    </a>
                </li>
                <!-- Menu customizado / Depende Tipo Usuario-->
                <li class="sidebar-item">
                    <a class="sidebar-link waves-effect waves-dark sidebar-link" href="#"
                       aria-expanded="false">
                        <i class="fas fa-boxes" aria-hidden="true"></i>
                    </a>
                </li>
                <li class="sidebar-item">
                    <a class="sidebar-link waves-effect waves-dark sidebar-link" href="#"
                       aria-expanded="false">
                        <i class="fas fa-chart-bar" aria-hidden="true"></i>
                    </a>
                </li>
                <!-- Fim Menu customizado -->
                <li class="sidebar-item">
                    <a class="sidebar-link waves-effect waves-dark sidebar-link" href="profile.html"
                       aria-expanded="false">
                        <i class="fas fa-share-alt" aria-hidden="true"></i>
                    </a>
                </li>
                <li class="sidebar-item">
                    <a class="sidebar-link waves-effect waves-dark sidebar-link" href="profile.html"
                       aria-expanded="false">
                        <i class="fa fa-exclamation" aria-hidden="true"></i>
                    </a>
                </li>
                <li class="sidebar-item">
                    <a class="sidebar-link waves-effect waves-dark sidebar-link" href="#"
                       aria-expanded="false">
                        <i class="fa fa-power-off" aria-hidden="true"></i>
                    </a>
                </li>
                <li class="sidebar-item">
                    <a class="sidebar-link waves-effect waves-dark sidebar-link" href="#" target="_blank">
                        <i class="fab fa-android" aria-hidden="true"></i>
                    </a>
                </li>
            </ul>
        </nav>
        <!-- End Sidebar navigation -->
    </div>
    <!-- End Sidebar scroll-->
</aside>
