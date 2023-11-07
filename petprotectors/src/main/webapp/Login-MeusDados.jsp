<!DOCTYPE html>
<html>

<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <link rel="shortcut icon" href="/assets/icons/icon-pegada-preta.ico" type="image/x-icon">
    <title>Pet Protectors - Meus Dados</title>
    <link rel="stylesheet" href="assets/css/styles.css">
    <link rel="stylesheet" href="assets/css/styles-arealogada.css">
    <link rel="stylesheet" href="assets/css/formclientelogado.css">
</head>

<body>

    <div class="navbar">
        <img src="assets/icons/icon-pegada.ico" alt="petprotectors-logo" style="height: 50px;">
        <a href="index.jsp" class="navbar-brand">Pet Protectors</a>
    </div>
    <form>
        <div class="sidebar">
            <div class="username">
                <img src="assets/images/user.png" alt="User Image">
                <p>${cliente.nome}</p>
            </div>
            <ul>
                <li><a href="Login-MeusDados.jsp">Meus Dados</a></li>
                <li><a href="Login-MeusPets.jsp">Meus Pets</a></li>
                <li><a href="Login-MeusAgendamentos.jsp">Agendamentos</a></li>
                <li><a href="">Meu Plano</a></li>
                <c:if test="${sessionScope.loggedUser != null}">
                    <li><a href="/logout">Sair</a></li>
                </c:if>
            </ul>
        </div>
    </form>
    <div class="conteudo">
        <div class="container">
            <div class="form-image">
                <img src="assets/images/undraw_Dog_c7i6.png" alt="">
            </div>
            <div class="form-dados">
                <form action="update-usuario" method="get">
                    <div class="input-group">
                        <div class="input-box">
                            <input type="hidden" id="clienteId" name="clienteId" value="${cliente.clienteId}">

                            <label for="nome">Nome</label>
                            <input id="nome" type="text" name="nome" placeholder="" value="${cliente.nome}" readonly>
                        </div>
                        <div class="input-box">
                            <label for="cpf">CPF</label>
                            <input id="cpf" type="text" name="cpf" value="${cliente.cpf}" readonly>
                        </div>
                        <div class="input-box">
                            <label for="endereco">Endereço</label>
                            <input id="endereco" type="text" name="endereco" value="${cliente.endereco}" readonly>
                        </div>
                        <div class="input-box">
                            <label for="telefone">Tel / Cel</label>
                            <input id="telefone" type="text" name="telefone" value="${cliente.telefone}" readonly>
                        </div>
                        <div class="input-box">
                            <label for="email">E-mail</label>
                            <input id="email" type="email" name="email" value="${cliente.email}" readonly>
                        </div>
                        <div class="input-box">
                            <label for="senha">Senha</label>
                            <input id="senha" type="password" name="senha" value="${cliente.senha}" readonly>
                        </div>
                    </div>
                    <div class="gender-inputs">
                        <div class="gender-title">
                            <h6>Gênero</h6>
                        </div>
                        <div class="gender-group">
                            <div class="gender-input">
                                <input type="radio" id="feminino" name="gender">
                                <label for="feminino">Feminino</label>
                            </div>
                            <div class="gender-input">
                                <input type="radio" id="masculino" name="gender">
                                <label for="masculino">Masculino</label>
                            </div>
                            <div class="gender-input">
                                <input type="radio" id="outros" name="gender">
                                <label for="outros">Outros</label>
                            </div>
                        </div>
                    </div>

                    <div class="cadastrar-button">
                        <button type="submit" class="botao">Editar</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

</body>

</html>