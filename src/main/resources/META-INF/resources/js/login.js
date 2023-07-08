// let alterFormLoginButton = document.getElementById("loginButtonAlter")
// let alterFormRegisterButton = document.getElementById("registerButtonAlter")
let loginForm = document.getElementById("loginForm")
let registerForm = document.getElementById("registerForm")

//Troca de formulário na página inicial
function alterFormLogin(){
    loginForm.style.display = "block";
    registerForm.style.display = "none";
}

function alterFormRegister(){
    loginForm.style.display = "none";
    registerForm.style.display = "block";
}

function validRegisterForm(){
    return document.getElementById("name_register").value !== '' && document.getElementById("email_register").value !== '' && document.getElementById("pass_register").value !== '';
}

function validLoginForm(){
    return document.getElementById("email_login").value !== '' && document.getElementById("pass_login").value !== '';
}

// Cadastro
function getUserDTO(){
    return {
        "email": document.getElementById("email_register").value,
        "nome": document.getElementById("name_register").value,
        "senha": document.getElementById("pass_register").value
    };
}


function createRequestRegister(dto){
    return new Request("http://localhost:8080/salvar", {
        method: "POST",
        headers: {
            "Accept": "application/json",
            "Content-Type": "application/json"
        },
        body: JSON.stringify(dto),
    });
}


function registerUser(){
    if (validRegisterForm()){
        alert("Deu certo")
        var dto = getUserDTO();
        var requisicao = createRequestRegister(dto);
        fetch(requisicao)
        .then((response) => {
            if (response.status === 200) {
                return response.json();
            } else {
                alert("Ocorreu algum erro no servidor!");
            }
        })
        .then(json => {
            alert(json.mensagem);
            window.location.href = window.location.origin+json.url;
        });
    } else
        alert('Os campos nome, e-mail e senha são obrigatórios! Verifique o formulário.')
}


// Login
function loginUser(){
    if (validLoginForm()){
        alert("Deu certo")
        var requisicao = createRequestLogin(document.getElementById("email_login").value,document.getElementById("pass_login").value);
        fetch(requisicao)
        .then((response) => {
            if (response.status === 200) {
                return response.json();
            } else {
                throw new Error("Ocorreu algum erro no servidor!");
            }
        })
        .then(json => {
            console.log(JSON.stringify(json));
            alert(json.mensagem);
            window.location.href = window.location.origin+json.url;
        });
    } else
        alert('Os campos e-mail e senha são obrigatórios! Verifique o formulário.')
}

function createRequestLogin(email, senha){
    return new Request("http://localhost:8080/autenticar", {
        method: "POST",
        headers: {
            "Accept": "application/json",
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            "email": email,
            "senha": senha
        }),
    });
}