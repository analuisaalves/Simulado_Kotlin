import kotlin.random.Random

fun main() {
    println("Gerador de Senhas Seguras")

    // Receber a quantidade de caracteres da senha
    print("Digite a quantidade de caracteres da senha: ")
    val tamanhoSenha = readLine()!!.toInt()

    // Gerar a senha
    val senha = gerarSenha(tamanhoSenha)

    // Exibir a senha gerada
    println("A senha gerada é: $senha")
}

fun gerarSenha(tamanho: Int): String {
    val letrasMinusculas = "abcdefghijklmnopqrstuvwxyz"
    val letrasMaiusculas = letrasMinusculas.uppercase()
    val numeros = "0123456789"
    val caracteresEspeciais = "!@#\$%^&*()_-+=<>?/{}[]"

    val caracteres = "$letrasMinusculas$letrasMaiusculas$numeros$caracteresEspeciais"

    // Usar um conjunto mutável para garantir a unicidade dos caracteres na senha
    val senha = mutableListOf<Char>()

    // Adicionar um caractere aleatório de cada categoria à senha
    senha.add(letrasMinusculas.random())
    senha.add(letrasMaiusculas.random())
    senha.add(numeros.random())
    senha.add(caracteresEspeciais.random())

    // Adicionar caracteres aleatórios para completar o tamanho da senha
    repeat(tamanho - 4) {
        senha.add(caracteres.random())
    }

    // Embaralhar a senha para garantir a aleatoriedade
    senha.shuffle()

    // Converter a lista de caracteres em uma string e retornar
    return senha.joinToString("")
}
