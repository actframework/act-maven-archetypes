package $package;

import act.inject.DefaultValue;
import org.osgl.mvc.annotation.GetAction;

public class Service {

    @GetAction("hello")
    public String hello(@DefaultValue("World") String who) {
        return "Hello " + who;
    }

}
