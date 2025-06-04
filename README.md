# LikeLion-Collab
멋쟁이사자처럼 | 벡엔드 자바 15기 | 회고2팀 협업 공간


# 🚀 팀원들을 위한 Git 사용 가이드

**문서 작성자: 박정환**

회고4팀 수업 및 프로젝트를 위해 Git 및 GitHub를 효과적으로 사용하는 방법을 설명합니다.  
브랜치를 활용하여 안정적인 코드 관리와 원활한 협업이 가능하도록 구성했습니다.<br><br>

 
**📌 1. GitHub 저장소 클론하기 (최초 1회)**

먼저 GitHub에서 팀 저장소를 내 컴퓨터(로컬)에 복제해야 합니다.


- 맥: 터미널 / 윈도우스: GitHub CLI를 활용한는 것을 추천합니다.  
  (GUI로 되어 있는 도구를 활용하셔도 괜찮습니다. 과정은 비슷합니다)
- 멋사 기본 폴더로 이동합니다. LikeLion-Collab 깃 폴더가 여기에 생성됩니다.
- 브라우저에서 다음으로 이동합니다: https://github.com/juanpark/LikeLion-Collab.git
- 위 사이트 화면에서 "<> Code" 버튼을 누르면 "Local" 탭 아래에 세 가지 옵션이 뜹니다.
- 클론을 위한 명령어를 HTTPS, SSH, GitHub CLI 중에서 본인에 맞는 옵션을 복사합니다.<br>

🔹 HTTPS 방식으로 클론하려면:  
`git clone https://github.com/juanpark/LikeLion-Collab.git`

🔹 SSH 방식으로 클론하려면:  
`git clone git@github.com:juanpark/LikeLion-Collab.git`

✅ 이제 프로젝트가 내 로컬 환경에 복사되었습니다.  
✅ GitHub 로그인/인증 방식에 따라 HTTPS, SSH, GitHub CLI를 선택하세요.<br><br>


**📌 2. main에서 직접 작업하지 마세요! (항상 브랜치 사용)**

❌ 잘못된 방식 (작업 금지)<br>

main 브랜치에서 바로 코드 수정 후 푸시 ❌  
```
git add .  
git commit -m "수정함"  
git push origin main  # 🚨 금지! 🚨  
```
👉 main 브랜치는 항상 안정적인 상태로 유지해야 합니다!<br><br>

**📌 3. 새로운 브랜치에서 작업하기**

(1) 새로운 기능/작업을 시작할 때 브랜치 생성  
```
git switch -c feature/작업이름  # 신규로 브랜치를 만들고 그 브랜치로 스위치 한다
```
<br>기타 관련 명령:
```
git branch                    # 모든 브랜치 확인
git switch 브랜치이름            # 원하는 브랜치로 이동
git switch -                  # 이전 브랜치로 이동
```

<br>📌 여러 개의 작업 브랜치를 만들 수도 있습니다.
```
git switch -c feature/add-login-api
git switch -c feature/improve-ui
git switch -c bugfix/fix-login-error
```
일반적으로 업계에서는 브랜치 이름을 develop/, feature/, bugfix/, release/, hotfix/, experiement/ 등을 사용하나 저희는 이제 배우기 시작하였기에 간소화 하여 아래와 같이 건의합니다:
```
chores/        # 폴더 관리
workspace/     # 개인 워크스페이스 업데이트
curriculum/    # 수업내용 업데이트
docs/          # 참고문서 없데이트
projects/      # 프로젝트 업데이트  
codetests/     # 코딩테스트 업데이트
```

✅ 이제 해당 브랜치에서만 작업하면 됩니다.<br><br>

**📌 4. 변경 사항 저장 (커밋하기)**  

(1) 변경된 파일 확인  

`git status`  

(2) 변경 사항 추가  

`git add .  # 모든 변경 사항 추가`. 

(3) 변경 사항을 커밋  

`git commit -m "[Feature] 로그인 API 구현"`

📌 좋은 커밋 메시지 예제:

[Fix] 로그인 오류 수정  

- 세션 만료 시간 조정
- 비밀번호 오류 메시지 개선
- 로그인 성공 시 홈으로 이동하도록 수정

✅ 이제 변경 사항이 로컬 저장소(Git)에 저장(커밋)됨 (하지만 아직 GitHub에는 올라가지 않음!)<br><br>

**📌 5. 원격 저장소(GitHub)로 푸시하기**

`git push origin feature/작업이름`

📌 여러 개의 브랜치를 작업했다면, 각각 푸시해야 합니다.
```
git push origin feature/add-login-api
git push origin feature/improve-ui
git push origin bugfix/fix-login-error
```

✅ 이제 GitHub에서 PR(Pull Request)을 만들 수 있음!<br><br>

**📌 6. Pull Request (PR) 생성하기**
	1.	GitHub 저장소에서 “Pull Requests” 클릭
	2.	“New Pull Request” 버튼 클릭
	3.	base → main, compare → feature/add-login-api 선택
	4.	작업 내용을 설명하고 팀원에게 코드 리뷰 요청
	5.	팀원이 리뷰 후 승인하면 Merge (병합) 진행

✅ PR을 통해 코드 리뷰 후 main에 반영!<br><br>

**📌 7. 머지 후 브랜치 삭제하기**

(1) main 브랜치로 이동
```
git switch main
git pull origin main  # 최신 상태로 업데이트
```
(2) 로컬 브랜치 삭제
```
git branch -d feature/add-login-api
git branch -d feature/improve-ui
git branch -d bugfix/fix-login-error
```
(3) 원격 브랜치 삭제 (GitHub에서도 제거)
```
git push origin --delete feature/add-login-api
git push origin --delete feature/improve-ui
git push origin --delete bugfix/fix-login-error
```
✅ 불필요한 브랜치를 삭제하여 GitHub 저장소를 깨끗하게 유지!<br><br>

**📌 8. 새로운 작업을 시작할 때 main 최신화 필수!**

작업을 시작하기 전에, 항상 main을 최신 상태로 업데이트하세요!
```
git switch main  # main 브랜치로 이동
git pull origin main  # 최신 상태로 가져오기
git switch -c feature/new-task  # 새 작업 브랜치 생성
```
✅ 항상 main에서 pull한 후 브랜치를 생성하세요!<br><br>

# 🚀 Git 워크플로우 정리 (팀원 필수 숙지)

단계	명령어	설명
1. 저장소 클론	git clone <repo-url>	내 로컬 환경에 저장소 복사 (최초 1회)
2. 새 작업 브랜치 생성	git switch -c feature/작업이름	새로운 작업을 위한 브랜치 생성
3. 변경 사항 확인	git status	어떤 파일이 수정되었는지 확인
4. 변경 사항 추가	git add .	모든 변경 사항 스테이징
5. 변경 사항 커밋	git commit -m "메시지"	변경 사항 저장
6. 원격 저장소 푸시	git push origin feature/작업이름	GitHub에 코드 업로드
7. PR 생성 및 코드 리뷰	GitHub에서 PR 생성	팀원 코드 리뷰 요청 후 병합
8. 브랜치 정리	git branch -d feature/작업이름	불필요한 브랜치 삭제
9. 새로운 작업 전 main 최신화	git switch main → git pull origin main	항상 최신 코드 기반으로 작업 시작

**🔥 Git 팀 협업 시 주의할 점**

✅ main 브랜치에서 직접 작업 금지!  
✅ 작업 시작 전 git pull origin main 필수!  
✅ 커밋 메시지는 의미 있게 작성 ([Chores], [Workspace] 등 협의한 태그 사용)!  
✅ 항상 새로운 기능은 별도의 브랜치에서 작업 후 PR 요청!  
✅ 머지된 브랜치는 정리하여 저장소를 깔끔하게 유지!<br><br>  


# 현재 협업 폴더 구조 안내

팀원들의 피드백을 받아 수정 및 보완할 예정입니다.

**workspace/** → 개인 작업 공간 (각 팀원별 폴더)  
폴더 이름은 팀원들의 영문명으로 설정했으며, 원하는 이름으로 변경 가능  
공유한 우리 팀 Git 가이드를 따라 직접 폴더명을 바꿔보고 GitHub에 반영하는 것을 추천합니다.  
**curriculum/** → 수업 및 학습 자료 공유  
**code-tests/** → 코딩 테스트 및 알고리즘 연습 공유  
**projects/** → 팀 프로젝트 및 공동 작업  
**doc/** → 협업을 위한 문서 정리  

각 폴더 안에는 관련 내용을 정리할 수 있도록 README.md 파일을 추가해 두었습니다.
폴더 구조나 사용 방식에 대한 의견이 있으면 공유해 주세요!
