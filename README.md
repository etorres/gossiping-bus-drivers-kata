# Gossiping Bus Drivers Kata, Now with Extra Lambda

Problem description: http://kata-log.rocks/gossiping-bus-drivers-kata

## Introduction

I'm proposing a slightly different way to do this kata by introducing a template and a few rules to guide the kata. My intention is to practice the use of lambda expressions with Java.

## Sets as a basis for the kata

The following is an example adapted from the original kata. For the next 8 hours, 3 bus drivers (Dave, Anna, and John) will drive around the city following their respective routes:

![Example 1](https://raw.githubusercontent.com/etorres/gossiping-bus-drivers-kata/master/images/Image1.png "Example 1")

Initially, each driver knows only one gossip. This is represented as 3 different sets named after the drivers:

![Initial stage](https://raw.githubusercontent.com/etorres/gossiping-bus-drivers-kata/master/images/Image2.png "Initial stage")

At minute 0, Dave and Anna coincides in the stop 3, so they exchange all the gossips they know. This is represented as a merge operation where sets 

![Minute 0](https://raw.githubusercontent.com/etorres/gossiping-bus-drivers-kata/master/images/Image3.png "Minute 0")



![Minute 1](https://raw.githubusercontent.com/etorres/gossiping-bus-drivers-kata/master/images/Image4.png "Minute 1")



![Minute 4](https://raw.githubusercontent.com/etorres/gossiping-bus-drivers-kata/master/images/Image5.png "Minute 4")
