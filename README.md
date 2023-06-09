# Design Patterns

## Chain of responsibility

Filtering access shows how a request containing user data passes a sequential chain of handlers that perform various
things such as authentication, authorization, and validation.
From: https://refactoring.guru/design-patterns/chain-of-responsibility/java/example

## Command

Text file implement all functionality required for performing some text-file
related operations, such as opening, writing, saving a text file, and so forth.
From: https://www.baeldung.com/java-command-pattern

## Observer

Text editor example each time the Editor object changes, it notifies its subscribers. EmailNotificationListener and 
LogOpenListener react to these notifications by executing their primary behaviors.
From: https://refactoring.guru/design-patterns/observer/java/example

## State

Package which is sent to a post office, the package itself can be ordered, then delivered to a post office and finally 
received by a client. Now, depending on the actual state, we want to print its delivery status.
From: https://www.baeldung.com/java-state-design-pattern

## Strategy

Payment methods is used to implement the various payment methods in an e-commerce application. After selecting a product 
to purchase, a customer picks a payment method: either Paypal or credit card.
From: https://refactoring.guru/design-patterns/strategy/java/example

## Visitor

Exporting shapes into XML export a set of geometric shapes into XML. The catch is that we don’t want to change the code 
of shapes directly or at least keep it to the minimum.
From: https://refactoring.guru/design-patterns/visitor/java/example

## Template Method

Template Method pattern defines an algorithm of working with a social network. Subclasses that match a particular social 
network, implement these steps according to the API provided by the social network.
From: https://refactoring.guru/design-patterns/template-method/java/example

## Mediator

Imagine we're building a simple cooling system that consists of a fan, a power supply, and a button. Pressing the button
will either turn on or turn off the fan. Before we turn the fan on, we need to turn on the power. Similarly, we have to 
turn off the power right after the fan is turned off.
From: https://www.baeldung.com/java-mediator-pattern

## Interpreter
Create a simple SQL-like syntax in an object-oriented way, which will be then interpreted and return us the result.
From: https://www.baeldung.com/java-interpreter-pattern
