package resumenesHash;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class CifradoSimetrico {

	public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, 
		InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		
		//CODIFICAR
		
		//Primero se genera una clave
		KeyGenerator kg = KeyGenerator.getInstance("AES");
		kg.init(128);
		
		//Genera una clave aleatoria
		//Key clave = kg.generateKey(); 
		
		//Genera una clave basada en un texto. Debe tener más de 16 bytes.
		String textoGenerador = "texto de clave....";
		Key clave = new SecretKeySpec(textoGenerador.getBytes(), 0, 16, "AES"); 
		
		String texto = "Este es mi texto secreto";
		
		Cipher codificadorAES = Cipher.getInstance("AES/ECB/PKCS5Padding");
		
		codificadorAES.init(Cipher.ENCRYPT_MODE, clave);
		
		//Convertimos String a array de Bytes
		byte[] textoBytes = texto.getBytes();
		for(byte b : textoBytes) {
			System.out.print(Integer.toHexString(0xFF & b));
		}
		System.out.println();
		
		byte[] textoEncriptado = codificadorAES.doFinal(textoBytes);
		for(byte b : textoEncriptado) {
			System.out.print(Integer.toHexString(0xFF & b));
		}
		System.out.println();
		
		
		//DESCODIFICAR
		
		Cipher descodificadorAES = Cipher.getInstance("AES/ECB/PKCS5Padding");
		descodificadorAES.init(Cipher.DECRYPT_MODE, clave);
		
		byte[] textoDesencriptado = descodificadorAES.doFinal(textoEncriptado);
		for(byte b : textoDesencriptado) {
			System.out.print(Integer.toHexString(0xFF & b));
		}
		System.out.println();
		
		String textoClaro = new String(textoDesencriptado);
		System.out.println(textoClaro);

	}

}
