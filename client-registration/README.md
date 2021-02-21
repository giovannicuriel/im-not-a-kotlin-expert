# Movie rental shop

This simple example will be an application that reads and registers client
data. It will use an in-memory map for client storage (no persistence for now)
just for the sake of simplicity. But, before going into the technical details
of how it is implemented, let's imagine a situation that will help us getting
requirements right and useful.

## A tiny tale

Imagine that you live in a small city. You just graduated (during the pandemic
somehow) and call yourself a "super software developer" or, as your relatives
call you, "the computer-fixing boy". The city is very nice and everything is at
reach, you can go walking downtown and get back home in less than thirty
minutes. There are nice places to hang around with your friends, talk about
ordinary stuff, have some laughs and do not worry about a thing in the world.
You've realized long ago that your place is a special one. Everything is calm,
everyone is close, sunsets are seized, friends come over, there is no
loneliness. There's only warmth and care everywhere.

Mr. Mayfield owns the video rental shop in your neighborhood. He is a bit old,
around his eighties, and has owned the place ever since he was a young lad (it
all started with a music shop, though). His shop feels like a travel to the
80's - the carpet, the smell, the lights, the stands with all those movies (Mr.
Mayfield always says that "blu-ray" is misleading because the disc is not blue.
And they missed an "e"!). The fancy coffee maker was a nice recent addition to
the place - nothing is more delightful than a thursday afternoon having a nice
conversation with his wife, a cup of coffee and that wonderful butter cookie
she makes. Mr. and Mrs. Mayfield are indeed adorable. Everyone loves and
respects them. Although they are in an advanced age, there is no need to have
nothing but a notebook to register all the rentals and bills from the shop.
This has been a cozy small place since forever, everyone knows each other,
there was no need to keep track of such fine details such as client records, as
they keep saying. "Just keep a suficient amount of money going in and that's
all we need".

One day, Mr. Mayfield comes to your house. It's a cloudy day, a bit warm, seems
like it is going to rain soon. "I brought you something - a cake Sheila made
for you. Hope you like it!". "Of course! I love'm, they are so tasty and
moist!". As he enters the living room, you notice something is off - you don't
know exactly what it is, but something is different. Kind of a tension, worry
or sheer pressure. It is subtle, but definitely noticeable. You both have a
seat at the dinner table and you realize that he just can't keep his hands
still. "You know, we have been working in that shop for years now. You kids
come over everyday and its lovely to have you all there". Yes, definitely
noticeable. "We are getting older", shoulders down a bit and a very deep sigh.
He looks through the window. Wind got a little bit stronger. "And we are happy
with all we have. We are still open even with all that internet thing. These
people nowadays only want to have something delivered to them right away, with
no interaction at all".

"Is there something going on?" you ask. You are not sure whether he paid
attention to your question. He goes on: "I really wanted nothing to change, you
know? Why? Why can't we just stop time and stay where we are, in the way we
used to be?". You start to worry about the situation. He never looked so... it
is not sadness nor regret, it is something else. "You know, if I only
could...", he says while punching the table with his fist. The sound of it...
it startles him. He opens his eyes wide. You really don't know what is going
on. For you, everything is fine with him, his wife and his shop. Nothing seemed
to have changed at all. The rain starts falling - heavy drops hit the window
glass, strong winds howl. The trees at distance shake violently as if they try
to grab someone's attention so that they could be placed in a safer place. He
smiles at you - and that smile is not natural, you notice it right away.
"Sometimes Sheila... she seems far. This morning she stared at a cup of tea for
fifteen minutes or so. I tried to talk to her, but she didn't respond. I had to
shake her shoulders to wake her up and look at me. 'What' - she said softly".
He stops and sighs again. You feel the air thickening as he tries to keep
talking. He looks up, facing you away. "While looking at her, at that moment,
she became a beautiful withering rose under an unbreakable glass dome. I
couldn't do anything, I couldn't say anything... I just stared at her,
flummoxed. And this is happening more often than not. At first, I thought it
was just a joke, something she did to show me how 'focused' she was. But, I
don't think this is that simple. I'm afraid that...".

His voice deepens as he speaks. You don't know what you feel right now. A mix
of sadness, anxiety and a weird feeling of saudade of the present, all the
people you know, your neighborhood, your home. You look out the window: nothing
but the rain. You feel deep inside that things are changing. Things are going
to be different. This thought came in a split second and you feel... different.
Rain is pouring down like never before.

"As I am also getting older", he lightens up a bit, "I think I will need your
help". "Anything, anything!", you say cheerly. "I think that we could modernize
a bit the video rental shop, what do you think? I would like to start by small
things - I need an easier way of checking if a client has not yet returned a
movie when renting one. I... I just can't remember such things anymore. I don't
think that red notebook is helping me. Can we think something through?"

"Yes, sure we can". You can see cristal clear what he is worried about. You
know that you can't assist them in that matter but, at least, you are able to
help them keeping their shop up and running. You can build something to be ran
in that computer of theirs to track everything, all rented movies, bills,
everything going in and out. Nothing will be overlooked. As for the other
things, you could ask your aunt to help them there - cleaning, organizing,
talking to people - she wanted something to do after her retirement after all.
With all your help, both of them can spend the rest of their lives just
enjoying life together.

You are able to help them, you are so able to help them.

## Project development

As we yet does not know all the features will Mr. Mayfield want, it would be
nice to follow an agile approach. We know, for sure, that he wants to digitally
store many things he writes onto that notebook of his but neither he nor us
know what should be delivered in fine details.

So, in general, this project is:

> Develop a rental shop administration solution for a small size rental shop.

The first main objective is:

> We want to decrease by, let's say, 50% the number of rentals that are due
until next month.

How are we going to measure it? How do we know what's the current situation?
So, I asked my cousin to check that red notebook and what she's figured out is:

> There are currently 10 people who rented 21 movies in total and have not yet
returned them. Also, there are currently 30 people with 67 rented movies in
total (including those 10). Reading all the entries, we figured out that the
shop has 75 returning customers.

So, measuring it will be pretty easy: let's check if a customer has something
to return when trying to rent a new movie. If so, we won't rent it to the
customer. This is a harsh decision, but we need to keep the cash flow well
balanced.

Ok, fair enough. So, what we will do, really? As of right now, we can thing of
a couple of things that are important:

- We want to store and retrieve all rentals digitally:
  - Why: This is what Mr. Mayfield needs *right now*. His memory begins to fail
    and it won't be as good as it is now in the near future.
  - Who: Mr. Mayfield is impacted directly by this. Also, whoever will operate
    this system will be impacted also.
  - How: well, this is straightforward - registering and reading all rentals.
  - What: there should be a system for accessing these rentals.
- We want to check if a client is overdue:
  - Why: this will be useful to check whether a particular client has no debts
   and therefore is able to rent a few more movies. This will help the shop cash
   flow to be fine.
  - Who: Mr. Mayfield, obvisously, is indeed impacted by this feature. But also
    his customers. If someone has not yet paid the previous rental, new ones
    won't be available to be rented.
  - How: There should be a warning when a user is renting something, so that the
    operator will see if that operation should be completed or not.
  - What: a validation procedure to check whether the user has pending rented
    movies or not.

These two things are the most important. Should a new request appears, we can
analyze it carefully in the future.
