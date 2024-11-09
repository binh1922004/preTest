<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://unpkg.com/bootstrap@5.3.3/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://unpkg.com/bs-brain@2.0.4/components/logins/login-4/assets/css/login-4.css">
    <title>Login</title>
</head>
<body>

<div class="col-md-9 col-sm-9">
    <h1>Login</h1>
    <div class="content-form-page">
        <div class="row">
            <div class="col-md-7 col-sm-7">
                <form action=" <%= request.getContextPath()%>/login" method="post" class="form-horizontal form-without-legend" role="form">
                    <div class="form-group">
                        <label for="email" class="col-lg-4 control-label">Email <span class="require">*</span></label>
                        <div class="col-lg-8">
                            <input type="text" class="form-control" id="email" name="email">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="pass" class="col-lg-4 control-label">Password <span class="require">*</span></label>
                        <div class="col-lg-8">
                            <input type="password" class="form-control" id="pass" name="pass">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-8 col-md-offset-4 padding-left-0">
                            <a href="<%=request.getContextPath()%>/forgot/identify">Forget Password?</a>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-8 col-md-offset-4 padding-left-0 padding-top-20">
                            <button type="submit" class="btn btn-primary">Login</button>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-8 col-md-offset-4 padding-left-0 padding-top-10 padding-right-30">
                            <hr>
                            <div class="login-socio">
                                <p class="text-muted">or login using:</p>
                                <ul class="social-icons">
                                    <li><a href="#" data-original-title="facebook" class="facebook" title="facebook"></a></li>
                                    <li><a href="#" data-original-title="Twitter" class="twitter" title="Twitter"></a></li>
                                    <li><a href="#" data-original-title="Google Plus" class="googleplus" title="Google Plus"></a></li>
                                    <li><a href="#" data-original-title="Linkedin" class="linkedin" title="LinkedIn"></a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
            <div class="col-md-4 col-sm-4 pull-right">
                <div class="form-info">
                    <h2><em>Important</em> Information</h2>
                    <p>Duis autem vel eum iriure at dolor vulputate velit esse vel molestie at dolore.</p>

                    <button type="button" class="btn btn-default">More details</button>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>