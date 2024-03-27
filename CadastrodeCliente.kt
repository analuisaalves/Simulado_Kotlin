class Client(
    val id: Int,
    var name: String,
    var birthDate: String,
    var sex: String,
    var email: String,
    var whatsapp: String,
    var profession: String
)

val clients = mutableListOf<Client>()

fun listClients() {
    println("ID\tName\tBirth Date\tSex\tEmail\tWhatsapp\tProfession")
    clients.forEachIndexed { index, client ->
        print("${client.id}\t${client.name}\t${client.birthDate}\t${client.sex}\t${client.email}\t${client.whatsapp}\t${client.profession}\n")
    }
}

fun registerClient() {
    print("Enter the client's name: ")
    val name = readLine()!!
    print("Enter the client's birth date: ")
    val birthDate = readLine()!!
    print("Enter the client's sex: ")
    val sex = readLine()!!
    print("Enter the client's email: ")
    val email = readLine()!!
    print("Enter the client's whatsapp: ")
    val whatsapp = readLine()!!
    print("Enter the client's profession: ")
    val profession = readLine()!!

    clients.add(Client(clients.size + 1, name, birthDate, sex, email, whatsapp, profession))
}

fun alterClient() {
    print("Enter the client's ID to be altered: ")
    val id = readLine()!!.toInt()
    val client = clients.find { it.id == id }
    if (client != null) {
        print("Enter the client's new name: ")
        client.name = readLine()!!
        print("Enter the client's new birth date: ")
        client.birthDate = readLine()!!
        print("Enter the client's new sex: ")
        client.sex = readLine()!!
        print("Enter the client's new email: ")
        client.email = readLine()!!
        print("Enter the client's new whatsapp: ")
        client.whatsapp = readLine()!!
        print("Enter the client's new profession: ")
        client.profession = readLine()!!
    } else {
        println("Client not found.")
    }
}

fun deleteClient() {
    print("Enter the client's ID to be deleted: ")
    val id = readLine()!!.toInt()
    val index = clients.indexOfFirst { it.id == id }
    if (index != -1) {
        clients.removeAt(index)
    } else {
        println("Client not found.")
    }
}

fun main() {
    while (true) {
        print("1. List clients\n2. Register client\n3. Alter client\n4. Delete client\n5. Exit\nChoose an option: ")
        when (readLine()!!.toInt()) {
            1 -> listClients()
            2 -> registerClient()
            3 -> alterClient()
            4 -> deleteClient()
            5 -> return
            else -> println("Invalid option.")
        }
    }
}