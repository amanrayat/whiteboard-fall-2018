public class solution {

    public static void main (String args[]){
        for(int i = 1 ; i <=9 ; i++){
            if(i%3==0){
                System.out.println("(" + i + ", " + 0 + " )");
            }
            else{
                System.out.print("(" + i + ", " + (i+1) + " )");
            }
        }
    }
}
