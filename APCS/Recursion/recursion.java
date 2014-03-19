public class recursion{
    public String lastName(){
        /*change this! to your name*/
        return "Noguchi";
    }
    public String firstName(){
        /*change this! to your name*/
        return "Genji";
    }
    public int hailLen(int n){
        if(n==1){
            return 1;
        }else if(n%2==0){
            return 1 + hailLen(n/2);
        }else{
            return 1 + hailLen(3*n + 1);
        }
    }

    public int longestHail(int n){
        /*put in your code here...*/
        if(n>1){
            return maxHail(n, longestHail(n-1));
        }else{
            return 1;
        }
    }
    public int maxHail(int a, int b){
        if(hailLen(a)>hailLen(b)){
            return a;
        }return b;
    }
    public int fibItr(int n){
        /*put in your code here...*/
        return fibItr(n,2,1,1);
    }
    public int fibItr(int n,int place,int fib, int fibprev){
        if(place==n){
            return fib;
        }else{
            return fibItr(n,place+1,fib+fibprev,fib);
        }
    }

    public recursion(){
        /*leave alone*/
    }
}
