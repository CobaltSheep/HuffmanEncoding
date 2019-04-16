import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import javax.swing.JOptionPane;

public class Huffman {
	//(1) calculate frequency of letters
	//(2) Tree (array) creation
	//(3) Creating dictionary


	public Huffman() {




	}
	/**
	 * Calculates the frequency of certain letters in the text file
	 * Returns a hash map with the letters and their frequencies
	 * @param a
	 * @return
	 * @throws FileNotFoundException
	 */
	public HashMap<String, Double> calcFrequency(Scanner a) throws FileNotFoundException{

		int size = 0;

		HashMap <String, Double> frequencies = new HashMap<>();

		a = a.useDelimiter("");

		while(a.hasNext()) {

			String curr = a.next();

			if(frequencies.containsKey(curr)) {

				double amt = frequencies.get(curr);
				amt++;
				frequencies.put(curr, amt);

			}
			else {
				frequencies.put(curr, 1.00);
			}
			size++;

		}
		for(String str : frequencies.keySet()) {
			double prob = frequencies.get(str)/size;
			frequencies.put(str, prob);
		}




		return frequencies;
	}
	/**
	 * Takes a hashmap, and adds its components as nodes into a heap.
	 * Then, creates the huffman tree.
	 * Then goes through the tree, and assigns binary values. (creates a dictionary)
	 * @param z
	 * @return
	 * @throws IOException 
	 */
	public void encrypt(HashMap<String,Double> z) throws IOException {


		Heap<HuffNode> heap = new Heap<HuffNode>();
		for(String str : z.keySet()) {
			HuffNode n = new HuffNode(str, z.get(str));
			heap.add(n);

		}

	
		while(heap.size()!=1) {
			HuffNode left = heap.remove();
			HuffNode right = heap.remove();

			HuffNode parent = new HuffNode(left.getLetter() + right.getLetter(), 	
					left.getProb() + right.getProb());


			parent.setLeft(left);
			parent.setRight(right);


			heap.add(parent);
			

		}
		HuffNode stored = heap.remove();

		HashMap<String, String> dictionary = new HashMap<String, String>();

		preOrder(stored, "", dictionary);
		String name = JOptionPane.showInputDialog("What file do you want to output to?");
		if(name == null) {
			System.exit(0);
		}
		Writer dict = new FileWriter(name);
		for(String str : dictionary.keySet()) {
			dict.write(str + ":" + dictionary.get(str) + System.lineSeparator());
		}
		dict.close();
		
		
		



	}
	/**
	 * Does a preorder traversal of the Huffman Tree and assigns binary values to its
	 * contingents.
	 * @param h
	 * @param b
	 * @param dictionary
	 */
	public void preOrder(HuffNode h, String b, HashMap<String, String> dictionary) {
		
		if(h.getLeft() == null) {
			dictionary.put(h.getLetter(), b);
			
			return;
		}
		preOrder(h.getLeft(), b+"0", dictionary);
		preOrder(h.getRight(), b+"1", dictionary);

	}







}
