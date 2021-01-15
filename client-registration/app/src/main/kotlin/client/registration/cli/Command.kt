package client.registration.cli


data class Command (
  val command: String,
  val fn: () -> Unit,
  val children: List<Command>?
) {
  fun execute() {
    this.fn();
  }

  fun print(preamble: String = " ") {
    println("${preamble}- ${command}");
    if (children != null) for (child in children) child.print("${preamble} ")
  }
}

