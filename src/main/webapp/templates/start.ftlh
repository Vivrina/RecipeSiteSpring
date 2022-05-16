<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />
<!DOCTYPE html>
<html lang="ru">
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.88.1">
    <title>RecipeSite</title>


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

</head>
<body>
<form action="/start" method="post" class="form">
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

    <div class="nav-scroller py-0 mb-0">
        <header class="blog-header py-3">
            <a class="p-2 link-secondary" href="/profile">Мой кабинет</a>
            <a class="p-2 link-secondary" href="/allRecipe">Все рецепты</a>
            <a class="p-2 link-secondary" href="https://vk.com/i_videeva">Контакты</a>
        </header>
    </div>
</div>

<main class="container">

    <div class="p-4 p-md-5 mb-4 text-white rounded bg-dark">
        <div class="col-md-6 px-0">
            <h1 class="display-4 fst-italic">Регистрируйся и делись своими рецептами на RecipeSite</h1>
            <p class="lead my-3">Станьте постоянными посетителями нашего сайта и лично убедитесь в том, что домашняя кухня без проблем – это реально!</p>
        </div>
    </div>




    <div class="row mb-2">
        <#list recipesTwo as recipesTwo>
        <div class="col-md-6">
                <div class="row g-0 border ounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
                    <div class="col p-4 d-flex flex-column position-static">
                        <strong class="d-inline-block mb-2 text-success">${recipesTwo.user.name}</strong>
                        <h3 class="mb-0">${recipesTwo.name}</h3>
                        <div class="mb-1 text-muted">${recipesTwo.created}</div>
                        <p class="mb-auto">${recipesTwo.description}</p>
                    </div>
                    <div class="col-auto d-none d-lg-block">
                        <#if recipesTwo.fileName??>
                            <img src="/image?name=${recipesTwo.fileName}" class="bd-placeholder-img" width="200" height="250">
                        <#else>
                            <img class="bd-placeholder-img" width="200" height="250" src="https://images.pexels.com/photos/1624487/pexels-photo-1624487.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940">
                        </#if>
                    </div>
                </div>
            </div>
        </#list>
    </div>



    <div class="row g-5">
        <div class="col-md-8">
            <#list recipes as recipe>
                <div class="row g-0 border ounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
                    <div class="col p-4 d-flex flex-column position-static">
                        <strong class="d-inline-block mb-2 text-success">${recipe.user.name}</strong>
                        <h3 class="mb-0">${recipe.name}</h3>
                        <div class="mb-1 text-muted">${recipe.created}</div>
                        <p class="mb-auto" aria-valuetext="20" >${recipe.description}</p>
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

        <div class="col-md-4">
            <div class="position-sticky" style="top: 2rem;">
                <div class="p-4 mb-3 bg-light rounded">
                    <h4 class="fst-italic">Уважаемые читатели!</h4>
                    <p class="mb-0">На нашем кулинарном сайте публикуются рецепты только на русском языке. Пожалуйста, размещайте
                        ваши кулинарные рецепты с фото и описание, а также добавляйте рецепт в нужную категорию.
                        И тогда всем будем легко и удобно готовить с нами!</p>
                </div>

                <div class="p-4">
                    <h4 class="fst-italic">Категории</h4>
                    <ol class="list-unstyled mb-0">
                        <#list categories as category>
                            <li><a href="/category/${category.id}">${category.name}</a></li>
                        </#list>
                    </ol>
                </div>

            </div>
        </div>
    </div>

</main>

<footer class="blog-footer">
    <p>2021 ©<a href="https://getbootstrap.com/">RecipeSite</a> - Ваши рецепты!</p>
    <p>
        <a href="https://twitter.com/mdo">RecipeSite@mail.ru</a>
    </p>
</footer>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
</form>
</body>
</html>