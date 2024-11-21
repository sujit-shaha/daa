package practiceDAAL;

import java.math.BigInteger;

public class assign1 {

	public static void main(String[] args) {
		String str1 = "12345678901234567890";
		String str2 = "12345678901234567890";
		System.out.println(new karstuba().multiply(str1, str2));
		
		BigInteger big1 = new BigInteger(str1);
		BigInteger big2 = new BigInteger(str2);
		
		System.out.println(big1.multiply(big2));
		
	}
	
	
}





class karstuba{
	
	
	public String sumTwo(String str1,String str2) {
		
		if(str1.length()>str2.length()) {
			
			String temp = str1;
			 str1 = str2;
			str2 = temp;
			
		}
		
		int n1 = str1.length();
		int n2 = str2.length();
		
		str1 = new StringBuilder(str1).reverse().toString();
		str2 = new StringBuilder(str2).reverse().toString();
		String ans = "";
		int carry = 0;
		for(int i = 0;i<n1;i++) {
			int sum = (str1.charAt(i)-'0') + (str2.charAt(i)-'0') + carry;
			ans += (char) sum%10;
			carry = sum/10;
		}
		for(int i = n1;i<n2;i++) {
			int sum = (str2.charAt(i)-'0') + carry;
			ans += (char) sum%10;
			carry = sum/10;
		}
		
		if(carry != 0) {
			ans += (char) (carry+'0');
		}
		
		return new StringBuilder(ans).reverse().toString();
		
	}
	
	
	
public String diffTwo(String str1,String str2) {
		
		if(str1.length()<str2.length()) {
			
			String temp = str1;
			 str1 = str2;
			str1 = temp;
			
		}
		
		int n1 = str1.length();
		int n2 = str2.length();
		
		str1 = new StringBuilder(str1).reverse().toString();
		str2 = new StringBuilder(str2).reverse().toString();
		String ans = "";
		int borrow = 0;
		for(int i = 0;i<n2;i++) {
			int diff = (str1.charAt(i)-'0') - (str2.charAt(i)-'0') - borrow;
			
			if(diff < 0) {
				diff += 10;
				borrow = 1;
			}else {
				borrow = 0;
			}
			
			ans += (char) (diff + '0');
		}
		for(int i = n2;i<n1;i++) {
			int diff = (str1.charAt(i)-'0') - borrow;
			
			if(diff < 0) {
				diff += 10;
				borrow = 1;
			}else {
				borrow = 0;
			}
			
			ans += (char) (diff + '0');
		}
		
		
		
		return new StringBuilder(ans).reverse().toString();
		
	}
	

	public String multiply(String str1,String str2) {
		
		if(str1.length()>str2.length()) {
			String temp= str1;
			str1 =str2;
			str2 = temp;
		}
		
		int n1 = str1.length();
		int n2 = str2.length();
//		System.out.println(n1+" "+n2);
		String ans = "";
		
		if(n1 ==1) {
			int ansInt = Integer.parseInt(str2)*Integer.parseInt(str1);
			return Integer.toString(ansInt);
		}
		
		while(n2>n1) {
			str1 = '0' + str1;
			n1++;
		}
		
		if(n1%2 == 1) {
			str1 = '0'+str1;
			str2 = '0'+str2;
			n1++;			
		}
		
		
		String al = "",ar = "",bl = "",br = "";
		for(int i = 0;i<n1/2;i++) {
			al += str1.charAt(i);
			bl += str2.charAt(i);
			ar += str1.charAt((n1/2)+i);
			br += str1.charAt((n1/2)+i);
		}
//		System.out.println("------"+al+"------"+ar+"------"+br+"------------"+bl);
		
		String p = multiply(al, bl);
		
		String q = multiply(br, ar);
		
		String r = diffTwo(multiply(sumTwo(al, ar), sumTwo(bl, br)), sumTwo(q, p));
		
		
		for(int i = 0;i<n1;i++) {
			p = p+'0';
		}
		
		for(int i = 0;i<n1/2;i++) {
			r = r+'0';
		}
		
//		System.out.println("------"+p+"------"+q+"------"+r);
		
		ans = sumTwo(p, sumTwo(q, r));
		
		ans = removeZero(ans);
		return ans;
		
		
	}
	
	public String removeZero(String s) {
		
		String pattern = "^0+(?!$)";
		
		s= s.replaceAll(pattern, "");
		return s;
		
	}
	
	
}














//class karstuba{
//	
//	
//	String sumTwo(String str1,String str2) {
//		
//		String ans = "";
//		
//		if(str1.length() > str2.length()) {
//			String temp = str1;
//			str1 = str2;
//			str2 = temp;			
//		}
//		
//		int n1 = str1.length();
//		int n2 = str2.length();
//		
//		str1 = new StringBuilder(str1).reverse().toString();
//		str2 = new StringBuilder(str2).reverse().toString();
//		int carry = 0;
//		for (int i = 0; i < n1; i++) {
//			int sum = (str1.charAt(i)-'0') + (str2.charAt(i)-'0') +carry;
//			ans += (char) sum%10;
//			carry = sum/10;
//		}
//		for (int i = n1; i < n2; i++) {
//			int sum = str2.charAt(i)-'0' +carry;
//			ans += (char) sum%10;
//			carry = sum/10;
//		}
//		if(carry != 0) {
//			ans += (char)(carry+ '0');
//		}
//		
//		return new StringBuilder(ans).reverse().toString();
//	}
//	
//	
//	String diffTwo(String str1,String str2) {
//
//		
//		String ans = "";
//		
//		if(str1.length() < str2.length()) {
//			String temp = str1;
//			str1 = str2;
//			str2 = temp;			
//		}
//		
//		int n1 = str1.length();
//		int n2 = str2.length();
//		
//		str1 = new StringBuilder(str1).reverse().toString();
//		str2 = new StringBuilder(str2).reverse().toString();
//		int borrow = 0;
//		for (int i = 0; i < n2; i++) {
//			int diff = (str1.charAt(i)-'0') - (str2.charAt(i)-'0') - borrow;
//			
//			if (diff < 0) {
//				diff = diff + 10;
//				borrow = 1;
//			} else {
//				borrow = 0;
//			}
//
//			ans += (char) (diff + '0');
//
//		}
//		for (int i = n2; i < n1; i++) {
//			
//			
//			int diff = (str1.charAt(i)-'0') - borrow;
//			
//			if (diff < 0) {
//				diff = diff + 10;
//				borrow = 1;
//			} else {
//				borrow = 0;
//			}
//
//			ans += (char) (diff + '0');
//		}
//		
//		return new StringBuilder(ans).reverse().toString();
//	}
//	
//	
//	String multiply(String str1, String str2) {
//		
//		String ans = "";
//		
//		
//		if(str1.length()>str2.length()) {
//			String temp = str1;
//			str1 = str2;
//			str2 = temp;
//		}
//		
//		int n1 = str1.length();
//		int n2 = str2.length();
//		
//		while(n2>n1) {
//			str1 = "0" + str1;
//			n1++;
//		}
//		
//		if (n1 == 1) {
//			int ansInt = Integer.parseInt(str1) * Integer.parseInt(str2);
//			return Integer.toString(ansInt);
//		}
//
//		if(n1%2 == 1) {
//			str1 = '0'+str1;
//			str2 = '0'+str2;
//			n1++;
//		}
//		
//		
//		String al = "", ar = "", bl = "", br = "";
//		
//		for(int i = 0;i<n1/2;i++) {
//			al += str1.charAt(i);
//			bl += str2.charAt(i);
//			ar += str1.charAt(i + n1/2);
//			br += str2.charAt(i + n1/2);
//			
//		}
//		
//		String p = multiply(al, bl);
//
//		String q = multiply(ar, br);
//
//		String r = diffTwo( multiply(sumTwo(al, ar), sumTwo(bl,br)), sumTwo(p, q));
//
//		// Multiply p by 10^n
//        for (int i = 0; i < n1; ++i)
//            p = p + "0";
// 
//        // Multiply s by 10^(n/2)
//        for (int i = 0; i < n1 / 2; ++i)
//            r = r + "0";
// 
//        // Calculate final answer p + r + s
//        ans = sumTwo(p, sumTwo(q, r));
//
//        ans = removeLeadingZeros(ans);
//        
//		return ans;
//		
//	}
//	
//	public static String removeLeadingZeros(String str) {
//        // Regex to remove leading 0s from a string
//        String pattern = "^0+(?!$)";
// 
//        // Replaces the matched value with given string
//        str = str.replaceAll(pattern, "");
//        return str;
//    }
//	
//	
//}
