////////////////////////////////////////////////////////////////////
/// 1.Banking Application(Exception):InsufficientBalanceException.java
/// 2.Used Entities:Extended class
/// 3.Functionality:Handles User defined Exception
/// 4..Date: 22-02-2025
////////////////////////////////////////////////////////////////////
public class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}