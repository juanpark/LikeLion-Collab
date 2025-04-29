import { useEffect, useState } from "react";
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
