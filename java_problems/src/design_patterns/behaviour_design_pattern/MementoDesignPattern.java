package design_patterns.behaviour_design_pattern;

class Editor {
	private Integer curX , curY ;
	private String text;
	private String selectionWidth;
	
	public void setSelectionWidth(String selectionWidth) {
		this.selectionWidth = selectionWidth;
	}
	
	public void setCursor(Integer curX,Integer curY) {
		this.curX = curX;
		this.curY = curY;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	  // Saves the current state inside a memento.
	public Snapshot getMemento() {
		// Memento is an immutable object; that's why the
        // originator passes its state to the memento's
        // constructor parameters.

		return new Snapshot(this.curX, this.curY, this.selectionWidth, this.text);
	}
}

/** Memento is immutable class  and these are below requirements need  
 * 1. Declare the class as final so it can�t be extended. Make all fields private so that direct access is not allowed. 
 * 2. Don�t provide setter methods for variables. 
 * 3. Make all mutable fields final so that its value can be assigned only once. 
 * 4. Initialize all the fields via a constructor performing deep copy.
 * 5. Perform cloning of objects in the getter methods to return a copy rather than returning the actual object reference.
 */
// Memento
// The memento class stores the past state of the editor.
final class Snapshot {
	
	private Integer curX , curY ;
	private String text;
	private String selectionWidth;
	
	public Snapshot(Integer curX,Integer curY,String selectionWidth,String text) {
		this.curX = curX;
		this.curY = curY;
		this.selectionWidth = selectionWidth;
		this.text = text;
	}
	
	// At some point, a previous state of the editor can be
    // restored using a memento object.
	public Editor restore() {
		Editor editor = new Editor();
		editor.setCursor(this.curX,this.curY);
		editor.setSelectionWidth(this.selectionWidth);
		editor.setText(this.text);
		return editor;
	}

	public Integer getCurX() {
		int curX = this.curX;
		return curX;
	}

	public Integer getCurY() {
		int curY = this.curY;
		return curY;
	}

	public String getText() {
		String textLocal = new String(this.text);
		return textLocal;
	}

	public String getSelectionWidth() {
		String selectionWidthLocal = new String(this.selectionWidth); 
		return selectionWidthLocal;
	}

}

//A command object can act as a caretaker. In that case, the
//command gets a memento just before it changes the
//originator's state. When undo is requested, it restores the
//originator's state from a memento.
/** Optional */
class Command {
	private Snapshot backup;
	private Editor editor ;
	
	// command save the ref of Memento and the Original Object 
	// memento so tha we get the backup anytime and store it the original value in the undo process 
	Command(Snapshot snap,Editor editor){
		this.backup = snap;
		this.editor = editor;
	}
	public void makeBackup() {
		this.backup = editor.getMemento();
	}
	
	public void undo() {
		if(backup!=null) {
			this.editor = backup.restore();
		}
	}
}

public class MementoDesignPattern {

}
