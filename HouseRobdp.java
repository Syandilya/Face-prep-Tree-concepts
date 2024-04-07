import java.util.*;
class Main
{
  static int max(int a,int b){return (a>b) ? a:b;}
  static int houseR(int hal[],int i)
  {
    int dp[]=new int[hal.length];
    if(i==0)
      return 0;
     if(i==1)
       return hal[0];
    if(i==2)
      return max(hal[0],hal[1]);
    dp[0]=hal[0];
    dp[1]=max(hal[0],hal[1]);
    for(int j=2;j<hal.length;j++){
      dp[j]=max(hal[j]+dp[j-2],dp[j-1]);}
    return dp[hal.length-1];
  }
	public static void main(String[]args)
    {
      Scanner sc= new Scanner(System.in);
      int n=sc.nextInt();
      int value[]=new int[n];
      for(int i=0;i<n;i++)
      {
        value[i]=sc.nextInt();
      }
      System.out.println(houseR(value,n));
    }
}
