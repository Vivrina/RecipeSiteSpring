<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.88.1">
    <title>Signin Template · Bootstrap v5.1</title>

    <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap-grid.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap-reboot.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap-utilities.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/form-validation.css">


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
    <link href="/resources/css/signin.css" rel="stylesheet">

    <title>Sign In</title>
</head>
<body class="text-center">
<main class="form-signin">
    <form action="/signIn" method="post" class="form">
    <h1 class="h3 mb-4 fw-normal">Пожалуйста, войдите</h1>
    <div class="form-floating">
        <input type="email" class="form-control" id="email" name="email">
        <label for="email">Email</label>
    </div>
    <div class="form-floating">
        <input type="password" class="form-control" id="password" name="password">
        <label for="password">Пароль</label>
    </div>
    <#if error??>
    <p><font color="#dc3545">${error}</font> </p>
    </#if>
    <button class="w-100 btn btn-lg btn-primary" type="submit">Войти</button>
    <p class="mt-3 mb-3 text-muted">&copy; 2021</p>
    </form>
</main>
</body>
</html>