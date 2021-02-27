<html lang="pt-br">
<head>
    <title>Gerador de Documentos</title>
    <link rel="stylesheet" type="text/css" href="${path}/bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="${path}/css/layout.css"/>
    <link rel="stylesheet" type="text/css" href="${path}/css/generator.css"/>
    <link rel="icon" href="${path}/img/icon.png">
</head>
<body>
<header>

        <a href="/"><img src="${path}/img/icon-back.png" width="40px" alt="Icone de voltar" class="float-left"></a>
        <h1 class="title">Preencha os dados abaixo para baixar seu documento</h1>
</header>

<input type="hidden" name="templateId" id="templateId" value="${template.id}">

<main>
    <section class="container mt-5">

        <form id="form" onsubmit="generate(event)">

            <#list template.inputGroupList as group>
                <fieldset class="border p-2 mb-4">
                    <legend class="w-auto">${group.legend}</legend>

                    <div>
                        <#list group.inputList as item>

                            <#if item.type == 'TEXT'>
                                <div class="form-group">
                                    <label for="${item.name}">${item.label}<#if item.required> *</#if></label>
                                    <input type="text" class="form-control"
                                           id="${item.name}"
                                           title="${item.title}"
                                           <#if item.required>required</#if>
                                           name="${item.name}"
                                           placeholder="${(item.placeholder)!}">
                                </div>
                            </#if>

                            <#if item.type == 'MASK'>
                                <div class="form-group">
                                    <label for="${item.name}">${item.label}<#if item.required> *</#if></label>
                                    <input type="text" class="form-control"
                                           id="${item.name}"
                                           title="${item.title}"
                                           <#if item.required>required</#if>
                                           name="${item.name}"
                                           placeholder="${(item.placeholder)!}">
                                </div>
                            </#if>

                            <#if item.type == 'NUMBER'>
                                <div class="form-group">
                                    <label for="${item.name}">${item.label}<#if item.required> *</#if></label>
                                    <input type="number"
                                           class="form-control"
                                           id="${item.name}"
                                           name="${item.name}"
                                           <#if item.required>required</#if>
                                           placeholder="${(item.placeholder)!}">
                                </div>
                            </#if>

                            <#if item.type == 'EMAIL'>
                                <div class="form-group">
                                    <label for="${item.name}">${item.label}<#if item.required> *</#if></label>
                                    <input type="email"
                                           class="form-control"
                                           id="${item.name}"
                                           <#if item.required>required</#if>
                                           name="${item.name}"
                                           placeholder="${(item.placeholder)!}">
                                </div>
                            </#if>


                            <#if item.type == 'TEXTAREA'>
                                <div class="form-group">
                                    <label for="${item.name}">${item.label}<#if item.required> *</#if></label>
                                    <textarea class="form-control"
                                              id="${item.name}"
                                              name="${item.name}"
                                              <#if item.required>required</#if>
                                                      placeholder="${(item.placeholder)!}"></textarea>
                                </div>
                            </#if>

                        </#list>

                    </div>
                </fieldset>
            </#list>

            <div class="dropdown">
                <button class="btn btn-primary dropdown-toggle"
                        type="button"
                        id="dropdownExport"
                        data-toggle="dropdown"
                        aria-haspopup="true"
                        aria-expanded="false">
                    Baixar Documento
                </button>

                <div class="dropdown-menu" aria-labelledby="dropdownExport">
                    <#list template.exportTypeSet as type>
                        <input type="submit"
                               class="dropdown-item"
                               value="${type.engine.label}"
                               onclick="typeToExport = '${type}'">
                    </#list>
                </div>
            </div>

        </form>

    </section>
</main>

<script src="${path}/jquery/jquery.min.js"></script>
<script src="${path}/jquery/jquery.mask.min.js"></script>
<script src="${path}/bootstrap/js/popper.min.js"></script>
<script src="${path}/bootstrap/js/bootstrap.min.js"></script>
<script src="${path}/js/generator.js"></script>


<script>
    $(document).ready(function(){
        <#list template.inputGroupList as group>
            <#list group.inputList as item>
                <#if item.type == 'MASK'>
                    $("#${item.name}").mask("${item.mask}");
                </#if>
            </#list>
        </#list>
    });
</script>
</body>
</html>
