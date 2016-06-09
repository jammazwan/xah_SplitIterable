### SplitIterable NOTES:

Run XahTest. Three different routes are run, each demonstrating variations on the same theme.

A more thoughtful reader might read this x__project example and conclude _'Hey! Wait a minute! You could have collapsed all of the x__Split__ projects into this one, because they all eventually do this same thing!'_ You would be right, as far as I can tell.

Three different routes are shown, A, B, C. 

### A - Body already is an Iterable

See funny story below, but main thing you have to do here is **_nothing_**.

If the body is already a List, _split().body()_ is all you need. Done.

### B - Bean returns body as an Iterable 

The use case for this example: **The manager wants the six man team to be split in two.**

Seems too simple to explain, but if you reference a bean which returns the body as Iterable, your work is complete.

### C - (any) operation or expression returns body as an Iterable

The use case for this example: **The team has decided to adopt pair programming.**

Hundreds of examples would still not be enough to exhaust the many ways of approaching this, so I just used one from the camel-core code.

From this you can extrapolate that any expression which accomplishes the conversion of the body into an Iterable will do the trick of provisioning a split() 

### Funny Story

The first time I had to split a list of objects, I looked for a long time in all 167 examples of .split( that I could find in camel-core. I was looking for an argument to use with split( that would tell it what to expect. But when I finally found it I wouldn't believe it and just kept looking.

When a body is an iterable, all you need is split().body(). Too simple for me to believe. 