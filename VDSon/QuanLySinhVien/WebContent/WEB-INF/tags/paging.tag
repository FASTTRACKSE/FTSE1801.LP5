<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags/" prefix="cs"%>

<%@ attribute name="trang" required="true" type="java.lang.Integer"%>
<%@ attribute name="soTrang" required="true" type="java.lang.Integer"%>

<c:if test="${trang != 1}">
	<c:if test="${trang > 2}">
		<a href='<cs:addParam name="page" value="1"/>'>start</a>
	</c:if>
	<a href='<cs:addParam name="page" value="${trang - 1}"/>'>&lt;</a>
</c:if>

<c:choose>
	<c:when test="${trang == 1 and sotrang == 1}">1</c:when>
	<c:when test="${trang < 3 and sotrang > 1}">
		<c:set var="end" value="${trang}" />
		<c:if test="${sotrang > 2}">
			<c:set var="end" value="3" />
		</c:if>
		<c:forEach var="item" begin="1" end="${end}">
			<c:choose>
				<c:when test="${trang == item}">${item}</c:when>
				<c:otherwise>
					<a href='<cs:addParam name="page" value="${item}"/>'>${item}</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</c:when>
	<c:when test="${currentPage == totalPage}">
		<a href='<cs:addParam name="page" value="${currentPage - 2}"/>'>${currentPage - 2}</a>
		<a href='<cs:addParam name="page" value="${currentPage - 1}"/>'>${currentPage - 1}</a>
		${currentPage}
	</c:when>
	<c:otherwise>
		<a href='<cs:addParam name="page" value="${currentPage - 1}"/>'>
			${currentPage - 1} </a>${currentPage}<a
			href='<cs:addParam name="page" value="${currentPage + 1}"/>'>${currentPage + 1}</a>
	</c:otherwise>
</c:choose>

<c:if test="${currentPage != totalPage}">
	<a href='<cs:addParam name="page" value="${currentPage + 1}"/>'>&gt;</a>
	<c:if test="${currentPage < (totalPage - 1)}">
		<a href='<cs:addParam name="page" value="${totalPage}"/>'>end</a>
	</c:if>
</c:if>