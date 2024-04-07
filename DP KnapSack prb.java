import java.util.*;
class Main
{
  static  int max(int a,int b){return (a>b)?a:b;}
  static int knaSackRec(int W, int wt[],int val[],int n,int[][] dp)
  {
    if(n<0||W==0)
      return 0;
    if(dp[n][W]!=-1)
      return dp[n][W];
    if(wt[n]>W)
      return dp[n][W]=knaSackRec(W,wt,val,n-1,dp);
    else
      return dp[n][W]=max((val[n]+knaSackRec(W-wt[n],wt,val,n-1,dp)),knaSackRec(W,wt,val,n-1,dp));
  }
  static int kanpSack(int W,int wt[],int val[],int N)
  {
    int dp[][]=new int [N+1][W+1];
    for(int i=0;i<N+1;i++)
      for(int j=0;j<W+1;j++)
        dp[i][j]=-1;
    return knaSackRec(W,wt,val,N,dp);
  }
  public static void main(String args[])
  {
    Scanner sc= new Scanner(System.in);
    int n=sc.nextInt();
    int pro[]=new int[n];
    for(int i=0;i<n;i++)
      pro[i]=sc.nextInt();
    int m=sc.nextInt();
    int wt[]=new int[m];
    for(int i=0;i<m;i++)
      wt[i]=sc.nextInt();
    int W=sc.nextInt();//KANPSACK MAX WEIGHT
	System.out.println(kanpSack(W,wt,pro,n-1));
  }
}
