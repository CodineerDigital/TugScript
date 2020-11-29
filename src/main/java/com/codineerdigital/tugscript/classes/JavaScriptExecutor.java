package com.codineerdigital.tugscript.classes;

import com.codineerdigital.tugscript.exceptions.TugInterpreterJavaScriptException;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class JavaScriptExecutor {

    static ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");

    public static void execute(String code) {
        try {
            engine.eval(code);
        } catch (ScriptException exception) {
            new TugInterpreterJavaScriptException(exception).printStackTrace();
        }
    }

}
