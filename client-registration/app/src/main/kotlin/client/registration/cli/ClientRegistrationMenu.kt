package client.registration.cli

import java.util.Scanner;

import client.registration.repository.DataStore;
import client.registration.dto.Client;
import client.registration.dto.Address;

class ClientRegistrationMenu(
  val datastore: DataStore
) {

  val scanner = Scanner(System.`in`)

  fun forceReadLine(message: String) : String {
    var inputString: String? = null;
    while (inputString == null) {
      println(message);
      inputString = readLine();
    }
    return inputString;
  }

  val registerClient = fun () {
    println("Registering a new client")
    var newClient = Client(
      "1",
      forceReadLine("Client name;"),
      Address(
        forceReadLine("Street: "),
        forceReadLine("Number: ").toInt(),
        forceReadLine("City: "),
        forceReadLine("State: "),
        forceReadLine("Zip code: ")
      ),
      forceReadLine("Birthday: "),
    );
    datastore.save(newClient);
  }

  fun buildMenu(): Command {
    return Command("client", this.registerClient, null);
  }
}