# 도우미 (Helper)

<p align="center">
 <img width="390" height="390" alt="image" src="https://github.com/user-attachments/assets/3bf2e043-ba70-4f7b-8b27-e1effce255ca" />
</p>

## 앱 소개

**도우미**는 돈까스 전문점의 조리 품질과 주방 업무를 표준화하기 위한 Android 애플리케이션입니다.

정밀 조리 타이머와 디지털 레시피로 작업자별 조리 편차를 줄이고, 실시간 업무 체크리스트로 오픈 준비·위생 관리·마감 업무 등의 누락을 방지합니다.

## 주요 기능

- 지점 및 사원번호를 이용한 직원 로그인
- 근무 시간대별 업무 체크리스트와 달성률 확인
- 메뉴별 조리 가이드 및 정밀 타이머
- 공지사항 확인
- 관리자용 업무 템플릿 및 직원 계정 관리
- 프로필, 비밀번호 및 알림 설정

## 이용 방법

1. 앱을 실행하고 로그인 화면에서 지점을 선택합니다.
2. 사원번호를 입력한 뒤 **주방 시스템 입장** 버튼을 누릅니다.
3. 관리자 기능을 확인하려면 사원번호 `7777`로 로그인합니다.
4. 하단 메뉴를 이용해 홈, 업무, 조리, 관리, 프로필 화면으로 이동합니다.
5. **업무** 화면에서 근무 시간대를 선택하고 완료한 업무를 체크합니다.
6. **조리** 화면에서 메뉴를 선택한 뒤 타이머를 시작하거나 초기화합니다.
7. 관리자로 로그인하면 **관리** 화면에서 공지사항, 업무 템플릿, 직원 계정을 관리할 수 있습니다.
8. **프로필** 화면에서 비밀번호와 알림 설정을 변경하거나 로그아웃할 수 있습니다.

### 테스트용 관리자 계정

| 구분 | 사원번호 | 사용 가능 기능 |
| --- | --- | --- |
| 관리자 | `7777` | 일반 기능, 공지 등록, 업무 관리, 직원 계정 관리 |

## 파일 구조

```text
helper/
├─ app/
│  ├─ src/main/
│  │  ├─ AndroidManifest.xml              # 앱 권한, 테마, 시작 화면 설정
│  │  ├─ java/com/example/helper/
│  │  │  ├─ MainActivity.kt               # 앱 진입점
│  │  │  ├─ model/
│  │  │  │  ├─ CookingTimerState.kt       # 조리 타이머 상태
│  │  │  │  ├─ HelperDefaults.kt          # 시연용 기본 데이터
│  │  │  │  ├─ LoginFormState.kt          # 로그인 입력 상태
│  │  │  │  ├─ LoginUser.kt               # 로그인 사용자 모델
│  │  │  │  └─ TaskItem.kt                # 업무, 공지, 직원 관련 모델
│  │  │  └─ ui/
│  │  │     ├─ MainScreen.kt              # 화면 이동 및 앱 상태 관리
│  │  │     ├─ components/                # 공통 UI 컴포넌트
│  │  │     ├─ navigation/                # 하단 탭과 화면 경로
│  │  │     ├─ screen/                    # 로그인, 홈, 업무, 조리 등 화면
│  │  │     └─ theme/Theme.kt             # 색상과 Compose 테마
│  │  └─ res/                             # 아이콘과 Android 리소스
│  └─ build.gradle.kts                    # 앱 모듈 빌드 설정
├─ gradle/libs.versions.toml              # 라이브러리 버전 관리
├─ build.gradle.kts                       # 프로젝트 공통 빌드 설정
└─ settings.gradle.kts                    # 프로젝트 및 모듈 설정
```

## 아키텍처

이 프로젝트는 **Model과 Compose UI를 분리하고 단방향 데이터 흐름을 사용하는 구조**로 작성했습니다.

```text
Model → MainScreen 상태 관리 → Compose Screen
                         ↑          │
                         └─ UI Event┘
```

- **Model**: 사용자, 업무, 공지, 조리 타이머 등의 데이터와 상태를 정의합니다.
- **View**: Jetpack Compose 화면과 공통 컴포넌트로 UI를 표현합니다.
- **State holder**: `MainScreen.kt`에서 앱 상태와 사용자 이벤트를 관리합니다.

> Android에서 일반적으로 사용하는 최신 구조 명칭은 **MVVM(Model-View-ViewModel)**입니다. 현재 버전은 별도 `ViewModel` 없이 Compose 상태 홀더를 사용하며, 이후 `MainScreen`의 상태와 로직을 `ViewModel`로 분리하면 정식 MVVM 구조로 확장할 수 있습니다.

## 사용 기술

- Kotlin
- Jetpack Compose
- Material 3
- Navigation Compose
- Gradle Version Catalog
- Min SDK 24 / Target SDK 35

