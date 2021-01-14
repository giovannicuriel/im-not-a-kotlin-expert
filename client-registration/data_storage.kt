package br.giovannicuriel.rentalshop.data_storage

data class Movie (
    name: String,
    releaseDate: String,
    genre: String,
    publisher: String,
    performers: ArrayList<String>,
    director: String,
    id: String,
    lenght: Int,
    rating: Int
)
    