/**
 * 
 */
package functionalinterface;

import java.util.function.Predicate;

/**
 * @author test
 *
 */
public class PredicateSample implements Predicate {
	@Override
    public boolean test(Object o) {
        return o != null;
    }
}
