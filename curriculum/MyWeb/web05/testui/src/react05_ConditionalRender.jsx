export default function LoginStatus({ isLoggedIn }) {
  return (
    <div>
      {isLoggedIn ? <p>로그인 상태입니다.</p> : <p>로그인이 필요합니다.</p>}
    </div>
  );
}
