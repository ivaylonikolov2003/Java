public class FileParseException extends Exception{
    private int lineNumber;
    private String lineText;
    public FileParseException(String message, int lineNumber, String lineText) {
        super(message + "(line #" + lineNumber + ") (text = " + lineText + ")");
        this.lineNumber = lineNumber;
        this.lineText = lineText;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public String getLineText() {
        return lineText;
    }
}
