
public class Link<T> {

		public Link previous;
		public Link next;
		private int index;
		public T data;
		
		public Link(T in) {
			
			data = in;
			previous = null;
			next = null;
			
		}
		
		public void setIndex(int in) {			
			index = in;
		}
		
		public int getIndex() {
			return index;
		}
}
