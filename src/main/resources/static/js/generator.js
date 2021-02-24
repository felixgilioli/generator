let typeToExport = null;

function generate(event) {
    event.preventDefault();

    if (!typeToExport) {
        return;
    }

    const $form = $("#form");

    const data = {
        type: typeToExport,
        templateId: $("#templateId").val(),
        params: getFormData($form)
    };

    fetch("/generator", {
        method: "POST",
        body: JSON.stringify(data),
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
    })
    .then(response => response.json())
    .then(response => {
        const blob = new Blob([response.file], {type : response.blobType});
        const url = window.URL.createObjectURL(blob);
        const a = document.createElement('a');
        a.href = url;
        a.download = response.fileName;
        document.body.appendChild(a); // we need to append the element to the dom -> otherwise it will not work in firefox
        a.click();
        a.remove();  //afterwards we remove the element again
    });

    typeToExport = null;
}

function getFormData($form){
    const unindexed_array = $form.serializeArray();
    const indexed_array = {};

    $.map(unindexed_array, function(n, i){
        indexed_array[n['name']] = n['value'];
    });

    return indexed_array;
}