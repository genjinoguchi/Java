import java.util.Stack;

public class ActionManager{
	private Stack<UndoableAction> actionSequence;
	private Stack<UndoableAction> redoSequence;

	public ActionManager(){
		sequenceStack = new Stack<UndoableAction>();
		redoSequence = new Stack<UndoableAction>();
	}

	public void addUndoableAction(int location, boolean delete, String data){
		actionSequence.push(new UndoableAction(location,delete,data));
	}




	private class UndoableAction{
		private String data;
		private boolean delete;

		public UndoableAction(int location,boolean delete, String data){
			this.data = data;
			this.delete = delete;
		}
		public boolean isDeleting(){
			return delete;
		}
		public String data(){
			return data;
		}
	}
}