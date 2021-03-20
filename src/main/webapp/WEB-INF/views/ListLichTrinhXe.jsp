<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="header.jsp" />
<div class="container">
	<div class="row">
		<div class="col-6 text-left">
			<a type="button" class="btn btn-primary" href="${pageContext.request.contextPath}/lichtrinhxe/getAddLichTrinhXe">
  			THEM LICH TRINH XE
			</a>
		</div>
		<div class="col-6 text-left">
			<form action="${pageContext.request.contextPath}/xe/searchXe"
				method="GET">
				<div class="input-group rounded">
					<input type="text" name="search" class="form-control rounded"
						placeholder="Search" autocomplete="off" aria-label="Search"
						aria-describedby="search-addon" />
				</div>
			</form>
		</div>
	</div>
	<hr>
	<table id="dsMay"
		class="table table-striped table-bordered dt-responsive nowrap cell-border">
		<thead>
			<tr>
				<th class="text-center">Ma Xe</th>
				<th class="text-center">Hãng SX</th>
				<th class="text-center">Ten Tai Xe</th>
				<th class="text-center">Ma Tuyen</th>
				<th class="text-center">Ngay Xuat Ben</th>
				<th class="text-center">Gio Xuat Ben</th>
				<th class="text-center">Thành Tiền</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
		<c:if test="${ listNull != null}">
			<tr>
				<td class="text-danger text-center" colspan="7">
					<c:out value="${ listNull }"></c:out>
				</td>
			</tr>
		</c:if>
		<c:if test="${ listNull == null}">
				<c:forEach items="${listLichTrinhXe}" var="items">
					<tr>
						<td class="text-center">${items[0].multykeyLTX.maXe}</td>
						<td class="text-center">${items[0].xe.hangSanXuat}</td>
						<td class="text-center">${items[0].tenTaiXe}</td>
						<td class="text-center">${items[0].tuyenXe.maTuyen}</td>
						<td class="text-center">${items[0].multykeyLTX.ngayXuatBen}</td>
						<td class="text-center">${items[0].multykeyLTX.gioXuatBen}</td>
						<td class="text-center">
							<fmt:parseNumber var="parsedNumberOne"  type="number" value="${items[0].tuyenXe.donGia}" />
							<fmt:parseNumber var="parsedNumberTow"  type="number" value="${items[0].soLuongHanhKhach}" />
							<c:set var="result" value="${parsedNumberOne * parsedNumberTow}"/>
							<c:out value="${result}" />
						</td>
						<td class="text-center"><a
							href="<c:url value='/lichtrinhxe/editlichtrinhxe?maXe=${items[0].multykeyLTX.maXe}'/>"
							class="btn btn-warning btn-xs pr-1"><i class="fas fa-edit"></i></a>
							<button id="delete" data-href="${pageContext.request.contextPath}/lichtrinhxe/delete?maXe=${items[0].multykeyLTX.maXe}"
								class="btn btn-danger btn-xs" data-toggle="modal" data-target="#confirm-delete">
								<i class="far fa-trash-alt"></i>
							</button>
							</td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>
	<!--Modal  -->
	<div class="modal fade" id="confirm-delete" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5><i class="fas fa-info-circle text-primary"></i> Xoá Thông Tin Lịch Trình Xe</h5>
            </div>
            <div class="modal-body">
                <span>Bạn sẽ mất dữ liệu của Lịch Trình Xe !!!</span>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                <a class="btn btn-danger btn-ok">Delete</a>
            </div>
        </div>
    </div>
</div>
	<!--  -->
</div>
<!-- Notify  -->
<c:if test="${addSuccess != null}">
		<script>
			Swal.fire('Thông Báo', 'Thêm Thành Công', 'success')
		</script>
</c:if>
<c:if test="${editOk != null}">
		<script>
			Swal.fire('Thông Báo', 'Cập Nhật Thành Công', 'success')
		</script>
</c:if>
<script type="text/javascript">
	 $(document).ready(function() {
		 $('#confirm-delete').on('show.bs.modal', function(e) {
			    $(this).find('.btn-ok').attr('href', $(e.relatedTarget).data('href'));
		 });
	 });
</script>
<jsp:include page="footer.jsp" />
