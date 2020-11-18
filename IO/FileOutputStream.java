package IO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//从内存中写到硬盘
public class FileOutputStreamTest {
    public static void main(String[] args) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream("t2",true);
            byte[] bytes = {49,34,56,77,88,103};
            String string = new String("我爱中国");
            byte[] bytes1 = string.getBytes();
            for (byte data : bytes1){
                System.out.print(data + " ");
            }
            fileOutputStream.write(bytes);
            fileOutputStream.write(bytes1,0,3);
            fileOutputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
