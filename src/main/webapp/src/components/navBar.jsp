<div class="absolute top-0 left-0 right-0 flex justify-between items-center text-white p-2">
    <jsp:include page="logo.jsp"/>
    <nav class="">
        <ul class="flex gap-20 text-sm font-medium">
            <li><a href="${pageContext.request.contextPath}/" class="mb-2 border-b-2">Home</a></li>
            <li><a href="${pageContext.request.contextPath}/rooms">Room &nbsp;&&nbsp; suites</a></li>
            <li><a href="${pageContext.request.contextPath}/events">Events</a></li>
            <li><a href="${pageContext.request.contextPath}/extras">Extras</a></li>
        </ul>
    </nav>
    <div class="mr-20">
        <button type="submit" class="bg-white text-[#4B476A] text-sm font-bold px-4 py-2 rounded-full"><a href="${pageContext.request.contextPath}/room">Reserve Now</a></button>
    </div>
</div>