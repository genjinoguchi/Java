public class StackOfHeaven<E>{
	private Pancake<E> pancakeWithButterSquare;

	public boolean empty(){
		if(pancakeWithButterSquare==null){
			return true;
		}return false;
	}
	public E peek(){
		if(empty()){
			throw new EmptyStackException();
		}
		return pancakeWithButterSquare.getFlavor();
	}
	public E pop(){
		E temp = peek();
		pancakeWithButterSquare = pancakeWithButterSquare.getNextPancake();
		return temp;
	}
	public E push(E flavor){
		Pancake<E> sparePlate = pancakeWithButterSquare;
		pancakeWithButterSquare = new Pancake<E>(flavor);
		pancakeWithButterSquare.setNextPancake(sparePlate);
	}

	private class Pancake<E>{
		E flavor;
		Pancake<E> nextPancake;
		public Pancake(E flavor){
			this.flavor = flavor;
		}
		public Pancake<E> getNextPancake(){
			return nextPancake;
		}
		public E getFlavor(){
			return flavor;
		}
		public void addFlavor(){
			
		}
		public E setNextPancake(Pancake<E> p){
			nextPancake = p;
			return p.getFlavor();
		}
	}

}