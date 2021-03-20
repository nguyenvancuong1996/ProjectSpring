<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
        <jsp:include page="header.jsp" />
        <div class="container">
            <form method="POST" action="<c:url value='/lichtrinhxe/editLTX'/>" id="form">
            <c:if test="${listNull != null }">
            	<div class="text-center text-danger"><c:out value="${ listLTX }"></c:out></div>
            </c:if>
             <c:if test="${listNull == null }">
             		<div class="form-group">
	                    <label>Xe</label>
	                     <select class="form-control" name="maxe">
						<c:forEach items="${listLTX}" var="listxeX">
								<option value='<c:out value="${ listxeX[0].multykeyLTX.maXe }"></c:out>' selected>${ listxeX[0].multykeyLTX.maXe }</option>
							<c:forEach items="${listXe}" var="listXe">
								<c:if test="${ listXe.maXe !=  listxeX[0].multykeyLTX.maXe}">
									<option value='<c:out value="${ listXe.maXe }"></c:out>'>${ listXe.maXe }</option>
								</c:if> 
							</c:forEach>
						</c:forEach>
						</select>
               		 </div>
               		 <div class="form-group">
	                    <label>Tuyen Xe</label>
	                     <select class="form-control" name="tuyenxe">
						<c:forEach items="${listLTX}" var="tuyenXeX">
								<option value='<c:out value="${ tuyenXeX[0].tuyenXe.maTuyen }"></c:out>' selected>${ tuyenXeX[0].tuyenXe.tenTuyen }</option>
							<c:forEach items="${tuyenXe}" var="tuyenXe">
								<c:if test="${ tuyenXe.maTuyen !=  tuyenXeX[0].tuyenXe.maTuyen }">
									<option value='<c:out value="${ tuyenXe.maTuyen }"></c:out>'>${ tuyenXe.tenTuyen }</option>
								</c:if> 
							</c:forEach>
						</c:forEach>
						</select>
               		 </div>
            	   <c:forEach items="${ listLTX }" var="lichtrinhxe">
			               <div class="form-group">
			                    <label>Ten Tai Xe</label>
			                    <input type="text" name="tentaixe"  class="form-control" aria-describedby="helpId" autocomplete="off" value="${ lichtrinhxe[0].tenTaiXe }">
			                </div>
			                
			                 <div class="form-group">
			                    <label>So Luong Hanh Khach</label>
			                    <input type="text" name="slHanhKhach"  class="form-control" aria-describedby="helpId" autocomplete="off" value="${ lichtrinhxe[0].soLuongHanhKhach }">
			                </div>
			                 <div class="form-group">
			                    <label>Ngay Xuat Ben</label>
			                    <input type="date" name="ngayxuatben" class="form-control" aria-describedby="helpId" autocomplete="off" value="${ lichtrinhxe[0].multykeyLTX.ngayXuatBen }">
			                </div>
			                
			                <div class="form-group">
			                    <label>Gio Xuat Ben</label>
			                    <input type="time" name="gioxuatben"  class="form-control" autocomplete="off" value="${ lichtrinhxe[0].multykeyLTX.gioXuatBen }">
			                </div>
              		</c:forEach>
	                </c:if>
                <button type="submit" class="btn btn-primary">Save</button>
            </form>
        </div>
        <script type="text/javascript">
	       
		</script>
        <jsp:include page="footer.jsp" />