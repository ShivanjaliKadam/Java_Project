////////////////////////////////////////////////////////////////////
/// 1.Banking Application(Exception):CustomerException.java
/// 2.Used Entities:Extended class
/// 3.Functionality:Handles User defined Exceptions
/// 4..Date: 22-02-2025
////////////////////////////////////////////////////////////////////
public class CustomerException {
    //Exception handling(declaration)
    //Case to handle negative/zero amount input
    class InvalidAmountException extends Exception{
        public InvalidAmountException(String message){
            super(message);
        }
    }
    //Case to handle withdraw money 
    class InsufficientBalanceException extends Exception{
        public InsufficientBalanceException(String message){
            super(message);
        }
    }

    //Case to handle invalid account
    class AccountNotFoundException extends Exception{
        public AccountNotFoundException(String message){
            super(message);
        }
    }
}
