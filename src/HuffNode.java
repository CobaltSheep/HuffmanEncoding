
public class HuffNode implements Comparable<HuffNode> {
// attributes
// - frequency, letter, left, right
	
	private String letter;
	private double probability;
	private HuffNode left;
	private HuffNode right;
	
	public HuffNode(String l, double f) {
		letter = l;
		probability = f;
	}
	
	
	/**
	 * compares a HuffNode's probability value to another
	 * If the objects probability is greater, it returns 1.
	 * If the "other" object is greater, it returns -1.
	 * If they are the same, it returns 0.
	 */
	@Override
	public int compareTo(HuffNode other) {
		// TODO Auto-generated method stub
		
		if(this.probability>other.probability) {
			return 1;
		}
		else if(this.probability<other.probability){
				return -1;
			}
		else {
			return 0;
		}
	}
	/**
	 * returns a string format of the HuffNode
	 */
	public String toString() {
		
		return this.letter + " " + this.probability;
	}
	/**
	 * sets the letter
	 * @param l
	 */
	public void setLetter(String l) {
		letter = l;
	}
	/**
	 * gets the letter
	 * @return
	 */
	public String getLetter() {
		return letter;
	}
	/**
	 * gets the probability
	 * @return
	 */
	public double getProb() {
		return probability;
	}
	/**
	 * sets the probability
	 * @param p
	 */
	public void setProb(double p) {
		probability = p;
	}
	/**
	 * sets the left of the HuffNode
	 * @param l
	 */
	public void setLeft(HuffNode l) {
		left = l;
	}
	/**
	 * sets the right of the HuffNode
	 * @param r
	 */
	public void setRight(HuffNode r) {
		right = r;
	}
	/**
	 * gets the left of the HuffNode
	 * @return
	 */
	public HuffNode getLeft() {
		return left;
	}
	/**
	 * gets the right of the HuffNode
	 * @return
	 */
	public HuffNode getRight() {
		return right;
	}
}
