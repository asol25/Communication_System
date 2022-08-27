# Communication_System

## Introduction

There will be Customers, Operators, and Bills.

Customers talk and send message with other Customers.
Customers also connect internet.

Operator calculate costs for each minute talk, cost message and usage internet.

Every customer will have their unique Bill that stores and do the necessary actions about their spending.

You’re going to take the input as an input file, do the operations, and will print out the necessary information to the output file. There will be no System.in arguments, in other words, there will not be any input given with the keyboard while the program runs.

## Classes and Implementation Details

There will be 5 classes interacting with each other in this project.

- Main
- Process
- Customer
- Operator
- Bill

Note that, it will be better to do the necessary calculations via using corresponding methods in the Customer, Operator, or Bill class, not in the main Class. Some parts of the main class are given to you call process and it given action (input-output operations); however, the other 3 classes are given completely empty. You’re expected to fill these classes with the given directions.

## Input/Output
You’re going to read the input file line by line or token by token. The first 3 lines
will be integers. In the first line, the number “Cus” represents the number of customers
who will be in this project. The second line has the number “Oper” which tells you the
number of Operators in the project. In the third line, the number “Net” will represent
the number of events that are going to be simulated.

Next Net lines are going to be operations with the given rules:

```
1 - Creating a new Customer
2 - Creating a new Operator
3 - A customer can talk to another customer
4 - A customer can send a message to another customer
5 - A customer can connect to the internet
6 - A customer can pay his/her bills.
7 - A customer can change his/her operator
8 - A customer can change his/her Bill limit
```

### Output
You should calculate the following and print them out to the output file.

1. For each operator, you should print out, the amount of time that they serviced for
talking, number of messages sent via that operator, amount of internet usage in terms
of MB that operator provided.

```
Operator <ID of the Operator> : <talking time> <num of messages> <MBs of usage>
```
2. For each customer, How much money that they spend for paying their bills and
the current debt at the end of the simulation in their bills.

```
Customer <ID of the Customer> : <total money spent> <current debt>
```

3. ID of the Customer that talks the most and the amount of time in terms of
minutes. (if 2 Customers are equal, then print out the one that has a smaller ID)

```
<name of the Customer> : <talking time>
```

4. ID of the Customer sends messages the most and the number of messages. (if 2 Customers are equal, then print out the one that has a smaller ID)

```
<name of the Customer> : <number Of Messages>
```
5. ID of the Customer that connects the internet the most and the amount in
terms of MBs. (if 2 Customers are equal, then print out the one that has a smaller ID)

```
<name of the Customer> : <connection amount> 
```
