package service;
/**
 * 模型：
 * 		负责业务逻辑的处理。
 * 
 * @author OldFarHigh
 *
 */
public class BmiService {
	public String bmi(double height,double weight) {
			String status = "正常";
			//计算bmi指数
			double bmi = weight / height / height;
			//依据bmi指数，判断一个人的身体状况。
			if(bmi<19) {
				status = "过轻";
			}
			if(bmi>25){
				status = "过重";
			}
			return "BMI:"+bmi +" 体重："+status;
	}
}
