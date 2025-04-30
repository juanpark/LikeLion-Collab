import React, { useEffect, useState } from "react";
export default function UserList() {
  const [users, setUsers] = useState([]);
  useEffect(() => {
    fetch("https://jsonplaceholder.typicode.com/users")
      .then(res => res.json())
      .then(data => setUsers(data.slice(0, 5)));
  }, []);
  return (
    <ul>
      {users.map(user => <li key={user.id}>{user.name}, {user.address.city}</li>)}
    </ul>
  );
}

export function TodosOne() {
const [user, setUser] = useState(null);
useEffect(() => {
  fetch('https://jsonplaceholder.typicode.com/todos/1')
  .then(res => res.json())
  .then(data => setUser(data));
  }, []);
  return (
    <div>
      {user ? (
        <>
          {user.userId}, {user.id}, {user.title}, {user.completed}
        </>
      ) : (
        "Loading..."
      )}
    </div>
  )
}

export function MyNode() {
  const [message, setMessage] = useState(null);
  useEffect(() => {
    fetch('http://localhost:7777/api/data')
    .then(res => res.json())
    .then(data => setMessage(data.message));
  }, []);
  return (
    <div className="App">
      <header className="App-header">
        <p>{message}</p>
      </header>
    </div>
  );
}

export function MyText() {
  const [message, setMessage] = useState(null);
  useEffect(() => {
    fetch('http://localhost:7777/api/text',
      {
        method: 'POST',
        headers: {'Content-Type' : 'application/json'},
        body: JSON.stringify({text:"Hello, from CLIENT"})
      }
    )
      .then(res => res.json())
      .then(data => setMessage(data.message));
  }, []);
  
  return (
    <div className="App">
      <header className="App-header">
        <p>{message}</p>
      </header>
    </div>
  );
}

export function MyUser() {
  const [message, setMessage] = useState('Loading');

  useEffect(() => {
    fetch('http://localhost:7777/api/user',
      {
        method: 'POST',
        headers: {'Content-Type' : 'application/json'},
        body: JSON.stringify({
          username: "Hong",
          email: "hong@gmail.com",
          addr: "Woosando"
        })
      }
    )
      .then(res => res.json())
      .then(data => setMessage(`
        [name: ${data.user.username}] 
        [email: ${data.user.email}] 
        [addr: ${data.user.addr}]`))
      .catch(err => {
        console.error(err);
        setMessage("요청싪패");
      });
  }, []);
  
  return (
    <div className="App">
      <header className="App-header">
        <p>{message}</p>
      </header>
    </div>
  );
}

export function MyTime() {
  const [message, setMessage] = useState('Loading...');
  useEffect(() => {
    fetch('http://localhost:7777/api/time',
      {
        method: 'POST',
        headers: {'Content-Type' : 'application/json'},
      }
    )
      .then(res => res.json())
      .then(data => setMessage(`Time from server: ${data.serverTime}`))
  }, []);
  
  return (
    <div className="App">
      <header className="App-header">
        <p>{message}</p>
      </header>
    </div>
  );
}