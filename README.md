# cs56-languages-vocab-quiz

W15 Changes (Dan Luo)

In a previous iteration this game would work for a hard coded german text file copy.
![](http://i.imgur.com/mTfTOD6.png)

In W15 I attempted to fix the file read-in error occurring with ant run, and finding a way to choose languages, and not having a single hard coded file to read from. 

At the moment the game does not actually work anymore, but there is a new file called menu.java that serves essentially as a menu. To add new languages/things to the menu, add another button for what you wish to add, and add something to perform in the action listener. For an input file to be successfully read in, the file has to be placed in to the build directory. 

The menu and the game work separately, but not together. If one wishes to test the game, simply uncomment the code in ForeignVocabQuizGUI.java and call the constructor for it, then call .go() in the main function. I uncommented that portion of the code, as it does not run properly when called from menu. There appears to be issues with how the previous person attempted to implement the Action Listener that for some reason works when called directly from main. 

project history
===============
```
YES | mastergberry | TBD | A quiz that is designed to test the user's knowledge on foreign vocabulary
```
```
 W14 | bkiefer13 | TBD | A quiz that is designed to test the user's knowledge on foreign vocabulary
 W15 | pichumy | TBD | A quiz that is designed to test the user's knowledge on foreign vocabulary
```

## Documentation

* The code for reading in the file is located in the `FileRead` class. As you can see in the constructor, it is currently hard-coded for the one text file included. 

```java
public FileRead()
{
	this.filename = "/text/vocabulary.txt";
	this.list = new ArrayList<String>();
}
```
* The `ForeignVocabWord` class stores a foreign word and its English translation as Strings.
* The `ForeignVocabQuiz` class contains the basic logic for running the quiz. It reads in the file and sets up the list of possible words to test the user on. Currently, the foreign words and English words are located on alternating lines in the text file, but this could be improved to possibly use JSON or XML format.

## How to run 
To start the game, use `ant run`. 
