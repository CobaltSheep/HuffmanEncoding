import java.util.ArrayList;
import java.util.List;

public class Heap<T extends Comparable<T>> {


	List<T> heap = new ArrayList<>();

	public Heap(){

	}
	/**
	 * returns the size of the heap.
	 * @return
	 */
	public int size() {
		return heap.size();
	}
	/**
	 * adds to the heap
	 * @param n
	 */
	public void add(T n) {

		heap.add(n);


		int child = heap.size() - 1;
		int parent = (child -1)/2;

		if( parent < 0 ) {
			return;
		}

		T parentNode = heap.get(parent);
		T childNode = heap.get(child);

		while(parentNode.compareTo(childNode) > 0 && parent != child) {
			T k = heap.get(parent);
			heap.set(parent, heap.get(child));
			heap.set(child, k);

			child = parent;
			parent = (child -1)/2;

			parentNode = heap.get(parent);
			childNode = heap.get(child);
		}

		

		


	}
	/**
	 * removes from the Heap
	 * @return
	 */
	public T remove() {
		T removed = heap.get(0);

		int end = heap.size()-1;

		heap.set(0, heap.get(end));

		heap.remove(end);



		int parent = 0;
		int min = -1;

		while(min!=parent) {
			min = parent;
			for(int i = 1; i<=2; i++) {
				if((parent*2)+i<heap.size() && heap.get(min).compareTo(heap.get((parent*2)+i)) > 0) {
					min = (parent*2)+i;
				}
			}
			if(min!=parent) {
				T k = heap.get(parent);
				heap.set(parent, heap.get(min));
				heap.set(min, k);

				min = -1;


			}
		}


		return removed;


	}

	/**
	 * returns a string version of the heap.
	 */
	public String toString() {
		return heap.toString();

	}
}
