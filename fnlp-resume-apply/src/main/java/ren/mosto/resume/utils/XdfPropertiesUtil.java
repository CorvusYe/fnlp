package ren.mosto.resume.utils;

//import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import java.util.Collection;
import java.util.Map;

/**
 * Created by yeweicheng on 2016/10/26.
 */
public class XdfPropertiesUtil {


    public static boolean isNotNull( Object o ) {
        return !isNull( o );
    }

    public static boolean isNull( Object o ) {
        if( o == null ) return true;
        if( o instanceof  String ) {
            return StringUtils.isEmpty( ( String )o );
        }
        if( o instanceof Map ) {
            return ( (Map) o ).size() == 0;
        }
        if( o instanceof Collection ) {
           // return CollectionUtils.isEmpty( ( Collection ) o );
        }
        return false;
    }

}
