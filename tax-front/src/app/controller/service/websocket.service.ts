import {Injectable} from '@angular/core';
import {Subject} from 'rxjs';

@Injectable({
    providedIn: 'root'
})
export class WebSocketService {

    private socket: WebSocket;
    private messageSubject = new Subject<string>();

    constructor() {
        // Connect to the WebSocket server
        this.socket = new WebSocket('ws://localhost:8080/my-websocket');

        // Define event handlers
        this.socket.onopen = (event) => {
            console.log('WebSocket connection opened:', event);
        };

        this.socket.onmessage = (event) => {
            this.messageSubject.next(event.data);
        };

        this.socket.onclose = (event) => {
            console.log('WebSocket connection closed:', event);
        };

        this.socket.onerror = (event) => {
            console.error('WebSocket error:', event);
        };
    }

    sendMessage(message: string): void {
        // Check if the WebSocket connection is open before sending a message
        if (this.socket.readyState === WebSocket.OPEN) {
            this.socket.send(message);
        } else {
            console.error('WebSocket connection not open. Message not sent.');
        }
    }

    getMessages(): Subject<string> {
        return this.messageSubject;
    }
}
