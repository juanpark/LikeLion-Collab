const items = ["HTML", "CSS", "JS", "React"];
export default function SkillList() {
  return (
    <ul>
      {items.map((item, i) => <li key={i}>{item}</li>)}
    </ul>
  );
}
