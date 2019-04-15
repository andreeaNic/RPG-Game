University Project: RPG game in command line
Programming Languague: Java


This is an basic RPG game in command line, made using different design patterns and OOP concepts. This is a short presentation of all the parts of this project:

Command Folder: I used the Command Pattern to be able to execute the commands given by the player. CommandManager helps by creating a command stack, keeping track in which needs to be executed, undone or redone specifically.

Entities Folder: I made the general class Hero for the basic character's parameters and methods. Then I extended in the three possible playable characters, Mage, Priest and Warrior.
	Aldso here we have the Monster and Treasurer classes.

Factories Folder: By using Factory Pattern, the game generates the three types of entities that we will see on the map.

Observers Folder: This classes help the player discover the map as the game unfolds by using the observer pattern.

Strategies Folder: Strategy Pattern helps switch between defence or offence when faced with a threat.

Game Folder: Gamestate - represents the game current state. It's also the observable class that we use for the observers in our Observers Folder.
	    Main - let's the game unfold and presents the current actions the player can use.





