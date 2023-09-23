package org.ti.DriverFactory;

import static org.ti.utils.logs.Log.error;

public class FrameworkException extends Exception{
    public static final long serialVersionUID = 700L;

    public FrameworkException(){
    }

    public FrameworkException(String message){
        super(message);
        error(message);
    }

    public FrameworkException(String message, Exception e){
        this(message);
        error(e.getMessage());

    }
}
