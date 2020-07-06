import java.io.Serializable;

/**
 * 可以序列化与反序列化的对象
 */
public class Person implements Serializable{

	/**
     * 一个表示序列化版本标识符的静态变量
	 *用以表明类的不同版本间的兼容性
	 */
    private static final long serialVersionUID = 1L;
    
    String name;
    int age;
    
}