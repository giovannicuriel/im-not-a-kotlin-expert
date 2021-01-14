# Movie rental shop

This simple example will be an application that reads and registers client data. It will use an in-memory map for client storage (no persistence for now) just for the sake of simplicity. But, before going into the technical details of how it is implemented, let's imagine a situation that will help us getting requirements right and useful.

## A tiny tale

Imagine that you live in a small city. You just graduated (during the pandemic somehow) and call yourself a "super software developer" or, as your relatives call you, "the computer-fixing boy". The city is very nice and everything is at reach, you can go walking downtown and get back home in less than thirty minutes. There are nice places to hang around with your friends, talk about ordinary stuff, have some laughs and do not worry about a thing in the world. You've realized long ago that your place is a special one. Everything is calm, everyone is close, sunsets are seized, friends come over, there is no loneliness. There's only warmth and care everywhere.

Mr. Mayfield owns the video rental shop in your neighborhood. He is a bit old, around his eighties, and has owned the place ever since he was a young lad (it all started with a music shop, though). His shop feels like a travel to the 80's - the carpet, the smell, the lights, the stands with all those movies (Mr. Mayfield always says that "blu-ray" is misleading because the disc is not blue. And they missed an "e"!). The fancy coffee maker was a nice recent addition to the place - nothing is more delightful than a thursday afternoon having a nice conversation with his wife, a cup of coffee and that wonderful butter cookie she makes. Mr. and Mrs. Mayfield are indeed adorable. Everyone loves and respects them. Although they are in an advanced age, there is no need to have nothing but a notebook to register all the rentals and bills from the shop. This has been a cozy small place since forever, everyone knows each other, there was no need to keep track of such fine details such as client records, as they keep saying. "Just keep a suficient amount of money going in and that's all we need".

One day, Mr. Mayfield comes to your house. It's a cloudy day, a bit warm, seems like it is going to rain soon. "I brought you something - a cake Sheila made for you. Hope you like it!". "Of course! I love'm, they are so tasty and moist!". As he enters the living room, you notice something is off - you don't know exactly what it is, but something is different. Kind of a tension, worry or sheer pressure. It is subtle, but definitely noticeable. You both have a seat at the dinner table and you realize that he just can't keep his hands still. "You know, we have been working in that shop for years now. You kids come over everyday and its lovely to have you all there". Yes, definitely noticeable. "We are getting older", shoulders down a bit and a very deep sigh. He looks through the window. Wind got a little bit stronger. "And we are happy with all we have. We are still open even with all that internet thing. These people nowadays only want to have something delivered to them right away, with no interaction at all".

"Is there something going on?" you ask. You are not sure whether he paid attention to your question. He goes on: "I really wanted nothing to change, you know? Why? Why can't we just stop time and stay where we are, in the way we used to be?". You start to worry about the situation. He never looked so... it is not sadness nor regret, it is something else. "You know, if I only could...", he says while punching the table with his fist. The sound of it... it startles him. He opens his eyes wide. You really don't know what is going on. For you, everything is fine with him, his wife and his shop. Nothing seemed to have changed at all. The rain starts falling - heavy drops hit the window glass, strong winds howl. The trees at distance shake violently as if they try to grab someone's attention so that they could be placed in a safer place. He smiles at you - and that smile is not natural, you notice it right away. "Sometimes Sheila... she seems far. This morning she stared at a cup of tea for fifteen minutes or so. I tried to talk to her, but she didn't respond. I had to shake her shoulders to wake her up and look at me. 'What' - she said softly". He stops and sighs again. You feel the air thickening as he tries to keep talking. He looks up, facing you away. "While looking at her, at that moment, she became a beautiful withering rose under an unbreakable glass dome. I couldn't do anything, I couldn't say anything... I just stared at her, flummoxed. And this is happening more often than not. At first, I thought it was just a joke, something she did to show me how 'focused' she was. But, I don't think this is that simple. I'm afraid that...".

His voice deepens as he speaks. You don't know what you feel right now. A mix of sadness, anxiety and a weird feeling of saudade of the present, all the people you know, your neighborhood, your home. You look out the window: nothing but the rain. You feel deep inside that things are changing. Things are going to be different. This thought came in a split second and you feel... different. Rain is pouring down like never before.

"As I am also getting older", he lightens up a bit, "I think I will need your help". "Anything, anything!", you say cheerly. "I think that we could modernize a bit the video rental shop, what do you think? I would like to start by small things - I need an easier way of checking which movies I have. I don't think that red notebook is helping me anymore. Can we think something through?"

"Yes, sure we can". You can see cristal clear what he is worried about. You know that you can't assist them in that matter but, at least, you are able to help them keeping their shop up and running. You can build something to be ran in that computer of theirs to track everything, all rented movies, bills, everything going in and out. Nothing will be overlooked. As for the other things, you could ask your aunt to help them there - cleaning, organizing, talking to people - she wanted something to do after her retirement after all. With all your help, both of them can spend the rest of their lives just enjoying life together.

You are able to help them, you are so able to help them.


## The shop management system

This movie rentals shop management system should be supposed to:

1) List all purchased movies, including date of purchase, price and seller
2) List all clients
3) Register the rental of a set of movies to a particular client (including dates, price and eventually discounts)
4) List all due movies
5) Get a history of rented movies per client
6) All user interactions wil be performed through a CLI-based terminal. Nice and green.

For now, there is no need for disk persistency for the registered data (as of now, I don't know how to deal with MongoDB connections with Kotlin, sorry for that ;D) and no user interface. C'mon, the shop is 80's themed. Nothing looks more like the 80's than a small green phosphor CRT monitor displaying a nice ASCII art with a cursor-based menu. Now let's delve into the awsome details of each feature.

For now, let's just explore a bit the three first ones, as they are directly related to database access. All other ones are going to be detailed in the future.

### Inventory

As a movie rental shop, there must be a way to register everything there is to be rented. Some professionals would call this "inventory". So, what should be registered, exactly? We don't know yet what these entries will be used for, how can we know what it should look like? Let's get the basics straight: it should be something like a movie database, so that all rentals are correctly registered. It would be enough to store:
- Movie name
- Any unique ID related to the movie (just like ISBN for books)
- Genre

Should we need extra data, we could simply add them to the document stored in MongoDB, no need to worry right now. For instance, let's suppose that we want to get the 5 most preferred movie actors, so that we could ask our supplier for more movies with that list as lead actors/actress. As we have already registered all rented movies by its ID, it would suffice to add the leading actors list to its document and there it is! A nice favorite-actor-per-customer report.

### Clients

As for the clients, it would be enough to have these parameters:

- Client full name
- clients address
–clients preferred movies genre

The same premises from inventory are valid here: should we need any extra data, we could simply add them here.

### Rental registration

We also need to register each client's rentals, so that we keep track of which movies are most requested and what is due. We need the following information to be stored (we don't yet care of how or where these data are persisted):

- Date
- List of rented movies
- Return date per movie
- Total price
- Price per movie
- Notes

This is all that we need to register each clients rentals and everything in inventory.

