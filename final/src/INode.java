import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public interface INode<T> {
	int count();
	T getNode(int position);
	INode<T> removeNode(int position);
	INode<T> getNodes(Predicate<T> tester); // Filter method
	String toString();
	<R> INode<R> map(Function<T, R> function); // Map method
	<U> U fold(U identity, BiFunction<U, T, U> accumulator); // Fold method
}