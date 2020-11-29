package com.codineerdigital.tugscript.classes;

import com.codineerdigital.tugscript.exceptions.TugInterpreterNotFoundException;
import com.codineerdigital.tugscript.interpreter.Interpreter;

import java.lang.reflect.Method;

public class MethodModifier {

    // Todo: Find out what it does
    public static void makeAccessible(String classname, String methodName) {
        Class modifierClass;
        try {
            modifierClass = Interpreter.getClassByName(classname);
        } catch (ClassNotFoundException e) {
            new TugInterpreterNotFoundException().printStackTrace();
            return;
        }
        for (Method method : modifierClass.getMethods()) {
            if (method.getName().equals(methodName)) {
                method.setAccessible(true);
            }
        }
    }

}
