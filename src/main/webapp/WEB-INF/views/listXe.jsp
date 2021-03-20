<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="header.jsp" />
<div class="container">
	<div class="row">
		<div class="col-6 text-left">
			<a href="${pageContext.request.contextPath}/xe/addXe"
				class="btn btn-success">Them Xe</a>
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
				<th class="text-center">Hang San Xuat</th>
				<th class="text-center">Ma Loai Xe</th>
				<th class="text-center">Bien So</th>
				<th class="text-center">Han Kiem Dinh</th>
				<th class="text-center">Ma Nha Xe</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${listNull != null}">
				<tr>
					<td class="text-danger text-center" colspan="7"><c:out
							value="${listNull}" /></td>
				</tr>
			</c:if>
			<c:if test="${dataNull != null }">
				<td class="text-danger text-center" colspan="7"><c:out
							value="${dataNull}" /></td>
			</c:if>
			<c:if test="${listNull == null && dataNull == null}">
				<c:forEach items="${listXe}" var="xe">
					<tr>
						<td class="text-center">${xe.maXe}</td>
						<td class="text-center">${xe.hangSanXuat}</td>
						<td class="text-center">${xe.loaiXe.maLoaiXe}</td>
						<td class="text-center"><c:out value="${xe.bienSo}" /></td>
						<td class="text-center"><c:out value="${xe.hanKiemDinh}" /></td>
						<td class="text-center">${xe.nhaXe.maNhaXe}</td>
						<td class="text-center"><a
							href="<c:url value='/xe/editXe?maXe=${xe.maXe}'/>"
							class="btn btn-warning btn-xs pr-1"><i class="fas fa-edit"></i></a>
							<button id="delete" data-href="${pageContext.request.contextPath}/xe/delete?maXe=${xe.maXe}"
								class="btn btn-danger btn-xs" data-toggle="modal" data-target="#confirm-delete">
								<i class="far fa-trash-alt"></i>
							</button>
							</td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>
	<div class="modal fade" id="confirm-delete" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5><i class="fas fa-info-circle text-primary"></i> Xoá Thông Tin Xe</h5>
            </div>
            <div class="modal-body">
                <span>Bạn sẽ mất dữ liệu của Xe !!!</span>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                <a class="btn btn-danger btn-ok">Delete</a>
            </div>
        </div>
    </div>
</div>
	<c:if test="${message != null}">
		<script>
			Swal.fire('Thông Báo', 'Thêm Thành Công', 'success')
		</script>
	</c:if>
	<c:if test="${messageEdit != null}">
		<script>
			Swal.fire('Thông Báo', 'Cập Nhật Thành Công', 'success')
		</script>
	</c:if>
	<c:if test="${messageDelete != null}">
		<script>
			Swal.fire('Thông Báo', 'Xoá Thành Công', 'success')
		</script>
	</c:if>
	<script type="text/javascript">
	 $(document).ready(function() {
		 $('#confirm-delete').on('show.bs.modal', function(e) {
			    $(this).find('.btn-ok').attr('href', $(e.relatedTarget).data('href'));
		 });
	 });
	</script>
</div>
<jsp:include page="footer.jsp" />
