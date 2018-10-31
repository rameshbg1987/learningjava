package regex;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Ramesh BG
 * 
 * Program to create a file with touch command with the following conditions.
 * suppose if there is a file exists with names like hello(1), hello(10)(20), 
 * hello(10)(21)
 * then
 * copy of hello(1) will create a file hello(1)(1)
 * copy of hello(10) will create a file hello(10)(22)
 * file created will be empty only name is generated dynamically.
 *
 */
public class FileNameGenerator {

    private String file2Duplicate = null;

    private String dirToSearch = null;

    public FileNameGenerator(String txt2Duplicate, String dirToSearch) {
        this.file2Duplicate = txt2Duplicate;
        this.dirToSearch = dirToSearch;

    }

    public void startProgram() throws IOException {
        int groupCount = getGroupCount();
        String newFileName = processDirectoryFiles(groupCount + 1);
        String newFileNameWithFullPath = this.dirToSearch + File.separator + newFileName;
        System.out.println("New file name is " + newFileNameWithFullPath);
        Runtime.getRuntime().exec(
                "touch " + newFileNameWithFullPath);
    }

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        if (args.length != 2) {
            System.out.println(
                    "Usage:"+ getJavaFileName()  +" <FilenameToCopy> <directoryToSearchForFileName>");
            System.exit(1);
        }

        System.out.println("Input file name is " + args[0]);
        FileNameGenerator paranthesisCopier = new FileNameGenerator(args[0], args[1]);
        paranthesisCopier.startProgram();
    }
    
    private static String getJavaFileName() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String[] classNames = stackTrace[1].getClassName().split("\\.");
        return classNames[classNames.length - 1];
    }

    /**
     * This methods finds number of pair of open and closed paranthesis
     * for e.g. hello(1)(34)(90)
     * will return 3 since there are three pairs.
     * 
     * @return groupCount
     */
    private int getGroupCount() {
        String exp3 = "\\(\\d*\\)";
        Pattern pattern2 = Pattern.compile(exp3,
                Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
        Matcher matcher2 = pattern2.matcher(this.file2Duplicate);

        int count = 0;
        while (matcher2.find()) {
            count++;
        }
        return count;
    }

    private String processDirectoryFiles(int groupCount) {

        File desktopDir = new File(dirToSearch);
        File[] listFiles = desktopDir.listFiles();

        /*
         * regular expression to match series of pair of open,closed paranthesis
         * which contains integers. 
         * for e.g. (1)(30)(89)...
         * 
         */
        String exp3 = "(\\(\\d*\\))";
        /**
         * suppose if the filename is hello(1) then copy of hello(1) will 
         * definitely have two pairs of paranthesis hence we need to find 
         * groupCount + 1 number of pairs of paranthesis in given directory.
         */
        // search for groupCount+1 paranthesis in files list.
        /*
         * java treats open and closed paranthesis to match groups hence in
         * order to treat as pair of paranthesis then you have to escape them 
         * with backslash
         * suppose if the filename is hello(1)(20)(89)
         * then we need to convert to like 
         * hello\(1\)\(20\)\(89\)
         *
         */
        String backslashString = this.file2Duplicate.replace("(", "\\(");
        String forwardSlashString = backslashString.replace(")", "\\)");
        
        /*
         * why "$" here ?
         * Ans: suppose if there is a file name exists with name hello(10)(20)
         * and you are trying to generate a name for hello(10)(20)(50) then 
         * regular expression 
         * String exp3 = "(\\(\\d*\\))";
         * matches for hello(10)(20) hence you need to make sure that after
         * text "hello(10)(20)" nothing should be present. so appending "$" 
         * will ensure end of string and text "hello(10)(20)(50) won't be 
         * considered in that case. 
         * 
         */
        String newRegex = forwardSlashString + exp3 + "$";

        Pattern pattern3 = Pattern.compile(newRegex,
                Pattern.CASE_INSENSITIVE | Pattern.DOTALL);

        List<String> desktopFileNamefilteredList = new ArrayList<String>();

        for (File file : listFiles) {
            String fileName = file.getName();

            if (fileName.startsWith(this.file2Duplicate)) {
                Matcher matcher3 = pattern3.matcher(fileName);
                while (matcher3.find()) {
                    desktopFileNamefilteredList.add(matcher3.group());
                }
            }
        }

        Collections.sort(desktopFileNamefilteredList);
        System.out.println("Existing file List: "+desktopFileNamefilteredList);

        // if the list is empty, just append(1)
        if (desktopFileNamefilteredList.isEmpty()) {
            return file2Duplicate + "(1)";
        } else {

            // get the last element last index value and increase the value by one
            String lastElement = desktopFileNamefilteredList
                    .get(desktopFileNamefilteredList.size() - 1);
            int startVal = lastElement.lastIndexOf('(');
            int endVal = lastElement.lastIndexOf(')');
            String substring = lastElement.substring(startVal + 1, endVal);
            Integer newValue = Integer.valueOf(substring) + 1;
            return file2Duplicate + "(" + newValue + ")";
        }
    }
}