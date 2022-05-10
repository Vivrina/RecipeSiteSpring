<!DOCTYPE html>
<html lang="ru">
<head>


    <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap-grid.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap-reboot.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap-utilities.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/form-validation.css">

    <link href="https://fonts.googleapis.com/css?family=Playfair&#43;Display:700,900&amp;display=swap" rel="stylesheet">


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

    <link rel="stylesheet" type="text/css" href="/resources/css/profile.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/blog.css">


    <title>Title</title>
</head>
<body>
<form action="/profile" method="post" class="form">
<div class="container">
    <header class="blog-header py-3">
        <div class="row flex-nowrap justify-content-between align-items-center">
            <div class="col-4 pt-1">
                <a class="link-secondary" href="/signOut">Выйти</a>
            </div>
            <div class="col-4 text-center">
                <a class="blog-header-logo text-dark" href="/start">RecipeSite</a>
            </div>
            <div class="col-4 d-flex justify-content-end align-items-center">
                <a class="link-secondary" href="#" aria-label="Search">
                    <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" class="mx-3" role="img" viewBox="0 0 24 24"><title>Search</title><circle cx="10.5" cy="10.5" r="7.5"/><path d="M21 21l-5.2-5.2"/></svg>
                </a>

            </div>
        </div>
    </header>
    <div class="row">
        <div class="col-lg-4 pb-5">
            <!-- Account Sidebar-->
            <div class="author-card pb-3">
                <div class="author-card-cover bg-dark" >
                    <a class="btn btn-style-1 btn-white btn-sm" href="#" data-toggle="tooltip" title="" data-original-title="You currently have 290 Reward points to spend">
                        <i class="fa fa-award text-md"></i>${user.achievement} рецептов</a></div>
                <div class="author-card-profile">
                    <div class="author-card-avatar"><img src="https://bootdey.com/img/Content/avatar/avatar1.png" alt="Daniel Adams">
                    </div>
                    <div class="author-card-details">
                        <dt >${user.name}</dt><div class="mb-0 text-muted">${user.created}</div>
                    </div>
                </div>
            </div>
            <div class="wizard">
                <nav class="list-group list-group-flush">
                    <a class="list-group-item" href="/start">
                    <div class="d-flex justify-content-between align-items-center">
                        <div><i ></i>
                            <div class=" font-weight-medium text-muted">На главную</div>
                        </div><span class="badge badge-secondary">3</span>
                    </div>
                    </a>
                    <a class="list-group-item" href="/addRecipe">
                    <div class="d-flex justify-content-between align-items-center">
                        <div><i ></i>
                            <div class=" font-weight-medium text-muted">Добавить рецепт</div>
                        </div><span class="badge badge-secondary">3</span>
                    </div>
                    </a>

                </nav>
            </div>
        </div>
        <!-- Wishlist-->
        <div class="col-lg-8 pb-5">
            <!-- Item-->
            <#list user.recipes as recipe>
                <div class="row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
                    <div class="col p-4 d-flex flex-column position-static">
                        <h3 class="mb-0">${recipe.name}</h3>
                        <div class="mb-1 text-muted">${recipe.created}</div>
                        <p class="mb-auto">${recipe.description}</p>

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
</form>
</body>
</html>