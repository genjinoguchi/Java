public class UndoableAction{
	private boolean add;
	
	private String symbol;

	public UndoableAction(boolean add, String symbol){
		this.add = add;
		this.symbol = symbol;
	}
}