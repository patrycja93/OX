# About "OX"

Author: Patrycja Hyjek

### Information about project

Prerequisites: 
* java version 11
* minimum maven version 3.6.0

### Launching

The game has 3 modes. 
1. Normal game with 2 players.
2. Automatic tests.
3. Computer with player(under construction).

##### Ad. 1
There are two arguments. Number of matches are always 3.
* board size - default 3
* unbroken line - default 3

`mvn clean package`

`java -jar ./target/ox-1.0.0.jar board_size unbroken_line`

##### Ad. 2

There are three arguments. Number of matches are calculate based on the possibility of winning.
Number of matches for draw are set on default value equals 1.
* arg1 - board size
* arg2 - unbroken line
* arg3 - checking towards (0-horizontal, 1-vertical, 2-diagonal up, 3-diagonal down, 4 - draw)

`mvn clean package`

`java -jar ./target/ox-1.0.0.jar arg1 arg2 arg3`

Results from demo will be saved in: src/main/resources/pl/patrycja/ox/ui/test_out.txt


##### Ad. 3

There is also developed mode the game with computer. But now you can only choose the language and enter the player name.
The board size, unbroken line and number of matches are set on default value equals 3.

`mvn clean package`

`java -jar ./target/ox-1.0.0.jar`

###### TIPS: If your boar size will be lower than unbroken line the values will be switched. If your board size or unbroken line will be lower than 3 the values will be set on default value equals 3.
                                                    
                                                    


