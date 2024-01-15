import {Component} from '@angular/core';
import {RouterOutlet} from '@angular/router';
import {WebSocketService} from "./controller/service/websocket.service";
import {SocketIoConfig} from "ngx-socket-io";
import {Subscription} from "rxjs";

const config: SocketIoConfig = {url: 'ws://localhost:8080/websocket', options: {}};

@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.scss'],
    standalone: true,
    imports: [RouterOutlet],
})
export class AppComponent {


    receivedMessages: string[] = [];
    private messageSubscription: Subscription;

    /**
     * Constructor
     */
    constructor(private webSocketService: WebSocketService) {
        this.messageSubscription = this.webSocketService.getMessages().subscribe(message => {
            console.log(message)
            this.receivedMessages.push(message);
        });
    }
}
