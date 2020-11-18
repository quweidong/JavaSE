package IO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//用字符流进行文本复制
//将工程根目录下的文件t1复制到桌面
public class FileCopy2 {
    public static void main(String[] args) {
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try {
            fileReader = new FileReader("t1");
            fileWriter = new FileWriter("C:\\Users\\win10\\Desktop\\t1");
            char[] chars = new char[3];
            int returnNumber = 0;
            while ((returnNumber = fileReader.read(chars)) != -1){
                fileWriter.write(chars,0,returnNumber);
            }
            fileWriter.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null){
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileWriter != null){
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
