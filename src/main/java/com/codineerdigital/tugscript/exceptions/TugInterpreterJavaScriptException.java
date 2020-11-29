package com.codineerdigital.tugscript.exceptions;

import javax.script.ScriptException;

public class TugInterpreterJavaScriptException extends TugInterpreterException {

    public TugInterpreterJavaScriptException(ScriptException exception) {
        this.setStackTrace(exception.getStackTrace());
    }

}
