import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private String s;
    private StringBuilder sb = new StringBuilder();

    private void readFile() {
        File file = new File("D:\\My tasks\\JAVA\\MASHA JAVA\\S0402\\src\\test.txt");
        try {
            FileReader in = new FileReader(file);
            Scanner scanner = new Scanner(in);
            while (scanner.hasNextLine()){
                sb.append(scanner.next()+" ");
            }
            s = new String(sb);
            in.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void writeFile(String text) {
        try (
            FileWriter fos = new FileWriter("D:\\My tasks\\JAVA\\MASHA JAVA\\S0402\\src\\outputData.txt")){
            fos.write(text);
            fos.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(text);
    }
    public static void main(String[] args) {
        int count = 0;
        Main r = new Main();
        r.readFile();
        String[] words = r.s.split(" ");
        String text = "";
        for (String w: words){
            Pattern p = Pattern.compile("abstract|continue|for|new|switch|" +
                    "assert|default|goto*|package|synchronized|" +
                    "boolean|do|if|private|this|" +
                    "break|double|implements|protected|throw|" +
                    "byte|else|import|public|throws|" +
                    "case|enum|instanceof|return|transient|" +
                    "catch|extends|int|short|try|" +
                    "char|final|interface|static|void|" +
                    "class|finally|long|strictfp|volatile|" +
                    "const*|float|native|super|while");
            Matcher m = p.matcher(w);
            if(m.matches()){
                text = text + " " + w;
                count ++;
            }
        }
        text = text + " " + count;
        r.writeFile(text);
    }
}
