package main;
import main.IOExceptions.*;
import main.Lines.CommentsLine;
import main.Lines.Line;
import main.Lines.LineFactory;
import main.Scopes.Global;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * This is the manager class of the program. It accepts a file with a code, and checks the property of it.
 * @author Ilia Bogov
 * @author Shani Cheskis
 */

public class Sjavac{

    //Constants that help receiving the accepted arguments.
    private static final int NUM_OF_ARGS = 1;
    private static final int CODE_FILE = 0;
    private static final int LEGAL = 0;
    private static final int ILLEGAL = 1;
    private static final int IO_ERRORS = 2;

    /**
     * Manages the process of filtering and ordering the files, and then printing their names.
     * @param file file that consists the code we want to check
     */
    private Sjavac (String file) {
        File code = new File(file);
        //Creates an ArrayList of lines of the code in the file.
        try{
            FileReader reader = new FileReader(file);
            BufferedReader bufReader = new BufferedReader(reader);
            ArrayList<Line> lines = new ArrayList<>();
            String curLine = bufReader.readLine();
            while(curLine != null){ // goes over the lines in the file,
                // creates Lines objects representing line, and saves in ArrayList them.
                //System.out.println("here");
                Line line = LineFactory.lineFactory (curLine);
                if (!(line instanceof CommentsLine)){
                    // adds all expect comments and empty line, no need to check them
                    lines.add(line);
                }
                curLine = bufReader.readLine();
            }
            Global globalCode = new Global(lines);
            globalCode.scopeCorrectness();
            System.out.println(LEGAL); // if this line received there was no exception throwing

            // during checking the code, means the code is legal.
        }
        catch (Exception e){ // if there was exception during checking the code, means the code is illegal.
            //System.out.println(e.getClass());
            //System.out.println(e.getClass());
            // System.err.println(e.getMessage());
            System.out.println(ILLEGAL);
        }

    }

    /**
     * Checks if the number of args is valid.
     * @param args the arguments accepted by the main function.
     * @throws InvalidNumOfArguments in case the number of arguments is invalid.
     */
    private static void checkArgsNumber(String[] args) throws InvalidNumOfArguments {
        if(args.length != NUM_OF_ARGS){
            throw new InvalidNumOfArguments();
        }
    }

    /**
     * @param args 1 parameters are required apart from the code file: the file with the code
     *             for checking. Prints 0- if the code is legal, 1- if illegal, 2- in case of IOError.
     *             Also prints an informative message to the screen using
     *             System.err(error message), describing in general what went wrong.
     */
    public static void main(String[] args){
        try {
            //Checks the number of arguments
            checkArgsNumber(args);
            //Tries to initiate the process of checking given code.
            Sjavac processor = new Sjavac(args[CODE_FILE]);
        }
        //In case an IOError occurred, prints the error-message.
        catch (IOException exception){
            System.err.println(exception.getMessage());
            System.out.println(IO_ERRORS);
        }
    }
}


