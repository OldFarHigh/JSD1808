package annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/**
 * 
 * @author OldFarHigh
 *
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface RequestMapping {
	public String value();
}
