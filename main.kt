class Customer(val name: String) {
  val customerKey = name.toUpperCase();
}

fun fibonacciRecursive(a: Long): Long {
  if (a == 0L) {
    return 0;
  } else if (a == 1L) { 
    return 1;
  }
  return a + fibonacciRecursive(a - 1L);
}

fun fibonacciLoop(a: Long): Long {
  var total = 0L;
  var x = 1L;
  while (x <= a) {
    total += x;
    x++;
  }
  return total;
}
fun sum(a: Long, b: Long): Long {
  return a + b
}

fun main(args: Array<String>) {
    println("Hello, world!");
    val total = sum(10, 20);
    println(total);
    println("Arguments: ${args[0]}");
    println("Fibonacci 10");
    println(fibonacciRecursive(10));
    // println("Fibonacci loop 1000000");
    // println(fibonacciLoop(args[0].toLong()));

    val c1 = Customer("Giovanni");

    println(c1.name);
    println(c1.customerKey);
    c1.name = "Curiel";
}