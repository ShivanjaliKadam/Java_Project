////////////////////////////////////////////////////////////////////
/// 1.Banking Application(Exception):InvalidAmountException.java
/// 2.Used Entities:Extended class
/// 3.Functionality:Handles User defined Exception
/// 4..Date: 22-02-2025
////////////////////////////////////////////////////////////////////
public class InvalidAmountException extends Exception {
    public InvalidAmountException(String message) {
        super(message);
    }
}