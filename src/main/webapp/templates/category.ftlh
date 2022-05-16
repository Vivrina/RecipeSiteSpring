<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />
<!DOCTYPE html>
<html lang="ru">
<head>


    <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap-grid.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap-reboot.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap-utilities.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/form-validation.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap.css.map">
    <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap.min.css.map">
    <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap-grid.min.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap-grid.css.map">
    <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap-grid.min.css.map">
    <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap-reboot.min.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap-reboot.css.map">
    <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap-reboot.min.css.map">
    <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap-utilities.min.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap-utilities.css.map">
    <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap-utilities.min.css.map">


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

    <link href="https://fonts.googleapis.com/css?family=Playfair&#43;Display:700,900&amp;display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="/resources/css/blog.css">
    <title>Title</title>
</head>
<body>
<div class="container">
    <header class="blog-header py-3">
        <div class="row flex-nowrap justify-content-between align-items-center">
            <@security.authorize access="isAuthenticated()">
                <div class="col-4 pt-1">
                    <a class="link-secondary" href="/signOut">Выйти</a>
                </div>
            </@security.authorize>
            <@security.authorize access="! isAuthenticated()">
                <div class="col-4 pt-1">
                    <a class="link-secondary" href="/signIn">Войти</a>
                </div>
            </@security.authorize>
            <div class="col-4 text-center">
                <a class="blog-header-logo text-dark" href="/start">RecipeSite</a>
            </div>
            <div class="col-4 d-flex justify-content-end align-items-center">
                <@security.authorize access="! isAuthenticated()">
                    <a class="btn btn-sm btn-outline-secondary" href="/signUp">Зарегистрироваться</a>
                </@security.authorize>
            </div>
        </div>
    </header>

    <div class="row g-5">
        <div class="col-md-12">
            <#list recipes as recipe>
                <div class="row g-0 border ounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
                    <div class="col p-4 d-flex flex-column position-static">
                        <strong class="d-inline-block mb-2 text-success">${recipe.user.name}</strong>
                        <h3 class="mb-0">${recipe.name}</h3>
                        <div class="mb-1 text-muted">${recipe.created}</div>
                        <p class="mb-auto">${recipe.description}</p>
                        <a href="#" class="stretched-link">Читать далее</a>
                    </div>
                    <div class="col-auto d-none d-lg-block">
                        <#if recipe.fileName??>
                            <img src="/image?name=${recipe.fileName}" class="bd-placeholder-img" width="200" height="250">
                        <#else>
                            <img class="bd-placeholder-img" width="200" height="250" src="https://images.pexels.com/photos/1624487/pexels-photo-1624487.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940">
                        </#if>
                    </div>
                </div>
            </#list>
        </div>
    </div>

</div>
</body>
</html>