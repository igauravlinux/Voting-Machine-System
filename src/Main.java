
import java.util.ArrayList;
import java.util.Scanner;

class User{

    boolean hasVoted = false;

    //   for register
    String newEmail;
    String newPass;
    String aadharNum;

    User(String newEmail , String newPass ,String aadharNum){
        this.newEmail = newEmail;
        this.newPass = newPass;
        this.aadharNum = aadharNum;
    }

} // user class block

class Main{
    Scanner sc = new Scanner(System.in);
    ArrayList<User> list = new ArrayList<>();

    void register(){
        System.out.print("Enter new email address: ");
        String newEmail = sc.nextLine();

        System.out.print("Enter new password: ");
        String newPass = sc.nextLine();

        System.out.print("Enter Aadhar Number: ");
        String aadharNum = sc.nextLine();

        User user = new User(newEmail,newPass,aadharNum);
        list.add(user);

        System.out.println("Registration Successful");

    }

    boolean loginStatus = false;
    User currentUser;

    int candidate1;
    int candidate2;
    int candidate3;
    int candidate4;

    void login(){
        System.out.print("Enter email address: ");
        String email = sc.nextLine();

        System.out.print("Enter password: ");
        String pass = sc.nextLine();

        boolean found = false;

        for(User u : list){
            if(u.newEmail.equals(email) && u.newPass.equals(pass)){
                System.out.println("Welcome");
                currentUser = u;
                found = true;
                loginStatus = true;
                break;
            }
        }
        if(!found){
            System.out.println("Invalid email or password");
        }

    }

    void votingPortal(){

        if(!loginStatus){
            System.out.println("You are not logged in , Please login first");
            return;
        }

        if(currentUser.hasVoted == true){
            System.out.println("You have already voted");
            return;
        }

        int vote = 0;

        while(!currentUser.hasVoted){
            System.out.println("-----------------------");
            System.out.println("-----------------------");
            System.out.println("1. Aam Aadmi Party");
            System.out.println("2. Congress");
            System.out.println("3. JDU");
            System.out.println("4. BJP");
            System.out.print("Press a number to vote: ");
            vote = sc.nextInt();

            switch (vote){
                case 1:
                    System.out.println("Voting Successful");
                    candidate1++;
                    currentUser.hasVoted = true;
                    break;

                case 2:
                    System.out.println("Voting Successful");
                    candidate2++;
                    currentUser.hasVoted = true;
                    break;

                case 3:
                    System.out.println("Voting Successful");
                    candidate3++;
                    currentUser.hasVoted = true;
                    break;

                case 4:
                    System.out.println("Voting Successful");
                    candidate4++;
                    currentUser.hasVoted = true;
                    break;

                default:
                    System.out.println("Invalid choice");

            }
        }

    }

    void resultPortal(){
        int max = candidate1;

        if(candidate2 > max){
            max = candidate2;
        }
        if(candidate3 > max){
            max = candidate3;
        }
        if(candidate4 > max){
            max = candidate4;
        }

        System.out.println("Winners: ");

        if(candidate1 == max){
            System.out.println("Aam Aadmi party wins");
        }
        if(candidate2 == max){
            System.out.println("Congress wins");
        }
        if(candidate3 == max){
            System.out.println("JDU wins");
        }
        if(candidate4 == max){
            System.out.println("BJP wins");
        }
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        Main m = new Main();

        int choice = 0;

        while(choice != 5){
            System.out.println("---------------------------------------------");
            System.out.println("1. Register");
            System.out.println("2. Log In");
            System.out.println("3. Voting Portal");
            System.out.println("4. Result Portal");
            System.out.println("5. Exit");

            System.out.println("---------------------------------------------");
            System.out.print("Enter your choice ");
            choice = sc.nextInt();

            switch (choice){
                case 1:
                    m.register();
                    break;

                case 2:
                    m.login();
                    break;

                case 3:
                    m.votingPortal();
                    break;

                case 4:
                    m.resultPortal();
                    break;

                case 5:
                    break;
            }
        }




    }
}
