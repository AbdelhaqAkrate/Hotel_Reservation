<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../components/sideBar.jsp"/>
<%--------------------------------------Section--------------------------%>

<div class="overflow-auto h-screen pt-2 pr-2 pl-2 md:pt-0 md:pr-0 md:pl-0">
  <div class="flex flex-col flex-wrap sm:flex-row ">
    <div class="container w-full sm:px-8">
      <div class="py-8">
        <%--                                    <div class="-mx-4 sm:-mx-8 px-4 sm:px-8 py-4 overflow-x-auto">--%>
        <div class="inline-block min-w-full shadow rounded-lg overflow-hidden">
          <table class="min-w-full leading-normal">
            <thead>
            <tr>
              <th scope="col" class="px-5 py-3 bg-white  border-b border-gray-200 text-gray-800  text-left text-sm uppercase font-normal">
                Client
              </th>
              <th scope="col" class="px-5 py-3 bg-white  border-b border-gray-200 text-gray-800  text-left text-sm uppercase font-normal">
                Email
              </th>
              <th scope="col" class="px-5 py-3 bg-white  border-b border-gray-200 text-gray-800  text-left text-sm uppercase font-normal">
                Tel
              </th>
              <th scope="col" class="px-5 py-3 bg-white  border-b border-gray-200 text-gray-800  text-left text-sm uppercase font-normal">
                Adresse
              </th>
            </tr>
            </thead>
            <tbody>


        <c:forEach var="client" items="${listClients}">
            <tr>
              <td class="px-5 py-5 border-b border-gray-200 bg-white text-sm">
                <div class="flex items-center">

                  <div class="ml-3">
                    <p class="text-gray-900 whitespace-no-wrap">
                      ${client.nom}  ${client.prenom}
                    </p>
                  </div>
                </div>
              </td>
              <td class="px-5 py-5 border-b border-gray-200 bg-white text-sm">
                <p class="text-gray-900 whitespace-no-wrap">
                 ${client.email}
                </p>
              </td>
              <td class="px-5 py-5 border-b border-gray-200 bg-white text-sm">
                <p class="text-gray-900 whitespace-no-wrap">
                 ${client.tel}
                </p>
              </td>
              <td class="px-5 py-5 border-b border-gray-200 bg-white text-sm">
                <p class="text-gray-900 whitespace-no-wrap">
                  ${client.adresse}
                </p>
              </td>

            </tr>
        </c:forEach>

            </tbody>
          </table>


      </div>
    </div>





  </div>
</div>
 <%------------------------------------ End section -------------------------------%>
</div>
</div>

</main>

</body>
</html>