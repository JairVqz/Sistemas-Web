var btnNoSubmitPost = document.getElementById("btnNoSubmitPost");
btnNoSubmitPost.addEventListener('click', function () {
    // recupero del formulario los valores de los campos email y password mediante sus IDs
    let email = document.getElementById('exampleInputEmail1').value;
    let pass = document.getElementById('exampleInputPassword1').value;
    // construyo una URL de parámetros, es decir un quertystring
    var params = new URLSearchParams();
    params.append('nombre', email);
    params.append('password', pass);

    // invocación de la librería AXIOS
    axios.post('http://localhost:4567/saludar', params)
        .then(function (response) {
            console.log(response);
            console.log("verdad: " + response.data);
            alert(response.data)
        })
        .catch(function (error) {
            console.log("error: " + error);
        })
});
