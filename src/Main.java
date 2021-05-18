
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    private static MyGymManager manager = new MyGymManager();

    public static void main(String[] args) {
        System.out.println("Welcome to Cool Spot Gym Management System");
        int option = 0;
        while (option != 7) {
            System.out.println("----------------------------------------------");
            System.out.println("Console");
            System.out.println("Select Option");
            System.out.println("1.Add New Member");
            System.out.println("2.Delete Existing Member");
            System.out.println("3.Member List");
            System.out.println("4.Sort Member List");
            System.out.println("5.Save Details");
            System.out.println("6.Open Interface");
            System.out.println("7.Exit");
            System.out.println("----------------------------------------------");

            System.out.println("Your Choice :");
            option = inputValidation();


            switch (option) {
                case 1: {
                    System.out.println("Select '1' to add the Default Member or'2' to add the Student Members or '3' to add Over 60 Members");
                    Scanner sc = new Scanner(System.in);
                    int choice = sc.nextInt();
                    switch (choice) {
                        case 1:
                            addDefaultMember();
                            break;
                        case 2:
                            addStudentMember();
                            break;
                        case 3:
                            addOver60Member();
                    }
                }
                break;
                case 2:
                    deleteMember();
                    break;
                case 3:
                    viewList();
                    break;
                case 4:
                    sortMembers();
                    break;
                case 5:
                    saveMembers();
                    break;
                case 6:
                    openInterface();
                    break;
                case 7:
                    System.out.println("Thank You For Using Cool Spot Gym Management System, See you Again!!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option selection, please re-enter the correct option number !!");
            }
        }
    }


    private static void openInterface() {

    }



    private static void sortMembers() {
        manager.sortMembers();
    }


    private static void viewList() {

        manager.viewList();
    }


    private static void saveMembers() {
        System.out.println("~~~Members data was successfully saved to a database  named 'CoolSpotGymDatabase'!!~~~ ");

    }



    private static void deleteMember() {
        System.out.print("Enter the Membership Number to Delete : ");
        int membershipNumber = sc.nextInt();

        manager.deleteMember(membershipNumber);
    }


    private static void addOver60Member() {

        System.out.print("Enter Member's First Name : ");
        String over60MemberName = sc.next();
        System.out.print("Enter New Membership Number : ");
        int over60MemberNumber = sc.nextInt();
        System.out.print("Enter Membership Starting Date : ");
        String over60StartDate = sc.next();
        System.out.print("Enter Member's Age : ");
        int over60Age = sc.nextInt();

        Over60Member over60 = new Over60Member(over60MemberName, over60MemberNumber, over60StartDate, over60Age);
        manager.addOver60Member(over60);
    }


    private static void addStudentMember() {

        System.out.print("Enter Member's First Name : ");
        String studentMemberName = sc.next();
        System.out.print("Enter New Membership Number : ");
        int studentMemberNumber = sc.nextInt();
        System.out.print("Enter Membership Starting Date : ");
        String studentMemberStartDate = sc.next();
        System.out.print("Enter Member's School : ");
        String studentMemberSchool = sc.next();

        StudentMember studentMember = new StudentMember(studentMemberName,studentMemberNumber,studentMemberStartDate,studentMemberSchool);
        manager.addStudentMember(studentMember);

    }


    private static void addDefaultMember() {

        System.out.print("Enter Member's First Name : ");
        String defaultMemberName = sc.next();
        System.out.print("Enter New Membership Number : ");
        int defaultMemberNumber = sc.nextInt();
        System.out.print("Enter Membership Starting Date : ");
        String defaultMemberStartDate = sc.next();

        DefaultMember defaultMember = new DefaultMember(defaultMemberName,defaultMemberNumber,defaultMemberStartDate);
        manager.addDefaultMember(defaultMember);

    }

    private static int inputValidation() {
        while (!sc.hasNextInt()) {
            System.out.println("Please Re-enter the Details !!");
            sc.next();
        }
        return sc.nextInt();
    }

}