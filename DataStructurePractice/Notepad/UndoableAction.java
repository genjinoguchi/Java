public class UndoableAction{
	private int index;
	private String data;
	private boolean delete; //T is delete, F is not.

	public UndoableAction(int index,boolean delete, String data){
		this.index = index;
		this.data = data;
		this.delete = delete;
	}
	public boolean deleting(){
		return delete;
	}
	public String data(){
		return data;
	}
	public int index(){
		return index;
	}
}