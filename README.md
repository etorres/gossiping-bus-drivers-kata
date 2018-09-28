# Gossiping Bus Drivers Kata, Now with Extra Lambda

Problem description: http://kata-log.rocks/gossiping-bus-drivers-kata

## Introduction

I'm proposing a slightly different way to do this kata by introducing a template and a few rules to guide the kata. My intention is to practice the use of lambda expressions with Java.

## Setting the basis for the kata

The following is an example adapted from the original kata. For the next 8 hours, 3 bus drivers (<span style="color:green;font-weight: bold">&bull;</span> Dave, <span style="color:red;font-weight: bold">&bull;</span> Anna, and <span style="color:yellow;font-weight: bold">&bull;</span> John) will drive around the city following their respective routes:

![Example 1](https://raw.githubusercontent.com/etorres/gossiping-bus-drivers-kata/master/images/Image1.png "Example 1")

![Initial stage](https://raw.githubusercontent.com/etorres/gossiping-bus-drivers-kata/master/images/Image2.png "Initial stage")

Initially, each driver knows only one gossip. Dave knows gossip G1, Anna knows gossip G2, and John knows gossip G3:

![Initial stage](https://raw.githubusercontent.com/etorres/gossiping-bus-drivers-kata/master/images/Image3.png "Initial stage")

At minute 0, Dave meets Anna at stop 3 and they exchange all the gossips they know. This is modelled using a merge operation where sets G1 and G2 are merged together into the set G1-G2: 

![Minute 0](https://raw.githubusercontent.com/etorres/gossiping-bus-drivers-kata/master/images/Image4.png "Minute 0")

At minute 1, Anna meets John at stop 2 and she merges the set G1-G2 with G3. Now both John and Anna know all the gossips.

![Minute 1](https://raw.githubusercontent.com/etorres/gossiping-bus-drivers-kata/master/images/Image5.png "Minute 1")

It's not until minute 4 that Anna meets Dave again at stop 3, and she merges G1-G2-G3 with G1-G2:

![Minute 4](https://raw.githubusercontent.com/etorres/gossiping-bus-drivers-kata/master/images/Image6.png "Minute 4")

In total, they need 4 minutes and 5 stops to spread all the gossips.

## Additional Rules

This kata becomes really interesting when you don't use any:

* Loops: `for`, `while`, or `do-while`
* Conditionals: `if-else`, or `switch`

_Note:_ I have to use a ternary operator in one of the auxiliary classes of my solution. If you find a better way to do it, please share it.

## Baby Steps

If you are new to lambda expressions I would recommend you to do this kata in the following incremental steps:

1. Use an internal iteration to step sequentially through the stops of the routes, until all the gossips are spread or until the end of the day, whatever comes first.
2. Use a function to group drivers by stop.
3. Use another function to exchange gossips with the drivers who meet at the same stop.
4. A function will check that all drivers are on board with the latest gossips.
