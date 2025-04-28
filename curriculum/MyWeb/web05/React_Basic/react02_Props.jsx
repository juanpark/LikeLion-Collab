function Welcome(props) {
  return <h2>Welcome, {props.name}!</h2>;
}
export default function App() {
  return <Welcome name="홍길동 " />;
}
