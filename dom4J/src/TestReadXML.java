import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;


public class TestReadXML {

	/**
	 * @param args
	 * @throws DocumentException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException, DocumentException {
		String pa = System.getProperty("user.dir");
		String path = pa + "\\xml\\bookstore.xml";
		SAXReader reader = new SAXReader();
		Document document = reader.read(new FileInputStream(path));
		//获取根节点
		Element root = document.getRootElement();
		System.out.println(root.getName());
		Iterator i = root.elementIterator();
		
		while(i.hasNext()){
			Element book = (Element)i.next();
			System.out.println("|---" + book.getName());
			Attribute attr = book.attribute("category");
			System.out.println("   |---" + attr.getName() + ": " + attr.getText());
			List<Element> list =  book.elements();
			for (Element e : list){
				System.out.println("      |---" + e.getName() + ": " + e.getText());
			}
		}

	}

}
