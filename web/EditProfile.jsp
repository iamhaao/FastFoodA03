<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.*" %>
<%@include file="/includes/header.jsp" %>
<main>
    <link rel="stylesheet" href="./css/styleEditProfile.css"/>
    <div class="container-xl px-4 mt-20">  
        <c:set value="${requestScope.acc}" var="acc" />
        <hr class="mt-0 mb-4">
        <div class="row">
            <div class="col-xl-4  text-center justify-content-center ">
                <!-- Profile picture card-->
                <form action="uploadAvatar?id=${acc.username}" enctype='multipart/form-data' method="post">
                    <div class="card mb-4 mb-xl-0">
                        <div class="card-header">Profile Picture</div>
                        <div class="card-body text-center mx-auto">
                            <!-- Profile picture image-->
                            <img class="img-account-profile rounded-circle mx-auto mb-2" src="${acc.avatar}" alt="">
                            <!-- Profile picture help block-->
                            <div class="small font-italic text-muted mb-4">JPG or PNG no larger than 5 MB</div>
                            <c:if test="${acc.royal!=0}"><div class=" font-italic text-danger mb-4 "> <h2>Loyal customer : Level ${acc.royal}</h2>  </div> </c:if>
                            <!-- Profile picture upload button-->
                            <input type="file"  name="image" class="form-control">
                            <input type="submit"  class="btn btn-primary bg-primary px-4" value="Save">
                        </div>
                    </div>
                </form>
            </div>
            <div class="col-xl-8">
                <!-- Account details card-->
                <div class="card mb-4">
                    <div class="card-header">Account Details</div>
                    <div class="card-body">
                        <form action="profile" method="post">
                            <!-- Form Group (username)-->
                            <div class="mb-3">
                                <label class="small mb-1" for="inputUsername">Username</label>
                                <input class="form-control" id="inputUsername" type="text" name="user" readonly placeholder="Enter your username" value="${acc.username}">
                            </div>
                            <!-- Form Row-->
                            <div class="row gx-3 mb-3">
                                <!-- Form Group (first name)-->
                                <div class="col-md">
                                    <label class="small mb-1" for="inputFirstName">First name + Last Name</label>
                                    <input class="form-control" id="inputFirstName" type="text" placeholder="name" name="name" value="${acc.name}">
                                </div>
                                <!-- Form Group (last name)-->

                            </div>
                            <!-- Form Row        -->
                            <div class="row gx-3 mb-3">
                                <!-- Form Group (organization name)-->
                                <div class="col-md-8">
                                    <label class="small mb-1" for="inputOrgName">Password</label>
                                    <input class="form-control" id="inputOrgName" name="password" type="password"  placeholder="Enter your organization name" value="${acc.password}">
                                </div>
                                <div class="col-sm-2 col-md-4 mt-8 ">
                                    <button class="p-2 bg-gray-500 border rounded text-white" type="button" data-toggle="modal" data-target="#user-form-modal" id="btnChangePassword">Change password</button>                                    
                                </div>
                                
                                <!-- Form Group (location)-->
                                
                            </div>
                             <div class="row gx-3 mb-3">
                                <!-- Form Group (first name)-->
                                <div class="col-md">
                                    <label class="small mb-1" for="inputFirstName">Address</label>
                                    <input class="form-control" id="inputFirstName" type="text" placeholder="address" name="address" value="${acc.address}">
                                </div>
                                <!-- Form Group (last name)-->

                            </div>
                            <!-- Form Group (email address)-->
                            <div class="mb-3">
                                <label class="small mb-1" for="inputEmailAddress">Email address</label>
                                <input class="form-control" id="inputEmailAddress" name="email" type="email" placeholder="Enter your email address" value="${acc.email}">
                            </div>
                            <!-- Form Row-->
                            <div class="row gx-3 mb-3">
                                <!-- Form Group (phone number)-->
                                <div class="col-md-6">
                                    <label class="small mb-1" for="inputPhone">Phone number</label>
                                    <input class="form-control" id="inputPhone" name="phone" type="tel" placeholder="Enter your phone number" value="${acc.phone}">
                                </div>
                                <!-- Form Group (birthday)-->
                                <div class="col-md-6">
                                    <label class="small mb-1" for="inputBirthday">Birthday</label>
                                    <input class="form-control" id="inputBirthday" type="text" name="birthday" placeholder="Enter your birthday" value="06/10/1988">
                                </div>
                            </div>
                            <!-- Save changes button-->
                            <button class="btn btn-primary bg-primary" type="submit">Save changes</button>
                            <div class="text-danger mt-4">${requestScope.alert}</div>
                        </form>
                    </div>
                </div>

            </div>
        </div>
    </div>
</main>
<%@include file="/includes/footer.jsp" %>

<div class="modal fade" role="dialog" tabindex="-1" id="user-form-modal">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <form action="changePass?username=${acc.username}" method="post">      
                <div class="modal-body">
                    <div class="py-1">
                        <form action="" class="" novalidate="">
                            <div class="row">
                                <div class="col-12 col-sm-6 mb-3">
                                    <div>
                                        <input class="" hidden="hidden" name="username" value="${acc.username}">
                                    </div>
                                    <div class="mb-2"><b>Change Password</b></div>
                                    <div class="row">
                                        <div class="col">
                                            <div class="form-group">
                                                <label>Current Password</label>
                                                <input name="pass" class="form-control" type="password" placeholder="Current Password">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col">
                                            <div class="form-group">
                                                <label>New Password</label>
                                                <input name="newpass" class="form-control" type="password" placeholder="New Password">
                                            </div>
                                        </div>
                                        <div class="col">
                                            <div class="form-group">
                                                <label>Confirm <span class="d-none d-xl-inline">Password</span></label>
                                                <input name="confirm" class="form-control" type="password" placeholder="Confirm"></div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col d-flex justify-content-end">
                                        <button class="btn bg-primary text-white" type="submit">Save Changes</button>
                                    </div>
                                </div>

                            </div>
                    </div>
                </div>
            </form>

        </div>
    </div>
    <script type="text/javascript"><!-- comment -->
        $(document).ready(function(){
            $("#user-form-modal").on('shown.bs.modal', function () {
                    $('#user-form-modal').trigger('focus');
            });
            $('#btnChangePassword').on('click', function(e){
                e.preventDefault();
            });
        });
    </script>