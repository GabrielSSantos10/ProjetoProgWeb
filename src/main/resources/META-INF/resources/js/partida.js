let seg = 0;
let min = 0;

let intervalo;

let pontuacaoTime1 = 0;
let pontuacaoTime2 = 0;

let buttonIniciar = document.getElementById("iniciar-cronometro");
let buttonPausar = document.getElementById("pausar-cronometro");
let buttonFinalizar = document.getElementById("finalizar-partida");

let buttonAdd2PontosTime1 = document.getElementById("add-2-pontos-time-1")
let buttonAdd3PontosTime1 = document.getElementById("add-3-pontos-time-1")

let buttonAdd2PontosTime2 = document.getElementById("add-2-pontos-time-2")
let buttonAdd3PontosTime2 = document.getElementById("add-3-pontos-time-2")

let buttonRetomar = document.getElementById("retomar-cronometro")
let resultadoPartida = document.getElementById("resultado-partida")
let criarPartida = document.getElementById("criar-partida")
let placar = document.getElementById("placar-partida")

let jogador1Time1 = document.getElementById("jogador1-time1")
let jogador2Time1 = document.getElementById("jogador2-time1")
let jogador3Time1 = document.getElementById("jogador3-time1")
let jogador1Time2 = document.getElementById("jogador1-time2")
let jogador2Time2 = document.getElementById("jogador2-time2")
let jogador3Time2 = document.getElementById("jogador3-time2")
let timeVencedor


function createRequestPartida(j1T1, j2T1, j3T1, j1T2, j2T2, j3T2, pT1, pT2, tV){
    return new Request("http://localhost:8080/partida/salvarPartida", {
        method: "POST",
        headers: {
            "Accept": "application/json",
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            "nomeJogador1Time1":j1T1,
            "nomeJogador2Time1":j2T1,
            "nomeJogador3Time1":j3T1,
            "nomeJogador1Time2":j1T2,
            "nomeJogador2Time2":j2T2,
            "nomeJogador3Time2":j3T2,
            "pontosTime1":pT1,
            "pontosTime2":pT2,
            "timeVencedor":tV
        }),
    });
}

function savePartida(){
    var requisicao = createRequestPartida(jogador1Time1.value, jogador2Time1.value, jogador3Time1.value, jogador1Time2.value, jogador2Time2.value, jogador3Time2.value, pontuacaoTime1, pontuacaoTime2, timeVencedor);
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
}

function mostrarResultadoPartida () {
    let pontuacaopartida = {}
    if (pontuacaoTime1 > pontuacaoTime2) {
        timeVencedor = 1;
        pontuacaopartida = {
            "nomeJogador1Time1":jogador1Time1.value,
            "nomeJogador2Time1":jogador2Time1.value,
            "nomeJogador3Time1":jogador3Time1.value,
            "nomeJogador1Time2":jogador1Time2.value,
            "nomeJogador2Time2":jogador2Time2.value,
            "nomeJogador3Time2":jogador3Time2.value,
            "pontosTime1":pontuacaoTime1,
            "pontosTime2":pontuacaoTime2,
            "timeVencedor":timeVencedor
        }
    } else {
        timeVencedor = 2;
        pontuacaopartida = {
            "nomeJogador1Time1":jogador1Time1.value,
            "nomeJogador2Time1":jogador2Time1.value,
            "nomeJogador3Time1":jogador3Time1.value,
            "nomeJogador1Time2":jogador1Time2.value,
            "nomeJogador2Time2":jogador2Time2.value,
            "nomeJogador3Time2":jogador3Time2.value,
            "pontosTime1":pontuacaoTime1,
            "pontosTime2":pontuacaoTime2,
            "timeVencedor":timeVencedor
        }
    }
    document.getElementById("resultado_time_ganhador").innerText = pontuacaopartida.timeVencedor
    document.getElementById("resultado_pontuacao_time1").innerText = pontuacaoTime1
    document.getElementById("resultado_pontuacao_time2").innerText = pontuacaoTime2

    console.log(pontuacaopartida)
    criarPartida.style.display = "none"
    placar.style.display = "none"
    resultadoPartida.style.display = "grid"
    savePartida();
}

function mostrarPlacar() {
    criarPartida.style.display = "none";
    placar.style.display = "grid";
    resultadoPartida.style.display = "none";
    desativarBotoes()
}

function doisDigitos(digito){
    if(digito<10){
        return('0'+digito)
    }else{
        return(digito)
    }
}

function iniciar(){
    cronometro();
    ativarBotoes2();
    intervalo= setInterval(cronometro,1000);
    buttonIniciar.style.display = "none";
    buttonPausar.style.display = "grid";
    buttonFinalizar.style.display = "grid";

}

function ativarBotoes2(){
    buttonAdd2PontosTime1.disabled = false;
    buttonAdd3PontosTime1.disabled = false;

    buttonAdd2PontosTime2.disabled = false;
    buttonAdd3PontosTime2.disabled = false;
}

function retomar(){
    cronometro();
    ativarBotoes2();
    intervalo= setInterval(cronometro,1000);
    buttonRetomar.style.display = "none";
    buttonPausar.style.display = "grid";

}

function pausar(){
    clearInterval(intervalo)
    buttonPausar.style.display = "none";
    buttonRetomar.style.display = "grid";
}

function finalizar(){
    if (pontuacaoTime1 === pontuacaoTime2) {
        document.getElementById("desempatar").style.display = "block";
        document.getElementById("quest_finalizar").style.display = "none";
        clearInterval(intervalo);
        desativarBotoes();
        buttonPausar.style.display = "none";
        buttonRetomar.style.display = "grid";
        return
    }else{
        document.getElementById("desempatar").style.display = "none";
        document.getElementById("quest_finalizar").style.display = "block";
        clearInterval(intervalo);
        desativarBotoes();
        buttonPausar.style.display = "none";
        buttonRetomar.style.display = "grid";
    }

}

function desativarBotoes(){
    buttonAdd2PontosTime1.disabled = true;
    buttonAdd3PontosTime1.disabled = true;

    buttonAdd2PontosTime2.disabled = true;
    buttonAdd3PontosTime2.disabled = true;
}

function cronometro(){
    seg++
    if(seg===60){
        min++
        seg=0
    }
    document.getElementById('cronometro').innerText=+doisDigitos(min)+':'+doisDigitos(seg)
}

function adicionar2PontosTime1(){
    pontuacaoTime1 += 2
    document.getElementById(`pontuacao-time-1`).innerText=pontuacaoTime1;
}

function adicionar3PontosTime1(){
    pontuacaoTime1 += 3
    document.getElementById(`pontuacao-time-1`).innerText=pontuacaoTime1;
}

function adicionar2PontosTime2(){
    pontuacaoTime2 += 2
    document.getElementById(`pontuacao-time-2`).innerText=pontuacaoTime2;
}

function adicionar3PontosTime2(){
    pontuacaoTime2 += 3
    document.getElementById(`pontuacao-time-2`).innerText=pontuacaoTime2;
}

// let dados_api_jogadores = []
// dados_api_jogadores = [{
//     'time': '1',
//     'jogador1': 'nomejogador1',
// }, {
//     'time': '2',
//     'jogador1': 'nomejogador1',
// } ]
//fazer um map com o json da API para criar a lista dos logs

// function gravarnaapi() {
//     document.getElementById("section_partida").innerHTML = `
//         <div id="historico-partidas" class="col-md-8 mx-auto text-center" style="padding-top: 200px">
//             <h1 class="mb-3 fw-semibold lh-1">Histórico de partidas</h1>
//             <div style="text-align: right">
//                 <!-- Não existe essa tela -->
//                 <a id="criar-nova-partida" href="partida.html" class="btn btn-primary active" role="button">Criar nova partida</a>
//             </div>
//             <br>
//             <div style="text-align: left">
//                 <table class="table">
//                     <thead class="table-dark">
//                         <tr>
//                             <th scope="col">Vencedor</th>
//                             <th scope="col">Time 1</th>
//                             <th scope="col">Pontuação</th>
//                             <th scope="col">Time 2</th>
//                             <th scope="col">Pontuação</th>
//                         </tr>
//                     </thead>
//                     <tbody>
//                         <tr>
//                             <td>18/06/2023 - 15:30</td>
//                             <td>Time: ${pontuacaopartida.time}</td>
//                             <td>jogador 1, jogador 2, jogador 3</td>
//                             <td>${pontuacaoTime1}</td>
//                             <td>jogador 1, jogador 2, jogador 3</td>
//                             <td>${pontuacaoTime2}</td>
//                         </tr>
//                     </tbody>
//                 </table>
//             </div>
//         </div>`
// }
