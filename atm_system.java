import java.util.Scanner;

class ATM{
    String name;
    String username;
    String pass;
    String acc_no;
    float balance=100000f;
    int transaction=0;
    String transactionhistory="";
    
    public void register()
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("\nEnter your name = ");
        this.name=sc.nextLine();
        System.out.print("\nEnter your Username = ");
        this.username=sc.nextLine();
        System.out.print("\nEnter your password = ");
        this.pass=sc.nextLine();
        System.out.print("\nEnter your account number = ");
        this.acc_no=sc.nextLine();
        System.out.println("\nYou have successfully registered.Please Login!");
        }
        
        public boolean login()
        {
            boolean islogin=false;
            Scanner sc=new Scanner(System.in);
            while(!islogin)
            {
                System.out.print("\nEnter your Username = ");
                String user =sc.nextLine();
                if(user.equals(username))
                {
                    while(!islogin)
                    {
                        System.out.print("\nEnter your password = ");
                String password =sc.nextLine();
                if(password.equals(pass))
                {
                    System.out.println("\nLogin is successful!");
                    islogin=true;
                }
                else
                {
                    System.out.println("\nIncorrect password");
                    }
                }
              }
              else
              {
                  System.out.println("\nUsername not found");
                }
            }
            return islogin;
        }
        
        public void withdraw()
        {
            System.out.print("\nEnter amount to withdraw = ");
            Scanner sc=new Scanner(System.in);
            float amt =sc.nextFloat();
            try
            {
              if(balance >= amt)
              {
                  transaction++;
                  balance -= amt;
                  System.out.println("\nWithdrawn Successfully");
                  String str=amt + " Rs Withdrawn\n";
                  transactionhistory=transactionhistory.concat(str);
              }
              else
              {
                  System.out.println("\nInsufficient Balance");
                }
            }
        
        catch ( Exception e) {
             }
            }
            
            public void deposit()
            {
                System.out.print("\nEnter your amount to deposit = ");
                Scanner sc=new Scanner(System.in);
                float amt=sc.nextFloat();
                
                try
                {
                    if(amt <= 100000f)
                    {
                        transaction++;
                  balance += amt;
                  System.out.println("\nDeposited Successfully");
                  String str=amt + " Rs Deposited\n";
                  transactionhistory=transactionhistory.concat(str);
                        
                    }
                    else
                    {
                       System.out.println("\nSorry.....limit is 100000.00"); 
                    }
                }
                catch ( Exception e)
                {
            }
              }
              
              public void transfer()
            {
                Scanner sc=new Scanner(System.in);
                System.out.print("\nEnter receipent's name = ");
                String receipent=sc.nextLine();
                System.out.print("\nEnter amount to transfer = ");
                float amt=sc.nextFloat();
                
                try
                {
                    if(balance>=amt)
                    {
                        if(amt<=50000f)
                        {
                        transaction++;
                  balance -= amt;
                  System.out.println("\nTransfered Successfully to " + receipent);
                  String str=amt + " Rs transfered to "+ receipent + "\n";
                  transactionhistory=transactionhistory.concat(str);
                        }
                         else
                    {
                       System.out.println("\nSorry.....limit is 50000.00"); 
                    }
                }
                    else
                    {
                        System.out.println("\nInsufficient balance");
                    }
                   
                }
                catch ( Exception e)
                {
            }
              }
              
              public void checkbalance()
              {
                  System.out.println("\n" + balance + " Rs");
                  }
                  
                  public void history()
                  {
                      if(transaction==0)
                      {
                          System.out.println("\nEmpty");
                      }
                      else
                      {
                          System.out.println("\n" + transactionhistory);
                      }
                  }
            }
            
            public class atm_system
            {
                public static int takeIntegerInput(int limit)
                {
                    int input=0;
                    boolean flag=false;
                    while(!flag)
                    {
                        try
                        {
                            Scanner sc =new Scanner(System.in);
                            input=sc.nextInt();
                            flag=true;
                            if(flag && input > limit || input < 1 )
                        {
                            System.out.println("Choose the number between 1 to " + limit);
                            flag=false;
                            }
                        }
                        catch ( Exception e )
                        {
                            System.out.println("Enter only integer value");
                            flag=false;
                        }
                    };
                    return input;
                     }
                     
                     public static void main(String[]args)
                     {
                         System.out.println("\n************Welcome to HDFC ATM SYSTEM*******\n");
                         System.out.println("1.Register \n2.Exit");
                         System.out.print("Enter your choice = ");
                         int choice =takeIntegerInput(2);
                         
                         if(choice==1)
                         {
                             ATM a = new ATM();
                             a.register();
                             while(true)
                             {
                                 System.out.println("\n1.Login \n2.Exit");
                                 System.out.print("Enter your choice = ");
                                 int ch = takeIntegerInput(2);
                                 if(ch==1)
                                 {
                                     if(a.login())
                                     {
                                         System.out.println("\n\n*******Welcome Back " + a.name + " ********\n");
                                         boolean iscomplete=false;
                                         while(!iscomplete)
                                         {
                                             System.out.println("\n1.Withdraw \n2.Deposit \n3.Transfer \n4.Check Your Balance \n5.Transaction History \n6.Exit");
                                             int c = takeIntegerInput(6);
                                             switch(c)
                                             {
                                                 case 1:
                                                     a.withdraw();
                                                     break;
                                                 case 2:
                                                     a.deposit();
                                                     break;
                                                 case 3:
                                                     a.transfer();
                                                     break;
                                                 case 4:
                                                     a.checkbalance();
                                                     break;
                                                  case 5:
                                                     a.history();
                                                     break;   
                                                  case 6:
                                                     iscomplete=true;
                                                     break;   
                                             }
                                         }
                                     }
                                 }
                                 else
                                 {
                                     System.exit(0);
                                 }
                             }
                            }
                            else
                            {
                                System.exit(0);
                            }
                             
                        
                         
                     }
            }
            
                 
                    
               
