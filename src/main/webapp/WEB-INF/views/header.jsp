<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <!DOCTYPE html>
        <html lang="en">

        <head>

            <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
            <meta name="description" content="">
            <meta name="author" content="">

            <title>Admin</title>

            <!-- Custom fonts for this template-->
            <link href="<c:url value='/resources/css/all.min.css'/>" rel="stylesheet" type="text/css">
            <link href="<c:url value='/resources/fontawesome-free-5.15.1-web/css/all.min.css'/>" rel="stylesheet" type="text/css">
            <!-- Custom styles for this template-->
            <link href="<c:url value='/resources/css/sb-admin-2.min.css'/>" rel="stylesheet" type="text/css">
            <script type="text/javascript" src="<c:url value='/resources/js/jquery.min.js' /> "></script>
            <script type="text/javascript" src="<c:url value='/resources/js/sweetalert2@10.js' />"></script>
            <script type="text/javascript" src="<c:url value='/resources/js/validate.min.js' />"></script>
            <script type="text/javascript" src="<c:url value='/resources/js/bootstrap.min.js' />"></script>
            <script type="text/javascript" src="<c:url value='/resources/js/bootstrap-datepicker.js' />"></script>
            <style type="text/css">
                .my-error-class {
                    color: red
                }
                
                ;
                .my-valid-class {
                    color: green
                }
            </style>
        </head>

        <body id="page-top">

            <!-- Page Wrapper -->
            <div id="wrapper">

                <!-- Sidebar -->
                <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

                    <!-- Sidebar - Brand -->
                    <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.html">
                        <div class="sidebar-brand-text mx-3 text-center">ADMIN</div>
                    </a>

                    <!-- Divider -->
                    <hr class="sidebar-divider my-0">

                    <!-- Nav Item - Dashboard -->
                    <li class="nav-item active">
                        <a class="nav-link" href="index.html"> <i class="fas fa-fw fa-tachometer-alt"></i> <span>BANG
						DIEU KHIEN</span></a>
                    </li>
                    <!-- Divider -->
                    <hr class="sidebar-divider">
                    <!-- Heading -->
                    <div class="sidebar-heading">Chuc nang</div>

                    <!-- Nav Item - Pages Collapse Menu -->
                    <li class="nav-item">
                        <a class="nav-link collapsed" href="${pageContext.request.contextPath}/xe/getAllXe"> <i class="fas fa-fw fa-cog"></i> <span>QUAN LY XE</span>
                        </a>
                    </li>
                    
                     <!-- Nav Item - Pages Collapse Menu -->
                    <li class="nav-item">
                        <a class="nav-link collapsed" href="${pageContext.request.contextPath}/lichtrinhxe/getAllLichTrinhXe"> <i class="fas fa-fw fa-cog"></i> <span>LICH TRINH XE</span>
                        </a>
                    </li>
                </ul>
                <!-- End of Sidebar -->

                <!-- Content Wrapper -->
                <div id="content-wrapper" class="d-flex flex-column">

                    <!-- Main Content -->
                    <div id="content">

                        <!-- Topbar -->
                        <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                            <!-- Sidebar Toggle (Topbar) -->
                            <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
						<i class="fa fa-bars"></i>
					</button>

                            <!-- Topbar Search -->
                            <form class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
                                <div class="input-group">
                                    <input type="text" class="form-control bg-light border-0 small" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2">
                                    <div class="input-group-append">
                                        <button class="btn btn-primary" type="button">
									<i class="fas fa-search fa-sm"></i>
								</button>
                                    </div>
                                </div>
                            </form>

                            <!-- Topbar Navbar -->
                            <ul class="navbar-nav ml-auto">

                                <!-- Nav Item - Search Dropdown (Visible Only XS) -->
                                <li class="nav-item dropdown no-arrow d-sm-none">
                                    <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="fas fa-search fa-fw"></i>
                                    </a>
                                    <!-- Dropdown - Messages -->
                                    <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in" aria-labelledby="searchDropdown">
                                        <form class="form-inline mr-auto w-100 navbar-search">
                                            <div class="input-group">
                                                <input type="text" class="form-control bg-light border-0 small" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2">
                                                <div class="input-group-append">
                                                    <button class="btn btn-primary" type="button">
												<i class="fas fa-search fa-sm"></i>
											</button>
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                </li>
                                <div class="topbar-divider d-none d-sm-block"></div>

                                <!-- Nav Item - User Information -->
                                <li class="nav-item dropdown no-arrow">
                                    <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <span class="mr-2 d-none d-lg-inline text-gray-600 small">Mr Cường</span> <img class="img-profile rounded-circle" src='<c:url value=' ${pageContext.request.contextPath}/resources/img/Avatar1.jpg ' />'>
                                    </a>
                                </li>
	
                            </ul>

                        </nav>
                        <!-- End of Topbar -->