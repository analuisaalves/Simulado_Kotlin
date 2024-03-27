var next_id: Int = 1

val clientes: MutableList<MutableMap<String, String>> = mutableListOf(
    mutableMapOf(
        "id" to "1",
        "nome" to "Fulano da Silva",
        "dtNasc" to "20/01/1994",
        "sexo" to "M",
        "email" to "fulano@dev.com",
        "whatsapp" to "+5562999990000",
        "profissao" to "Programador"
    )
)


fun obterNovoId(): String {
    next_id += 1
    return "$next_id"
}

fun obterIndicePeloId(id: String):Int {
    var cliente_index: Int = -1
    for ((index, cliente) in clientes.withIndex()){
        if (cliente["id"] == id){
            cliente_index = index
            break
        }
    }
    return cliente_index
}

fun obterIndiceCliente(): Int{
    print("Informe o id do cliente: ")
    val id = readln()
    val cliente_index: Int = obterIndicePeloId(id)
    if(cliente_index == -1){
        println("Cliente não encontrado!")
    }
    return cliente_index
}

fun mostrarMenu(){
    println("---- Cadastro de Clientes ----")
    println("1 - Mostrar clientes")
    println("2 - Cadastrar cliente")
    println("3 - Excluir cliente")
    println("4 - Alterar cliente")
    println("0 - Sair")
}

fun mostrarClientes(){
    println("+---+---------------+-----------+------+---------------+---------------+---------------+")
    println("| # | Nome          | Dt. Nasc. | Sexo | Email         | Whatsapp      | Profissao     |")
    println("+---+---------------+-----------+------+---------------+---------------+---------------+")
    
    if(clientes.size == 0){
        println("|                           Nenhum cliente cadastrado!                                 |")
        println("+--------------------------------------------------------------------------------------+")
    }else{
        for (cliente in clientes){
            val id   = cliente["id"]?.padEnd(3)?.substring(0, 3)
            val nome   = cliente["nome"]?.padEnd(15)?.substring(0, 15)
            val dtNasc = cliente["dtNasc"]?.padEnd(11)?.substring(0, 11)
            val sexo   = cliente["sexo"]?.padEnd(6)?.substring(0, 6)
            val email  = cliente["email"]?.padEnd(15)?.substring(0, 15)
            val whatsapp  = cliente["whatsapp"]?.padEnd(15)?.substring(0, 15)
            val profissao = cliente["profissao"]?.padEnd(15)?.substring(0, 15)
            println("|$id|$nome|$dtNasc|$sexo|$email|$whatsapp|$profissao|")    
            println("+---+---------------+-----------+------+---------------+---------------+---------------+")
        }
    }
}

fun mostrarCadastroCliente(){
    println("---- Cadastro ----")

    print("Nome: ")
    val nome = readln()

    print("Dt. Nasc (Ex. 20/01/1999): ")
    val dtNasc = readln()

    print("Sexo (M ou F): ")
    val sexo = readln()

    print("Email: ")
    val email = readln()

    print("Whatsapp: ")
    val whatsapp = readln()
    
    print("Profissao: ")
    val profissao = readln()
            
    val novo_id = obterNovoId()

    val cadastro = mutableMapOf(
        "id" to novo_id,
        "nome" to nome,
        "dtNasc" to dtNasc,
        "sexo" to sexo,
        "email" to email,
        "whatsapp" to whatsapp,
        "profissao" to profissao
    )

    clientes.add(cadastro)
    mostrarClientes()
}

fun mostrarExclusaoCliente(){
    val cliente_index = obterIndiceCliente()
    if(cliente_index != -1){
        val nome = clientes[cliente_index]["nome"]
        print("Deseja realmente excluir $nome (S ou N)? ")
        val resposta = readln()
        if (resposta == "S"){
            clientes.removeAt(cliente_index)
            mostrarClientes()
        }
    }
}

fun mostrarAlteracaoCliente(){
    val cliente_index = obterIndiceCliente()
    if(cliente_index != -1){
        println("Informe o campo a ser alterado:")
        println("1 - Nome")
        println("2 - Dt. Nasc.")
        println("3 - Sexo")
        println("4 - Email")
        println("5 - Whatsapp")
        println("6 - profissao")
        val indice = readln().toInt() - 1
        val campos = listOf("nome","dtNasc","sexo","email","whatsapp","profissao")
        val campo: String = campos[indice]
        
        print("Informe o novo $campo: ")
        val valor = readln()
        
        clientes[cliente_index][campo] = valor

        mostrarClientes()
    }
}

fun main(){
    do{
        mostrarMenu()
        print("Opção: ")
        var digit = readln()
        if (digit == ""){
            digit = "-1"
        }
        val opcao: Int = digit.toInt() 
        when(opcao){
            1 -> mostrarClientes()
            2 -> mostrarCadastroCliente()
            3 -> mostrarExclusaoCliente()
            4 -> mostrarAlteracaoCliente()
            0 -> println("Bye")
            else -> println("Opção inválida!")
        }
    }while(opcao != 0)
}