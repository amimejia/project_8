package edu.guilford;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

public class Project_8 {
    public static void main(String[] args) {
        // read the file in resources folder

        Path pathLocation = null;
        
        String line = null;
        //String fileName1 = "Tech_paragraph.txt";
        // priority Queue because it's similar to comparable where it has the natural
        // order of Alphabetical order
        PriorityQueue<String> techQueue = new PriorityQueue<String>();
        //https://www.geeksforgeeks.org/set-in-java/
        //Set will be used because it does not duplicate items
        Set<String> techSet = new HashSet<String>();

        try {
            pathLocation = Paths.get(Project_8.class.getResource("/" + "Tech_paragraph.txt").toURI());
            // FileReader techReaderFile = new FileReader(pathLocation.toFile());
            BufferedReader second_readBuffer = new BufferedReader(new FileReader(pathLocation.toFile()));

            // Setting up the output file
            PrintWriter techQueuePrint = new PrintWriter(new FileWriter("techqueue_print.txt"));
            PrintWriter techQueuePolled = new PrintWriter(new FileWriter("techqueue_polled.txt"));

            // while each line is read by the buffered reader, it will split the words by
            // the spaces, commas, and periods using the "\\W+"
            // then it will add the words to the queue
            // the queue naturally put the words in alphabetical order
            while ((line = second_readBuffer.readLine()) != null) {
                String[] words = line.split("\\W+"); // words are split here by spaces, commas, and periods
                // for every word in the array, it will add the word to the queue in lower case
                // letters
                for (int i = 0; i < words.length; i++) {
                    String word = words[i];
                    if (!word.isEmpty()) {
                        techQueue.add(word.toLowerCase());
                        techSet.add(word.toLowerCase());
                    }
                }
            }
            // prints out the queue
            System.out.println(techQueue);
            techQueuePrint.println(techQueue);
            techQueuePrint.close();

            // prints out the queue in individual strings by polling the queue
            // until techqueue is empty, it will print out the words in alphabetical order
            while (!techQueue.isEmpty()) {
                String word = techQueue.poll();
                techQueuePolled.println(word);
                System.out.println(word);
            }
            techQueuePolled.close();

            // prints out the set
            System.out.println("Here is the set collection interface method: " + techSet);
        }

        catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }

    }
}
