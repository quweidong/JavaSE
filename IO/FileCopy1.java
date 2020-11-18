package IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//文件复制
//将一个目录下的图片复制到桌面
public class FileCopy {
    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream("C:\\Users\\win10\\Pictures\\Saved Pictures\\图片.jpg");
            fileOutputStream = new FileOutputStream("C:\\Users\\win10\\Desktop\\图片.jpg");
            byte[] bytes = new byte[1024*1024];
            int returnNumber = 0;
            while ((returnNumber = fileInputStream.read(bytes)) != -1){
                fileOutputStream.write(bytes,0,returnNumber);
            }
            fileOutputStream.flush();
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
