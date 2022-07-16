<!DOCTYPE html>
<html lang="en">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<head>
    <title>Sign Up</title>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="css/util.css">
    <link rel="stylesheet" type="text/css" href="css/login.css">
    <!--===============================================================================================-->
</head>
<body style="background-color: #666666">
<div class="limiter">
    <div class="container-login100">
        <div class="wrap-login100">
            <form action="signup" method="post" class="login100-form validate-form">
                <span class="login100-form-title p-b-43"> Sign Up </span>
                <div
                        class="wrap-input100 validate-input"
                        data-validate="User name is required"
                >
                    <input
                            class="input100"
                            type="text"
                            name="userName"
                            placeholder="User name"
                    />
                    <span class="focus-input100"></span>
                </div>

                <div
                        class="wrap-input100 validate-input"
                        data-validate="Phone number is required"
                >
                    <input
                            class="input100"
                            type="number"
                            name="phoneNumber"
                            placeholder="Phone Number"
                    />
                    <span class="focus-input100"></span>
                </div>

                <div
                        class="wrap-input100 validate-input"
                        data-validate="Password is required"
                >
                    <input
                            class="input100"
                            type="password"
                            name="pass"
                            placeholder="Password"
                            value=""
                    />
                    <span class="focus-input100"></span>
                </div>

                <c:choose>
                    <c:when test="${isPhoneNumberExist == 1}">
                        <div class="alert-error">
                            <p class="alert__content">This phone number is already register!</p>
                        </div>
                    </c:when>
                </c:choose>

                <div class="container-login100-form-btn">
                    <button class="login100-form-btn">Sign Up</button>
                </div>

                <div class="text-center p-t-46 p-b-20">
                    <a href="signin" class="txt1"> Already have an account ? </a>
                </div>


            </form>

            <div
                    class="login100-more"
                    style="background-image: url('images/signup-bg.jpg')"
            ></div>
        </div>
    </div>
</div>
<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
<script>
    /*Validate*/
    var input = $('.validate-input .input100');

    $('.validate-form').on('submit', function () {
        var check = true;

        for (var i = 0; i < input.length; i++) {
            if (validate(input[i]) == false) {
                showValidate(input[i]);
                check = false;
            }
        }

        return check;
    });


    $('.validate-form .input100').each(function () {
        $(this).focus(function () {
            hideValidate(this);
        });
    });

    function validate(input) {
        if ($(input).val().trim() == '') {
            return false;
        }
    }

    function showValidate(input) {
        var thisAlert = $(input).parent();

        $(thisAlert).addClass('alert-validate');
    }

    function hideValidate(input) {
        var thisAlert = $(input).parent();

        $(thisAlert).removeClass('alert-validate');
    }
</script>
</body>
</html>
