import { Heading } from 'components/Heading';

function Home() {
  return (<>
    <Heading>Soccer Search</Heading>;
    <table>
      <thead>
        <tr>
          <th>No.</th>
          <th>문제</th>
          <th>답</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <th>1</th>
          <th>{"전체 축구팀 목록을 팀이름 오름차순으로 출력"}</th>
          <th>답</th> 
        </tr>
        <tr>
          <th>2</th>
          <th>{"플레이어의 포지션 종류를 나열하시오. 단 중복은 제거하고, 포지션이 없으면 빈공간으로 두시오"}</th>
          <th>답</th>
        </tr>
        <tr>
          <th>3</th>
          <th>{"플레이어의 포지션 종류를 나열하시오. 단 중복은 제거하고, 포지션이 없으면 '신입' 으로 기재하시오"}</th>
          <th>답</th>
        </tr>
        <tr>
          <th>4</th>
          <th>{"수원팀에서 골키퍼(GK)의 이름을 모두 출력하시오. 단 수원팀 ID는 K02 입니다"}</th>
          <th>답</th>
        </tr>
        <tr>
          <th>5</th>
          <th>{"수원팀에서 골키퍼(GK)의 이름을 모두 출력하시오. 아이디를 모를경우"}</th>
          <th>답</th>
        </tr>
        <tr>
          <th>6</th>
          <th>{"수원팀에서 성이 고씨이고 키가 170 이상인 선수를 출력하시오. 단 수원팀 ID는 K02 입니다"}</th>
          <th>답</th>
        </tr>
        <tr>
          <th>7</th>
          <th>{"수원팀에서 성이 고씨이고 키가 170 이상인 선수를 출력하시오. 아이디를 모를경우"}</th>
          <th>답</th>
        </tr>
      </tbody>

    </table>



  </>)

}

export default Home;
