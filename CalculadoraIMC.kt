fun main() {
    println("Calculadora de IMC")

// Solicitar gênero do usuário
    print("Informe seu gênero (M ou F): ")
    var genero = readLine()!!.uppercase()

    // Solicitar peso em quilogramas
    print("Informe seu peso em kg: ")
    var peso = readLine()!!.toFloat()
    

    // Solicitar altura em metros
    print("Informe sua altura em metros: ")
    var altura = readLine()!!.toFloat()
    

    // Calcular IMC
    var imc = peso / (altura * altura)

    // Determinar faixa de IMC e condição física com base no gênero
    var condicaoFisica = when {
        genero == "M" && imc < 20.7 -> "Abaixo do peso"
        genero == "M" && imc < 26.4 -> "Normal"
        genero == "M" && imc < 27.8 -> "Sobrepeso"
        genero == "M" && imc >= 27.8 -> "Obesidade"
        genero == "F" && imc < 19.1 -> "Abaixo do peso"
        genero == "F" && imc < 25.8 -> "Normal"
        genero == "F" && imc < 27.3 -> "Sobrepeso"
        genero == "F" && imc >= 27.3 -> "Obesidade"
        else -> "IMC fora da faixa de análise"
    }

    // Exibir o IMC e a condição física
    println("Seu IMC é: %.2f: ".format(imc))
    println("Condição física: $condicaoFisica")
}
