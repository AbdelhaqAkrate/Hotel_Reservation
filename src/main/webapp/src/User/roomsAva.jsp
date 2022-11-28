<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../components/header.jsp"/>
    <jsp:include page="../components/navBarBg.jsp"/>
    <div class="m-8 p-2">
        <div class="mt-5 ml-10 text-xl font-semibold">${type.getName()}</div>
        <div class="flex flex-wrap">
            <!-- Start Card -->
           <c:if test="${roomType.size() == 0}">
               <div class="flex justify-center items-center w-full h-64">
                   <div class="text-2xl font-semibold">No Rooms Available</div>
               </div>
              </c:if>
            <c:if test="${roomType.size() != 0}">
    
            <c:forEach var="room" items="${roomType}" >
            <div class="flex flex-col w-1/4 bg-[#1E1E1E] rounded-3xl m-10 mt-16">
                <div class="w-100"><img src="http://localhost/assets/imgs/r1.png" class="w-100 rounded-t-3xl" height="120"></div>
                <div class="text-white font-semibold self-center p-4">${room.getNum()}</div>
                <div class="text-white text-xs self-center p-1">${room.getDescription()}</div>
                <div class="flex justify-between p-2">
                    <div class="text-gray-200 text-xs ml-3 p-4">$ ${room.getTarif()} / Day</div>
                    <div class="flex gap-2 mr-3 p-1">
                        <button type="submit" class="bg-green-600 text-white text-xs font-semibold px-4 py-1 rounded-full">Book now</button>
                        <a href="${pageContext.request.contextPath}/room?number=${room.getNum()}"  type="submit" class="bg-[#4B476A] text-white text-xs font-semibold px-3 py-1 rounded-full">View details</a>
                    </div>
                </div>
            </div>
            </c:forEach>
            </c:if>
            <!-- End Card -->

            <!-- Start Card -->
            
            <!-- End Card -->

            <!-- Start Modal -->



            <!-- End Modal -->
        </div>
    </div>

<div class="mt-40">
    <jsp:include page="../components/footer.jsp"/>
</div>
