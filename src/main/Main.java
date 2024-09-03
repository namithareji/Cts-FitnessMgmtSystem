package main;
import com.fitness.dao.*;
import com.fitness.exception.MemberNotFoundException;
//import com.TrainerDAO;
//import com.ClassDAO;
import com.fitness.model.*;
//import com.model.Member;
//import com.model.Trainer;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws MemberNotFoundException {
      Scanner scanner = new Scanner(System.in);
      MemberDAO memberDAO = new MemberDAO();
      TrainerDAO trainerDAO = new TrainerDAO();
      ClassDAO classDAO = new ClassDAO();

      while (true) {
    	  System.out.println();
          System.out.println("FITNESS CENTER MANAGEMENT SYSTEM");
          System.out.println("1. Member Management");
          System.out.println("2. Trainer Management");
          System.out.println("3. Class Management");
          System.out.println("4. Exit");

          int choice = scanner.nextInt();

          switch (choice) {
              case 1:
                  memberMenu(scanner, memberDAO);
                  break;
              case 2:
                  trainerMenu(scanner, trainerDAO);
                  break;
              case 3:
                  classMenu(scanner, classDAO);
                  break;
              case 4:
                  System.exit(0);
                  break;
              default:
                  System.out.println("Invalid choice, please try again.");
          }
      }
  }
     //Member Management Menu
  public static void memberMenu(Scanner scanner, MemberDAO memberDAO) throws MemberNotFoundException {
	  System.out.println();
      System.out.println("Member Management Menu");
      System.out.println("1. Register a new member");
      System.out.println("2. View member details");
      System.out.println("3. Update member information");
      System.out.println("4. Delete a member");
      System.out.println("5. Back to main menu");

      int choice = scanner.nextInt();
      switch (choice) {
          case 1:
              // Register a new member
              System.out.println("Enter name:");
              String name = scanner.next();
              System.out.println("Enter email:");
              String email = scanner.next();
              System.out.println("Enter phone number:");
              String phone = scanner.next();
              System.out.println("Enter membership type:");
              String type = scanner.next();
              Member newMember = new Member(0, name, email, phone, type);
              memberDAO.registerMember(newMember);
              System.out.println("Registered Successfully!");
              break;
          case 2:
              // View member details
              System.out.println("Enter member ID:");
              int memberId = scanner.nextInt();
              Member member = memberDAO.viewMember(memberId);
              if (member != null) {
                  System.out.println("Member ID: " + member.getMemberId());
                  System.out.println("Name: " + member.getName());
                  System.out.println("Email: " + member.getEmail());
                  System.out.println("Phone: " + member.getPhoneNumber());
                  System.out.println("Membership Type: " + member.getMembershipType());
             } 
                 // else {
//                  System.out.println("Member not found.");
//              }
                	  else {
                          throw new MemberNotFoundException("Member with ID " + memberId + " not found.");
                      }
              break;
          case 3:
              // Update member information
              System.out.println("Enter member ID:");
              memberId = scanner.nextInt();
              member = memberDAO.viewMember(memberId);
              if (member != null) {
                  System.out.println("Enter new name:");
                  name = scanner.next();
                  System.out.println("Enter new email:");
                  email = scanner.next();
                  System.out.println("Enter new phone number:");
                  phone = scanner.next();
                  System.out.println("Enter new membership type:");
                  type = scanner.next();
                  member.setName(name);
                  member.setEmail(email);
                  member.setPhoneNumber(phone);
                  member.setMembershipType(type);
                  memberDAO.updateMember(member);
                  System.out.println("Updated Successfully!");
              } else {
                  System.out.println("Member not found.");
              }
              break;
          case 4:
              // Delete a member
              System.out.println("Enter member ID:");
              memberId = scanner.nextInt();
              memberDAO.deleteMember(memberId);
              System.out.println("Deleted Successfully!");
              break;
          case 5:
        	  return;
          default:
              System.out.println("Invalid choice, please try again.");
      }
  }

  
  // Trainer Management Menu
  private static void trainerMenu(Scanner scanner, TrainerDAO trainerDAO) {
      while (true) {
    	  System.out.println();
          System.out.println("Trainer Management Menu");
          System.out.println("1. Add a new trainer");
          System.out.println("2. View trainer details");
          System.out.println("3. Update trainer information");
          System.out.println("4. Delete a trainer");
          System.out.println("5. Back to main menu");

          
          int choice = scanner.nextInt();
          switch (choice) {
              case 1:
                  // Register a new trainer
              System.out.println("Enter name:");
              String name = scanner.next();
              System.out.println("Enter email:");
              String email = scanner.next();
              System.out.println("Enter phone number:");
              String phone = scanner.next();
              System.out.println("Enter specialization:");
              String specialization = scanner.next();
              Trainer newTrainer = new Trainer(0, name, email, phone, specialization);
              trainerDAO.addTrainer(newTrainer);
              System.out.println("Registered Successfully!");
                  break;
              case 2:
                  // View trainer details
              System.out.println("Enter trainer ID:");
              int trainerId = scanner.nextInt();
              Trainer trainer = trainerDAO.viewTrainer(trainerId);
              if (trainer != null) {
                  System.out.println("Trainer ID: " + trainer.getTrainerId());
                  System.out.println("Name: " + trainer.getName());
                  System.out.println("Email: " + trainer.getEmail());
                  System.out.println("Phone: " + trainer.getPhoneNumber());
                  System.out.println("Specialization: " + trainer.getSpecialization());
              } else {
                  System.out.println("Trainer not found.");
              }
              break;
              case 3:
                  // Update trainer information
              System.out.println("Enter trainer ID:");
              trainerId = scanner.nextInt();
              trainer = trainerDAO.viewTrainer(trainerId);
              if (trainer != null) {
                  System.out.println("Enter new name:");
                  name = scanner.next();
                  System.out.println("Enter new email:");
                  email = scanner.next();
                  System.out.println("Enter new phone number:");
                  phone = scanner.next();
                  System.out.println("Enter new specialization:");
                  specialization = scanner.next();
                  trainer.setName(name);
                  trainer.setEmail(email);
                  trainer.setPhoneNumber(phone);
                  trainer.setSpecialization(specialization);
                  trainerDAO.updateTrainer(trainer);
                  System.out.println("Updated Successfully!");
              } else {
                  System.out.println("Trainer not found.");
              }
              break;
              case 4:
                  // Delete a trainer
              System.out.println("Enter trainer ID:");
              trainerId = scanner.nextInt();
              trainerDAO.deleteTrainer(trainerId);
              System.out.println("Deleted Successfully!");
              break;
              case 5:
            	  return;
              default:
                  System.out.println("Invalid choice, please try again.");
          }
      }
  }

  // Class Management Menu
  private static void classMenu(Scanner scanner, ClassDAO fitnessClassDAO) {
      while (true) {
    	  System.out.println();
          System.out.println("Class Management Menu");
          System.out.println("1. Schedule a new class");
          System.out.println("2. View class details");
          System.out.println("3. Update class information");
          System.out.println("4. Cancel a class");
          System.out.println("5. Back to main menu");

          
          int choice = scanner.nextInt();
          switch (choice) {
              case 1:
//                  System.out.println("Enter class ID for the class:");
//                  int classId = scanner.nextInt();
            	  System.out.println("Enter trainer ID for class:");
                  int trainerId = scanner.nextInt();
                  System.out.println("Enter class name:");
                  String name = scanner.next();
                  System.out.println("Enter class schedule(yyyy-mm-ddThh:mm:ss):");
                  String schedule = scanner.next();
                  System.out.println("Enter class capacity:");
                  int capacity = scanner.nextInt();
//                System.out.println("Enter class status(scheduled/cancelled):");
//                String status = scanner.next();
                  String status = "scheduled";
                  FitnessClass newClass = new FitnessClass(0,trainerId, name, schedule,capacity, status);
                  fitnessClassDAO.scheduleClass(newClass);
                  System.out.println("Scheduled Successfully!");
                  break;
              case 2:
                  // View class details
              System.out.println("Enter class ID:");
              int classId = scanner.nextInt();
              newClass = fitnessClassDAO.viewClass(classId);
              if (newClass != null) {
                  System.out.println("Trainer ID: " + newClass.getTrainerId());
                  System.out.println("Class Name: " + newClass.getClassName());
                  System.out.println("Class Schedule: " + newClass.getSchedule());
                  System.out.println("Class Capacity: " + newClass.getCapacity());
                  System.out.println("Status: " + newClass.getStatus());
              } else {
                  System.out.println("Class not found.");
              }
              break;
              case 3:
                  // Update class information
              System.out.println("Enter class ID:");
              classId = scanner.nextInt();
              newClass = fitnessClassDAO.viewClass(classId);
              if (newClass != null) {
            	  System.out.println("Enter new trainer ID for class:");
                  trainerId = scanner.nextInt();
                  System.out.println("Enter new class name:");
                  name = scanner.next();
                  System.out.println("Enter new class schedule:");
                  schedule = scanner.next();
                  System.out.println("Enter new class capacity:");
                  capacity = scanner.nextInt();
                  System.out.println("Enter new status:");
                  status = scanner.next();
                  newClass.setTrainerId(trainerId);
                  newClass.setClassName(name);
                  newClass.setSchedule(schedule);
                  newClass.setCapacity(capacity);
                  newClass.setStatus(status);;
                  fitnessClassDAO.updateClass(newClass);
                  System.out.println("Updated Successfully!");
              } else {
                  System.out.println("Class not found.");
              }
              break;
              case 4:
              // Cancel a class
              System.out.println("Enter class ID:");
              classId = scanner.nextInt();
              fitnessClassDAO.cancelClass(classId);
              System.out.println("Class cancelled!");
              break;
              case 5:
            	  return;
              default:
                  System.out.println("Invalid choice, please try again.");
          }
      }
  }
}


