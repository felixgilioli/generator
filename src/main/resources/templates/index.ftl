<html>
<head>
    <title>Gerador de Documentos</title>
    <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="css/layout.css" />
    <link rel="stylesheet" type="text/css" href="css/index.css" />
    <link rel="icon" href="/img/icon.png">
</head>
<body>
    <header>
        <h1 class="title">Gerador de Documentos</h1>
        <h2 class="subtitle">Selecione o template, preencha os dados e baixe seu documento!</h2>
    </header>

    <main>
        <section class="container mt-5 templates">

            <div class="row">

                <#list templatePage.content as item>

                    <div class="col-3 mb-5">
                        <div class="card" style="min-height: 450px; min-width: 400px;">
                            <a href="/template/${item.id}/generate">
                                <img class="card-img-top"
                                     width="100%"
                                     height="300px"
                                     title="Clique para selecionar o template"
                                     src="${item.imgLocation}" alt="Foto do template ${item.title}">
                            </a>
                            <div class="card-body">
                                <h5 class="card-title">${item.title}</h5>
                                <p class="card-text">${item.description}</p>
                            </div>
                        </div>
                    </div>
                </#list>

            </div>
        </section>

    </main>

    <script src="jquery/jquery.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <script src="js/index.js"></script>
</body>
</html>