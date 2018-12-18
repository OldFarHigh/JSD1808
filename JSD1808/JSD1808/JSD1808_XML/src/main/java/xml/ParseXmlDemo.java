package xml;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 *使用DOM4J解析XML 
 * @author OldFarHigh
 *
 *Element getRootElement():获取根元素的方法
 *String getName():获取名字
 */
public class ParseXmlDemo {
	public static void main(String[] args) {
		/*
		 * 将emplist.xml的元素装进list集合中
		 * 
		 */
		List<Emp> list = new ArrayList<Emp>();
		
		/*
		 * 解析流程
		 * 1、创建SAXReader
		 * 2、使用SAXReader读取xml问的那个并生成Document对象这一步就是DOM解析耗时耗资源的地方，
		 * 		因为会将当前XML问的那个解析为一棵树的结构并存入Document对象，那么内容越多内存消耗越多，
		 * 		并且要求读取完整的XML文档所以相对耗时。
		 * 3、通过Document对象获取根元素
		 * 4、通过根元素开始逐级获取子元素，以达到遍历XML文档数据的目的。
		 */
		try {
			//1
			SAXReader reader = new SAXReader();
			//2
			Document doc  = reader.read(new FileInputStream("emplist.xml"));
			//reader.read(new FileInputStream("emplist.xml"));
			/*
			 * 3
			 * Document提供了获取根元素的方法
			 * Element getRootElement()
			 * 
			 * Element的每一个实例用于表示XML问到文档中的一个元素
			 * 通过Element可以获取其表示的元素的相关信息
			 * 
			 * String getName()
			 * 获取当前元素的名字
			 * 
			 * String getText()
			 * 获取当前元素中间的文本(开始与结束标签中间的文本)
			 * 
			 * Element element(String name)
			 * 获取当前标签中指定名字的子标签
			 * 
			 * List element()
			 * 获取当前标签中所有子标签
			 * 
			 * List elements(String name)
			 * 获取当前标签中所有指定名字的子标签
			 */
			Element root =  doc.getRootElement();
			System.out.println("root:"+root.getName());
			/*
			 * 获取根标签下所有的<emp>标签
			 */
			List<Element> emplist  = root.elements("emp");
			System.out.println("<emp>标签个数："+emplist.size());
			/*
			 * 遍历集合，通过每个<emp>标签获取到对应员工信息
			 */
			for (Element empEle : emplist) {
				//获取员工名字
				//1、获取<name>标签
				Element nameEle = empEle.element("name");
				//2、获取<name>标签中间的文本
				String name = nameEle.getText();
//				System.out.println(name);
				
				//获取年龄:age String elementText(String name)
				Element ageEle = empEle.element("age");
				int age = Integer.parseInt(ageEle.getText()) ;
//				System.out.println(age);
				
				//获取性别:gender String elementText(String name)
				String gender = empEle.elementText("gender");
//				Element genderEle = empEle.element("gender");
//				String gender = genderEle.getText();
//				System.out.println(gender);
				
				//获取工资:salary String elementText(String name)
				double salary = Double.parseDouble(empEle.elementText("salary"));
//				Element salaryEle =empEle.element("salary");
//				double salary = Double.parseDouble(salaryEle.getText());
//				System.out.println(salary);
				
				//获取属性：id   String attributeValue(String name)
//				Attribute attr = empEle.attribute("id");
//				int id =Integer.parseInt(attr.getValue());
				int id = Integer.parseInt(empEle.attributeValue("id"));
//				System.out.println(id);
				
				Emp emp = new Emp(id,name,age,gender,salary);
				list.add(emp);
			}
				System.out.println("解析完毕！");
				for (Emp emp : list) {
					System.out.println(emp);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
