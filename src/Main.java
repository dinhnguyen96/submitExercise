import java.util.List;

public class Main {

    public static void main(String[] args)
    {
        CreateFile file = new CreateFile("src/file/user.dat","src/file/result.txt");
        List<User> list = file.ReadFile();
        if (list == null)
        {
            System.out.println("Lỗi");
        }
        else
        {
            System.out.println(list);
        }
    }
}
