var btnNoSubmitPost = document.getElementById("btnNoSubmitPost");
btnNoSubmitPost.addEventListener('click', function () {
    // recupero del formulario los valores de los campos email y password mediante sus IDs
    let email = document.getElementById('exampleInputEmail1').value;
    let pass = document.getElementById('exampleInputPassword1').value;
    // construyo una URL de parámetros, es decir un quertystring
    var params = new URLSearchParams();
    params.append('nombre', email);
    params.append('password', pass);
    // console.log(params);
    // console.log(params.get('nombre'));
    // console.log(params.get('password'));
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

var btnNoSubmitGet = document.getElementById("btnNoSubmitGet");
btnNoSubmitGet.addEventListener('click', function () {
    // recupero del formulario los valores de los campos email y password mediante sus IDs
    let email = document.getElementById('exampleInputEmail1').value;
    let pass = document.getElementById('exampleInputPassword1').value;
    // construyo una URL de parámetros, es decir un quertystring
    var params = new URLSearchParams();
    params.append('nombre', email);
    params.append('password', pass);
    // console.log(params);
    // console.log(params.get('nombre'));
    // console.log(params.get('password'));
    // invocación de la librería AXIOS
    axios.get('http://localhost:4567/saludar?'+ params)
        .then(function (response) {
            console.log(response);
            console.log("verdad: " + response.data);
            alert(response.data)
        })
        .catch(function (error) {
            console.log("error: " + error);
        })
});


var btnNoSubmitPostJson = document.getElementById("btnNoSubmitPostJson");
btnNoSubmitPostJson.addEventListener('click', function () {
    // recupero del formulario los valores de los campos email y password mediante sus IDs
    let email = document.getElementById('exampleInputEmail1').value;
    let pass = document.getElementById('exampleInputPassword1').value;
    // construyo una URL de parámetros, es decir un quertystring
    var params = new URLSearchParams();
    params.append('nombre', email);
    params.append('password', pass);
    // console.log(params);
    // console.log(params.get('nombre'));
    // console.log(params.get('password'));
    // invocación de la librería AXIOS
    //var param2 = {firstName:"John", lastName:"Doe", age:50, eyeColor:"blue"};
    axios.post('http://localhost:4567/saludarJson', {
        firstName : email,
        password : pass
    })
        .then(function (response) {
            console.log(response);
            console.log("verdad: " + response.data.usuario);
            alert(response.data.usuario)
            window.location.replace("http://127.0.0.1:5500/formulario.html")
        })
        .catch(function (error) {
            console.log("error: " + error);
        })
});