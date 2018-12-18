package dayTest_1019;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 读取文件中的***.xml文件
 * @author OldFarHigh
 *
 */
public class xmlDemo {
	public static void main(String[] args) {
		
		List<Emp> list = new ArrayList<Emp>();//web.xml中的信息读取出来后，存入的集合
		try {
			SAXReader reader = new SAXReader();//使用SAXReader方式读取xml文件
			Document doc = reader.read(new FileInputStream("web.xml"));//读取文件输入流，并将其装进Document对象中
			Element root = doc.getRootElement();//获取根标签
			List<Element> rootlist  = root.elements();//获取根标签下的所有子标签
			for (Element element : rootlist) {//遍历根标签下的所有子标签
				Element nameEle = element.element("name");//获取名为name的标签
				String name = nameEle.getText();//
				
				int age =Integer.parseInt(element.elementText("age"));
				
				String gender =element.elementText("gender");
				
				double salary = Double.parseDouble(element.elementText("salary"));
				
				int id =Integer.parseInt(element.attributeValue("id"));//解析给定元素id的属性
				
				Emp  emp = new Emp(id,name,age,gender,salary);
				list.add(emp);
			}
			System.out.println("解析完毕！");
			for (Emp emp : list) {
				System.out.println(emp);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			
			e.printStackTrace();
		}
		
	}
}
