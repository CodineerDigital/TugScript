package com.codineerdigital.tugscript.exceptions;

import javax.script.ScriptException;

public class TugInterpreterJavaScriptException extends Exception {

    public TugInterpreterJavaScriptException(ScriptException exception) {
        this.setStackTrace(exception.getStackTrace());
    }

}
