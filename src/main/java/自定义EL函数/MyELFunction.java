package 自定义EL函数;
/**
 * 
 * @author Eric_Junior
 * 创建时间：2017年10月5日
 */
//类必须是public修饰的
public class MyELFunction {
	//方法必须是public的静态方法
	public static Integer getLength(String str){
		if(str==null || str.trim()==""){
			return 0;
		}else{
			return str.length();
		}
	}
}
