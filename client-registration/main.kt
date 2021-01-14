data class CLICommand (
    val command: String,
    val fn: () -> Unit,
    val children: List<CLICommand>?
) {
    fun print(preamble: String = " ") {
        println("${preamble}- $command")
        if (children != null) for (command in children) command.print(preamble + "  ")
    }
}

fun startClientRegistrationMenu(preamble: String): Unit {
    println("##### Client Registration Menu #####")
    println("$preamble -> ")
}

val openClientRegistrationMenu = fun () {
    println("THIS IS CLIENT REGISTRATION MENU. WELCOME.")
}

fun buildClientRegistrationMenu() : CLICommand {
    return CLICommand("client", openClientRegistrationMenu, listOf(
            CLICommand("add-client", {
                println("Adding client")
            }, null),
            CLICommand("list-clients",  {
                println("Retrieving all clients")
            }, null)
        )
    )
}

fun main() {
    startClientRegistrationMenu("RentalShop")
    //var add
    val clientRegistrationMenu = buildClientRegistrationMenu()
    clientRegistrationMenu.print()
}