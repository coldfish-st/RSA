package rho;

import java.math.BigInteger;
import java.security.SecureRandom;

public class PollardRho {
    private final static BigInteger ZERO = new BigInteger("0");
    private final static BigInteger ONE  = new BigInteger("1");
    private final static BigInteger TWO  = new BigInteger("2");
    private final static SecureRandom random = new SecureRandom();

    public static BigInteger rho(BigInteger N) {
        BigInteger divisor;
        BigInteger c  = new BigInteger(N.bitLength(), random);
        BigInteger x  = new BigInteger(N.bitLength(), random);
        BigInteger xx = x;

        // check divisibility by 2
        if (N.mod(TWO).compareTo(ZERO) == 0) return TWO;

        do {
            x  =  x.multiply(x).mod(N).add(c).mod(N);
            xx = xx.multiply(xx).mod(N).add(c).mod(N);
            xx = xx.multiply(xx).mod(N).add(c).mod(N);
            divisor = x.subtract(xx).gcd(N);
            System.out.println(c);
            //System.out.println();
            System.out.println();
        } while((divisor.compareTo(ONE)) == 0);

        return divisor;
    }

    public static void factor(BigInteger N) {
        if (N.compareTo(ONE) == 0) return;
        if (N.isProbablePrime(20)) {System.out.println(N); return; }
        BigInteger divisor = rho(N);
        factor(divisor);
        factor(N.divide(divisor));
    }

 
    public static void main(String[] args) {
        BigInteger N = new BigInteger("99193711547257063160816850544214924340574358752670644615293764532335872088470223740970673347993652626497557387222167784182876395436088845281840169701654629849214222297784511349059698963212947299142320497759258889425182705042123217476724761095690092179821753840224757786599021225709340258545979566824267620959");
        factor(N); 
    }
}
