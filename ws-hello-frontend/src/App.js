import React, { useState, useEffect, useRef } from 'react';
import StompJs from 'stompjs';

const App = () => {
    const [messages, setMessages] = useState([]);
    const [stompClient, setStompClient] = useState(null);
    const subscriptionRef = useRef(null);

    useEffect(() => {
        console.log('Opening Web Socket...');
        const client = StompJs.client('ws://localhost:8080/ws');
        client.connect({}, (frame) => {
            console.log('Connected: ' + frame);
            setStompClient(client);
            if (!subscriptionRef.current) {
                subscriptionRef.current = client.subscribe('/topic/greetings', (message) => {

                    const newMessage = JSON.parse(message.body).content;
                    console.log(message.body)
                    setMessages(prevMessages => [...prevMessages, message.body]);
                });
            }
        }, (error) => {
            console.error('Error with websocket', error);
        });

        return () => {
            if (stompClient && stompClient.connected) {
                console.log(">>> DISCONNECT");
                stompClient.disconnect();
                console.log("Disconnected");
            }
        };
    }, []);

    return (
        <div>
            <h1>WebSocket Messages</h1>
            <div>
                {messages.map((message, index) => (
                    <p key={index}>{message}</p>
                ))}
            </div>
        </div>
    );
};

export default App;
