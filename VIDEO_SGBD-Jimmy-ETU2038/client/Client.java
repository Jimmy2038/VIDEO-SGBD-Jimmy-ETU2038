import java.net.*;
import java.util.Scanner;
import java.io.*;
public class Client {
  public static void main(String[] args) throws Exception {
    Socket s = new Socket("localhost",500);
    InputStream is = s.getInputStream();
    InputStreamReader in=new InputStreamReader(is);
    BufferedReader bf=new BufferedReader(in);
    OutputStream os = s.getOutputStream();
    PrintWriter pr = new PrintWriter(os);
    String rep=bf.readLine();
    System.out.println(rep);
    System.out.println();
    while (true) {
      Scanner scan = new Scanner(System.in);
      String req=scan.nextLine();
      pr.println(req);
      pr.flush();
      int test = is.read();
      if(test==1){
        System.out.println();
        ObjectInputStream obj=new ObjectInputStream(is);
        Relation re=(Relation) obj.readObject();
        re.affichage();
      }if(test==0){
        System.out.println();
        String exce=bf.readLine();
        System.out.println(exce);
      }
      
        System.out.println();
        // scan.close();
      
    }
      
    
  }
}
