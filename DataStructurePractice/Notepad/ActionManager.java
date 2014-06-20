import java.util.Stack;

public class ActionManager{
	private ActionSequence actionSequence;

	public ActionManager(){
		actionSequence = new ActionSequence();

	}

	public void addUndoableAction(){}

	private class ActionSequence{ //Modified Stack
		Node<UndoableAction>









		// Combination of stack and linked list
		private class Node<E>{
			private Node<E> forward,backward;
			private E data;

			public Node(E data){
				this.data = data;
			}
			public Node<E> getFront(){
				return forward;
			}
			public Node<E> getBack(){
				return backward;
			}
			public E getData(){
				return data;
			}

		}
	}


}