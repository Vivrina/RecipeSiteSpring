<!DOCTYPE html>
<html lang="ru">
<head>
    <link rel="stylesheet" type="text/css" href="/src/main/webapp/resources/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="/src/main/webapp/resources/css/bootstrap-grid.css">
    <link rel="stylesheet" type="text/css" href="/src/main/webapp/resources/css/bootstrap-reboot.css">
    <link rel="stylesheet" type="text/css" href="/src/main/webapp/resources/css/bootstrap-utilities.css">
    <link rel="stylesheet" type="text/css" href="/src/main/webapp/resources/css/form-validation.css">


    <!-- Bootstrap core CSS -->
    <link href="../assets/dist/css/bootstrap.min.css" rel="stylesheet">

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
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.0/font/bootstrap-icons.css">

    <!-- Custom styles for this template -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/form-validation.css">
    <title>Загрузить фото</title>
</head>
<body>
<form action="/image" method="post" enctype="multipart/form-data">
    <div class="container">
        <main>
            <div class="py-5 text-center">
                <svg xmlns="http://www.w3.org/2000/svg" width="72" height="57" fill="currentColor" class="bi bi-chevron-right" viewBox="0 0 16 16"><path d="M5 10.5a.5.5 0 0 1 .5-.5h2a.5.5 0 0 1 0 1h-2a.5.5 0 0 1-.5-.5zm0-2a.5.5 0 0 1 .5-.5h5a.5.5 0 0 1 0 1h-5a.5.5 0 0 1-.5-.5zm0-2a.5.5 0 0 1 .5-.5h5a.5.5 0 0 1 0 1h-5a.5.5 0 0 1-.5-.5zm0-2a.5.5 0 0 1 .5-.5h5a.5.5 0 0 1 0 1h-5a.5.5 0 0 1-.5-.5z"/>
                    <path d="M3 0h10a2 2 0 0 1 2 2v12a2 2 0 0 1-2 2H3a2 2 0 0 1-2-2v-1h1v1a1 1 0 0 0 1 1h10a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H3a1 1 0 0 0-1 1v1H1V2a2 2 0 0 1 2-2z"/>
                    <path d="M1 5v-.5a.5.5 0 0 1 1 0V5h.5a.5.5 0 0 1 0 1h-2a.5.5 0 0 1 0-1H1zm0 3v-.5a.5.5 0 0 1 1 0V8h.5a.5.5 0 0 1 0 1h-2a.5.5 0 0 1 0-1H1zm0 3v-.5a.5.5 0 0 1 1 0v.5h.5a.5.5 0 0 1 0 1h-2a.5.5 0 0 1 0-1H1z"/></svg>
                <h2>Добавление рецепта</h2>
                <p class="lead">Пожайлуйста, добавьте фото!</p>
            </div>
            <div class="col-md-6">
                <label for="id_recipe" class="form-label">Фото блюда</label>
                <input class="form-control" type="hidden" id="id_recipe" name="id_recipe" value="${recipe}">
                <input type="file" name="image">
            </div>
            <div class="col-12">
                <button type="submit" class="btn btn-primary">Загрузить фото</button>
            </div>
            <%--<input type="hidden" id="id_recipe" name="id_recipe" value="${recipe}">
            <input type="file" name="image">
            <button type="submit" class="btn btn-info">Загрузить фото</button>--%>
        </main>
    </div>
</form>
</body>
</html>