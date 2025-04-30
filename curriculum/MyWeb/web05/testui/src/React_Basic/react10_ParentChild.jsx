function Child({ msg }) {
  return <p>자식 메시지: {msg}</p>;
}
export default function Parent() {
  return <Child msg="안녕하세요 자식 컴포넌트입니다!" />;
}
