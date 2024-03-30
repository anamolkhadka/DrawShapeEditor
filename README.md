# Draw Shape Java Application

This is a Java draw shape editor application created for drawing shapes such as circles and boxes.

## Software Development Process
- Agile Unified Development

## Software Design Patterns
- Controller, Expert, Composite, and Iterator patterns

## Java API for GUI
- Java API JPanel

## Introduction
The homework assignment requires the student to design a simple application for drawing different shapes such
as circles and boxes. The design must apply the controller, expert, composite and iterator patterns. When the
application starts, it displays a window containing two buttons and a drawing area called canvas. The buttons
are labeled “Circle” and “Box,” respectively. When one of the buttons is clicked, and then the mouse is pressed
in the canvas, the corresponding shape is painted in the canvas at the location where the mouse was pressed.
Figure 1 shows a sample window with a circle and a box painted.

Hint: The assignment has one use case—that is, the Draw Shape use case. The software works in the background
as follows. When one of the buttons is clicked, the software remembers which button was clicked. This can be
achieved by using an attribute of the controller. When the mouse is pressed in the canvas, the software creates
the desired shape and adds it to the collection of shapes. The software then invokes the repaint() function of
the canvas, which extends the Java API JPanel and overrides its paintComponent(Graphics g) method. The
call to the repaint() function of the canvas automatically invokes the paintComponent(Graphics g) function of
canvas to paint the shapes stored in the collection of shapes. One trick here is that the collection of shapes
should store different types of shape, which requires you to apply the composite pattern.

## What to Do, Product and Submit

This individual homework assignment requires the student to do the following work items and submit the results
on Canvas (see Section 3 for how to submit your solution).

1. Apply the domain-model brainstorming rules to this homework assignment document to identify domainspecific/
app-specific phrases. Note: For this simple application, not all of the rules will identify a phrase.

2. Apply the domain-model classification rules to classify the identified phrases as classes, attributes, inheritance,
aggregation and association relationships. Note: For this simple application, not all of the OO
modeling concepts will be present in the classification result.

3. Convert the classification result to a UML class diagram, that is, a domain-model class diagram (DMCD).
Use a UML diagram tool of your choice, Microsoft Visio, or Word to draw the DMCD. You must use the
UML class diagram notations correctly.

4. Produce an expanded use case for the Draw Shape use case, assuming that the high-level use case is:
TUCBW the user clicking on a shape button.
TUCEW the user seeing the desired shape painted at the location clicked.

5. For each nontrivial step of the expanded use case you produce above, produce a scenario to describe how
the software objects interact with each other to process the actor request. Your scenario must apply the
controller, expert, composite and iterator patterns.

6. Convert each scenario to a scenario table.
   
7. Convert each scenario table to an informal sequence diagram, where the messages between the objects are
labeled by English texts. Indicate the patterns applied using UML notes or stereotypes.
A UML note is a mechanism to show comments in a UML diagram. It is a dog-ear shape containing the
comment and with a dashed line connecting to the UML notation to be commented. A UML stereotype
is a mechanism to introduce app-specific concepts such as design patterns (which are not UML modeling
concepts). A stereotype is shown by enclosing the non-UML concept in a pair of double-angle quotes like
“<< controller >>,” which is placed above the class name to indicate that the class is a controller.

8. Convert each informal sequence diagram to a design sequence diagram (DSD). Note: you can simply copy
and paste the informal sequence diagram and change the labels of the messages between the objects to
function calls between the objects.

9. Derive a design class diagram (DCD) from all of the design sequence diagrams. Indicate the patterns
applied using UML notes or stereotypes.

10. Implement your design in Java (not any other programming language). You may use Swing or AWT,
whichever you prefer. Provide comments in your code to show the patterns applied. Submit the complete
source code in a .zip or .rar file.

11. Compile your program and test run your application by adding a circle and two boxes, and produce a
screen shot to show the result.
