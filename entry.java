import java.util.Scanner;
public class entry{
  public static void main(String[] args){
    Scanner scan=new Scanner(System.in);
    login log=new login();
    System.out.println("1. Admin\n2. Faculty");
    int choice=scan.nextInt();
    if(choice==1){
        System.out.println("-------------------------------------------------");
        log.input_taker_admin();
    }
    else{
        System.out.println("-------------------------------------------------");
        log.input_taker_faculty();
    }
  }
}
