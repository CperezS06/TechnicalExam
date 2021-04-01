package com.ks;

import java.util.LinkedHashMap;

/**
 * Exam :)
 */
public class Application
{
    /**
     * How many centuries have n years ?
     *
     * Example
     * Year 1 belongs to the 1st century
     * Year 99 belongs to the 1st century
     * Year 101 belongs to the 2nd century
     * Year 2020 belongs to the 21st century
     *
     * @param years years...
     * @return century on the years
     */
    public static int yearsToCenturies(int years)
    {
        //Let's start!
        double year = years;
        double centuries = year / 100;
        double decimalPart = centuries % 1;
        double entirePart = centuries - decimalPart;
        
        if(decimalPart != 0){
            return ((int)entirePart + 1);
        }
        else{
            return (int)entirePart;
        }
    }
    
    /**
     * This method search a text equality inside of another text like SCRAMBLE !!!
     *
     * You don't need instructions, right?
     *
     * in: hdsasdellsdasooawwadwdwawrl ,  helloworld
     *     hd    ell    oo w        rl -> hdelloowrl
     * Yes, it doesn't look the same, but ordered you should get the same word, you know, like scramble ...
     *
     **** You must have the same number of letters if you use them more than once ***
     *
     * @param str1 unknown text
     * @param str2 searched word
     * @return if all same words and same quantity from second string exists in first string
     */
    public static boolean scramble(String str1, String str2)
    {
        //First tear ;(
        char[] caracteres = str1.toCharArray();
        char[] cadena = str2.toCharArray();
        char[] banderas1 = new char[str1.length()];
        char[] banderas2 = new char[str2.length()];
        boolean existe = true;
        
        for( int i=0 ; i < cadena.length ; i++){
            
            for( int j=0 ; j<caracteres.length ; j++){
                if (banderas1[j] == 0){
                    if (cadena[i] == caracteres[j]){
                        banderas1[j] = 1;
                        banderas2[i] = 1;
                        break;
                    }
                    else{
                        banderas1[j] = 0;
                        banderas2[i] = 0;
                    }
                }
            } 
        }
        
        for( int i=0 ; i<banderas2.length ; i++){
            if(banderas2[i] == 0){
                existe = false;
            }
        }
        return existe;
    }

    /**
     * Find a middle char(s) in a text
     *
     * Example
     *
     * in: yes (hint: odd)
     * out: e
     *
     * in: word (hint: pair)
     * out: or
     *
     * *** Always wait for a single word ***
     *
     * @param word is the resource
     * @return a middle char(s)
     */
    public static String getMiddle(String word)
    {
        //So easy ...
        char[] palabra = word.toCharArray();
        int caracteres = word.length();
        int div = caracteres / 2;
        String resultado = "";
        
        if((caracteres%2) == 0){
            char[] par = new char[2];
            par[0] = palabra[div];
            par[1] = palabra[div + 1];
            
            resultado = String.copyValueOf(par);
        }
        else{
            resultado = Character.toString(palabra[div]);
        }
        
        return resultado;
    }

    /**
     * This method is used to find how many letters are repeated
     *
     * Example
     *
     * in: AcCoMmOdatIOn
     * out: 4
     *
     * AcCoMmOdatIOn -> have (a:2, c:2, o:3, m:2, d:1, t:1, i:1, n:1)
     *               -> just more than one (a:2, c:2, o:3, m:2)
     *               -> sum them             ^    ^    ^    ^  -> 4
     *
     * *** As you can see, case sensitive is irrelevant, spaces don't count ***
     *
     * @param text is the resource to search
     * @return how many words are repeated
     */
    public static int duplicateCount(String text)//PENDIENTE
    {
        //have fun!
        
        String cadena = text.toLowerCase();

        LinkedHashMap <Character, Integer> map = new LinkedHashMap<Character, Integer>();
        for(char c : cadena.toCharArray()){
            if(map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        
        int contador=0;
        for(Integer valor : map.values()){
            if (valor > 1){
                contador++;
            }
        }
        return contador;
        
    }

    /**
     * This method get how many times a vocals are in a text
     *
     * Example
     *
     * in : "vowel counting is not an everyday thing"
     *        ^ ^   ^^  ^   ^   ^  ^  ^ ^   ^    ^   -> 12
     *
     * ***Always wait lowercase***
     *
     * @param str is a text to search
     * @return a number of how many times a vocals are in a text
     */
    public static int getCount(String str)
    {
        //...
        int contador = 0;
        for(int i=0 ; i<str.length() ; i++){
            if(str.charAt(i)=='a'||str.charAt(i)=='e'||str.charAt(i)=='i'||str.charAt(i)=='o'||str.charAt(i)=='u'){
                contador++;
            }
        }
        return contador;
    }

    /**
     * This method solve a quantity of multiply all separated decimal numbers on a number recursively
     *
     * in : 236
     * out: 8
     *
     * how ?
     *
     * 236 -> (2 * 3 * 6) = [36] -> (3 * 6) = [18] (1 * 8) = [8]
     *
     * <h3> How many times a decimal values need be multiplied to find a root number</h3>
     *
     * @param n a number to find a digital root
     * @return how many times a decimal values in a number can be multiplied recursively
     */
    public static int persistence(long n)
    {
        //Next is so easy after this
        
        int numero = (int)n;
        int total, d;
        do{
            total = 1;
            while (numero > 0){
            d = numero % 10;
            total = total*d;
            numero = numero / 10;
            }
            numero = total;
        }while(total > 9);
        return total;
    }

    /**
     * This value sum all separated decimal numbers on a number recursively
     *
     * in : 123456
     * out : 3
     *
     * how ?
     *
     * 123456 -> (1 + 2 + 3 + 4 + 5 + 6) = [21] -> (2 + 1) = [3]
     *
     * @param n a number to find a digital root
     * @return digital root from a number
     */
    public static int digital_root(int n)
    {
        //Another easy
        int total, d;
        do{
            total = 0;
            while (n > 0){
            d = n % 10;
            total = total+d;
            n = n / 10;
            }
            n = total;
        }while(total > 9);
        
        return total;
        
    }


    /**
     * This method return a char pair in array
     *
     * Example
     * in: "Give me some pairs please"
     * out: [Gi, ve,  m, e , so, me,  p, ai, rs,  p, le, as, e_]
     *
     * ***Spaces also count***
     *
     * @param s a text to evaluate
     * @return an array with pair of chars
     */
    public static String[] solution(String s) 
    {
        //Will be worse ?
        
        boolean impar = false;
        if((s.length())%2 == 0){
            double tam = ((double)s.length() / 2);
        }
        else{
            
            double par = ((double)s.length() / 2);
            double tam = Math.ceil(par);
            impar = true;
        }
        double par = ((double)s.length() / 2);
        double tam = Math.ceil(par);
        
        String[] pares = new String[(int)tam];
        char[] caracter = new char[2];
        int cont=0;
        
        for (int i = 0; i < s.length() -1; i += 2) {
            s.getChars(i, i+2, caracter, 0);
            pares[cont] = String.valueOf(caracter);
            cont++;
        }
        
        if(impar){
            pares[pares.length - 1] = s.substring(s.length()-1) + "_";
        }
        return pares;
        
    }

    /**
     * This method convert a long in a valid ip
     *
     * Example
     *
     * in: 2147483467L -> out : 127.255.255.75
     *
     * how ?
     * 1.- Convert a long in binary (you will always get 32 bits or less, if there is less just apply the pad to the left with zero)
     * 2.- Get 4 bytes (4 groups of 8 bits will give you 4 bytes)
     * 3.- Converts each byte to a decimal number
     * 4.- Apply the ip format to your 4 decimal numbers
     *
     * @param ip is a 32 bits number maximum
     * @return an IP
     */
    public static String longToIP(long ip)
    {
        //yes, can be worse...
        String binario = Long.toBinaryString(ip);
        String[] octetos = new String[4];
        StringBuilder direccion = new StringBuilder();
        
        int contador=0;
        for(int i=0 ; i<4 ; i++){
            octetos[i] = binario.substring(contador, contador + 8);
            contador = contador + 8;
        }
        
        for(int i=0 ; i<4 ; i++){
            
            long decimal = 0;
            int posicion = 0;
            
            for(int j = octetos[i].length() -1 ; j>=0 ; j-- ){
                short digito = 1;
                if(octetos[i].charAt(j) == '0'){
                    digito = 0;
                }

                double multiplicador = Math.pow(2,posicion);
                decimal += digito * multiplicador;
                posicion++;
            }
            direccion.append(decimal);
            if( i <3){
                direccion.append(".");
            }
            
        }
        String direccionIP = direccion.toString();
        return direccionIP;
    }

    /**
     * This method find a shortest word in a text
     *
     * Example
     * in : "When I was young I had a lot of toys" -> out : 1
     *            ^           ^     ^              -> can be any of them
     *
     * in : "The worst part of school was solving problems like this" -> out : 2
     *                      ^^
     *
     * @param s a text to find the shortest word
     * @return a shortest word size in a text
     */
    public static int findShort(String s)
    {
        //have fun!
        String [] words = s.split(" ");
        
        int conteo = 1000;
        
        for(int i=0 ; i<words.length ; i++ ){
            if(words[i].length() < conteo){
                conteo = words[i].length();
            }
        }
        
        return conteo;
    }

    /**
     * Find a first number repeated in the array
     *
     * Example
     * in : {1,2,3,8,5,2} -> out : 2
     * in : {5,9,6,7,5,9,9} -> out : 5
     * in : {5,1,6,7,8,9,9} -> out : 9
     *
     * @param values is an int array
     * @return a first number repeated in the array or else return -1
     */
    public static Integer repeated(int[] values)
    {
        //Last one!
       
        boolean repetido = false;
        int indice = 0;
        for(int i=0 ; i<values.length ; i++){
            int contador = 0;
           for(int j=0 ; j<values.length ; j++){
               if(values[i] == values[j]){
                   contador++;
               }
           }
           if(contador > 1){
               indice = i;
               repetido = true;
           }
           if(repetido){
               break;
           }
        }
        
        if(!repetido){
            return -1;
        }
        return values[indice];
    }
}
