<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
        <jsp:include page="header.jsp" />
        <div class="container">
            <form method="POST" action="<c:url value='/xe/editXe'/>" id="form">
            	   <c:forEach items="${ listXe }" var="xe">
				             <div class="form-group">
				                    <label>Ma Xe</label>
				                    <input type="text" name="maxe" id="maxe" class="form-control" placeholder="XeXXX" aria-describedby="helpId" autocomplete="off" value="${ xe[0].maXe }">
				              </div>
	              
			               <div class="form-group">
			                    <label>Hang San Xuat</label>
			                    <input type="text" name="hangsanxuat" id="hangsanxuat" class="form-control" aria-describedby="helpId" autocomplete="off" value="${ xe[0].hangSanXuat }">
			                </div>
			                
			                 <div class="form-group">
			                    <label>Bien So</label>
			                    <input type="text" name="bienso" id="bienso" class="form-control" aria-describedby="helpId" autocomplete="off" value="${ xe[0].bienSo }">
			                </div>
			                
			                <div class="form-group">
			                    <label>Hang Kiem Dinh</label>
			                    <input type="date" name="hangkiemdinh" id="hangkiemdinh" class="form-control" autocomplete="off" value="${ xe[0].hanKiemDinh }">
			                </div>
              		</c:forEach>
	                <div class="form-group">
	                    <label>Loai Xe</label>
	                    
	                        <select class="form-control" name="maloaixe" id="maloaixe">
								<c:forEach items="${listXe}" var="loaixeX">
									<option value='<c:out value="${ loaixeX[1].maLoaiXe }"></c:out>' selected>${ loaixeX[1].moTaLoaiXe }</option>
									<c:forEach items="${listLoaiXe}" var="loaixe">
										<c:if test="${ loaixe.maLoaiXe !=  loaixeX[1].maLoaiXe}">
											<option value='<c:out value="${ loaixe.maLoaiXe }"></c:out>'>${ loaixe.moTaLoaiXe }</option> 
										</c:if>
									</c:forEach>
								</c:forEach>
								
							</select>
	                </div>
                <div class="form-group">
                    <label>Nha Xe</label>
                     <select class="form-control" name="manhaxe" id="manhaxe">
					<c:forEach items="${listXe}" var="listxeX">
							<option value='<c:out value="${ listxeX[2].maNhaXe }"></c:out>' selected>${ listxeX[2].tenNhaXe }</option>
						<c:forEach items="${listNhaXe}" var="nhaxe">
							<c:if test="${ nhaxe.maNhaXe !=  listxeX[2].maNhaXe}">
								<option value='<c:out value="${ nhaxe.maNhaXe }"></c:out>'>${ nhaxe.tenNhaXe }</option>
							</c:if> 
						</c:forEach>
					</c:forEach>
				</select>
                </div>
                <button type="submit" class="btn btn-primary">Save</button>
            </form>
        </div>
        <script type="text/javascript">
	       
		</script>
        <jsp:include page="footer.jsp" />