public class ActionManager{
	private ActionSequence actionSequence;

	public ActionManager(){
		actionSequence = new ActionSequence();

	}

	public void addUndoableAction(){}

	private class ActionSequence{ //Modified Stack
		

		private class UndoableAction{
			private String symbol;
			private boolean delete;
			private UndoableAction next, previous;

			public UndoableAction(boolean delete, String symbol){
				this.symbol = symbol;
				this.delete = delete;
			}
			public boolean isDeleting(){
				return delete;
			}

			public void setNext(UndoableAction ua){ next = ua; }
			public void setPrevious(UndoableAction ua){ previous = ua;}
			public UndoableAction getNext(){ return next;}
			public UndoableAction getPrevious(){ return previous;}
		}

	}


}