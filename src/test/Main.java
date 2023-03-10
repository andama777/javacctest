package test;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

//import parser.MyParser;
//import parser.ParseException;
//import parser.TokenMgrError;
import parser.*;

import java.io.File;
import java.io.FileInputStream;

import java.io.OutputStream;
import java.io.FileOutputStream;

import java.io.PrintStream;

public class Main {
	private static String InputFile = "C:\\Users\\kanda.mao.18\\javacctest\\javacctest\\src\\test\\asmin.c";
	private static String OutputFile = "C:\\Users\\kanda.mao.18\\javacctest\\javacctest\\src\\test\\asmout.txt";
	//private static String OutputFile = "C:\\Users\\kanda.mao.18\\javacctest\\javacctest\\src\\test\\asmout.asm";
	
	public static void main(String[] args) throws IOException {
    	fileCompile();
    }
    
    public static void fileCompile() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(InputFile)));
        StringBuffer sb = new StringBuffer();

        String line;
        while((line = br.readLine()) != null) { sb.append(line);}
        String inputStr = sb.toString();
        
        try {
        	
        	//OutputStream os = new FileOutputStream(new File(OutputFile));
        	PrintStream ps = new PrintStream(new FileOutputStream(OutputFile));
        	System.setOut(ps);
        	
        	InputStream is = new ByteArrayInputStream(inputStr.getBytes("utf-8"));
            MyParser myParser = new MyParser(is);
            myParser.program();
        }catch(TokenMgrError ex) {
            System.out.println("TokenMgrError:" + ex.getMessage());
        }catch(ParseException ex) {
            System.out.println("ParseException:" +ex.getMessage());
        }
    }
}