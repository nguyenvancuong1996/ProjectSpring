<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="header.jsp" />

<div class="container">
	<form
		action="${pageContext.request.contextPath}/lichtrinhxe/addLichTrinhXe"
		method="POST">
		<div class="modal-body">
			<div class="form-group">
				<label>Ma Xe</label> <select class="form-control" name="maxe"
					id="maxe">
					<option selected disabled="disabled">XE</option>
					<c:forEach items="${listXeSelect}" var="xe">
						<option value='<c:out value="${ xe.maXe }"></c:out>'>${ xe.maXe }</option>
					</c:forEach>
				</select>

			</div>
			<div class="form-group">
				<label>Tai Xe</label> <input type="text" name="taixe"
					class="form-control" placeholder="Tai Xe">
			</div>
			<div class="form-group">
				<label>Ma Tuyen</label> <select class="form-control" name="matuyen"
					id="matuyen">
					<option selected disabled="disabled">TUYEN XE</option>
					<c:forEach items="${listTuyenXe}" var="tuyenxe">
						<option value='<c:out value="${ tuyenxe.maTuyen }"></c:out>'>${ tuyenxe.tenTuyen }</option>
					</c:forEach>
				</select>

			</div>
			<div class="form-group">
				<label>Ngay Xuat Ben</label> <input type="date" name="ngayxuatben"
					class="form-control">
			</div>
			<div class="form-group">
				<label>Gio Xuat Ben</label> <input type="time" name="gioxb"
					class="form-control">
			</div>
			<div class="form-group">
				<label>So Luong Hanh Khach</label> <input type="number"
					name="slhanhkhach" class="form-control">
			</div>
		</div>
		<div class="modal-footer">
			<button type="submit" class="btn btn-primary">Save</button>
		</div>
	</form>
</div>
<jsp:include page="footer.jsp" />