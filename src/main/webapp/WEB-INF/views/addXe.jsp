<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <jsp:include page="header.jsp" />

        <div class="container">
            <form method="POST" action="<c:url value='/xe/addXe'/>" id="form">
                <div class="form-group">
                    <label>Ma Xe</label>
                    <input type="text" name="maxe" id="maxe" class="form-control" placeholder="XeXXX" aria-describedby="helpId" autocomplete="off">
                    <small id="checkmaxe" class="text-danger"></small>
                </div>
                <div class="form-group">
                    <label>Hang San Xuat</label>
                    <input type="text" name="hangsanxuat" id="hangsanxuat" class="form-control" aria-describedby="helpId" autocomplete="off">
                    <small id="checkhsx" class="text-danger"></small>
                </div>
                <div class="form-group">
                    <label>Loai Xe</label>
                    <c:if test="${listNull != null}">
                        <input class="form-control" type="text" readonly="readonly" value='<c:out value="${listNull}"></c:out>'>
                    </c:if>
                    <c:if test="${listNull == null}">
                        <select class="form-control" name="maloaixe" id="maloaixe">
							<option selected disabled="disabled">LOAI XE</option>
							<c:forEach items="${listLoaiXe}" var="loaixe">
								<option value='<c:out value="${ loaixe.maLoaiXe }"></c:out>'>${ loaixe.moTaLoaiXe }</option>
							</c:forEach>
						</select>
                    </c:if>
                </div>
                <div class="form-group">
                    <label>Bien So</label>
                    <input type="text" name="bienso" id="bienso" class="form-control" aria-describedby="helpId" autocomplete="off">
                    <small id="checkbienso" class="text-danger"></small>
                </div>
                <div class="form-group">
                    <label>Hang Kiem Dinh</label>
                    <input type="date" name="hangkiemdinh" id="hangkiemdinh" class="form-control" autocomplete="off">
                    <small id="checkhkd" class="text-danger"></small>
                </div>
                <div class="form-group">
                    <label>Nha Xe</label>
                    <c:if test="${listNull != null}">
                        <input class="form-control" type="text" readonly="readonly" value='<c:out value="${listNull}"></c:out>'>
                    </c:if>
                    <c:if test="${listNull == null}">
                        <select class="form-control" name="manhaxe" id="manhaxe">
					<option selected disabled="disabled">NHA XE</option>
					<c:forEach items="${listNhaXe}" var="nhaxe">
						<option value='<c:out value="${ nhaxe.maNhaXe }"></c:out>'>${ nhaxe.tenNhaXe }</option>
					</c:forEach>
				</select>
                    </c:if>
                </div>
                <button type="submit" class="btn btn-primary">Save</button>
            </form>
        </div>
        <c:if test="${errorDate != null}">
			<script>
				Swal.fire('Thông Báo', 'Han kiem dinh phai lon hon thoi gian hien tai la 1 thang !!!', 'error')
			</script>
		</c:if>
        <script type="text/javascript">
            $(document).ready(function() {
                $("#bienso").change(function() {
                    if (checkBienSo() == false) {
                        $("#checkbienso").html("Bien so sai dinh dang !!!");
                        $(':input[type="submit"]').prop('disabled', true);
                    } else {
                        $("#checkbienso").html("");
                        $(':input[type="submit"]').prop('disabled', false);
                    }
                });

             /*    $("#hangkiemdinh").change(function() {
                    checkDate();
                }); */

                function checkBienSo() {
                    var value = $("#bienso").val();
                    var regex = /^([0-9]{2}[a-zA-Z]{1}[0-9]{1})\-([0-9]{5})$/;
                    var check = regex.test(value);
                    return check;
                }

                function checkDate() {
                    var dateNow = new Date();
                    dateNow = dateNow.setMonth(dateNow.getMonth() + 1);
                    var dateInput = new Date($("#hangkiemdinh").val());
                    if (dateInput >= dateNow) {
                    	$("#checkhkd").html("");
                        $(':input[type="submit"]').prop('disabled', false);
                    } else {
                    	$("#checkhkd").html("Han kiem dinh khong dung, han kiem dinh phai lon hon thoi gian hien tai la 1 thang, xin hay nhap lai thong tin han kiem dinh !!!");
                        $(':input[type="submit"]').prop('disabled', true);
                    }
                }
            });
        </script>
        <jsp:include page="footer.jsp" />