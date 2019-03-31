package com.filename.example1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class filecontrol {
	public static void main(String[] args) throws IOException {
		
		//String filePath = "E:/����/DataBase/02.Table/SC/JMSC/table_create_test.sql";
		try{
			File writefile = new File("E:/����/DataBase/02.Table/SC/JMSC/table_create_new_c.sql");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(writefile));

            //���� ��ü ����
            File file = new File("E:/����/DataBase/02.Table/SC/JMSC/table_create_new.sql");
            //�Է� ��Ʈ�� ����
            FileReader filereader = new FileReader(file);
            //�Է� ���� ����
            BufferedReader bufReader = new BufferedReader(filereader);
            String line = "";
            while((line = bufReader.readLine()) != null){
            	
            	int index = line.indexOf("CONSTRAINT SYS_");
            	
            	String replaceText = null;
            	replaceText = line;
            	if(line.indexOf("CONSTRAINT SYS_") >=0 ) {
            		System.out.println(line);
            		System.out.println(line.substring(index, index+23));
            		
            		String text = line.substring(index, index+23);
            		replaceText = line.replaceAll(text, "");
            	}
            	
            	if(writefile.isFile() && writefile.canWrite()){
                    //����
                    bufferedWriter.write(replaceText);
                    //���๮�ھ���
                    bufferedWriter.newLine();                        
                }
            }
            //.readLine()�� ���� ���๮�ڸ� ���� �ʴ´�.            
            bufReader.close();
            bufferedWriter.close();
        }catch (FileNotFoundException e) {
            // TODO: handle exception
        }catch(IOException e){
            System.out.println(e);
        }

    }

}

