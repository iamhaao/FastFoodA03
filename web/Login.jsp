<%-- 
    Document   : Login
    Created on : May 16, 2023, 11:04:23 AM
    Author     : ACER NITRO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="./includes/header.jsp" %>
<body>
<c:set var="c" value="${pageContext.request.cookies}"></c:set>
  <section class="h-screen">
    <div class="px-2 h-full text-gray-800">
      <div
        class="flex xl:justify-center lg:justify-between justify-center items-center flex-wrap h-full g-6"
      >
        <div
          class="grow-0 shrink-1 md:shrink-0 basis-auto xl:w-2/4 lg:w-6/12 md:w-9/12 mb-12 md:mb-0"
        >
          <img
            src="./images/1.jpg"
            class="w-full h-full"
            alt="Sample image"
          />
        </div>

        <div id="form" class="block bg-slate-50 p-6 rounded-xl  shodow-md shadow-slate-300 w-90   xl:ml-20 xl:w-2/6 lg:w-5/12 md:w-8/12 mb-12 md:mb-0">
            <form action="login" method="post">
            <div class="flex flex-row items-center justify-center lg:justify-start ml-12 px-28 ">
              <p class="text-5xl font-semibold pr-10 pb-3">Login</p>
  
              
            </div>
  
            <div
              class="flex items-center my-4 before:flex-1 before:border-t before:border-black before:mt-0.5 after:flex-1 after:border-t after:border-black after:mt-0.5"
            >
              
            </div>
  
            <!-- Email input -->
            <div class="mb-6">
              <input
                type="text"
                class="form-control block w-full px-4 py-2 text-xl font-normal text-gray-700 bg-white bg-clip-padding border border-solid border-gray-300 rounded transition ease-in-out m-0 focus:text-gray-700 focus:bg-white focus:border-gray-600 focus:outline-none"
                id="exampleFormControlInput2"
                placeholder="User name"
                name="user"
                value="${cookie.cuser.value}"
              />
            </div>
  
            <!-- Password input -->
            <div class="mb-6">
              <input
                type="password"
                class="form-control block w-full px-4 py-2 text-xl font-normal text-gray-700 bg-white bg-clip-padding border border-solid border-gray-300 rounded transition ease-in-out m-0 focus:text-gray-700 focus:bg-white focus:border-gray-600 focus:outline-none"
                id="exampleFormControlInput2"
                placeholder="Password" name="pass"
                value="${cookie.cpass.value}"
              />
            </div>
  
            <div class="flex justify-between items-center mb-6">
              <div class="form-group form-check">
                <input
                  type="checkbox"
                  class="form-check-input appearance-none h-4 w-4 border border-gray-300 rounded-sm bg-white checked:bg-gray-700 focus:outline-none transition duration-200 mt-1 align-top bg-no-repeat bg-center bg-contain float-left mr-2 cursor-pointer"
                  id="exampleCheck2"
                  ${(cookie.crem != null ? "checked" : "")} name="rem" value="ON"
                />
                <label class="form-check-label inline-block text-gray-800" for="exampleCheck2"
                  >Remember me</label
                >
              </div>
               <button type="button" class="" data-toggle="modal" data-target="#verify">
                    Forgot password?
                </button>
            </div>
                  <h1>${requestScope.alert}</h1>
                    <h1 class="text-danger" >${requestScope.mess}</h1>
            <div class="text-center lg:text-left">
              <button
                class="inline-block px-7 py-3 bg-black text-white font-medium text-sm leading-snug uppercase rounded shadow-md hover:bg-gray-800 hover:shadow-lg focus:bg-black focus:shadow-lg focus:outline-none focus:ring-0 active:bg-blue-800 active:shadow-lg transition duration-150 ease-in-out"
              >
                Login
              </button>
                <div class="divider d-flex align-items-center my-4">
            <p class="text-center fw-bold mx-3 mb-0 text-muted" style="display: inline-block; padding-left:  180px">OR</p>
          </div>
           <a  class="btn btn-primary btn-lg btn-block" style="background-color: #b21f2d" href="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:8080/SWP391/LoginGoogleHandler&response_type=code&client_id=876393109162-qq2f685854i38o0mjnmb8690kgd0c202.apps.googleusercontent.com&approval_prompt=force"
            role="button">
            <i class="fab fa-google me-2"></i>Login with Google
           </a>
              <p class="text-sm font-semibold mt-2 pt-1 mb-0">
                Don't have an account?
                <a
                  href="SignUp.jsp"
                  class="text-red-600 hover:text-red-700 focus:text-red-700 transition duration-200 ease-in-out"
                  >Register</a
                >
              </p>
            </div>
          </form>
           
              
        </div>
      </div>
    </div>
  </section>
   <form action="UserVerify" method="post">    
        <div class="modal fade" id="verify"  style="font-family: serif; " tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content " style="box-shadow: 0 3px 8px #d5979d; border: 0.5px solid #ce7b83;">
                    <div class="modal-header" style="background-color: #b21f2d">
                        <h5 class="modal-title text-white " id="verify" style="font-size: 24px; ">User email verification:</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <label for="Username">Username:</label>
                        <input name="username" type="text"  class="form-control mb-6" id="Username" placeholder="Enter username">
                        
                        <label for="emailInput">Your gmail:</label>
                        <input name="useremail" type="email" class="form-control" id="emailInput" placeholder="Enter your email">
                    </div>
                    <div class="modal-footer">
                        <button type="submit" class="btn btn-primary text-gray-800">Send</button>
                    </div>
                </div>
            </div>

    </form>
</body>
<%@include file="./includes/footer.jsp" %>