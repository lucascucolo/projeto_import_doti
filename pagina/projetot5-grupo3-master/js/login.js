
function fazerLogin(event) {

    event.preventDefault(); //não permite o envio padrão do formulário
    window.location = "dados.html";

    // let txtUser = document.getElementById("txtUser").value;
    // let txtSenha = document.getElementById("txtSenha").value;

    // let msgLogin = {
    //     email: txtUser,
    //     racf: txtUser,
    //     senha: txtSenha
    // }

    // let cabecalho = {
    //     method: 'POST',
    //     body: JSON.stringify(msgLogin),
    //     headers: {
    //         'Content-type': 'application/json'
    //     }
    // }

    // fetch("http://localhost:8082/login", cabecalho)
    //     .then(res => tratarResposta(res));
        
}

//a@a.com
//1234567
//1234

function tratarResposta(res){
    if(res.status == 200){
        res.json().then(res => gravarUsuario(res));
    }else{
        document.getElementById("msgError").innerHTML = "<p>Login/senha inválido!</p>";
    }
}

function gravarUsuario(res) {
    localStorage.setItem("userLogged", JSON.stringify(res));
    window.location = "dados.html";
}
