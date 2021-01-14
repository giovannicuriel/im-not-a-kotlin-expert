# Database models

In this document, we will Think about all the database models we could use to register?

Clients registration
Inventory
Rentals


Therefore, we could Store everything needed to keep the rental shop running.


We could model the clients registration as:
- client name
- clients address (including street address, house number, City name, state, ZIP Code)
- favorite movie genres
- unique identifier

For the inventory, we could set its database model as:

- movie name movie
–movie release date
–movie genre
–movie publisher
–main actors and actresses
–Director
–some sort of unique ID, just like ISBN for books
–movie length(in minutes)
–may metacritic ratings

For the rentals records, we could set its database model as:

–clients hygiene
–movie id
–date
–Price
–discounts
–Notes (this attribute Will hold an extra name information related to this rental)


And that's all.

Oh this information will be stored in-memory. In the future, they will be moved to a persistent database such as MongoDB. But for now this is enough.