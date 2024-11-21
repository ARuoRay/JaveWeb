import React, { useEffect, useState } from "react"
import ChatList from "../component/ChatList";
import ChatContent from "../component/ChatContent";

function Home() {

  const [chats, setChats] = useState([
    {
      id: 5,
      creator: {
        username: "abc"
      },
      chatname: "123",
    },
    {
      id: 5,
      creator: {
        username: "abc"
      },
      chatname: "123",
    },
  ]);

  // const [message,setMessage]=useState([
  //   {
      
  //   }
  // ]);

  return (
    <div>
      <h1>歡迎來到首頁！</h1>
      <p>你已經成功登入。</p>

      <div>
        <ChatList chats={chats} />
        <ChatContent chats={chats} />
      </div>
    </div>
  );
}

export default Home;
