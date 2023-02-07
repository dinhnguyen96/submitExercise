import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CreateFile {

    private String pathReadFile;
    private String pathWriteFile;


    public CreateFile(String pathReadFile, String pathWriteFile)
    {
        this.pathReadFile = pathReadFile;
        this.pathWriteFile = pathWriteFile;
    }

    public List<User> ReadFile()
    {
        try(InputStream inputStream = new FileInputStream(pathReadFile);
             ObjectInputStream objectInputStream = new ObjectInputStream(inputStream))
        {
            List<User> userList = (List<User>)objectInputStream.readObject();
            return userList;

        }
        catch(FileNotFoundException e)
        {
            System.out.println("Lỗi không tìm thấy file!");
        }
        catch(IOException e)
        {
            System.out.println("Lỗi Đọc dữ liệu!");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Lỗi không tìm thấy lớp!");
        }
        return null;
    }
    public void writeFile(User user)
    {
        try(OutputStream outputStream = new FileOutputStream(pathWriteFile);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream))
        {
            objectOutputStream.writeObject(user);
            objectOutputStream.flush();
            System.out.println("Ghi file thành công!");

        }
        catch (IOException e)
        {
            System.out.println("Lỗi không tìm thấy file!");
        }
    }
}
