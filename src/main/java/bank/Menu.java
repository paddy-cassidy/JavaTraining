package bank;

import java.util.Scanner;

import javax.security.auth.login.LoginException;

public class Menu {

  private Scanner scanner;

  private static void main(String[] args){
    System.out.println("Welcome to Paddy bank");

    Menu menu = new Menu();
    menu.scanner = new Scanner(System.in);

    Customer customer = menu.authenticateUser();

    if(customer != null){

       Account account = DataSource.getAccount(customer.getAccountId());
       menu.showMenu(customer, account);

    }

    menu.scanner.close();
  }

private Customer authenticateUser(){
  System.out.println("Pls enter your Username: ");
  String username = scanner.next();

  System.out.println("Pls enter your password: ");
  String password = scanner.next();

  Customer customer = null;
  try{
  customer = Authenticator.login(username, password);
  } catch(LoginException e){
    System.out.println("There was an error: " + e.getMessage());
  }

  return customer;
}

private void showMenu(Customer customer, Account account){
  int selection = 0;

  while(selection != 4 && customer.isAuthenticated()){
    System.out.println("============================================");
    System.out.println("Pls select one of the folowing options: ");
    System.out.println("1: Deposit");
    System.out.println("2: Withdraw");
    System.out.println("3: Check Balance");
    System.out.println("4: Exit");
    System.out.println("============================================");

    selection = scanner.nextInt();

    switch(selection){

      case 1:
        System.out.println("How nuch would you like to desposit");
        amount = scanner.nextDouble();
        account.desposit(amount);


    }
  }

}

}
