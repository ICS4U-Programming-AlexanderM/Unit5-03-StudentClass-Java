/**
* This file contains the student class.
*
* @author  Alexander Matheson
* @version 1.0
* @since   2023-06-06
*/
public class Student {
    // Variables for this class.
    private String _firstName;
    private String _lastName;
    private char _midInitial;
    private int _grade;
    private boolean _iep;
    private String _info;

    // I love this style checker.
    private final String _space = " ";
    private final String _gradeString = " is in grade ";

    /**
    * Constructor to set initial values.
    *
    * @param firstName from user.
    * @param lastName from user.
    * @param midInitial from user.
    * @param grade from user.
    * @param iep from user.
    */
    public Student(String firstName, String lastName, char midInitial,
        int grade, boolean iep) {
        this._firstName = firstName;
        this._lastName = lastName;
        this._midInitial = midInitial;
        this._grade = grade;
        this._iep = iep;
    }

    /**
    * Constructor to set initial values.
    *
    * @param firstName from user.
    * @param lastName from user.
    * @param grade from user.
    * @param iep from user.
    */
    public Student(String firstName, String lastName, int grade, boolean iep) {
        this._firstName = firstName;
        this._lastName = lastName;
        this._grade = grade;
        this._iep = iep;
        this._midInitial = ' ';
    }

    /**
    * Accessor method.
    *
    * @return requested variable.
    */
    public String getFirst() {
        return this._firstName;
    }

    /**
    * Accessor method.
    *
    * @return requested variable.
    */
    public char getMid() {
        return this._midInitial;
    }

    /**
    * Accessor method.
    *
    * @return requested variable.
    */
    public String getLast() {
        return this._lastName;
    }

    /**
    * Accessor method.
    *
    * @return requested variable.
    */
    public int getGrade() {
        return this._grade;
    }

    /**
    * Accessor method.
    *
    * @return requested variable.
    */
    public boolean getIep() {
        return this._iep;
    }

    /**
    * Print all information.
    *
    * @return String of information.
    */
    public String print() {
        // Check if middle initial exists.
        if (this._midInitial == ' ') {
            this._info = this._firstName + _space + this._lastName
                + _gradeString + this._grade;
        } else {
            this._info = this._firstName + _space + this._midInitial + ". "
                + this._lastName + _gradeString + this._grade;
        }

        // Check if iep is true.
        if (this._iep) {
            this._info += " and has an iep.";
        } else {
            this._info += " and does not have an iep.";
        }
        return this._info;
    }
}
