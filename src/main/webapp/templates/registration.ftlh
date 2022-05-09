<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.88.1">
    <title>Signin Template · Bootstrap v5.1</title>

    <link rel="stylesheet" type="text/css" href="/src/main/webapp/resources/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="/src/main/webapp/resources/css/bootstrap-grid.css">
    <link rel="stylesheet" type="text/css" href="/src/main/webapp/resources/css/bootstrap-reboot.css">
    <link rel="stylesheet" type="text/css" href="/src/main/webapp/resources/css/bootstrap-utilities.css">
    <link rel="stylesheet" type="text/css" href="/src/main/webapp/resources/css/form-validation.css">
    <!--<link rel="stylesheet" type="text/css" href="/src/main/webapp/resources/css/profile.css">
    <link rel="stylesheet" type="text/css" href="/src/main/webapp/resources/css/signin.css">
    <link rel="stylesheet" type="text/css" href="/src/main/webapp/resources/css/blog.css"> -->

    <!-- Bootstrap core CSS -->

    <style>
        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            user-select: none;
        }

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }
    </style>


    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/css/signin.css" rel="stylesheet">
    <title>Registration</title>
</head>
<body class="text-center">
<main class="form-signin">
    <form action="<c:url value="/signUp"/>" method="post" class="form">
    <%--<p>Sign Up</p>
    <p>
        <label for="name">Name<input id="name" type="text" name="name"></label><br>
        <label for="password">Password<input id="password" type="password" name="password"></label><br>
        <label for="email">Email<input id="email" type="email" name="email" value=""></label>

        <%--        <p><input type="submit"></p>--%>
    <%--<p><button type="submit">Зарегистрироваться!</button></p><br>--%>
    <h1 class="h3 mb-4 fw-normal">Пожалуйста, зарегистрируйтесь</h1>
    <div class="form-floating">
        <input type="text" class="form-control" id="name" name="name">
        <label for="name">Имя</label>
    </div>
    <div class="form-floating">
        <input type="password" class="form-control" id="password" name="password">
        <label for="password">Пароль</label>
    </div>
    <div class="form-floating">
        <input type="email" class="form-control" id="email" name="email">
        <label for="email">Email</label>
    </div>



    <button class="w-100 btn btn-lg btn-primary" type="submit">Зарегистрироваться</button>
    <p class="mt-3 mb-3 text-muted">&copy; 2021</p>
    </form>
</main>
</body>
</html>