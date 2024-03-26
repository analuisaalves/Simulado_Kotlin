fun main() {
    println("Calculadora de Média Escolar")

    // Solicitar ao usuário a quantidade de notas
    print("Digite a quantidade de notas: ")
    var quantidadeNotas = readLine()!!.toInt()

    // Lista para armazenar as notas
    var notas = mutableListOf<Double>()

    // Solicitar ao usuário todas as notas
    for (i in 1..quantidadeNotas) {
        print("Digite a nota $i: ")
        var nota = readLine()!!.toDouble()
        notas.add(nota)
    }

    // Calcular a média das notas
    var media = notas.average()

    // Exibir a média
    println("A média das notas é: $media")
}

