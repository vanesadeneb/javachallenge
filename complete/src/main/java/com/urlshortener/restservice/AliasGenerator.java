package com.urlshortener.restservice;
import java.util.Random;

public class AliasGenerator {

	public static String generate(String url) {
		String alias;
		
		if(url.contains("google")){
			//generar random de 5 letras
			char[] charset_azAZ = "abcdefghijklmnopqrstvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
			alias = randomString(charset_azAZ, 5);
		}else if(url.contains("yahoo")){
			// generar random de 7 letras y numeros
			char[] charset_azAZ09 = "abcdefghijklmnopqrstvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
			alias = randomString(charset_azAZ09, 7);
		}else{
			// eliminar de url caracteres especiales, vocales y numeros
			//primer filtro: quitar caracteres especiales
			String withoutSpecialChars = url.replaceAll("[^\\dA-Za-z]", "");
			//segundo filtro: quitar vocales
			String withoutVowels = withoutSpecialChars.replaceAll("[aeiouAEIOU]", "");
			//Tercer filtro: quitar numeros
			String withoutNumbers = withoutVowels.replaceAll("[0123456789]", "");
			alias = withoutNumbers;
		}
		return alias;
	}
	
	private static String randomString(char[] characterSet, int length) {
		Random random = new Random();
		char[] result = new char[length];
		for (int i = 0; i < result.length; i++) {
			// picks a random index out of character set > random character
			int randomCharIndex = random.nextInt(characterSet.length);
			result[i] = characterSet[randomCharIndex];
		}
		return new String(result);
	}
}
