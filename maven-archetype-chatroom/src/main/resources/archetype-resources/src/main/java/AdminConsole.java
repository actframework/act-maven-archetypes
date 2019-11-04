package $package;

import act.cli.Command;
import act.cli.Required;
import act.ws.WebSocketConnectionManager;

import javax.inject.Inject;

public class AdminConsole {

    @Inject
    private WebSocketConnectionManager connectionManager;

    @Command(name = "send", help = "Send broadcast message to all connected users")
    public void send(@Required("specify the message to be sent") String message) {
        connectionManager.sendToUrl("[admin-broadcast] " + message, "/msg");
    }

}
