import java.util.*;
import java.io.*;
class Update
{
    private String[] double_length(String str[],int len) throws IOException
    {
         String temp[]=new String[2*len];
         for(int i=0;i<len;i++)
            temp[i]=str[i];
        return temp;
    }
    public void change_password(String id ,String new_pass) throws IOException
    {
        String[] final_str=new String[5];
        int i=0;
        try{
           BufferedReader bf=new BufferedReader(new FileReader("login_details_fac.csv"));
           String line=bf.readLine();
           while(line!=null)
           {
               String[] str_line=line.split(",");
               if (id.equals(str_line[0]))
               {
                   str_line[1]=new_pass;
                   line=(Arrays.toString(str_line)).replace("[","").replace("]","");
                   for(int j=0;j<line.length();j++)
                   {
                       if (line.charAt(j)==' ')
                       {
                           line=line.substring(0,j)+line.substring(j+1,line.length());
                           break;
                       }
                   }
               }
                final_str[i]=line;    
               i++; 
               if (i==final_str.length)
                  final_str=double_length(final_str,final_str.length);
               line=bf.readLine();
           }
        }
        catch(Exception e)
        {
            System.out.println("Problem in file reading");
        }
        PrintWriter pw=new PrintWriter("login_details_fac.csv");
        for(int j=0;j<i;j++)
            pw.println(final_str[j]);
        pw.flush();
        pw.close();
    }
}