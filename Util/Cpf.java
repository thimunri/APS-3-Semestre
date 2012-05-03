package Util;

public class Cpf {
	  
	public static boolean validaCPF(String cpf) {  
		      boolean ret = false;  
		      String base = "000000000";  
		      String digitos = "00";  
		      
		      if (cpf.length() <= 11) {  
		         if (cpf.length() < 11) {  
		            cpf = base.substring(0, 11 - cpf.length()) + cpf;  
		            base = cpf.substring(0, 9);  
		         }  
		         base = cpf.substring(0, 9);  
		         digitos = cpf.substring(9, 11);  
		         int soma = 0, mult = 11;  
		         int[] var = new int[11];  
		         // Recebe os números e realiza a multiplicação e soma.  
		         for (int i = 0; i < 9; i++) {  
		            var[i] = Integer.parseInt("" + cpf.charAt(i));  
		            if (i < 9)  
		               soma += (var[i] * --mult);  
		         }  
		         // Cria o primeiro dígito verificador.  
		         int resto = soma % 11;  
		         if (resto < 2) {  
		            var[9] = 0;  
		         } else {  
		            var[9] = 11 - resto;  
		         }  
		         // Reinicia os valores.  
		         soma = 0;  
		         mult = 11;  
		         // Realiza a multiplicação e soma do segundo dígito.  
		         for (int i = 0; i < 10; i++)  
		            soma += var[i] * mult--;  
		         // Cria o segundo dígito verificador.  
		         resto = soma % 11;  
		         if (resto < 2) {  
		            var[10] = 0;  
		         } else {  
		            var[10] = 11 - resto;  
		         }  
		         if ((digitos.substring(0, 1).equalsIgnoreCase(new Integer(var[9])  
		               .toString()))  
		               && (digitos.substring(1, 2).equalsIgnoreCase(new Integer(  
		                     var[10]).toString()))) {  
		            ret = true;  
		         }  
		      }  
		  
		      if (ret) {  
		         System.out.println("O CPF  [" + cpf + "]    é   válido.");  
		      } else {  
		         System.out.println("O CPF  [" + cpf + "]    é inválido.");  
		      }  
		      return ret;  
		   } 
}
