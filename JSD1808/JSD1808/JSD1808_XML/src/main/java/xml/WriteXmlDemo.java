package xml;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

/**
 * 使用DOM4J生称一个文档
 * @author soft01
 *
 */
public class WriteXmlDemo {
	public static void main(String[] args) {
		List<Emp> list = new ArrayList<Emp>();
		list.add(new Emp(1,"杨大",22,"男",5000));
		list.add(new Emp(2,"李二",23,"男",6000));
		list.add(new Emp(3,"张三",24,"男",7000));
		list.add(new Emp(4,"赵四",25,"男",8000));
		list.add(new Emp(5,"王五",26,"男",9000));
		list.add(new Emp(6,"郝六",27,"男",10000));
		/*
		 * 生成一个XML文档的大致步骤：
		 * 1、创建一个Document对象，表示一个空白文档
		 * 2、向Document中添加根元素
		 * 3、向根元素中逐级添加子元素以达到XML文档应有的结构
		 * 4、创建XmlWriter
		 * 5、将Document对象通过XmlWriter写出以生成XML文档
		 */
		try {
			//1、
			Document doc = DocumentHelper.createDocument();
			/*
			 * 2、Document提供了添加根元素的方法：
			 * Element addElement(String name)
			 * 添加指定名字的根元素，并以Element实例形式将其返回，以便于继续对该根元素操作。
			 * 
			 * 
			 * 注意：这个方法只能调用一次！因为只有一个根。
			 */
			Element root = doc.addElement("list");
			/*
			 * 将每个员工信息以一个<emp>标签添加到<list>中
			 */
			for (Emp emp : list) {
				//向<list>中添加子标签<emp>
				Element empEle = root.addElement("emp");
				//添加员工姓名
				Element nameEle = empEle.addElement("name");
				nameEle.addText(emp.getName());
				//添加员工年龄
				Element ageEle = empEle.addElement("age");
				ageEle.addText(emp.getAge()+"");
				//添加员工性别
				Element genderEle = empEle.addElement("gender");
				genderEle.addText(emp.getGender());
				//添加员工工资
				Element salaryEle = empEle.addElement("salary");
				salaryEle.addText(emp.getSalary()+"");
				//添加属性
				empEle.addAttribute("id", emp.getId()+"");
				
			}
			XMLWriter  writer = new XMLWriter(new FileOutputStream("myemp.xml"),OutputFormat.createPrettyPrint());
			writer.write(doc);
			System.out.println("写出完毕！");
			writer.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
}
