package $package;

import act.inject.DefaultValue;
import org.osgl.mvc.annotation.GetAction;

public class Service {

    /**
     * The hello (`/hello`) endpoint.
     *
     * This will accept a query parameter named `who` and
     * return a greeting string in a form of "Hello $who"
     *
     * @param who
     *      request query parameter to specify the hello target.
     *      default value is `World`.
     * @return A hello string
     */
    @GetAction("hello")
    public String hello(@DefaultValue("World") String who) {
        return "Hello " + who;
    }

}
