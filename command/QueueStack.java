package command;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

class QueueStack<T> {

    private LinkedList<T> dataCollection;

    QueueStack() {
        dataCollection = new LinkedList<>();
    }

    void push(T item) {
        dataCollection.add( item);
    }

    Optional<T> pop() {
    	
        if(dataCollection.size() > 0)
        	return Optional.of(dataCollection.remove());
        else
            return Optional.empty();
    }

    void clear() {
        dataCollection.clear();
    }

}