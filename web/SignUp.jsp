<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.*" %>
<%@include file="/includes/header.jsp" %>
<body>
    <form action="signup" method="get">
        <div class="flex items-center min-h-screen bg-gray-50">
            <div class="flex-1 h-full max-w-4xl mx-auto bg-white rounded-lg shadow-xl">
                <div class="flex flex-col md:flex-row">
                    <div class="h-32 md:h-auto md:w-1/2 w-full opacity-90" style="width: 100%;">
                        <img class="object-cover w-full h-full" src="./images/signup.png"
                             alt="img" />
                    </div>

                    <div class="flex items-center justify-center p-6 sm:p-12 md:w-1/2">
                        <div class="w-full">
                            <div class="flex justify-center">

                                <path d="M12 14l9-5-9-5-9 5 9 5z" />
                                <path
                                    d="M12 14l6.16-3.422a12.083 12.083 0 01.665 6.479A11.952 11.952 0 0012 20.055a11.952 11.952 0 00-6.824-2.998 12.078 12.078 0 01.665-6.479L12 14z" />
                                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                                      d="M12 14l9-5-9-5-9 5 9 5zm0 0l6.16-3.422a12.083 12.083 0 01.665 6.479A11.952 11.952 0 0012 20.055a11.952 11.952 0 00-6.824-2.998 12.078 12.078 0 01.665-6.479L12 14zm-4 6v-7.5l4-2.222" />
                                </svg>
                            </div>
                            <h1 class="mb-4 text-2xl font-bold text-center text-gray-700">
                                Sign up
                            </h1>

                            <!--name-->
                            <div>
                                <label class="block text-sm">
                                    Name
                                </label>
                                <input type="text"
                                       class="w-full px-4 py-2 text-sm border rounded-md focus:border-gray-400 focus:outline-none focus:ring-1 focus:ring-gray-600"
                                       placeholder="Your name"
                                       name="name"/>
                            </div>

                            <!--username-->
                            <div class="mt-4">
                                <label class="block text-sm">
                                    Username
                                </label>
                                <input type="username"
                                       class="w-full px-4 py-2 text-sm border rounded-md focus:border-gray-400 focus:outline-none focus:ring-1 focus:ring-gray-600"
                                       placeholder="Username" name="username"/>
                            </div>

                            <div class="mt-4">
                                <label class="block text-sm">
                                    Date of birth
                                </label>
                                <input type="date"  
                                       class="w-full px-4 py-2 text-sm border rounded-md focus:border-gray-400 focus:outline-none focus:ring-1 focus:ring-gray-600"
                                       placeholder="dd-mm-yyyy" value="" name="birthday"
                                       min="1997-01-01" max="2030-12-31">
                            </div>

                            <!--email-->
                            <div class="mt-4">
                                <label class="block text-sm">
                                    Email
                                </label>
                                <input type="email"
                                       class="w-full px-4 py-2 text-sm border rounded-md focus:border-gray-400 focus:outline-none focus:ring-1 focus:ring-gray-600"
                                       placeholder="yourmail@provider.com" name="email"/>
                            </div>
                            <label class="block mt-4 text-sm">
                                Address
                            </label>
                            <div>

                                <input
                                    class="w-full px-4 py-2 text-sm border rounded-md focus:border-gray-400 focus:outline-none focus:ring-1 focus:ring-gray-600"
                                    placeholder="Your address" type="text" name="address"/>
                            </div>
                            <!--phone number-->
                            <div>
                                <label class="block mt-4 text-sm">
                                    Phone number
                                </label>
                                <input
                                    class="w-full px-4 py-2 text-sm border rounded-md focus:border-gray-400 focus:outline-none focus:ring-1 focus:ring-gray-600"
                                    placeholder="0912xxxxxx" type="phone" name="phone"/>
                            </div>
<!--
                            <div>
                                <label class="block mt-4 text-sm">
                                    Role
                                </label>
                                <select class="w-full px-4 py-2 mt-2 text-sm border rounded-md focus:border-gray-400 focus:outline-none focus:ring-1 focus:ring-gray-600" name="role" id="id">
                                    <option value="2">User</option>
                                    <option value="3">Shipper</option>

                                </select>

                            </div>-->

                            <!--password-->
                            <div>
                                <label class="block mt-4 text-sm">
                                    Password
                                </label>
                                <input
                                    class="w-full px-4 py-2 text-sm border rounded-md focus:border-gray-400 focus:outline-none focus:ring-1 focus:ring-gray-600"
                                    placeholder="Password" type="password" name="password" />
                            </div>
                            <div class="mt-4 text-danger ">
                                <p class="text-sm">${requestScope.alert} </p>
                            </div>
                            <button
                                class="block w-full px-4 py-2 mt-4 text-sm font-medium leading-5 text-center text-white transition-colors duration-150 bg-black border border-transparent rounded-lg active:bg-black hover:bg-gray-800 focus:outline-none focus:shadow-outline-blue"
                                >
                                Sign up
                            </button>

                            <div class="mt-4 text-center">
                                <p class="text-sm">Already have an account? <a href="Login.jsp"
                                                                               class="text-red-700 hover:underline">Login</a></p>
                            </div>
                        </div>

                    </div>

                </div>
            </div>
        </div>
    </form>
</body>
<%@include file="/includes/footer.jsp" %>
