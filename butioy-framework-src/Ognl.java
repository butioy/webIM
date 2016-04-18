/**
 * Created with IntelliJ IDEA.
 * Author butioy
 * Date 2015-09-05 03:46
 */
public class Ognl {

    public static boolean isNotEmpty( Object value ) {
        if( null == value ) {
            return false;
        }
        if( value instanceof String ) {
            if( value.toString().length() > 0 )
                return true;
            return false;
        } else if( value instanceof Boolean )
            return (Boolean) value;
        else
            return value != null;
    }

}
