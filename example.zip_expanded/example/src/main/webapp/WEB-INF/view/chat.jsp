<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>聊天室</title>
 	<script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.5.1/sockjs.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
    <script type="text/javascript">
        var stompClient = null;

        function connect() {
            var socket = new SockJS('/chat-websocket');
            stompClient = Stomp.over(socket);
            stompClient.connect({}, function (frame) {
                console.log('Connected: ' + frame);
                stompClient.subscribe('/topic/messages', function (messageOutput) {
                    showMessage(JSON.parse(messageOutput.body));
                });
            });
        }

        function sendMessage() {
            var messageContent = document.getElementById("messageInput").value;
            var sender = document.getElementById("senderInput").value;
            stompClient.send("/app/sendMessage", {}, JSON.stringify({'sender': sender, 'content': messageContent}));
            document.getElementById("messageInput").value = "";
        }

        function showMessage(message) {
            var response = document.getElementById("messages");
            var p = document.createElement('p');
            p.appendChild(document.createTextNode(message.sender + ": " + message.content));
            response.appendChild(p);
        }
    </script>
</head>
<body onload="connect()">
    <h2>聊天室</h2>
    <div id="messages"></div>
    <input type="text" id="senderInput" placeholder="輸入你的名字" />
    <input type="text" id="messageInput" placeholder="輸入訊息" />
    <button onclick="sendMessage()">發送</button>
</body>
</html>