import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;


public class TestXpath {

	/**
	 * @param args
	 * @throws DocumentException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException, DocumentException {
		String ph = System.getProperty("user.dir");
		String path = ph + "\\xml\\bookstore.xml";
		SAXReader reader = new SAXReader();
		Document document = reader.read(new FileInputStream(path));
		List list = document.selectNodes("bookstore/book/title");
		for (int i = 0; i < list.size(); i++){
			Element ele = (Element)list.get(i);
			System.out.println(ele.getName() + ele.getText());
		}
	}

}
