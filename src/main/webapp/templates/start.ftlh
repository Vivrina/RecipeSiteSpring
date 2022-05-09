<!DOCTYPE html>
<html lang="ru">
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.88.1">
    <title>RecipeSite</title>

    <%--<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">--%>

    <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap-grid.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap-reboot.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap-utilities.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/form-validation.css">



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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/blog.css">

</head>
<body>
<form action="<c:url value="/start"/>" method="post" class="form">
<div class="container">
    <header class="blog-header py-3">
        <div class="row flex-nowrap justify-content-between align-items-center">
            <c:set var="isAuth"  value="${isAuth}"/>
            <c:choose>
                <c:when test="${isAuth=='true'}">
                    <div class="col-4 pt-1">
                        <a class="link-secondary" href="<c:url value="/signOut"/>">Выйти</a>
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="col-4 pt-1">
                        <a class="link-secondary" href="<c:url value="/signIn"/>">Войти</a>
                    </div>
                </c:otherwise>
            </c:choose>
            <div class="col-4 text-center">
                <a class="blog-header-logo text-dark" href="<c:url value="/start"/>">RecipeSite</a>
            </div>
            <div class="col-4 d-flex justify-content-end align-items-center">


                <c:if test="${isAuth!='true'}">
                    <a class="btn btn-sm btn-outline-secondary" href="<c:url value="/signUp"/>">Зарегистрироваться</a>
                </c:if>
            </div>
        </div>
    </header>

    <div class="nav-scroller py-0 mb-0">
        <header class="blog-header py-3">
            <a class="p-2 link-secondary" href="<c:url value="/profile"/>">Мой кабинет</a>
            <a class="p-2 link-secondary" href="<c:url value="/allRecipe"/>">Все рецепты</a>
            <a class="p-2 link-secondary" href="https://vk.com/i_videeva">Контакты</a>
        </header>
    </div>
</div>

<main class="container">

    <div class="p-4 p-md-5 mb-4 text-white rounded bg-dark">
        <div class="col-md-6 px-0">
            <h1 class="display-4 fst-italic">Регистрируйся и делись своими рецептами на RecipeSite</h1>
            <p class="lead my-3">Станьте постоянными посетителями нашего сайта и лично убедитесь в том, что домашняя кухня без проблем – это реально!</p>
            <%--<p class="lead mb-0"><a href="#" class="text-white fw-bold">Continue reading...</a></p>--%>
        </div>
    </div>




    <div class="row mb-2">
        <c:forEach items="${firstRecipes}" var="firstRecipes">
            <div class="col-md-6">
                <div class="row g-0 border ounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
                    <div class="col p-4 d-flex flex-column position-static">
                        <strong class="d-inline-block mb-2 text-success">${user.name}</strong>
                        <h3 class="mb-0">${firstRecipes.title}</h3>
                        <div class="mb-1 text-muted">${firstRecipes.dateCreation}</div>
                        <p class="mb-auto">${firstRecipes.description}</p>
                    </div>
                    <div class="col-auto d-none d-lg-block">
                        <c:set var="image"  value="${pageContext.request.contextPath}${firstRecipes.image}"/>
                        <c:choose>
                            <c:when test="${image!='null'}">
                                <img src="/image?name=${image}" class="bd-placeholder-img" width="200" height="250">
                            </c:when>
                            <c:otherwise>
                                <img class="bd-placeholder-img" width="200" height="250" src="https://images.pexels.com/photos/1624487/pexels-photo-1624487.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940">
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
            </div>
        </c:forEach>
        <%--        <div class="col-md-6">--%>
            <%--            --%>
            <%--            <div class="row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">--%>
                <%--                <div class="col p-4 d-flex flex-column position-static">--%>
                    <%--                    <strong class="d-inline-block mb-2 text-success">Соня</strong>--%>
                    <%--                    <h3 class="mb-0">Сочная курица с картошкой</h3>--%>
                    <%--                    <div class="mb-1 text-muted">11 Октября</div>--%>
                    <%--                    <p class="mb-auto">This is a wider card with supporting text below as a natural lead-in to additional content.</p>--%>
                    <%--                    <a href="#" class="stretched-link">Читать далее</a>--%>
                    <%--                </div>--%>
                <%--                <div class="col-auto d-none d-lg-block">--%>
                    <%--                    &lt;%&ndash;<svg class="bd-placeholder-img" width="200" height="250" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#55595c"/><text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text></svg>&ndash;%&gt;--%>
                    <%--                        <img class="bd-placeholder-img" width="200" height="250" src="https://images.pexels.com/photos/1624487/pexels-photo-1624487.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940">--%>
                    <%--                </div>--%>
                <%--            </div>--%>
            <%--        </div>--%>
    </div>



    <div class="row g-5">
        <div class="col-md-8">
            <c:forEach items="${recipes}" var="recipe">
                <div class="row g-0 border ounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
                    <div class="col p-4 d-flex flex-column position-static">
                        <strong class="d-inline-block mb-2 text-success">${user.name}</strong>
                        <h3 class="mb-0">${recipe.title}</h3>
                        <div class="mb-1 text-muted">${recipe.dateCreation}</div>
                        <p class="mb-auto">${recipe.description}</p>
                    </div>
                    <div class="col-auto d-none d-lg-block">
                        <c:set var="image"  value="${pageContext.request.contextPath}${recipe.image}"/>
                        <c:choose>
                            <c:when test="${image!='null'}">
                                <img src="/image?name=${image}" class="bd-placeholder-img" width="200" height="250">
                            </c:when>
                            <c:otherwise>
                                <img class="bd-placeholder-img" width="200" height="250" src="https://images.pexels.com/photos/1624487/pexels-photo-1624487.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940">
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
            </c:forEach>

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
                        <c:forEach items="${categories}" var="category">
                            <li><a href="/category?id=${category.id}">${category.name}</a></li>
                        </c:forEach>
                    </ol>
                </div>

            </div>
        </div>
    </div>

</main>

<footer class="blog-footer">
    <p>2021 ©<a href="https://getbootstrap.com/">RecipeSite</a> - Ваши рецепты!</p>
    <%--<a href="https://twitter.com/mdo">@mdo</a>--%>
    <p>
        <a href="https://twitter.com/mdo">RecipeSite@mail.ru</a>
    </p>
</footer>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
</form>
</body>
</html>