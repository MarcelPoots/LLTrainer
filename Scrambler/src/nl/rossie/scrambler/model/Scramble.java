package nl.rossie.scrambler.model;

public class Scramble {

	private int index;
	private String scramble;
	private String hint;
	private String time;
	private String name;
	private String category;
	private String imageFileName;
	private Long result;
	
	public Scramble(){
		// empty constructor
	}
	
	public Scramble(int index, Long result){
		setIndex(index);
		setResult(result);
	}
	
	public String getHint() {
		return hint;
	}
	public void setHint(String hint) {
		this.hint = hint;
	}
	public String getScramble() {
		return scramble;
	}
	public void setScramble(String scramble) {
		this.scramble = scramble;
	}
	public synchronized String getTime() {
		return time;
	}
	public synchronized void setTime(String time) {
		this.time = time;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public Long getResult() {
		return result;
	}
	public void setResult(Long result) {
		this.result = result;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the imageFileName
	 */
	public String getImageFileName() {
		return imageFileName;
	}

	/**
	 * @param imageFileName the imageFileName to set
	 */
	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}
