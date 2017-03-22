import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by rmiao on 4/21/2016.
 */
public class TestDel {

    public static void main(String[] args) throws IOException {
            String dest = "D:\\projects\\EPC";
            File file = new File(dest);

        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        if ("y".equalsIgnoreCase(next) || "yes".equalsIgnoreCase(next)){
            System.out.println("=============Start delete==================");
            forceDelete(file);
        }else{
            System.out.println("Nothing to do.");
        }


    }

    private static void forceDelete(File file) throws IOException {
        if (file.isDirectory()){
            deleteDirectory(file);
        }else{
            boolean filePresent = file.exists();
            if(!file.delete()){
                if(!filePresent){
                    throw  new FileNotFoundException("File does note exist:"+file);
                }

                String message = "Unable to delete file:"+file;
                throw new IOException(message);

            }else{
                System.out.println("-"+file.getAbsolutePath());
            }

        }
    }
    public static void deleteDirectory(File directory) throws IOException{
        if (directory.exists()){
            cleanDirectory(directory);
        }
        if(!directory.delete()){
            String message = "Unable to delete directory "+directory+".";
            throw  new IOException(message);
        }
    }

    /**
     * Cleans a directory without deleting it.
     *
     * @param directory directory to clean
     * @throws IOException in case cleaning is unsuccessful
     */
    public static void cleanDirectory(File directory) throws IOException {
        if (!directory.exists()) {
            String message = directory + " does not exist";
            throw new IllegalArgumentException(message);
        }

        if (!directory.isDirectory()) {
            String message = directory + " is not a directory";
            throw new IllegalArgumentException(message);
        }

        File[] files = directory.listFiles();
        if (files == null) {  // null if security restricted
            throw new IOException("Failed to list contents of " + directory);
        }

        IOException exception = null;
        for (File file : files) {
            try {
                forceDelete(file);
            } catch (IOException ioe) {
                exception = ioe;
            }
        }

        if (null != exception) {
            throw exception;
        }
    }

}
