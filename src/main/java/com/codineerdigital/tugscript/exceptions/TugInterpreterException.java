package com.codineerdigital.tugscript.exceptions;

import java.io.PrintStream;
import java.io.PrintWriter;

public class TugInterpreterException extends Exception {

    @Override
    public void printStackTrace() {
        System.err.println("TugScript Interpreter run into an Exception!");
        super.printStackTrace();
    }

    @Override
    public void printStackTrace(PrintStream s) {
        s.println("TugScript Interpreter run into an Exception!");
        super.printStackTrace(s);
    }

    @Override
    public void printStackTrace(PrintWriter s) {
        s.println("TugScript Interpreter run into an Exception!");
        super.printStackTrace(s);
    }
}
