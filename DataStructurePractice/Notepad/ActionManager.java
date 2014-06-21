import java.util.Stack;
import java.util.EmptyStackException;

public class ActionManager{
	private static Stack<UndoableAction> actionSequence = new Stack<UndoableAction>();
	private static Stack<UndoableAction> redoSequence = new Stack<UndoableAction>();
	private static boolean ctrlPressed;

/*
	public static void main(String[] args) {
		ActionManager.insertUndoableAction(0,false,"h");
		ActionManager.insertUndoableAction(1,false,"e");
		ActionManager.insertUndoableAction(2,false,"l");
		ActionManager.insertUndoableAction(3,false,"l");
		ActionManager.insertUndoableAction(4,false,"o");
		ActionManager.insertUndoableAction(5,false,"a");
		ActionManager.insertUndoableAction(4,true,"");
		ActionManager.insertUndoableAction(5,false," ");
		ActionManager.insertUndoableAction(6,false,"h");
		ActionManager.insertUndoableAction(7,false,"u");
		ActionManager.insertUndoableAction(8,false,"r");
		ActionManager.insertUndoableAction(9,false,"r");
		ActionManager.insertUndoableAction(10,false,"r");
		ActionManager.undo();
		ActionManager.redo();

		System.out.println(ActionManager.processActions());
	}
*/

	public ActionManager(){

	}

	public static void processInput(String s,int index){
		if(ctrlPressed){
			if(s.equals("z")){
				undo();
			}
			if(s.equals("y")){
				redo();
			}
		}else{
			insertUndoableAction(index,false,s);
			Notepad.w.displaceCursor(1);
		}
		System.out.println(ctrlPressed);
		//System.out.println(processActions());
	}

	public static String processActions(){
		Stack<UndoableAction> temp = new Stack<UndoableAction>();
		String toReturn = new String();
		while(!actionSequence.empty()){ //Possible optimizations here-- replace pop with a variable holding push.
			temp.push(actionSequence.pop());
		}
		while(!temp.empty()){
			toReturn = processActions(temp.peek(),toReturn);
			actionSequence.push(temp.pop());
		}
		return toReturn;
	}
	public static String processActions(UndoableAction ua,String s){
		if(ua.deleting()){
			s = delete(s,ua.index());
		}else{
			s = insert(s,ua.data(),ua.index());
		}
		return s;
	}

	public static String delete(String s,int index){
		try{
			return s.substring(0,index) + s.substring(index+1);
		} catch (Exception e){
			return s;
		}
	}
	public static String insert(String s, String i,int index){
		try{
			return s.substring(0,index) + i + s.substring(index);
		} catch (Exception e){
			return s;
		}
	}

	public static void insertUndoableAction(int index,boolean delete,String symbol){
		actionSequence.push(new UndoableAction(index,delete,symbol));
		redoSequence.push(new UndoableAction(index,delete,symbol));
	}

	public static void undo(){
		try{
			redoSequence.push(actionSequence.pop());
		}catch(EmptyStackException e){

		}
	}
	public static void redo(){
		try{
			actionSequence.push(redoSequence.pop());
		} catch (EmptyStackException e){

		}
	}

	public static void emptyRedoSequence(){
		try{
			while(true){
				redoSequence.pop();
			}
		}catch(EmptyStackException e){}
	}

	public static void toggleCtrl(boolean b){
		ctrlPressed = b;
	}
	public static boolean isCtrlPressed(){
		return ctrlPressed;
	}
}