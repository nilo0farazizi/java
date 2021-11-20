package model;

import jdbc.MyJdbc;
import match.Emtiyaz;
import match.Match;
import match.Team;
import java.util.ArrayList;
import java.util.Scanner;

public class MyScanner {

    static  int choice;
    public MyScanner(){

        User p=new User();
        Match m=new Match();
        MyJdbc j=new MyJdbc();
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> mylist = new ArrayList<>();
        Emtiyaz emtiyaz=new Emtiyaz();

        do{
            System.out.println("=======foootbal--niloofar========");
            System.out.println(" ---------------------------------- ");
            System.out.println(" 1. ...inset new matches");
            System.out.println(" 2. ...show all match");
            System.out.println(" 3. ...insert a prediction for matches");
            System.out.println(" 4. ...insert match results");
            System.out.println(" 5. ...mohasebe natayej va sabt emtiyaz har username");
            System.out.println(" 6. Exit      ");
            System.out.println(" ----------------------------------\n ");
            System.out.print("Please enter the number choice what)\n");
            choice=Integer.parseInt(scanner.next());



            switch(choice) {
                case 1:{
                    System.out.print("Enter in order :>>>>>Id(Numerically):>>>>>:\n");
                    mylist.add(scanner.next());
                    System.out.print("plz Enter :>>>>>Team1:>>>>>:az lis sabt shavad\n");
                    System.out.print(" "+ Team.ESTEGHLAL+" or  " +Team.PERSPOLIS+ " OR "+ Team.SEPAHAN+"\n");
                    String team1=scanner.next();
                    mylist.add(team1);
                    System.out.print("plz Enter :>>>>>Team2:>>>>>::az list sabt shavad\n");
                    System.out.print(Team.ESTEGHLAL+" or " +Team.PERSPOLIS+ " OR "+ Team.SEPAHAN +"\n");
                    String team2=scanner.next();
                    mylist.add(team2);
                    if (team1.equals(team2)){ System.out.print("dar yek mosabeghe beyn 2 tim moshabeh vared nashavad dobare bezan \n ");break;}
                    System.out.print("plz Enter :>>>>>Name baraye mosabeghe :>>>>>:");
                    mylist.add(scanner.next());
                    try {
                       j.save(mylist);
                    } catch (Exception e) {
                        System.out.println("Input is incorrect" + e.getMessage());
                    }
                    System.out.println("Press Enter key to continue... \n");

                }//End of case 1
                break;




                case 2:{
                    try {
                        j.findAll();
                    } catch (Exception e) {
                        System.out.println("Input is incorrect" + e.getMessage());
                    }
                    System.out.println("Press Enter key to continue...\n");
                }
                break;




                case 3:{
                    System.out.print(":>>>>>:(id) mosabeghe ra az list zir entekhab konid va (number) ra vared konid \n");
                     j.findAll();
                     int Matchid=scanner.nextInt();
                      j.findByResult(Matchid);
                   try {
                           System.out.println("tedad GOlhaye time aval ra vared konid (number)...\n");
                           int tim1 = scanner.nextInt();
                           System.out.println("tedad GOlhaye time dovom ra vared konid (number)...\n");
                           int tim2 = scanner.nextInt();
                           System.out.println("plz username khod ra baraye sabte emtiyaz vared konid..\n");
                           p.setUsername(scanner.next());
                           emtiyaz.SetPishbini(tim1,tim2, p.getUsername(),Matchid);
                    } catch (Exception e) {
                        System.out.println("Input is incorrect" + e.getMessage());
                    }
                    System.out.println("Press Enter key to continue... \n");

                }//End of case 3
                break;



                case 4:{
                    System.out.print(":>>>>>:mosabeghe ra az list zir entekhab konid va ((Name)) ra varde konid \n");
                    j.findAll();
                    String matchname=scanner.next();
                 try{
                System.out.println("tedad golhaye time 1 (number)... \n");
                Integer team1=scanner.nextInt();
                System.out.println("tedad golhaye time 2 (number)... \n");
                Integer team2=scanner.nextInt();
                j.updateResult(team1,team2,matchname);
                     } catch (Exception e) {
                System.out.println("Input is incorrect" + e.getMessage());
                  }
                    System.out.println("Press Enter key to continue... \n");
                }
                break;


                case 5:{
                    System.out.println("Press Enter username baraye mosahebe emtiyazat dorost va sabt... \n");
                    p.setUsername(scanner.next());
                 try {
                     emtiyaz.SetEmtiyaz(p.getUsername());
                 }catch (Exception e) {
                     System.out.println("Input is incorrect" + e.getMessage());
                 }
                    System.out.println("Press Enter key to continue... \n");
                }
                break;



                default:
                    return;
            }

        } while (choice!=5);


    }

}
