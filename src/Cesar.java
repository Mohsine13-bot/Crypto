import java.io.*;

public class Cesar {
    private int key;
    private BufferedReader bufferedReader;
    private String name;

    public Cesar(int key, String path) {
        this.key = key;
        this.name = path;
        try {
            this. bufferedReader = new BufferedReader(new FileReader(path));
        }
        catch (IOException e){

        }

    }

    public Character crypt(char character){
        if (Character.isLetter(character)){
            character = (char) (character+(key%26));
        }
        return character;
    }

    public Character decrypt(char character){
        if (Character.isLetter(character)){
            character = (char)(character+(-key%26));
        }
        return character;
    }

    public void MakeFile(){
        try {
            File myObj = new File(name+".crypt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }



    public void crypto(){
        MakeFile();
        try {
            FileWriter myWriter = new FileWriter(name+".decyph");
            while (bufferedReader.ready()){
                myWriter.write(crypt((char)(bufferedReader.read())));
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void decipher(){
        MakeFile();
        try {
            FileWriter myWriter = new FileWriter(name+".decyph");
            while (bufferedReader.ready()){
                myWriter.write(decrypt((char)(bufferedReader.read())));
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
}
