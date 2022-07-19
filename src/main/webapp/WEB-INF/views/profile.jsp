<!DOCTYPE html>
<html>
<head>
    <title>Profile</title>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <link rel="stylesheet" type="text/css" href="css/profile.css"/>
    <link
            rel="stylesheet"
            href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
    />
    <link
            rel="stylesheet"
            href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"
    />
    <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"
    />
    <link rel="icon" type="image/png" href="/images/icons/favicon.png"/>
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css"/>
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css"/>
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="fonts/iconic/css/material-design-iconic-font.min.css"/>
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="fonts/linearicons-v1.0.0/icon-font.min.css"/>
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/animate/animate.css"/>
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css"/>
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css"/>
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css"/>
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css"/>
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/slick/slick.css"/>
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/MagnificPopup/magnific-popup.css"/>
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/perfect-scrollbar/perfect-scrollbar.css"/>
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="css/util.css"/>
    <link rel="stylesheet" type="text/css" href="css/main.css"/>
    <link href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,700' rel='stylesheet' type='text/css'>
</head>
<body>
<%@include file="layout/managerHeader.jsp" %>
<div class="container rounded bg-white m-t-100 mb-5">
    <div class="row">
        <div class="col-md-3 border-right">
            <div class="avatar" id="avatar">
                <div id="preview">
                    <img
                            src="https://media.istockphoto.com/photos/funny-winking-kitten-picture-id1267021092?k=20&m=1267021092&s=612x612&w=0&h=yzwxZXklHn5NwDTgKmbq2Ojtg3pga6j8K3oT7lLneAY="
                            id="avatar-image"
                            class="avatar_img"
                            id=""
                    />
                </div>
                <div class="avatar_upload">
                    <label class="upload_label"
                    >Upload
                        <input type="file" id="upload"/>
                    </label>
                </div>
            </div>

            <div class="font-weight-bold text-center mt-2">Amelly</div>
        </div>
        <div class="col-md-8 border-right">
            <div class="p-3 py-5">
                <div class="d-flex justify-content-between align-items-center mb-2 bl-color">
                    <h4 class="text-right">Profile Settings</h4>
                </div>
                <div class="row mt-4">
                    <div class="col-md-12">
                        <label class="labels ml-2 labels--custom">Full name</label>
                        <input
                                type="text"
                                class="form-control form-control-custom"
                                placeholder="Full name"
                                value=""
                        />
                    </div>
                </div>
                <div class="row mt-4">
                    <div class="col-md-6">
                        <label class="labels ml-2 labels--custom">Date of birth</label>
                        <div class="input-group">
                            <input
                                    class="form-control form-control-custom pr-20"
                                    type="date"
                                    value="date1"
                                    id="example-input"
                            />
                            <span class="input-group-append ml-n4 z-index-1">
                    <button class="btn btn-light border-left-0 border bg-white">
                      <i class="fa fa-calendar-alt"></i>
                    </button>
                  </span>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <label class="labels ml-2 labels--custom">PhoneNumber</label>
                        <input
                                type="text"
                                class="form-control form-control-custom"
                                placeholder="Phone number"
                                value=""
                        />
                    </div>
                </div>

                <div
                        class="d-flex justify-content-between align-items-center mb-2 mt-4 bl-color"
                >
                    <h4 class="text-right">Account Settings</h4>
                </div>
                <div class="row mt-3">
                    <div class="col-md-12">
                        <label class="labels ml-2 labels--custom">User name</label>
                        <input
                                type="text"
                                class="form-control form-control-custom"
                                placeholder="User name"
                                value=""
                        />
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col-md-6">
                        <label class="labels ml-2 labels--custom">Password</label>
                        <input
                                type="text"
                                class="form-control form-control-custom"
                                value=""
                                placeholder="Password"
                        />
                    </div>
                    <div class="col-md-6">
                        <label class="labels ml-2 labels--custom"
                        >Confirm password</label
                        >
                        <input
                                type="text"
                                class="form-control form-control-custom"
                                value=""
                                placeholder="Confirm Password"
                        />
                    </div>
                </div>
                <div class="mt-5 text-right">
                    <button class="btn btn--custom profile-button" type="button">
                        Save
                    </button>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    var upload = document.getElementById("upload");
    var preview = document.getElementById("preview");
    var avatar = document.getElementById("avatar");

    var avatars = {
        srcList: [],
        activeKey: 1,
        add: function (_name, _src) {
            this.activeKey = this.srcList.length;
            return (
                this.srcList.push({name: _name, src: encodeURIComponent(_src)}) -
                1
            );
        },
    };

    function showAvatar(key) {
        if (!key) {
            key = avatars.activeKey;
        }
    }

    /*

/** Handle uploading of files */
    upload.addEventListener("change", handleFiles, false);

    function handleFiles() {
        var files = this.files;
        for (var i = 0; i < files.length; i++) {
            var file = files[i];
            var imageType = /^image\//;

            if (!imageType.test(file.type)) {
                avatar.classList.add("avatar--upload-error");
                setTimeout(function () {
                    avatar.classList.remove("avatar--upload-error");
                }, 1200);
                continue;
            }

            avatar.classList.remove("avatar--upload-error");

            while (preview.firstChild) {
                preview.removeChild(preview.firstChild);
            }

            var img = document.createElement("img");
            img.file = file;
            img.src = window.URL.createObjectURL(file);
            img.onload = function () {
                // window.URL.revokeObjectURL(this.src);
            };
            img.className = "avatar_img";

            /* Clear focus and any text editing mode */
            document.activeElement.blur();
            window.getSelection().removeAllRanges();

            var _avatarKey = avatars.add(file.name, img.src);
            preview.appendChild(img);
        }
    }

    window.handleAriaUpload = function (e, obj) {
        if (e.keyCode == 13) {
            obj.click();
        }
    };
</script>
<%@include file="layout/footer.jsp" %>
<script src="js/main.js"></script>
<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
<script src="vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
<script src="vendor/bootstrap/js/popper.js"></script>
<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
<script src="vendor/select2/select2.min.js"></script>

<!--===============================================================================================-->
<script src="vendor/daterangepicker/moment.min.js"></script>
<script src="vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
<script src="vendor/slick/slick.min.js"></script>
<script src="js/slick-custom.js"></script>
<!--===============================================================================================-->
<script src="vendor/parallax100/parallax100.js"></script>

<!--===============================================================================================-->
<script src="vendor/MagnificPopup/jquery.magnific-popup.min.js"></script>

<!--===============================================================================================-->
<script src="vendor/isotope/isotope.pkgd.min.js"></script>
<!--===============================================================================================-->
<script src="vendor/sweetalert/sweetalert.min.js"></script>

<!--===============================================================================================-->
<script src="vendor/perfect-scrollbar/perfect-scrollbar.min.js"></script>
<script>
    $('.js-pscroll').each(function () {
        $(this).css('position', 'relative');
        $(this).css('overflow', 'hidden');
        var ps = new PerfectScrollbar(this, {
            wheelSpeed: 1,
            scrollingThreshold: 1000,
            wheelPropagation: false,
        });

        $(window).on('resize', function () {
            ps.update();
        })
    });
</script>
<!--===============================================================================================-->
<script src="js/main.js"></script>
</body>
</html>
