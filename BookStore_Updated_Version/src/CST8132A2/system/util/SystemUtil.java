package CST8132A2.system.util;

public class SystemUtil {
	private final int NUMCOLS;

    public SystemUtil(){
        this.NUMCOLS = 6;
    }
	// Line reader
    public String[] lineReader(String line){
        String[] str = new String[NUMCOLS];
        int index =  0;
        final char chComma = ',';
		final char chQuotes = '"';
		int start = 0;
		int end = line.indexOf(chComma);
		String value;
		while (start < end) {
			if (line.charAt(start) == chQuotes) {
				start++;
				end = line.indexOf(chQuotes, start + 1);
			}
			value = line.substring(start, end);
			value = value.trim();
			str[index++] = value;
			if (line.charAt(end) == chQuotes)
				start = end + 2;
			else
				start = end + 1;
			end = line.indexOf(chComma, start + 1);
		}
		if (start < line.length()) {
			value = line.substring(start);
			str[index++] = value;
		}
		return str;

    }
// check plan
	public boolean isValid(String plan){
		if(plan.isBlank() || !plan.isEmpty() || plan == null){
			return true;
		}
		return false;	
    }
}
