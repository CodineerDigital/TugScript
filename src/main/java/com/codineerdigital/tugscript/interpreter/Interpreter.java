package com.codineerdigital.tugscript.interpreter;

import com.codineerdigital.tugscript.exceptions.TugInterpreterInvalidSyntaxException;
import com.codineerdigital.tugscript.exceptions.TugInterpreterInvalidArgumentException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Interpreter {

    public static Class getClassByName(String location) throws ClassNotFoundException {
        return Class.forName("com.codineerdigital.tugscript.classes." + location);
    }

    public static void executeMethod(String className, String methodName, Object... parameters) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, TugInterpreterInvalidSyntaxException, TugInterpreterInvalidArgumentException {
        Class methodsClass = getClassByName(className);
        List<Class<?>> classTypes = new ArrayList<>();
        for (Object parameter : parameters) {
            classTypes.add(parameter.getClass());
        }
        for (Method method : methodsClass.getMethods()) {
            if (method.getName().equals(methodName)) {
                if (Arrays.equals(method.getParameterTypes(), classTypes.toArray())) {
                    method.invoke(null, parameters); // Todo: Remove null
                    return;
                }
            }
        }
        throw new TugInterpreterInvalidArgumentException();
    }

    public static void executeLine(String input) throws TugInterpreterInvalidSyntaxException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, TugInterpreterInvalidArgumentException {
        String[] elements = input.split("\\.");
        if (elements.length < 2) {
            throw new TugInterpreterInvalidSyntaxException();
        }
        String bracketInput = input.substring(input.indexOf("(")+1,input.indexOf(")"));
        String[] arguments = bracketInput.split(",");
        Interpreter.executeMethod(input.replace("." + elements[elements.length - 1], ""), elements[elements.length - 1].replace("(", "").replace(")", "").replace(bracketInput, ""), arguments);
    }

}
