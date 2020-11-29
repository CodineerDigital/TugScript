package com.codineerdigital.tugscript.interpreter;

import com.codineerdigital.tugscript.exceptions.TugInterpreterInvalidArgumentException;
import com.codineerdigital.tugscript.exceptions.TugInterpreterInvalidSyntaxException;

import java.lang.reflect.InvocationTargetException;

public class Test {

    public static void main(String[] args) throws NoSuchMethodException, TugInterpreterInvalidSyntaxException, IllegalAccessException, TugInterpreterInvalidArgumentException, InvocationTargetException, ClassNotFoundException {
        Interpreter.executeLine("Console.log(Test123)");
    }





}
