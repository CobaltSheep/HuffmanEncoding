import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class GUI {
	
	
	/**
	 * User chooses file to compress
	 * Class calls calcfrequency,and encrypt
	 * Then closes.
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		
		
		Huffman huff = new Huffman();
		
		
        JFileChooser chooser = new JFileChooser();
        
        chooser.setApproveButtonText("Select File");
        FileNameExtensionFilter filter = new FileNameExtensionFilter(null, "txt");
        
        chooser.setFileFilter(filter);
        
        
        int returnVal = chooser.showOpenDialog(null);
        
        if (returnVal == JFileChooser.APPROVE_OPTION) {
           
            try {
                Scanner file = new Scanner(chooser.getSelectedFile());
                HashMap<String, Double> k = huff.calcFrequency(file);
                huff.encrypt(k);
                file.close();
            }
            catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
	public GUI() {
		
		
	}
}
