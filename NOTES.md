There are so many approaches to splitting a message body that I found it helpful to break it into different projects.

### Common to all x__Split___ Projects

There are often many different ways to split even just one kind of body. This is where Camel's "does everything to anything" approach can be a bit confusing to the newbie. You may eventually want to learn 20 great approaches, but right now you just want one specific approach that's going work for your use case.

So each Split___ example project has to show, and/or cross reference, working code that makes each of the relevant approaches work, quickly and without a bunch of cruft.

**All Split___ example projects** were inspired by a grep of **'.split('** on **'*Test.java'** in the actual **camel-core** code base - hundreds of examples. A good place to start, if you want a more in depth exploration of anything, not just '.split('.

You will probably want to read [**this doc on Camel's site**](http://camel.apache.org/splitter.html) before doing much with splits. It took me a week to find it, and ended up being one of the best sources.

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