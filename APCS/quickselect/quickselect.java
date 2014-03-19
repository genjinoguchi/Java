import java.util.*;

public class quickselect{
    //The slower method-- this creates a new array every time it partitions.
    
    public static int quickselect(int[]L, int k){
        return quickselect(L,k,0,L.length);
    }
    public static int quickselect(int[]L, int k, int left, int right){
        if(partition(L,int left, int right)==k){
            return L[k];
        }else if(k<pivotI){
            partition()
        }
    }
    public static int partition(int[]L,int left, int right){
        int[]x = L;
    }
    
    
    public static void main(String[]args){

    }
    
}