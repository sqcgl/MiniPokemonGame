import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;


public class ADTList<T> {
	
	private INode<T> data;
	
	public ADTList() {
		this.data = new EmptyNode<T>();
	}
	
	public ADTList(T t) {
		this.data = new Node<T>(t, new EmptyNode<T>());
	}
	
	public ADTList(INode<T> data) {
		this.data = data;
	}
	
	public T getNode(int position) {
		if(position < 0 || position >= this.count()) {
			throw new IllegalArgumentException("Position out of range");
		}
		return data.getNode(position);
	}
	
    public T pop() {
    	if (this.isEmpty()) {
            throw new IllegalStateException("Cannot pop from an empty list");
        }
        T result = data.getNode(0); // Get the head of the list
        data = data.removeNode(0); // Remove the head of the list
        return result;
    }
	
	public void addNode(T t) {
		data = new Node<T>(t,data); // Add a node
	}
	
	public void makeHeadNode(int position) {
	    if (position < 0 || position >= this.count()) {
	        throw new IllegalArgumentException("Position out of range");
	    }
	    if (position == 0) {
	        // It's already the head node.
	        return;
	    }

	    // Retrieve the node at the specified position
	    T nodeData = this.getNode(position);

	    // Remove the node from its current position
	    this.removeNode(position);

	    // Add the node at the front of the list
	    this.addNode(nodeData);
	}
	
	public int count() {
		return data.fold(0, (acc, item) -> acc + 1);
	}
	
	public void removeNode(int position) { // Remove a node
		if(position < 0 || position >= this.count()) {
			throw new IllegalArgumentException("Position out of range");
		}
		data = data.removeNode(position);
	}
	
	public ADTList<T> getNodes(Predicate<T> tester)
	{
	    return new ADTList<T>(data.getNodes(tester)); 
	}
	
	public String toString() { // Print all nodes
		return data.toString(); 
	}
	
	public <R> ADTList<R> map(Function<T, R> function) {
		return new ADTList<R> (data.map(function));
	}
	
	public <U> U fold(U identity, BiFunction<U, T, U> accumulator) {
        return data.fold(identity, accumulator);
    }
	
	public boolean isEmpty() {
        return data instanceof EmptyNode;
    }
}
