package $package;

import act.app.ActionContext;
import act.ws.WebSocketContext;
import org.osgl.mvc.annotation.Before;
import org.osgl.mvc.annotation.GetAction;
import org.osgl.mvc.annotation.PostAction;
import org.osgl.mvc.annotation.WsAction;
import org.osgl.util.S;

import static act.controller.Controller.Util.redirect;

@SuppressWarnings("unused")
public class ChatroomService {

    @Before(only = "home")
    public void ensureLogin(ActionContext context) {
        if (!context.isLoggedIn()) {
            throw redirect("/login");
        }
    }

    @GetAction
    public void home() {
    }

    @GetAction("login")
    public void loginForm() {
    }

    @PostAction("login")
    public void login(String username, ActionContext context) {
        context.login(username);
        redirect("/");
    }

    @WsAction("msg")
    public void onMessage(String message, WebSocketContext context) {
        // suppress blank lines
        if (S.notBlank(message)) {
            context.sendToPeers("[" + context.actionContext().username() + "] " + message);
        }
    }

}
