package myapp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TextProcessor {

    public static void main(String[] args) throws IOException {

        Path p = Paths.get(args[0]);
        File f = p.toFile();
        
        Map<String, Integer> wordFreq =  new HashMap<>();

        // Open file as input stream
        InputStream is = new FileInputStream(f);
        // Convert the input stream to a reader byte
        InputStreamReader isr = new InputStreamReader(is);
        // Write whole lines 
        BufferedReader br = new BufferedReader(isr);

        String line;
        int numWords = 0;
        while ((line = br.readLine()) != null) {
            System.out.printf("> %s\n", line.toUpperCase());
            String[] words = line.split(" ");
            numWords += words.length;
            // iterate the words in line and check if it is in 
            for (String w : words) {
                w = w.trim().toLowerCase();
                if (w.length() <= 0) {
                    continue;
                } 
                if (!wordFreq.containsKey(w)) {
                    // if word is not in map, initialise with freq of 1
                    wordFreq.put(w, 1);
                } else {
                    // if word is in map, increment the count
                    wordFreq.put(w, wordFreq.get(w)+1);
                }
            }
        }

        Set<String> words = wordFreq.keySet();
        for (String w : words) {
            System.out.printf(": %s = %d\n", w, wordFreq.get(w));
        }

        System.out.printf("Number of words: %d\n", numWords);
        System.out.printf("Number of unique words: %d\n", words.size());

        br.close();
        isr.close();
        is.close();
        // closed in reverse order of how it was opened

    }
    
}
