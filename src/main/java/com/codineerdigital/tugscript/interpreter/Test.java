package com.codineerdigital.tugscript.interpreter;

import com.codineerdigital.tugscript.exceptions.TugInterpreterInvalidSyntaxException;
import com.codineerdigital.tugscript.exceptions.TugInterpreterInvalidArgumentException;

import java.lang.reflect.InvocationTargetException;

public class Test {

    public static void main(String[] args) {
        try {
            Interpreter.executeLine("Console.log(Hallo, Bert)");
        } catch (TugInterpreterInvalidSyntaxException | ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException | TugInterpreterInvalidArgumentException e) {
            e.printStackTrace();
        }
    }





}
