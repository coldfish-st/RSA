package rho;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;

public class Guo_attack {
	
	BigInteger e_1 = new BigInteger("46786465362686334917265996843779843233606992585424976481745055335468678697948774988450305612127967926533923268260412557000125153569622340353246096040604284883505587337829322949633637609180797447754513992039018904786537115087888005528547900640339270052628915440787357271345416818313808448127098885767015748889");

	BigInteger e_2 = new BigInteger("152206992575706893484835984472544529509325440944131662631741403414037956695665533186650071476146389737020554215956181827422540843366433981607643940546405002217220286072880967331118344806315756304650248634546597784597963886656422706197757265316981889118026978865295597135470735576032282694348773714479076093197");

	BigInteger two = new BigInteger("2");
	
	static ArrayList<Pair> list = new ArrayList<Pair>();
	
	public Guo_attack() {
		
		readTxtFile("./data_set/num.txt", list);
		Pair result = new Pair(BigInteger.ONE, BigInteger.ONE);
		
		for (int i = 0 ; i< list.size(); i++) {
			
			Pair pair = list.get(i);
			BigInteger a = pair.getMin();
			BigInteger b = pair.getMax();
			
			BigInteger x = e_1.multiply(a);
			BigInteger y = e_2.multiply(b);			
			BigInteger diff = x.subtract(y);
			
			if (a.mod(two).compareTo(BigInteger.ZERO) != 0 ||
					b.mod(two).compareTo(BigInteger.ZERO) != 0) {
				
				System.out.println("a is"+a.toString()+" test 1");
				
				for (BigInteger k_2 = new BigInteger("3"); a.compareTo(k_2.multiply(k_2)) >= 0; k_2 = k_2.add(two) ) {
					if (a.mod(k_2).compareTo(BigInteger.ZERO) == 0) {
						BigInteger k_1 = k_2.subtract(diff);
						if (b.mod(k_1).compareTo(BigInteger.ZERO) == 0) {
							result = new Pair(k_1, k_2);
							break;
						}
					}
				}
					
			} else {
				
				System.out.println("a is"+a.toString()+" test 2");
				
				for (BigInteger k_2 = new BigInteger("2"); a.compareTo(k_2.multiply(k_2)) >= 0; k_2 = k_2.add(BigInteger.ONE) ) {
					if (a.mod(k_2).compareTo(BigInteger.ZERO) == 0) {
						BigInteger k_1 = k_2.subtract(diff);
						if (b.mod(k_1).compareTo(BigInteger.ZERO) == 0) {
							result = new Pair(k_1, k_2);
							break;
						}
					}
				}
			}
			
			
		}
		
		System.out.println("k_1 is"+result.getMin().toString());
		System.out.println("k_2 is"+result.getMax().toString());
	}
	
	public static void readTxtFile(String filePath, ArrayList<Pair> list){

		try {

			String encoding="GBK";

			File file=new File(filePath);

			if(file.isFile() && file.exists()){ //判断文件是否存在

				InputStreamReader read = new InputStreamReader(new FileInputStream(file),encoding);//考虑到编码格式

				BufferedReader bufferedReader = new BufferedReader(read);

				String line_1 = null;
				String line_2 = null;
				// int i = 0; 
				// HashSet<String> remove_duplicate = new HashSet<String>();
				while((line_1 = bufferedReader.readLine()) != null &&
						(line_2 = bufferedReader.readLine()) != null ){

					StringBuilder temp_1 = new StringBuilder (line_1);
					temp_1.delete(0, 2);
					
					StringBuilder temp_2 = new StringBuilder (line_2);
					temp_2.delete(0, 2);
					
					BigInteger a = new BigInteger(temp_1.toString());
					BigInteger b = new BigInteger(temp_2.toString());
					
					Pair pair = new Pair(a, b);
					
					list.add(pair);
					

					
					System.out.println("Pair is "+a.toString() +" and "+b.toString());
					
				}

				read.close();

			}else{
				System.out.println("找不到指定的文件");
			}
		} catch (Exception e) {
			System.out.println("读取文件内容出错");
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		
		new Guo_attack();
	}

}
