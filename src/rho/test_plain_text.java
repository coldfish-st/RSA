package rho;

import java.math.BigInteger;

public class test_plain_text {
	
	public static void main(String[] args) {
		BigInteger N = new BigInteger("9876543210abcdef0000000f00000000000000000000000000000000000000000000000000000000000000000000000000000000000000007977686572652e22", 16);
		BigInteger M = new BigInteger("111178307033150739104608647474199786251516913698936331430121060587893564405482896814045419370401816305592149685291034839621072343496556225594365571727260237484885924615887468053644519779081871778996851601207571981072261232384577126377714005550318990486619636734701266032569413421915520143377137845245405768733");
		BigInteger result = (N.pow(65537)).mod(M);
		
		System.out.println(result);

	}
}