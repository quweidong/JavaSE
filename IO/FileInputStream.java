package IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//字节流从硬盘中读取文件内容
public class FileInputStreamTest {
    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("t1");
            byte[] bytes = new byte[3];
            int number = 0;
            while ((number = fileInputStream.read(bytes)) != -1){
                System.out.print(new String(bytes,0,number));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
