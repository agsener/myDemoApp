package com.mycompany.app;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
    //Verilen stringin verilen indexleri ve o indexler arasında harf disinda baska bir kar. varsa false donen program
    public static boolean rr(String[] str, int x, int y){
	if(str == null){
		return false;
	}
    	String ss="";
    	for(int i=0; i<str.length; i++){
    		ss += str[i];
    	}
    	ss = ss.toLowerCase();
    	for(int i=x; i<=y; i++){
    		if(!(ss.charAt(i) >= 'a' && ss.charAt(i) <= 'z') ){
    			return false;
    		}
    	}
    	return true;
    }
}
