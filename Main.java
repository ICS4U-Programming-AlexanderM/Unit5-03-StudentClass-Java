import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
* This file contains the main class.
*
* @author  Alexander Matheson
* @version 1.0
* @since   2023-06-06
*/

public final class Main {
    /**
    * For style checker.
    *
    *
    * @exception IllegalStateException Utility class.
    * @see IllegalStateException
    */
    private Main() {
        throw new IllegalStateException("Utility class");
    }

    /**
    * Print messages.
    *
    * @param args Unused
    */
    public static void main(String[] args) {
        // Declare list and variables.
        final ArrayList<Student> studentList = new ArrayList<Student>();
        boolean iep = false;
        int counter = 0;
        String outputString = "";
        final String newLine = "\n";

        try {
            // Choose a file to get input from.
            final File input = new File("input.txt");
            final Scanner scanInput = new Scanner(input);

            // Choose (or create) a file to print output to.
            final FileWriter output = new FileWriter("output.txt");

            // Loop to read each line of input file.
            while (scanInput.hasNextLine()) {
                // Add the next line as a student.
                final String[] currentStudent = scanInput.nextLine().split(" ");

                // Check if iep exists.
                if (currentStudent[currentStudent.length - 1].equals("y")) {
                    iep = true;
                } else {
                    iep = false;
                }

                // Check number of pieces of information and add to output.
                if (currentStudent.length == 4) {
                    final Student student = new Student(currentStudent[0],
                        currentStudent[1], Integer.parseInt(currentStudent[2]),
                        iep);
                    studentList.add(student);
                    outputString += studentList.get(counter).print() + newLine;
                } else if (currentStudent.length == 5) {
                    final Student student = new Student(currentStudent[0],
                        currentStudent[2], currentStudent[1].charAt(0),
                            Integer.parseInt(currentStudent[3]), iep);
                    studentList.add(student);
                    outputString += studentList.get(counter).print() + newLine;
                } else {
                    // Incorrect input.
                    outputString += "Error.\n";
                }
                counter++;
            }

            // Output information, including number of students.
            final String numStudents = "There are " + studentList.size()
                + " students.\n";
            System.out.print(numStudents);
            System.out.println(outputString);
            output.write(numStudents);
            output.write(outputString);

            // Close writer.
            output.close();

        } catch (IOException err) {
            // For when no input file is found.
            System.err.println("Error: " + err.getMessage());
        }
    }
}
