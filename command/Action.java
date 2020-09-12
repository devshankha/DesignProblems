package command;

//similar to Command interface

public interface Action {

	void execute();

	void undo();

	String getName();
}