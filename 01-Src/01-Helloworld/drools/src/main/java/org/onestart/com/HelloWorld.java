package org.onestart.com;

import java.util.Objects;

public class HelloWorld {
    private String  message;
    private boolean isGreetingDone=true;

    public HelloWorld() {
    }

    public HelloWorld(String message) {
        this.message = message;
    }

    public boolean getIsGreetingDone() {
        return this.isGreetingDone;
    }

    public void setIsGreetingDone(boolean isGreetingDone) {
        this.isGreetingDone = isGreetingDone;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "{" +
            " message='" + getMessage() + "'" +
            "}";
    }
}