package test.java.org.framework.pom.exceptions;

public class IdNotFoundException extends Exception {
    public IdNotFoundException() {
        System.err.println("Product ID is invalid, please enter a number between 0-5");
    }
}
