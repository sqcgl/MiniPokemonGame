import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmptyNode<T> implements INode<T> {
	public int count() {return 0;}
	public T getNode(int position) {return null;}
	public INode<T> removeNode(int position) {return this;}
	public INode<T> getNodes(Predicate<T> tester){return new EmptyNode<T>();}
	public String toString() {return "";}
	public <R> INode<R> map(Function<T, R> function){return new EmptyNode<R>();}
	public <U> U fold(U identity, BiFunction<U, T, U> accumulator) {return identity;}
}
