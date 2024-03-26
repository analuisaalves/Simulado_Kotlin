fun main() {
    println("Conversor de Temperatura")

    // Solicitar a unidade de entrada
    print("Digite a unidade de entrada (C para Celsius ou F para Fahrenheit): ")
    val unidadeEntrada = readLine()!!.uppercase()

    // Solicitar o valor da temperatura
    print("Digite o valor da temperatura: ")
    val temperatura = readLine()!!.toDouble()

    // Converter temperatura para a outra unidade
    val temperaturaConvertida = if (unidadeEntrada == "C") {
        celsiusParaFahrenheit(temperatura)
    } else {
        fahrenheitParaCelsius(temperatura)
    }

    // Exibir a temperatura convertida
    println("A temperatura convertida é: %.2f".format(temperaturaConvertida))
}

// Função para converter Celsius para Fahrenheit
fun celsiusParaFahrenheit(celsius: Double): Double {
    return celsius * 9 / 5 + 32
}

// Função para converter Fahrenheit para Celsius
fun fahrenheitParaCelsius(fahrenheit: Double): Double {
    return (fahrenheit - 32) * 5 / 9
}
