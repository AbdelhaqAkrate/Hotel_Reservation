
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>

</head>
<body>
<!-- Container -->
<div class="flex flex-wrap min-h-screen w-full content-center justify-center bg-white py-5">

    <!-- Login component -->
    <div class="flex shadow-lg">
        <!-- Login form -->
        <div class="flex flex-wrap content-center justify-center rounded-l-md bg-white w-full" style="width: 35rem; height: 35rem;">
            <div class="w-50">
                <img class="w-16 mb-8 mr-2" src="http://localhost/assets/imgs/managerLogo.png">
                <!-- Heading -->
                <h1 class="text-2xl font-semibold">Welcome back</h1>
                <small class="text-gray-400">Login with your data that you entered
                    during your registration</small>

                <!-- Form -->
                <form class="mt-4" method="post" action="${pageContext.request.contextPath}/admin">
                    <div class="mb-4 mt-10">
                        <label class="mb-3 block text-l font-semibold">Enter your email address </label>
                        <input type="email" placeholder="name@exemple.com" name="username" class="block h-10 w-full text-xs rounded-md border border-gray-300 focus:border-[#4B476A] focus:outline-none focus:ring-1 focus:ring-purple-700 p-4 text-gray-500" />
                    </div>

                    <div class="mb-4">
                        <label class="mb-3 block text-l font-semibold">Password</label>
                        <input type="password" name="password" placeholder="*****" class="block w-full h-10 text-xs rounded-md border border-gray-300 focus:border-[#4B476A] focus:outline-none focus:ring-1 focus:ring-purple-700 p-4 text-gray-500" />
                    </div>

                    <div class="mb-3">
                        <button class="mb-1.5 block text-center text-white bg-[#4B476A] hover:bg-purple-900 px-5 py-2 rounded-3xl"><a href="dashboard" class="">Login</a></button>
                    </div>
                </form>


            </div>
        </div>

        <!-- Login banner -->
        <div class="flex flex-wrap content-center justify-center rounded-r-md" style="width: 35rem; height: 35rem;">
            <img class="w-full h-full bg-center bg-no-repeat bg-cover rounded-r-md" src="http://localhost/assets/imgs/img2.png">
        </div>

    </div>


</div>
</body>
</html>
