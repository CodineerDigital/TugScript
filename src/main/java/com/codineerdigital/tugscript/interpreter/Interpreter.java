package com.codineerdigital.tugscript.interpreter;

import com.codineerdigital.tugscript.exceptions.TugInterpreterException;
import com.codineerdigital.tugscript.exceptions.TugInterpreterInvalidSyntaxException;
import com.codineerdigital.tugscript.exceptions.TugInterpreterInvalidArgumentException;
import com.codineerdigital.tugscript.exceptions.TugInterpreterNativeException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Interpreter {

    public static Class getClassByName(String location) throws ClassNotFoundException {
        return Class.forName("com.codineerdigital.tugscript.classes." + location);
    }

    public static void executeMethod(String className, String methodName, Object... parameters) throws TugInterpreterException {
            Class methodsClass;
        try {
            methodsClass = getClassByName(className);
        } catch (ClassNotFoundException exception) {
            throw new TugInterpreterNativeException();
        }
        List<Class<?>> classTypes = new ArrayList<>();
            for (Object parameter : parameters) {
                classTypes.add(parameter.getClass());
            }
            for (Method method : methodsClass.getMethods()) {
                if (method.getName().equals(methodName)) {
                    if (Arrays.equals(method.getParameterTypes(), classTypes.toArray())) {
                        try {
                            method.invoke(null, parameters); // Todo: Remove null
                        } catch (IllegalAccessException | InvocationTargetException exception) {
                            throw new TugInterpreterNativeException();
                        }
                        return;
                    }
                }
            }
            throw new TugInterpreterInvalidArgumentException();
    }

    public static void executeLine(String input) throws TugInterpreterException {
        String[] elements = input.split("\\.");
        if (elements.length < 2) {
            throw new TugInterpreterInvalidSyntaxException();
        }
        //String bracketInput = input.substring(input.indexOf("(")+1,input.indexOf(")"));
        String bracketInput = "";
        Pattern pattern = Pattern.compile("[^\\(]*(\\(.*\\))[^\\)]*");
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            bracketInput = matcher.group(1).substring(1, matcher.group(1).length()-1);
        }
        String[] arguments = bracketInput.split(",");
        if (arguments.length == 1) {
            if (arguments[0].equals("")) {
                arguments = new String[]{};
            }
        }
        Interpreter.executeMethod(input.replace("." + elements[elements.length - 1], ""), elements[elements.length - 1].replace("(", "").replace(")", "").replace(bracketInput, ""), arguments);
    }

}
