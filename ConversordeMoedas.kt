fun main() {
    println("Conversor de Moedas")

    // Definição das taxas de conversão
    val taxaRealParaDolar = 4.95
    val taxaRealParaEuro = 5.38
    val taxaDolarParaEuro = 1.10

    // Mostrar lista de moedas disponíveis
    println("Moedas:")
    println("BRL - Real")
    println("USD - Dólar")
    println("EUR - Euro")

    // Solicitar a moeda inicial
    print("Selecione a moeda inicial (BRL, USD, EUR): ")
    var moedaInicial = readLine()!!.uppercase()

    // Solicitar a moeda final
    print("Selecione a moeda final (BRL, USD, EUR): ")
    var moedaFinal = readLine()!!.uppercase()

    // Solicitar a quantidade de dinheiro a ser convertida
    print("Informe  a quantia em USD: ")
    val quantidade = readLine()!!.toDouble()

    // Calcular o valor convertido com base nas taxas de conversão
    val valorConvertido = when {
        moedaInicial == "BRL" && moedaFinal == "USD" -> quantidade / taxaRealParaDolar
        moedaInicial == "BRL" && moedaFinal == "EUR" -> quantidade / taxaRealParaEuro
        moedaInicial == "USD" && moedaFinal == "BRL" -> quantidade * taxaRealParaDolar
        moedaInicial == "USD" && moedaFinal == "EUR" -> quantidade * (1 / taxaDolarParaEuro)
        moedaInicial == "EUR" && moedaFinal == "BRL" -> quantidade * taxaRealParaEuro
        moedaInicial == "EUR" && moedaFinal == "USD" -> quantidade * taxaDolarParaEuro
        else -> quantidade // Se as moedas forem as mesmas
    }

    // Exibir o valor convertido
println("O valor em BRL é: %.2f".format(valorConvertido))
}
