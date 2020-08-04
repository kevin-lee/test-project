package example

object Hello extends Greeting with App {

  println(greeting)
}

trait Greeting {
  lazy val greeting: String = "hello"

  def foo(s: String): Unit = s match {
    case "a" =>
      println("a")
  }

  def bar(n: Int): Unit = n match {
    case 1 =>
      println("1")
  }

  import Greeting._

  def baz(something: Something): Unit = something match {
    case Something("a") =>
      println("a")

    case Something(_) =>
      println("else")
  }

}

object Greeting {
  final case class Something(s: String) extends AnyVal
}
