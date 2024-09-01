package vrenamer;

import javax.swing.*;
import javax.swing.text.*;

public class numbersField extends JTextField {

     private static Boolean Numero = true;

     public numbersField(int cols) {
         super(cols);
     }
 
     @Override
     protected Document createDefaultModel() {
         return new numbersDocument();
     }
     static class numbersDocument extends PlainDocument {

         @Override
         public void insertString(int offs, String str, AttributeSet a) 
             throws BadLocationException {
 
             if (str == null) {
                 return;
             }
             char[] number = str.toCharArray();
	     str="";
             for (int i = 0; i < number.length; i++) {
		 String esNumero = number[i] + "";
                 if ( ! Numero )
                     str = str + number[i];
                 else if ( esNumero.matches("^[0-9]$")) 
                     str = str + number[i];
             }
             super.insertString(offs, str, a);
         }
     }
     public void setNumero (Boolean Numero) {
         numbersField.Numero = Numero;
     }
}