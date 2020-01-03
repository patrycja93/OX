# About "OX"

Author: Patrycja Hyjek

### Launching

1. Prerequisites: JDK 11, Maven 3
2. Setup: nothing aside from prerequisites
3. Launch game:

Game launches with default values it means: board size - 3x3 and unbroken line - 3.
* `mvn clean package`
* `java -jar ./target/ox-1.0.0.jar`

4. Demo mode: 

In demo mode you have possibility to put three arguments:

* arg1 - board size

* arg2 - unbroken line

* arg3 - checking towards (0-horizontal, 1-vertical, 2-diagonal up, 3-diagonal down)

* `mvn clean package`
*  `java -jar ./target/ox-1.0.0.jar arg1 arg2 arg3`

For example `java -jar ./target/ox-1.0.0.jar 5 4 0`
Results from demo will be saved in: main/resources/pl/patrycja/ox/ui/test_out.txt

### Tips:

1. If you put the second argument greater than first in demo mode, argument will be switched.
2. If amount of arguments will be different than three, game will launch in normal mode.


### Future

In the future the user will have possibility to put two arguments:

* arg1 - board size
* arg2 - unbroken line
                                                    
                                                    


