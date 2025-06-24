import java.util.List;
import java.util.ArrayList;
class SumDigPower {

    public static boolean isEureka(long n){
        long x = n;
        long sum = 0;
        List<Long> digits = new ArrayList<Long>();
        while(x > 0){
            digits.add(x%10);
            x /= 10;
        }

        for(int i = 0; i < digits.size(); i++){
            sum += Math.pow(digits.get(i), i+1);
        }

        if(n == sum)
            return true;
        else
            return false;
    }

    public static List<Long> sumDigPow(long a, long b) {
        List<Long> result = new ArrayList<Long>();
        for(long i = a; i <= b; i++){
            if(isEureka(i)){
                result.add(i);
            }
        }

        return result;
    }

    public static void main(String[] args){
        long a = 1;
        long b = 10;
        System.out.println(sumDigPow(a,b));
    }

}