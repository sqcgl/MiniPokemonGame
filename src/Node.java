import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class Node<T> implements INode<T> {
	
	private T t;
	private INode<T> nextNode;
	
	public Node(T t, INode<T> nextNode) {
		this.t = t;
		this.nextNode = nextNode;
	}
	
	public int count() {
		return 1 + nextNode.count();
	}
	
	public T getNode(int position) {
		if (position == 0) {
			return t;
		}
		return (T)nextNode.getNode(--position);
	}
	
	public INode<T> removeNode(int position) {
		if(position == 0) {
			return (INode<T>)nextNode;
		} else {
			nextNode = nextNode.removeNode(--position);
			return this;
		}	
	}
	
	public INode<T> getNodes(Predicate<T> tester)
	{
	  if (tester.test(t))
	  {
		  return new Node<T>(t, nextNode.getNodes(tester));
	  }
	  else 
	  {
		  return nextNode.getNodes(tester);
	  }
	}
	
	public String toString() {
		return t.toString() + nextNode.toString();
	}
	
	public <R> INode<R> map(Function<T, R> function) {
		return new Node<R>(function.apply(t), nextNode.map(function));
	}
	
	public <U> U fold(U identity, BiFunction<U, T, U> accumulator) {
		return nextNode.fold(accumulator.apply(identity, t), accumulator);
	}
}
