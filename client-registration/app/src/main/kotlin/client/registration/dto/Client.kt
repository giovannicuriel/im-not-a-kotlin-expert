package client.registration.dto

data class Address (
  val street: String,
  val number: Int,
  val city: String,
  val state: String,
  val zipcode: String,
)

data class Client (
  val id: String,
  val name: String,
  val address: Address,
  val birthday: String,
)