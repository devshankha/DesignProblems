package command;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * https://medium.com/better-programming/utilizing-the-command-pattern-to-support-undo-redo-and-history-of-operations-b28fa9d58910
 * 
 * The following diagram outlines the main components:
The Action interface which includes two methods, execute and undo.
Two modified linked lists, which I like to call ‘queue-stacks’ because they push like a stack and pop like a queue, and
the CommandManager, which is going to handle the core functionality, executing actions and performing undo/redo.
Note that the execute method of the CommandManager requires an array of actions, as, for example,
 Every executed action will be registered in the QueueStackNormal — when performing undo, that action will be popped, undo method will be called
  and   be pushed to QueueStackReverse, and vice-versa for the redo operation.
 * 
 * The clear method is used to clear all registered actions. It will be useful to provide two clear methods for each queue-stack so that after 
 * some undo operations (when the QueueStackReverse is populated) the user draws another rectangle on the board. We also might want to empty 
 * that queue-stack so that clicking redo won’t cause any unwanted behavior.
Assuming that the logical explanation is clear, we can proceed to the coding. This should be easy now that we’ve formally defined the components
 and interactions. The code can be found at this link.
First of all, we define the QueueStack, which is implemented as a generic class. This data structure uses a LinkedList internally. 
It behaves like a stack when adding an item to it (the item is added at the beginning) and as a queue when popping elements 
(the last element is removed and returned).

Next, we define the Action interface. Every class that is going to implement it should provide an implementation for:
The method execute, which will be called when the action is logged and needs to perform the required operations
undo, which will be called when that action gets undone
A utility method, getName that will be used to display the history of actions.
Note that the code could be simplified further by defining Action as an abstract class.

Finally, we implement the CommandManager, modeled as a singleton since it internally manages the state of the actions and history through 
respective data structures. The CommandManager allows the execution of a list of actions, performing undo and redo as well as retrieving the 
history of operations.

 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * @author dev
 *
 */











public class Main {
	public static void main(String[] args) {
		CommandManager manager = CommandManager.getInstance();
		List<Action> actionList = new ArrayList<>();
        actionList.add(new Action1("Action 1"));
        actionList.add(new Action2("Action 2"));
        manager.execute(actionList);

        manager.undo();
        manager.redo();

        System.out.println("=========");
        manager.clearNormal();
        manager.undo();
        manager.redo();

        System.out.println(manager.getActionHistory().toString());
        
        
		


	}

}
