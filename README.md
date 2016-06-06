# Kata objective
The main goal is practice object oriented design via refactoring.

# Kata domain
##Goal
 Calculate the score for one line of American Ten-Pin Bowling.

##Scoring rules
- Each game, or _line_, of bowling includes ten turns, or _frames_, for the bowler.
- In each frame, the bowler gets up to two tries, or _rolls__, to knock down all the pins.
- If in two tries, he fails to knock them all down, his score for that frame is the total number of pins knocked down in his two tries.
- If in two tries he knocks them all down, this is called a _spare_ and his score for the frame is ten plus the number of pins knocked down on his next throw (in his next turn).
- If on his first try in the frame he knocks down all the pins, this is called a _strike_. His turn is over, and his score for the frame is ten plus the simple total of the pins knocked down in his next two rolls.
- If he gets a spare or strike in the last (tenth) frame, the bowler gets to throw one or two more bonus balls, respectively. These bonus throws are taken as part of the same turn. If the bonus throws knock down all the pins, the process does not repeat: the bonus throws are only used to calculate the score of the final frame.
- The game score is the total of all frame scores.

##Input
- String with the representation of the line.
- Each character represents one frame.
- The characters follow the rules:
	- X when is an strike (knock the 10 pins in the first try of the frame)
	- / when in the second try throws the remaining pins: spare.
	- - when no pin is knock in a try.
	- Number of the pins knock in a try.
- Example of the representation :
	- "35--6/--X--2/------" : 3+5 + 0+0 + 6+4 + 0+0 + 10 + 0+0 + 2+8 + 0+0 + 0+0 + 0+0

# Kata simplifications
- We will not check for valid rolls.
- We will not check for correct number of rolls and frames.
- We will not provide scores for intermediate frames.

# Some test cases
- "9-9-9-9-9-9-9-9-9-9-":
	- Meaning: 10 pairs of 9 and miss (20 rolls)
	- Score: 90 (9 + 9 + 9 + 9 + 9 + 9 + 9 + 9 + 9 + 9)
- "5/5/5/5/5/5/5/5/5/5/5"
	- Meaning: 10 pairs of 5 and spare, with a final 5 (21 rolls)
	- Score: 150 (10+5 + 10+5 + 10+5 + 10+5 + 10+5 + 10+5 + 10+5 + 10+5 + 10+5 + 10+5)
- "XXXXXXXXXXXX":
	- Meaning: 10 strikes + 2 strikes for the extra bonus (12 rolls)
	- Score: 300 (10+10+10 + 10+10+10 + 10+10+10 + 10+10+10 + 10+10+10 + 10+10+10 + 10+10+10 + 10+10+10 + 10+10+10 + 10+10+10)

# My solution
- **Bowling**: It's the glue to process all the steps.
- **StringRollParser**: Parser the string input into Roll objects.
- Roll package: No dependencies.
	- Roll: Value object. Contains the roll related information
	- RollParser: The interface to parse the input into Roll objects
- Frame: Dependencies with Roll.
	- Frame, Spare and Strike: Value objects. Contains the data related to each type of frame.
	- **FrameParser**: Transform the list of Rolls into a list of frames.
- Line: Dependencies with Frame.
	- Line: Handles the rolls as a line.
	- **LineScorer**: Knows how to score a line. It's the only class with score logic.

# Working process
1. Solve the kata using the simplest solution that I could find.
2. Refactor to objects to achieve single responsibility principle.
3. Following the Object Calisthenics rules:
	1. Only one level of indentation per method
	- Don't use the else keyword
	- Wrap all primitives and strings
	- First class collections
	- One dot per line
	- Don't abbreviate
	- Keep all entities small
	- No classes with more than two instance variables
	- No getters/setters/properties
4. Dividing in packages and reduce coupling between them.
 	
