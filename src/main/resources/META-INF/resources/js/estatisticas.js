function gravarnaapi() {
    document.getElementById("section_partida").innerHTML = `
        <div id="historico-partidas" class="col-md-8 mx-auto text-center" style="padding-top: 200px">
            <h1 class="mb-3 fw-semibold lh-1">Histórico de partidas</h1>
            <div style="text-align: right">
                <!-- Não existe essa tela -->
                <a id="criar-nova-partida" href="partida.html" class="btn btn-primary active" role="button">Criar nova partida</a>
            </div>
            <br>
            <div style="text-align: left">
                <table class="table">
                    <thead class="table-dark">
                        <tr>
                            <th scope="col">Data</th>
                            <th scope="col">Vencedor</th>
                            <th scope="col">Time 1</th>
                            <th scope="col">Pontuação</th>
                            <th scope="col">Time 2</th>
                            <th scope="col">Pontuação</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>18/06/2023 - 15:30</td>
                            <td>Time: ${pontuacaopartida.time}</td>
                            <td>jogador 1, jogador 2, jogador 3</td>
                            <td>${pontuacaoTime1}</td>
                            <td>jogador 1, jogador 2, jogador 3</td>
                            <td>${pontuacaoTime2}</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>`
}