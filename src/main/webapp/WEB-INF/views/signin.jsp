<!DOCTYPE html>
<html lang="en">
<head>
    <title>Login</title>
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
            <form class="login100-form validate-form">
                <span class="login100-form-title p-b-43"> Login to continue </span>

                <div
                        class="wrap-input100 validate-input"
                        data-validate="Phone number is required"
                >
                    <input
                            class="input100"
                            type="number"
                            name="phone"
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
                    />
                    <span class="focus-input100"></span>
                </div>

                <div class="flex-sb-m w-full p-t-3 p-b-32">
                    <div class="contact100-form-checkbox">
                        <input
                                class="input-checkbox100"
                                id="ckb1"
                                type="checkbox"
                                name="remember-me"
                        />
                        <label class="label-checkbox100" for="ckb1">
                            Remember me
                        </label>
                    </div>

                    <div>
                        <a href="#" class="txt1"> Forgot Password? </a>
                    </div>
                </div>

                <div class="container-login100-form-btn">
                    <button class="login100-form-btn">Login</button>
                </div>

                <div class="text-center p-t-46 p-b-20">
                    <span class="txt2"> Or sign in with  </span>
                </div>

                <div class="login100-form-social flex-c-m">
                    <a href="#" class="login100-form-social-item flex-c-m bg1 m-r-5">
                        <i class="fa fa-facebook-f" aria-hidden="true"></i>
                    </a>

                    <a href="#" class="login100-form-social-item flex-c-m bg2 m-r-5">
                        <i class="fa fa-twitter" aria-hidden="true"></i>
                    </a>
                </div>

                <div class="text-center p-t-46 p-b-20">
                    <a href="signup" class="txt1"> Don't have an account ?  </a>
                </div>


            </form>

            <div
                    class="login100-more"
                    style="background-image: url('images/login-bg.jpg')"
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