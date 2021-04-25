![header](https://capsule-render.vercel.app/api?type=slice&color=A37DD6&height=150&section=header&text=BE%20SOPT%20AOS%20ASSIGNMENT&fontSize=50&fontAlignY=70&animation=scaleIn)

## 팟장님을 위한 수행 과제 목록

상황 | 과제 이름 | 세부 내용
|:--:|:--|:--|
✅| 1-1 안린이 탈출 | SignIn, SignUp, Home Activity 제작하기
✅| 1-2 안청년 탈출 | 변수 이름 바꾸기, Constraint Layout 마스터
❌|1-3 안드 고수를 향해 | ViewBinding, 객체지향 적용, 아키텍쳐
✅| 2-1 안린이 탈출 | HomeActivity 추가
✅|2-2-1 안청년 탈출 | GridLayoutManager 사용
❌|2-2-2 안청년 탈출 | 이중 RecyclerView 만들기
❌|2-2-3 안청년 탈출 | RecyclerView Item 기능 구현
❌|2-3 안드 고수를 향해 | 객체지향, notifyDataSetChanged 적용
✅| 3-선택 | 디자인 적용

## Week 1 : LifeCycle & ConstraintLayout & ViewBinding

### 1. 화면 전환 후 데이터를 가져오는 로직
`SignupActivity`에서 `LoginActivity`로 이동하는 코드조각
```kotlin
private var loginActivityLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
) {
  Log.d("로그", "Came from LogIn Activity")
}

...

val intent = Intent(this@SignUpActivity, SignInActivity::class.java)
val bundle = Bundle()
bundle.putString("username", userName.toString())
bundle.putString("userId", userId.toString())
bundle.putString("userPw", userPw.toString())
intent.putExtras(bundle)
loginActivityLauncher.launch(intent)
```
* registerForActivityResult : 액티비티 스택이 쌓이는 문제를 막아주기 위해 쓰이던 `startActivityResult`가 deprecated되며 생겨난 대안
* 각 데이터를 하나의 `Bundle`로 묶어준 후 `intent.putExtras()`를 통해 인텐트 속에 넣어준다.
* `LoginActivity`에서 다시 `SignUpActivity`로 이동하면 "Came from LogIn Activity"가 출력된다.
   * 저걸 안 쓰면 LoginActivity에서 SignUpActivity로 이동할 경우 SignUpActivity가 새로운 스택으로 쌓이게 된다.

### 2. 생명주기 로그
![life_cycle](https://user-images.githubusercontent.com/48249505/114261616-7bafaa00-9a16-11eb-8e16-06ef1fa9ac3f.gif)![안드로이드 4대 컴포넌트 생명주기](https://media.vlpt.us/images/eun3673/post/1cee08b0-cc76-4680-8863-3d44726a69b1/22AC6833597EDA1626.png)

### 3. 과제를 통해 배운 내용
* 코드리뷰를 통해 특히 많이 배웠습니다
* 구글링한걸 그대로 치기보다는 무슨 뜻인지, 왜 그런지 생각하는 시간을 더 가져야겠다고 느꼈습니다.


## Week 2 : Fragment and  RecyclerView

### 1. Fragment
* 액티비티 내에서 화면 ui의 일부를 나타내는 조각
* 여러 개의 프라그먼트를 조합하여 액티비티가 출력하는 한 화면의 UI 표현
* 재사용성, 분리 관리로 편의, 복잡도 감소
* 액티비티와 다른 생명 주기를 가짐
<img src="https://developer.android.com/images/guide/fragments/fragment-view-lifecycle.png">
* 액티비티에서 프라그먼트를 가져오는 코드

```kotlin
val followingListFragment = FollowingListFragment()
val transaction = supportFragmentManager.beginTransaction()
transaction.add(R.id.fragment_user_info, followingListFragment)
transaction.commit()
```

### 2. RecyclerView
요소 | 역할
|:--|:--|
item | 각각 뷰 객체들의 형태를 xml로 나타냄
ViewHolder | 지금 화면에 보여지는 뷰 객체들을 홀딩하고 있는 객체
ViewAdapter | 리스트를 리사이클러 뷰에 바인딩 시켜주는 객체
LayoutManager | 리사이클러 뷰의 형태를 잡아주는 멋진 친구
