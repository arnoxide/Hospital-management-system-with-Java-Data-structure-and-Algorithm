
package curalli;

import java.util.Scanner;

public class Curalli {

   
    public static void main(String[] args) {
        
        PatientList plist = new PatientList();
        DoctorsList dlist = new DoctorsList();
        Scanner s= new Scanner(System.in);
        
        String choice;
        
        while(true){
            MainMenu();
            choice=s.nextLine();
            if(choice.equals("1")){
                
                System.out.println("\n Doctor ID");
                String id = s.nextLine();
                
                System.out.println("\n Doctor Name");
                String name = s.nextLine();
                
                 System.out.println("\n Doctor Contact");
                String contact = s.nextLine();
                
                 System.out.println("\n Doctor Specialty");
                String spec = s.nextLine();
                
                System.out.println("\n Doctor Fee");
                int fees = s.nextInt();
                s.nextLine();
                
                Doctor d = new Doctor(id,name,contact,spec,fees);
                dlist.Insert(d);
            }
            else if(choice.equals("2")){
                System.out.println("\n Patient ID");
                        String id = s.nextLine();
                        
                System.out.println("\n Patient Name");
                String name = s.nextLine();
                        
                System.out.println("\n Patient Contact");
                String contact = s.nextLine();
                
                Patient patient = new Patient(id,name,contact);
                plist.Insert(patient);
            }
            else if(choice.equals("3")){
                dlist.PrintData();
            }
            else if(choice.equals("4")){
                plist.PrintData();
            }
            
             else if(choice.equals("5")){
              System.out.println("\n Welcome to Checkup Menu");
              
              CheckUpList[] clist = new CheckUpList[dlist.size()];
              //System.out.println(clist.length);
              for(int i=0;i<clist.length;i++){
                  clist[i] = new CheckUplist();
                  Doctor doctor = dlist.getAtIndex(1);
                  System.out.println("\n\n Enter Patient for Doctor");
                   System.out.println("Name         :"+doctor.getName());
                    System.out.println("Speciality         :"+doctor.getSpecialty());
                     System.out.println("Fees         :"+doctor.getFees());
                     
                     System.out.println("All Patients ");
                     plist.PrintData();
                     
                     while(true){
                         System.out.println("Enter Patient ID or type null to stop");
                         String id=s.nextLine();
                         
                         if(id.equals("null")){
                             break;
                         }
                         
                         System.out.println("Priority 3 for Emergency, 2 for Intermediate, any other key for Normal");
                         String per=s.nextLine();
                         
                         int p=1;
                         
                         if(per.equals(3)){
                             p=3;
                         }
                         else if(per.equals(2)){
                             p=2;
                         }
                         
                         Patient patient=plist.searchByID(id);
                         if(patient==null){
                             System.out.println("\n Invalid Patient Id : \n");
                         }
                         else{
                             Checkup cup = new Checkup(doctor,patient,p,"",""+java.util.Calendar.getInstance().getTime().toString());
                             
                             clist[i].Enqueue(cup);
                         }
                     }
                    
              }
              
              for (int i=0;i<clist.length;i++){
                  System.out.println("\n\n Patient "+ (i+1)+" In Queue For Doctor "+dlist.getAtIndex(i).getName());
                  
                  for(int j=0;j<clist[i].size();j++){
                      System.out.println("Enter Reccomendation For Patient : "+clist[i].getPatient(j));
                      String rec = s.nextLine();
                      
                      clist[i].addRecomandation(j, rec);
                  }
              }
              
              
              
            }
            
            
             else if (choice.equals("0")){
                 
             }
        }
        
       
        
        
         
         
        
    }
    
    public static void MainMenu(){
        
        System.out.println("\n\n ||   ******  Curalli   ******   ||");
        System.out.println("\n\n ||   Main Menu  ||");
        System.out.println("\n Enter 1 to insert new Doctor ");
        System.out.println("\n Enter 2 to insert new Patient ");
        System.out.println("\n Enter 3 to Print all Doctors ");
        System.out.println("\n Enter 4 to Print all Patients ");
   
        
        
        System.out.println("\n Enter 5 for CheckUP Menu ");
        System.out.println("\n Enter 0 to Exit ");
        
    }
    
}
