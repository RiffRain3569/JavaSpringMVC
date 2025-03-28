# Toy Project

- DDD 개발 방법론 테스트
- 플랫폼 개발 시 베이스 코드 목표

## 디렉터리 구조

```
root
├─ global: 프로젝트 전체에서 사용하는 코드
│  ├─ config
│  ├─ logger: 서버 로그 포맷 정의 
│  ├─ security
│  └─ util 
│  ├─ ...
├─ domain: 도메인 관련 코드
│  ├─ user
│  │  ├─ api: 컨트롤러 관련 디렉터리
│  │  │  ├─ request
│  │  │  └─ response
│  │  ├─ application: usecase 관련 디렉터리
│  │  │  └─ dto 
│  │  └─ persistence: 영속성 관련 디렉터리
│  │     ├─ entity
│  │     ├─ query
│  │     └─ repository
│  └─ ...
├─ infrastructure: 횡단 관심사 관련 코드
│  ├─ auth
│  ├─ email
│  └─ ...
└─ web: 외부 인터페이스 관련 코드
   ├─ client: client front 외부 인터페이스
   ├─ admin: admin front 외부 인터페이스
   └─ rest: api 외부 인터페이스

```
