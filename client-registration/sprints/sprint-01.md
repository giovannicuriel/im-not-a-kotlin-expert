# Sprint 01

Let's recap what we said in the README:

Objective: We want to decrease by 50% the number of rentals that are due until
next month.

This can be split into two stories:

- Registering rentals
- Registering returns
- Checking whether client is overdue

So, let's explore each one of them.

## Registering rentals

As a teller, I want to digitally store and retrieve a customer rental,
so that I can check who rented what and when.

This is directly associated to the main objective, as we are able to know who
rented what.

Tasks:

- Build a user interface (CLI) to register all the rentals. The information
provided by the teller are:
  - Client name
  - Client ID
  - Movie ID
  - Returning Date
  - Price paid
- Persist this rental into the database
- Build a user interface (CLI) to retrieve all the rental. There should be a
  filter to select all the rentals for a specific customer.
- Read all the rentals from the database

## Registering returns

As a teller, I want to indicate that a customer has returned a movie, so that
I can check what's due and what's not.

This is also directly associated to the main objective, as this feature will
be the source to indicate whether a customer is due or not.

Tasks:

- Build a user interface (CLI) to indicate that a customer is returning a movie.
  The information provided by the teller are:
  - Client name
  - Client ID
  - Movie ID
- Update the rental information into the database indicating that this movie
  is returned.

It is important to note that each rental is stored individually. So if a
customer rents three movies, there will be three 'customer returns' operations.

## Overdue check

As a teller, I want to check whether a customer should have already returned
any movie she rented, if any, so that I can tell her that it would be better
if those movies were returned before renting more.

This is also directly associated to the main objective, as we have means to
check if a customer is overdue. So we can ask the customer to return all of
them. This way we can decrease the number of due movies and, hopefully, improve
the cash flow.

- Add a overdue blocking mechanism. This mechanism reads all the rented movies
  from this particular customer and returns if any of them is due.
- Change the rental registration mechanism in order to inform the teller if
  any movie rented by the customer is due. If so, no further movie rentals are
  allowed for that customer.
