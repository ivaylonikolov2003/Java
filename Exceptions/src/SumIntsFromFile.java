public class SumIntsFromFile {
    public static void main(String[] args) throws Exception {
        try {
            var ints = FileParser.readIntsFromTextFile("nums.txt");
            long sum = 0;
            for (int x:ints) {
                sum += x;
            }
            System.out.println("Sum = " + sum);
        }catch (FileParseException ex){
            System.out.println("Error parsing file");
            System.out.println("Line: " + ex.getLineNumber());
            System.out.println("Wrong Text: " + ex.getLineText());
        }

    }
}
