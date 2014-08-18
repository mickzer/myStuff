import java.util.ArrayList;

public class WebPage {

	String fileName;
	String content;
	ArrayList<String> outLinks;
	
	public WebPage(String fileName, String content) {
		
		this.fileName = fileName;
		this.content = content;
		outLinks = new ArrayList<String>();
		
	}
	
	public String getName() {
		return this.fileName;
	}
	
}
